/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.consulting.management.system.service;

import com.mycompany.consulting.management.system.bean.CompanyBean;
import com.mycompany.consulting.management.system.dao.imp.CompanyDaoIml;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author MelihKerman
 */
public class CompanyService {
    
    private CompanyDaoIml companyDaoIml;
    
    public CompanyService(){
        companyDaoIml=new CompanyDaoIml();
    }
    
    public boolean addCompany(CompanyBean companyBean) throws ClassNotFoundException, SQLException{
        return companyDaoIml.addCompany(companyBean);
    }
    
  
    public CompanyBean getCompanyById(int id) throws ClassNotFoundException, SQLException{
      return companyDaoIml.getCompanyById(id);
    }
    
    public List<CompanyBean> getAllCompanies()throws ClassNotFoundException, SQLException{
        return companyDaoIml.getAllCompanies();
    }
    
    
    
    public CompanyBean getCompanyByName(String name)throws ClassNotFoundException, SQLException{
        return companyDaoIml.getCompanyByName(name);
    }
    
    public CompanyBean getCompanyBySector(String sector)throws ClassNotFoundException, SQLException{
        return companyDaoIml.getCompanyBySector(sector);
    }
}
