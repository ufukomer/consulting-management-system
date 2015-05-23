/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.consulting.management.system.dao.imp;

import com.mycompany.consulting.management.system.bean.ConnectionControlBean;
import com.mycompany.consulting.management.system.bean.ProjectBean;
import com.mycompany.consulting.management.system.dao.ProjectDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MelihKerman
 */
public class ProjectDaoIml implements ProjectDao {

    Connection conn;
    PreparedStatement prestmt;
    ConnectionControlBean connectionControl;
    ResultSet result;
    private static final Logger logger = Logger.getLogger(ProjectDaoIml.class.getName());

    public ProjectDaoIml() {
       
    }

    @Override
    public boolean addProject(ProjectBean projectbean) {
        logger.info("Started the adding the project to the database");
        boolean isInsert = false;
        try {
            
            conn = new ConnectionControlBean().getConnection();
            String insertSql = "insert into project (name , sector , min , max,projectManagerNumber,"
                    + "analistNumber,designerNumber,developerNumber,testerNumber) values(?,?,?,?,?,?,?,?,?)";
            prestmt = conn.prepareStatement(insertSql);
            prestmt.setString(1, projectbean.getName());
            prestmt.setString(2, projectbean.getSector());
            prestmt.setString(3, String.valueOf(projectbean.getMinimumPersonelNumber()));
            prestmt.setString(4, String.valueOf(projectbean.getMaximumPersonelNumber()));
            prestmt.setString(5, String.valueOf(projectbean.getProjectManagerNumber()));
            prestmt.setString(6, String.valueOf(projectbean.getAnalistNumber()));
            prestmt.setString(7, String.valueOf(projectbean.getDesignerNumber()));
            prestmt.setString(8, String.valueOf(projectbean.getDeveloperNumber()));
            prestmt.setString(9, String.valueOf(projectbean.getTesterNumber()));
            isInsert = prestmt.execute();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProjectDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (prestmt != null) {
                    prestmt.close();
                }
                if(isInsert == true)
                    logger.info("Adding the project to database:");
            } catch (SQLException ex) {
                Logger.getLogger(ProjectDaoIml.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return isInsert;
    }

    @Override
    public boolean deleteProjectById(int id) {
       logger.info("Started the deleting the project from the database");
       boolean isDeleted = false;
       
       try {     
           conn = new ConnectionControlBean().getConnection();
            String deleteSql = "delete from project where id = ?";
            prestmt = conn.prepareStatement(deleteSql);
            prestmt.setInt(1, id);
            isDeleted = prestmt.execute();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProjectDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
                try { 
                    if(conn != null)
                        conn.close();
                    if(conn != null)
                        prestmt.close();
                    if(isDeleted == true)
                        logger.info("Deleting the project from database");
            } catch (SQLException ex) {
                Logger.getLogger(ProjectDaoIml.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       return isDeleted;
    }

    @Override
    public boolean updateProjectById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProjectBean getProjectById(int id) {
        ProjectBean project = null;
        try {
            conn = new ConnectionControlBean().getConnection();
            logger.info("Started the getting project from database");
            
            String getProjectSql = "Select * from project where id = ?";
            prestmt = conn.prepareStatement(getProjectSql);
            prestmt.setInt(1, id);
            result = prestmt.executeQuery();
            project = new ProjectBean();
            while(result.next()){
                project.setId(result.getInt("id"));
                project.setName(result.getString("name"));
                project.setSector(result.getString("sector"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProjectDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
                try { 
                    if(conn != null)
                        conn.close();
                    if(conn != null)
                        prestmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProjectDaoIml.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return project;
    }

    @Override
    public List<ProjectBean> getAllProject() {
        List<ProjectBean> allProject = null;
        ProjectBean projectBean = null;
            try {
                conn = new ConnectionControlBean().getConnection();
                logger.info("Started the getting all project ");
                
                String getAllProject = "Select * from project";
                prestmt = conn.prepareStatement(getAllProject);
                result = prestmt.executeQuery();
                
                allProject = new ArrayList<>();
                while (result.next()) {
                    projectBean = new ProjectBean();
                    projectBean.setId(result.getInt("id"));
                    projectBean.setName(result.getString("name"));
                    projectBean.setSector(result.getString("sector"));
                    projectBean.setMinimumPersonelNumber(result.getInt("min"));
                    projectBean.setMaximumPersonelNumber(result.getInt("max"));
                    projectBean.setProjectManagerNumber(result.getInt("projectManagerNumber"));
                    projectBean.setAnalistNumber(result.getInt("analistNumber"));
                    projectBean.setDesignerNumber(result.getInt("designerNumber"));
                    projectBean.setDeveloperNumber(result.getInt("developerNumber"));
                    projectBean.setTesterNumber(result.getInt("testerNumber"));
                    projectBean.setReadyToStart(result.getBoolean("readyToStart"));
                    projectBean.setStartedDate(result.getDate("startedDate"));
                    projectBean.setReadyToStart(result.getBoolean("readyToStart"));
                    allProject.add(projectBean);
                }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProjectDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
                try { 
                    if(conn != null)
                        conn.close();
                    if(conn != null)
                        prestmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProjectDaoIml.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return allProject;
    }

    @Override
    public boolean projectManagerOperation(ProjectBean projectBean) {
        
        
        
        
        
        return false;
    }

}
