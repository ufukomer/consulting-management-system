/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.consulting.management.system.service;

import com.mycompany.consulting.management.system.bean.ProjectBean;
import com.mycompany.consulting.management.system.dao.imp.ProjectDaoIml;
import java.util.List;

/**
 *
 * @author MelihKerman
 */
public class ProjectService {
    
    private ProjectDaoIml daoIml;

    public ProjectService() {
        daoIml = new ProjectDaoIml();
    }
    
    public void addProject(ProjectBean bean){
        daoIml.addProject(bean);
    }
    
    public void deleteProject(int id){
        daoIml.deleteProjectById(id);
    }
    
    public ProjectBean getProject(int id){
        return daoIml.getProjectById(id);
    }
    
    public List<ProjectBean> getAllProjectList(){
        return daoIml.getAllProject();
    }
    
    
    
}
