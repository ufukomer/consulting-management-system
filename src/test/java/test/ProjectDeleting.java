/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.mycompany.consulting.management.system.dao.imp.ProjectDaoIml;
import org.junit.Test;

/**
 *
 * @author semih
 */
public class ProjectDeleting {
    
    @Test
    public void project_deleting(){
        ProjectDaoIml daoIml = new ProjectDaoIml();
        
        daoIml.deleteProjectById(1);
    }
    
}
