/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.mycompany.consulting.management.system.bean.CompanyBean;
import com.mycompany.consulting.management.system.dao.imp.CompanyDaoIml;
import com.mycompany.consulting.management.system.dao.imp.ProjectDaoIml;
import java.sql.SQLException;
import org.junit.Test;

/**
 *
 * @author MelihKerman
 */
public class CompanyTest {

    @Test
    public void companyinsert() throws ClassNotFoundException, SQLException {
        CompanyDaoIml comp = new CompanyDaoIml();
        CompanyBean company = new CompanyBean();
        company.setName("deneme4");
        company.setSector("deneme");
        comp.addCompany(company);
    }
}
