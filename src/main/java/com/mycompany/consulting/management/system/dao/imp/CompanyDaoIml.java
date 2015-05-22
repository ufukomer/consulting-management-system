/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.consulting.management.system.dao.imp;

import com.mycompany.consulting.management.system.bean.CompanyBean;
import com.mycompany.consulting.management.system.bean.ConnectionControlBean;
import com.mycompany.consulting.management.system.dao.CompanyDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author MelihKerman
 */
public class CompanyDaoIml implements CompanyDao {

    @Override
    public CompanyBean getCompanyById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CompanyBean> getAllCompanies() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addCompany(CompanyBean bean) throws ClassNotFoundException, SQLException {

        ConnectionControlBean connection = new ConnectionControlBean();
        Connection con = connection.getConnection();
        try {

            String sql = "INSERT INTO `company`(`name`, `sector`) VALUES  VALUES (?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, bean.getName());
            ps.setString(2, bean.getSector());

            ps.executeUpdate();

        } catch (Exception ex) {
            return false;
        } finally {
            con.close();
        }
        
        return true;
    }

    @Override
    public List<CompanyBean> getCompanyByName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CompanyBean> getCompanyBySector() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
