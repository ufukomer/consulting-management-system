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
import java.sql.SQLException;
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
    private static final Logger logger = Logger.getLogger(ProjectDaoIml.class.getName());

    public ProjectDaoIml() {
        try {
            conn = new ConnectionControlBean().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProjectDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean addProject(ProjectBean projectbean) {
        logger.info("Started the adding the project to the database");
        boolean isInsert = false;
        try {
            String insertSql = "insert into project (name , sector) values(?,?)";
            prestmt = conn.prepareStatement(insertSql);
            prestmt.setString(1, projectbean.getName());
            prestmt.setString(2, projectbean.getSector());
            isInsert = prestmt.execute();
        } catch (SQLException ex) {
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
            String deleteSql = "delete from project where id = ?";
            prestmt = conn.prepareStatement(deleteSql);
            prestmt.setInt(1, id);
            isDeleted = prestmt.execute();
        } catch (SQLException ex) {
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
