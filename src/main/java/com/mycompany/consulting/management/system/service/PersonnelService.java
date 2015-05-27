/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.consulting.management.system.service;

import com.mycompany.consulting.management.system.bean.PersonnelBean;
import com.mycompany.consulting.management.system.dao.imp.PersonnelDaoIml;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
    
    public List<PersonnelBean> getAllActivePersonnel() {
        return daoIml.getAllActivePersonnel();
    }
    
    public List<PersonnelBean> getAllPassivePersonnel() {
        return daoIml.getAllPassivePersonnel();
    }
    
    public List<PersonnelBean> getFreePersonnelByRole(String role){
        return daoIml.getFreePersonnelByRole(role);
    }
    

    public boolean updateWorkingStatus(String username,boolean isWorking){
        return daoIml.updateWorkingStatus(username,isWorking);
    }
    
    public boolean setPersonnelProjectId(int projectId, String email) {
        return daoIml.setPersonnelProjectId(projectId, email);
    }

    public boolean getPersonnelWorkingState(String email) {
        return daoIml.getPersonnelWorkingStateByEmail(email);
    }
    
    public boolean setPersonnelProjectOperation(int projectId, String role, 
            int requestCount) {
        return daoIml.setPersonnelProjectOperation(projectId, role, requestCount);
    }
    
    public void addAllPassiveProjectToTable(JTable table, DefaultTableModel tableModel){
        
        
        List<PersonnelBean> personnelList = getAllPassivePersonnel();
        
        if(!personnelList.isEmpty()){
            table.setModel(tableModel);
            for(PersonnelBean personnelBean : personnelList)
                tableModel.addRow(new Object[]{personnelBean.getId(),personnelBean.getName(), personnelBean.getSurname(), personnelBean.getEmail(),personnelBean.getRole()});
        }
    }
    public void addAllActiveProjectToTable(JTable table, DefaultTableModel tableModel){
        List<PersonnelBean> personnelList = getAllActivePersonnel();
        
        if(!personnelList.isEmpty()){
            table.setModel(tableModel);
            for(PersonnelBean personnelBean : personnelList)
                tableModel.addRow(new Object[]{personnelBean.getId(),personnelBean.getName(), personnelBean.getSurname(), personnelBean.getEmail(),personnelBean.getRole()});
        }
    }
    
    public boolean isPersonnelActive(int id) {
        return daoIml.isPersonnelActive(id);
    }
    
    public List<PersonnelBean> getAllPersonnelByProjectId(int projectId) {
        return daoIml.getAllPersonnelByProjectId(projectId);
    }
    
    
    public void addAllProjectPersonnelToTable(JTable table, DefaultTableModel tableModel, int projectId){
        List<PersonnelBean> personnelList = getAllPersonnelByProjectId(projectId);
        
        if(!personnelList.isEmpty()){
            table.setModel(tableModel);
            for(PersonnelBean personnelBean : personnelList)
                tableModel.addRow(new Object[]{personnelBean.getId(),personnelBean.getName(), personnelBean.getSurname(), personnelBean.getEmail(),personnelBean.getRole()});
        }
    }
}

