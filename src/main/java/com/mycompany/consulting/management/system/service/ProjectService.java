/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.consulting.management.system.service;

import com.mycompany.consulting.management.system.bean.ProjectBean;
import com.mycompany.consulting.management.system.dao.imp.ProjectDaoIml;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MelihKerman
 */
public class ProjectService {
    
    private ProjectDaoIml daoIml;

    public ProjectService() {
        daoIml = new ProjectDaoIml();
    }
    
    public boolean addProject(ProjectBean bean){
        return daoIml.addProject(bean);
    }
    
    public boolean deleteProject(int id){
        return daoIml.deleteProjectById(id);
    }
    
    public ProjectBean getProject(int id){
        return daoIml.getProjectById(id);
    }
    
    public List<ProjectBean> getAllProjectList(){
        return daoIml.getAllProject();
    }
    
    public List<ProjectBean> getAllActiveProject(){
        return daoIml.getAllActiveProject();
    }
    
    public void addAllProjectToTable(JTable table, DefaultTableModel tableModel){
        List<ProjectBean> projectList = getAllProjectList();
        
        if(!projectList.isEmpty()){
            table.setModel(tableModel);
            for(ProjectBean projectBean : projectList)
                tableModel.addRow(new Object[]{projectBean.getId(),projectBean.getName(),projectBean.getSector(),projectBean.getMinimumPersonelNumber()
                ,projectBean.getMaximumPersonelNumber(),projectBean.getProjectManagerNumber(),projectBean.getAnalystNumber()
                ,projectBean.getDesignerNumber(),projectBean.getDeveloperNumber(), projectBean.getTesterNumber(),projectBean.getStartedDate()
                ,projectBean.isReadyToStart()});
        }
    }
    
    public void addAllActiveProjectToTable(JTable table, DefaultTableModel tableModel){
        List<ProjectBean> projectList = getAllActiveProject();
        
        if(!projectList.isEmpty()){
            table.setModel(tableModel);
            for(ProjectBean projectBean : projectList)
                tableModel.addRow(new Object[]{projectBean.getId(),projectBean.getName(),projectBean.getSector(),projectBean.getMinimumPersonelNumber()
                ,projectBean.getMaximumPersonelNumber(),projectBean.getProjectManagerNumber(),projectBean.getAnalystNumber()
                ,projectBean.getDesignerNumber(),projectBean.getDeveloperNumber(), projectBean.getTesterNumber(),projectBean.getStartedDate()
                ,projectBean.isReadyToStart()});
        }
    }
    
    public List<ProjectBean> getAllPassiveProject() {
        return daoIml.getAllPassiveProject();
    }
    
    public boolean updateProjectStatus(int projectId, boolean updateStatus) {
        return daoIml.updateProjectStatus(projectId, updateStatus);
    }
    
    public boolean projectRoleOperation(int projectId) {
        return daoIml.projectRoleOperation(projectId);
    }
}
