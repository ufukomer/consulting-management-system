/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.consulting.management.system.dao;

import com.mycompany.consulting.management.system.bean.PersonnelBean;
import java.util.List;

/**
 *
 * @author MelihKerman
 */
public interface PersonnelDao {

    boolean addPersonnel(PersonnelBean personnelBean);

    PersonnelBean getPersonnelById(int id);

    PersonnelBean getPersonnelByEmail(String email);

    boolean updatePersonnelById(int id);

    boolean deletePersonnelById(int id);
    
    List<PersonnelBean> getAllPersonnel();
}
