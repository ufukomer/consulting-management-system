/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.consulting.management.system.dao;

import com.mycompany.consulting.management.system.bean.ProjectBean;
import java.util.List;

/**
 *
 * @author MelihKerman
 */
public interface ProjectDao {
    
    public boolean addProject(ProjectBean projectbean);

    public boolean deleteProjectById(int id);

    @Deprecated
    public boolean updateProjectById(int id);

    public ProjectBean getProjectById(int id);

    public List<ProjectBean> getAllProject();
    
    public List<ProjectBean> getAllPassiveProject();
    
    public List<ProjectBean> getAllActiveProject();
    
    public boolean projectRoleOperation(int projectId);
    
    public boolean updateProjectStatus(int projectId, boolean updateStatus);
    
    public boolean updateProjectDateById(int id);
    
    public boolean isProjectActive(int id);
}
