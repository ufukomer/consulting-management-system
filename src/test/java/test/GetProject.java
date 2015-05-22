/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.mycompany.consulting.management.system.bean.ProjectBean;
import com.mycompany.consulting.management.system.dao.ProjectDao;
import com.mycompany.consulting.management.system.dao.imp.ProjectDaoIml;
import org.junit.Test;

/**
 *
 * @author semih
 */
public class GetProject {
    
    @Test
    public void getting_project(){
        ProjectDao projectDao = new ProjectDaoIml();
        ProjectBean projectBean = projectDao.getProjectById(2);
        
        System.out.println(projectBean);
    }
    
}
