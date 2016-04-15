package com.mycompany.consulting.management.system.dao;

import com.mycompany.consulting.management.system.bean.ConnectionControlBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class LoginDao {

    private final static Logger LOGGER = Logger.getLogger(LoginDao.class.getName());

    public LoginDao() {
    }

    public boolean loginDBcontrol(String username, String password)
            throws ClassNotFoundException, SQLException {

        boolean success = false;

        ConnectionControlBean connection = new ConnectionControlBean();

        try (Connection con = connection.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM personnel WHERE email = '"
                    + username + "'");
            while (rs.next()) {
                System.out.println(rs.getString("password"));
                success = password.equals(rs.getString("password"));
            }
        } catch (Exception ex) {

        }
        return success;
    }
}
