/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.consulting.management.system.service;

import com.mycompany.consulting.management.system.bean.PersonnelBean;
import com.mycompany.consulting.management.system.dao.imp.PersonnelDaoIml;
import java.util.List;

/**
 *
 * @author MelihKerman
 */
public class PersonnelService {
    
    private PersonnelDaoIml daoIml;
    
    public PersonnelService() {
        daoIml = new PersonnelDaoIml();
    }
    
    public boolean addPersonnel(PersonnelBean personnelBean) {
        return daoIml.addPersonnel(personnelBean);
    }
    
    public boolean deletePersonnel(int id) {
        return daoIml.deletePersonnelById(id);
    }
    
    public PersonnelBean getPersonnel(int id) {
        return daoIml.getPersonnelById(id);
    }
    
    public PersonnelBean getPersonnel(String email) {
        return daoIml.getPersonnelByEmail(email);
    }
    
    public List<PersonnelBean> getAllPersonnel() {
        return daoIml.getAllPersonnel();
    }
}
