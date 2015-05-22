/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.mycompany.consulting.management.system.bean.ProjectBean;
import com.mycompany.consulting.management.system.dao.imp.ProjectDaoIml;
import org.junit.Test;

/**
 *
 * @author semih
 */
public class AllProject {
    
    @Test
    public void all_project(){
        ProjectDaoIml daoIml = new ProjectDaoIml();
        for(ProjectBean bean : daoIml.getAllProject())
            System.out.println(bean);
    }
    
}
