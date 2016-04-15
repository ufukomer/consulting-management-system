package com.mycompany.consulting.management.system.dao;

import com.mycompany.consulting.management.system.bean.ProjectBean;

import java.util.List;

public interface ProjectDao {

    boolean addProject(ProjectBean projectbean);

    boolean deleteProjectById(int id);

    @Deprecated
    boolean updateProjectById(int id);

    ProjectBean getProjectById(int id);

    List<ProjectBean> getAllProject();

    List<ProjectBean> getAllPassiveProject();

    List<ProjectBean> getAllActiveProject();

    boolean projectRoleOperation(int projectId);

    boolean updateProjectStatus(int projectId, boolean updateStatus);

    boolean updateProjectDateById(int id);

    boolean isProjectActive(int id);
}
