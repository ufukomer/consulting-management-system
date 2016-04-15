/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.consulting.management.system.dao.imp;

import com.mycompany.consulting.management.system.bean.ConnectionControlBean;
import com.mycompany.consulting.management.system.bean.ProjectBean;
import com.mycompany.consulting.management.system.dao.ProjectDao;
import com.mycompany.consulting.management.system.service.PersonnelService;
import com.mycompany.consulting.management.system.service.ProjectService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
            String insertSql = "insert into project (startedDate,name , sector , min , max,projectManagerNumber,"
                    + "analystNumber,designerNumber,developerNumber,testerNumber,readyToStart) values(CURDATE(),?,?,?,?,?,?,?,?,?,?)";
            prestmt = conn.prepareStatement(insertSql);
            prestmt.setString(1, projectbean.getName());
            prestmt.setString(2, projectbean.getSector());
            prestmt.setString(3, String.valueOf(projectbean.getMinimumPersonelNumber()));
            prestmt.setString(4, String.valueOf(projectbean.getMaximumPersonelNumber()));
            prestmt.setString(5, String.valueOf(projectbean.getProjectManagerNumber()));
            prestmt.setString(6, String.valueOf(projectbean.getAnalystNumber()));
            prestmt.setString(7, String.valueOf(projectbean.getDesignerNumber()));
            prestmt.setString(8, String.valueOf(projectbean.getDeveloperNumber()));
            prestmt.setString(9, String.valueOf(projectbean.getTesterNumber()));
            prestmt.setBoolean(10, false);
            isInsert = prestmt.execute();
        } catch (Exception ex) {
            Logger.getLogger(ProjectDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (prestmt != null) {
                    prestmt.close();
                }
                if (isInsert == true) {
                    logger.info("Adding the project to database:");
                }
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
        } catch (Exception ex) {
            Logger.getLogger(ProjectDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (conn != null) {
                    prestmt.close();
                }
                if (isDeleted == true) {
                    logger.info("Deleting the project from database");
                }
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
            while (result.next()) {
                project.setId(result.getInt("id"));
                project.setName(result.getString("name"));
                project.setSector(result.getString("sector"));
                project.setAnalystNumber(result.getInt("analystNumber"));
                project.setDesignerNumber(result.getInt("designerNumber"));
                project.setDeveloperNumber(result.getInt("developerNumber"));
                project.setProjectManagerNumber(result.getInt("projectManagerNumber"));
                project.setTesterNumber(result.getInt("testerNumber"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProjectDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (conn != null) {
                    prestmt.close();
                }
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
                projectBean.setAnalystNumber(result.getInt("analystNumber"));
                projectBean.setDesignerNumber(result.getInt("designerNumber"));
                projectBean.setDeveloperNumber(result.getInt("developerNumber"));
                projectBean.setTesterNumber(result.getInt("testerNumber"));
                projectBean.setReadyToStart(result.getBoolean("readyToStart"));
                projectBean.setStartedDate(result.getDate("startedDate"));
                projectBean.setReadyToStart(result.getBoolean("readyToStart"));
                allProject.add(projectBean);
            }
        } catch (Exception ex) {

            Logger.getLogger(ProjectDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (conn != null) {
                    prestmt.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProjectDaoIml.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return allProject;
    }

    @Override
    public List<ProjectBean> getAllActiveProject() {
        List<ProjectBean> allProject = null;
        ProjectBean projectBean = null;
        try {
            conn = new ConnectionControlBean().getConnection();
            logger.info("Started the getting all project ");

            String getAllProject = "Select * from project where readyToStart = true";
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
                projectBean.setAnalystNumber(result.getInt("analystNumber"));
                projectBean.setDesignerNumber(result.getInt("designerNumber"));
                projectBean.setDeveloperNumber(result.getInt("developerNumber"));
                projectBean.setTesterNumber(result.getInt("testerNumber"));
                projectBean.setReadyToStart(result.getBoolean("readyToStart"));
                projectBean.setStartedDate(result.getDate("startedDate"));
                projectBean.setReadyToStart(result.getBoolean("readyToStart"));
                allProject.add(projectBean);
            }
        } catch (Exception ex) {

            Logger.getLogger(ProjectDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (conn != null) {
                    prestmt.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProjectDaoIml.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return allProject;
    }

    @Override
    public List<ProjectBean> getAllPassiveProject() {
        List<ProjectBean> allProject = null;
        ProjectBean projectBean = null;
        try {
            conn = new ConnectionControlBean().getConnection();
            logger.info("Started the getting all project ");

            String getAllProject = "Select * from project where readyToStart = false";
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
                projectBean.setAnalystNumber(result.getInt("analystNumber"));
                projectBean.setDesignerNumber(result.getInt("designerNumber"));
                projectBean.setDeveloperNumber(result.getInt("developerNumber"));
                projectBean.setTesterNumber(result.getInt("testerNumber"));
                projectBean.setReadyToStart(result.getBoolean("readyToStart"));
                projectBean.setStartedDate(result.getDate("startedDate"));
                projectBean.setReadyToStart(result.getBoolean("readyToStart"));
                allProject.add(projectBean);
            }
        } catch (Exception ex) {

            Logger.getLogger(ProjectDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (conn != null) {
                    prestmt.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProjectDaoIml.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return allProject;
    }

    @Override
    public boolean projectRoleOperation(int projectId) {

        PersonnelService personnelService = new PersonnelService();
        ProjectService projectService = new ProjectService();
        try {

            int analystCount = personnelService.getFreePersonnelByRole("Analyst").size();
            int projectManagerCount = personnelService.getFreePersonnelByRole("Project Manager").size();;
            int designerCount = personnelService.getFreePersonnelByRole("Designer").size();;
            int developerCount = personnelService.getFreePersonnelByRole("Developer").size();;
            int testerCount = personnelService.getFreePersonnelByRole("Tester").size();;

            ProjectBean projectBean = getProjectById(projectId);

            if (projectBean.getAnalystNumber() <= analystCount
                    && projectBean.getDesignerNumber() <= designerCount
                    && projectBean.getDeveloperNumber() <= developerCount
                    && projectBean.getProjectManagerNumber() <= projectManagerCount
                    && projectBean.getTesterNumber() <= testerCount) {

                personnelService.setPersonnelProjectOperation(projectId, "Analyst", projectBean.getAnalystNumber());
                personnelService.setPersonnelProjectOperation(projectId, "Project Manager", projectBean.getProjectManagerNumber());
                personnelService.setPersonnelProjectOperation(projectId, "Designer", projectBean.getDesignerNumber());
                personnelService.setPersonnelProjectOperation(projectId, "Developer", projectBean.getDeveloperNumber());
                personnelService.setPersonnelProjectOperation(projectId, "Tester", projectBean.getTesterNumber());
                projectService.updateProjectStatus(projectId, true);
                logger.info("ProjectRoleOperation completed with Project Id: " + projectId);
            } else {
                throw new Exception();
            }

        } catch (Exception ex) {
            logger.warning("ProjectRoleOperation error with Project Id: " + projectId + " Message:" + ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean updateProjectStatus(int projectId, boolean updateStatus) {
        
        try {
            conn = new ConnectionControlBean().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PersonnelDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            String sql = "UPDATE project SET readyToStart=? WHERE id='" + projectId + "'";
            prestmt = conn.prepareStatement(sql);
            prestmt.setBoolean(1, updateStatus);
            prestmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProjectDaoIml.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {

            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProjectDaoIml.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return true;
    }

    @Override
    public boolean updateProjectDateById(int id) {
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        
        java.sql.Date datee = new java.sql.Date(id, id, id);
        
        System.out.println(dateFormat.format(date));
        
        try {
            conn = new ConnectionControlBean().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PersonnelDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {

            String sql = "UPDATE project SET startedDate=? WHERE id='" + id + "'";
            prestmt = conn.prepareStatement(sql);
            prestmt.setDate(1, (java.sql.Date) date);
            prestmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProjectDaoIml.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {

            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProjectDaoIml.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return true;
    }

    @Override
    public boolean isProjectActive(int id) {
        
        boolean readyToStart = false;
        try {
            conn = new ConnectionControlBean().getConnection();
            logger.info("Started the getting project from database");

            String getProjectSql = "Select readyToStart from project where id = ?";
            prestmt = conn.prepareStatement(getProjectSql);
            prestmt.setInt(1, id);
            result = prestmt.executeQuery();
            
            while (result.next()) {
                readyToStart = result.getBoolean("readyToStart");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProjectDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (conn != null) {
                    prestmt.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProjectDaoIml.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return readyToStart;
    }
}
