/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.mycompany.consulting.management.system.bean.PersonnelBean;
import com.mycompany.consulting.management.system.dao.imp.PersonnelDaoIml;
import com.mycompany.consulting.management.system.service.ProjectService;
import java.util.List;

/**
 *
 * @author Ufuk
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //ProjectService projectService=new ProjectService();
       //projectService.projectRoleOperation(1);
       
        PersonnelDaoIml personnelDaoIml = new PersonnelDaoIml();
        System.out.println(personnelDaoIml.getAllPersonnelByProjectId(9));
    }
    
}
