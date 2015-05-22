/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.consulting.management.system.dao;

import com.mycompany.consulting.management.system.bean.ProjectBean;

/**
 *
 * @author MelihKerman
 */
public interface ProjectDao {
    
    public boolean addProject(ProjectBean projectbean);

    public boolean deleteProjectById(int id);

    public boolean updateProjectById(int id);

    public ProjectBean getProjectById(int id);


    
}
