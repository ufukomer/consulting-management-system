/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.mycompany.consulting.management.system.bean.PersonnelBean;
import com.mycompany.consulting.management.system.dao.imp.PersonnelDaoIml;
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
        
        PersonnelBean personnelBean = new PersonnelBean();
        personnelBean.setName("melih");
        personnelBean.setSurname("Efendi");
        personnelBean.setEmail("Omer@hot");
        personnelBean.setIsWorking(true);
        personnelBean.setSalary(10000);
        personnelBean.setRole("tasimaci");
        personnelBean.setPassword("24234234");
        PersonnelDaoIml personnelDaoIml = new PersonnelDaoIml();
        //personnelDaoIml.addPersonnel(personnelBean);
        
        List<PersonnelBean> list = personnelDaoIml.getFreePersonnelByRole("tasimaci");
        System.out.println(list);
    }
    
}
