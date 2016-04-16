package com.mycompany.consulting.management.system.dao;

import com.mycompany.consulting.management.system.bean.PersonnelBean;
import java.util.List;

public interface PersonnelDao {

    boolean addPersonnel(PersonnelBean personnelBean);

    PersonnelBean getPersonnelById(int id);

    PersonnelBean getPersonnelByEmail(String email);

    boolean updatePersonnelById(int id);

    boolean deletePersonnelById(int id);
    
    List<PersonnelBean> getAllPersonnel();
    
    List<PersonnelBean> getFreePersonnelByRole(String role);
    
    boolean updateWorkingStatus(String username,boolean isWorking);
    
    boolean setPersonnelProjectId(int projectId, String email);

    boolean setPersonnelDeactivateOperation(int projectId);

    boolean getPersonnelByProjectId(int projectId);
    
    boolean getPersonnelWorkingStateByEmail(String email);
    
    boolean setPersonnelProjectOperation(int projectId, String role, int requestCount);
    
    List<PersonnelBean> getAllActivePersonnel();
    
    List<PersonnelBean> getAllPassivePersonnel();
    
    boolean isPersonnelActive(int id);
    
    List<PersonnelBean> getAllPersonnelByProjectId(int projectId);
}
