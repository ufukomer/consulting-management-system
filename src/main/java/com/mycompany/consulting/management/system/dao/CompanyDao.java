/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.consulting.management.system.dao;

import com.mycompany.consulting.management.system.bean.CompanyBean;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author MelihKerman
 */
public interface CompanyDao {
    
    public CompanyBean getCompanyById(int id)throws ClassNotFoundException, SQLException;
    
    public List<CompanyBean> getAllCompanies()throws ClassNotFoundException, SQLException;
    
    public boolean addCompany(CompanyBean bean) throws ClassNotFoundException, SQLException;
    
    public CompanyBean getCompanyByName(String name)throws ClassNotFoundException, SQLException;
    
    public CompanyBean getCompanyBySector(String sector)throws ClassNotFoundException, SQLException;
    
}
