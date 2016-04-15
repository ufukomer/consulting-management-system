package com.mycompany.consulting.management.system.dao;

import com.mycompany.consulting.management.system.bean.CompanyBean;

import java.sql.SQLException;
import java.util.List;

public interface CompanyDao {

    CompanyBean getCompanyById(int id) throws ClassNotFoundException, SQLException;

    List<CompanyBean> getAllCompanies() throws ClassNotFoundException, SQLException;

    boolean addCompany(CompanyBean bean) throws ClassNotFoundException, SQLException;

    CompanyBean getCompanyByName(String name) throws ClassNotFoundException, SQLException;

    CompanyBean getCompanyBySector(String sector) throws ClassNotFoundException, SQLException;
}
