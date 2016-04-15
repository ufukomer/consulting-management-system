package com.mycompany.consulting.management.system.service;

import com.mycompany.consulting.management.system.dao.LoginDao;

import java.sql.SQLException;

public class LoginService {

    private LoginDao logindao;

    public LoginService() {
        logindao = new LoginDao();
    }

    public boolean loginControl(String username, String password)
            throws ClassNotFoundException, SQLException {
        return logindao.loginDBcontrol(username, password);
    }
}
