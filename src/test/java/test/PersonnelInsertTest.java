/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.mycompany.consulting.management.system.bean.PersonnelBean;
import com.mycompany.consulting.management.system.dao.imp.PersonnelDaoIml;
import org.junit.Test;

/**
 *
 * @author Ufuk
 */
public class PersonnelInsertTest {
    @Test
    public void personnel_select_test() {
        
        PersonnelBean personnelBean = new PersonnelBean();
        personnelBean.setName("Omer");
        personnelBean.setSurname("efendioglu");
        personnelBean.setEmail("ufukomer@hotmail.com");
        personnelBean.setPassword("password");
        personnelBean.setRole("tuccar");
        personnelBean.setSalary(15000);
        personnelBean.setIsWorking(true);
        
        
        PersonnelDaoIml personnelDaoIml = new PersonnelDaoIml();
        //personnelDaoIml.addPersonnel(personnelBean);
        
        PersonnelBean omer = personnelDaoIml.getPersonelByEmail("ufukomer@hotmail.com");
        
        System.out.println(omer.getName());
    }
}
