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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author MelihKerman
 */
public class CompanyDaoIml implements CompanyDao {

    @Override
    public CompanyBean getCompanyById(int id)throws ClassNotFoundException, SQLException {
         ConnectionControlBean connection = new ConnectionControlBean();
        Connection con = connection.getConnection();
        CompanyBean companyBean=null;
        try {

            String sql = "SELECT * FROM `company` WHERE id='"+id+"'";

           Statement stmt=con.createStatement();
           ResultSet rs=stmt.executeQuery(sql);
           while(rs.next()){
               companyBean=new CompanyBean(rs.getInt("id"),rs.getString("name"),rs.getString("sector"));
           }
 
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.close();
        }
        return companyBean;
    }

    @Override
    public List<CompanyBean> getAllCompanies()throws ClassNotFoundException, SQLException {
        List<CompanyBean> companyList=null;
          ConnectionControlBean connection = new ConnectionControlBean();
        Connection con = connection.getConnection();
        try {

            String sql = "SELECT * FROM `company` WHERE 1";

           Statement stmt=con.createStatement();
           ResultSet rs=stmt.executeQuery(sql);
           while(rs.next()){
               companyList.add(new CompanyBean(rs.getInt("id"),rs.getString("name"),rs.getString("sector")));
           }
 
        } catch (Exception ex) {
         
        } finally {
            con.close();
        }
        
     return companyList;
    
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
    public CompanyBean getCompanyByName(String name)throws ClassNotFoundException, SQLException {
           
        ConnectionControlBean connection = new ConnectionControlBean();
        Connection con = connection.getConnection();
        CompanyBean companyBean=null;
        try {

            String sql = "SELECT * FROM `company` WHERE name='"+name+"'";

           Statement stmt=con.createStatement();
           ResultSet rs=stmt.executeQuery(sql);
           while(rs.next()){
               companyBean=new CompanyBean(rs.getInt("id"),rs.getString("name"),rs.getString("sector"));
           }
 
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.close();
        }
        return companyBean;
                
    }

    @Override
    public CompanyBean getCompanyBySector(String sector)throws ClassNotFoundException, SQLException {
            ConnectionControlBean connection = new ConnectionControlBean();
        Connection con = connection.getConnection();
        CompanyBean companyBean=null;
        try {

            String sql = "SELECT * FROM `company` WHERE sector='"+sector+"'";

           Statement stmt=con.createStatement();
           ResultSet rs=stmt.executeQuery(sql);
           while(rs.next()){
               companyBean=new CompanyBean(rs.getInt("id"),rs.getString("name"),rs.getString("sector"));
           }
 
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.close();
        }
        return companyBean;
    }

   

}
