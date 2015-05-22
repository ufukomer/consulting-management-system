/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.consulting.management.system.database.test;

import com.mycompany.consulting.management.system.bean.ProjectBean;
import com.mycompany.consulting.management.system.dao.imp.ProjectDaoIml;
import org.junit.Test;

/**
 *
 * @author semih
 */
public class ProjectInsertTest {
    
    @Test
    public void project_insert_test() {
        ProjectBean pro = new ProjectBean();
        pro.setName("ASD");
        pro.setSector("Okan");
        
        ProjectDaoIml imp = new ProjectDaoIml();
        imp.addProject(pro);
    }
    
    
}
