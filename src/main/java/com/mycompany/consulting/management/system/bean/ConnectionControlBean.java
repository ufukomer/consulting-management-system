package com.mycompany.consulting.management.system.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.logging.Logger;

public class ConnectionControlBean {

    String a;

    public String myDriver = "com.mysql.jdbc.Driver";
    public final String url = "jdbc:mysql://127.0.0.1/";
    public final String db = "consultingmanagementsystem";
    public final String user = "root";//ProjectProperties.getProperty("mysql.username");
    public final String Password = "";// ProjectProperties.getProperty("mysql.password");
    private final static Logger LOGGER = Logger.getLogger(ConnectionControlBean.class.getName());

    public Connection getConnection() throws ClassNotFoundException {

        try {
            Class.forName(myDriver);
            Connection con = DriverManager.getConnection(url + db, user,
                    Password);
            LOGGER.info("CONNECTED DB!");
            return con;
        } catch (SQLException ex) {
            LOGGER.warning("DB Connection Error! ," + ex.getMessage());

        }

        return null;

    }
}
