/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.consulting.management.system.dao;

import com.mycompany.consulting.management.system.bean.CompanyBean;
import java.util.List;

/**
 *
 * @author MelihKerman
 */
public interface CompanyDao {
    
    public CompanyBean getCompanyById(int id);
    
    public List<CompanyBean> getAllCompanies();
    
    public boolean addCompany(CompanyBean bean);
    
    public List<CompanyBean> getCompanyByName();
    
    public List<CompanyBean> getCompanyBySector();
    
}
