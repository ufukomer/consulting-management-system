/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.consulting.management.system.service;

import com.mycompany.consulting.management.system.dao.LoginDao;
import java.sql.SQLException;

/**
 *
 * @author MelihKerman
 */
public class LoginService {
     LoginDao logindao;
    public LoginService(){
        logindao=new LoginDao();
    }
    public boolean loginControl(String username,String password) throws ClassNotFoundException, SQLException{
        return logindao.loginDBcontrol(username, password);
    }
}
