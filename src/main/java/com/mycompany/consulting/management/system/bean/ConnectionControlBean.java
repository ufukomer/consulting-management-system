package com.mycompany.consulting.management.system.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.logging.Logger;

public class ConnectionControlBean {

    private final String myDriver = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://127.0.0.1/";
    private final String db = "consult";
    private final String user = "root"; //ProjectProperties.getProperty("mysql.username");
    private final String Password = "root"; // ProjectProperties.getProperty("mysql.password");
    private final static Logger LOGGER = Logger.getLogger(ConnectionControlBean.class.getName());

    public Connection getConnection() throws ClassNotFoundException {

        try {
            Class.forName(myDriver);
            Connection con = DriverManager.getConnection(url + db, user, Password);
            LOGGER.info("Connected to DB!");
            return con;
        } catch (SQLException ex) {
            LOGGER.warning("DB Connection Error! ," + ex.getMessage());
        }

        return null;
    }
}
