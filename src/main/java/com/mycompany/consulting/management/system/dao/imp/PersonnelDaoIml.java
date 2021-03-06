package com.mycompany.consulting.management.system.dao.imp;

import com.mycompany.consulting.management.system.bean.ConnectionControlBean;
import com.mycompany.consulting.management.system.bean.PersonnelBean;
import com.mycompany.consulting.management.system.dao.PersonnelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonnelDaoIml implements PersonnelDao {

    private static final Logger logger = Logger.getLogger(PersonnelDaoIml.class.getName());
    private Connection conn;
    private PreparedStatement prestmt;
    private ResultSet rs;

    public PersonnelDaoIml() {
    }

    @Override
    public boolean addPersonnel(PersonnelBean personnelBean) {

        boolean isInsert = false;

        try {
            conn = new ConnectionControlBean().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PersonnelDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            String sql = "insert into personnel (name , surname, email, "
                    + "password, role, salary, isWorking) values(?,?,?,?,?,?,?)";

            prestmt = conn.prepareStatement(sql);

            prestmt.setString(1, personnelBean.getName());
            prestmt.setString(2, personnelBean.getSurname());
            prestmt.setString(3, personnelBean.getEmail());
            prestmt.setString(4, personnelBean.getPassword());
            prestmt.setString(5, personnelBean.getRole());
            prestmt.setInt(6, personnelBean.getSalary());
            prestmt.setBoolean(7, personnelBean.isIsWorking());

            isInsert = prestmt.execute();

            if (isInsert) {
                logger.info("Personel inserted into database");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonnelDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (prestmt != null) {
                    prestmt.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDaoIml.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return isInsert;
    }

    @Override
    public PersonnelBean getPersonnelById(int id) {

        PersonnelBean personnelBean = null;

        try {
            conn = new ConnectionControlBean().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PersonnelDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            String sql = "select * from personnel where id = ?";

            prestmt = conn.prepareStatement(sql);

            prestmt.setInt(1, id);

            rs = prestmt.executeQuery();

            while (rs.next()) {

                personnelBean = new PersonnelBean();

                personnelBean.setId(rs.getInt("id"));
                personnelBean.setName(rs.getString("name"));
                personnelBean.setSurname(rs.getString("surname"));
                personnelBean.setEmail(rs.getString("email"));
                personnelBean.setPassword(rs.getString("password"));
                personnelBean.setRole(rs.getString("role"));
                personnelBean.setSalary(rs.getInt("salary"));
                personnelBean.setIsWorking(rs.getBoolean("isWorking"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonnelDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (prestmt != null) {
                    prestmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDaoIml.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return personnelBean;
    }

    @Override
    public PersonnelBean getPersonnelByEmail(String email) {
        PersonnelBean personnelBean = null;
        try {
            conn = new ConnectionControlBean().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PersonnelDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            String sql = "select * from personnel where email = ?";

            prestmt = conn.prepareStatement(sql);

            prestmt.setString(1, email);

            rs = prestmt.executeQuery();

            while (rs.next()) {

                personnelBean = new PersonnelBean();

                personnelBean.setId(rs.getInt("id"));
                personnelBean.setName(rs.getString("name"));
                personnelBean.setSurname(rs.getString("surname"));
                personnelBean.setEmail(rs.getString("email"));
                personnelBean.setPassword(rs.getString("password"));
                personnelBean.setRole(rs.getString("role"));
                personnelBean.setSalary(rs.getInt("salary"));
                personnelBean.setIsWorking(rs.getBoolean("isWorking"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonnelDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (prestmt != null) {
                    prestmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDaoIml.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return personnelBean;
    }

    @Override
    public boolean updatePersonnelById(int id) {
        return false;
    }

    @Override
    public boolean deletePersonnelById(int id) {
        boolean isDeleted = false;
        try {
            conn = new ConnectionControlBean().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PersonnelDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            String sql = "delete from personnel where id = ?";

            prestmt = conn.prepareStatement(sql);

            prestmt.setInt(1, id);

            isDeleted = prestmt.execute();

            if (isDeleted) {
                logger.info("Personnel has been deleted");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonnelDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (prestmt != null) {
                    prestmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDaoIml.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return isDeleted;
    }

    @Override
    public List<PersonnelBean> getAllPersonnel() {

        List<PersonnelBean> personnelList = new ArrayList<>();
        try {
            conn = new ConnectionControlBean().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PersonnelDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            String sql = "select * from personnel where 1";
            prestmt = conn.prepareStatement(sql);
            rs = prestmt.executeQuery(sql);

            while (rs.next()) {
                personnelList.add(new PersonnelBean(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("role"),
                        rs.getInt("salary"),
                        rs.getBoolean("isWorking")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonnelDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (prestmt != null) {
                    prestmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDaoIml.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return personnelList;
    }

    @Override
    public List<PersonnelBean> getAllActivePersonnel() {

        List<PersonnelBean> personnelList = new ArrayList<>();
        try {
            conn = new ConnectionControlBean().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PersonnelDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            String sql = "select * from personnel where isWorking=true";
            prestmt = conn.prepareStatement(sql);
            rs = prestmt.executeQuery(sql);

            while (rs.next()) {
                personnelList.add(new PersonnelBean(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("role"),
                        rs.getInt("salary"),
                        rs.getBoolean("isWorking")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonnelDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (prestmt != null) {
                    prestmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDaoIml.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return personnelList;
    }

    @Override
    public List<PersonnelBean> getAllPassivePersonnel() {

        List<PersonnelBean> personnelList = new ArrayList<>();
        try {
            conn = new ConnectionControlBean().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PersonnelDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            String sql = "select * from personnel where isWorking=false";
            prestmt = conn.prepareStatement(sql);
            rs = prestmt.executeQuery(sql);

            while (rs.next()) {
                personnelList.add(new PersonnelBean(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("role"),
                        rs.getInt("salary"),
                        rs.getBoolean("isWorking")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonnelDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (prestmt != null) {
                    prestmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDaoIml.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return personnelList;
    }

    @Override
    public List<PersonnelBean> getFreePersonnelByRole(String role) {

        List<PersonnelBean> personnelList = new ArrayList<>();
        try {
            conn = new ConnectionControlBean().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PersonnelDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            String sql = "select * from personnel where role = '" + role + "' and isWorking = false";
            prestmt = conn.prepareStatement(sql);
            rs = prestmt.executeQuery(sql);

            while (rs.next()) {
                personnelList.add(new PersonnelBean(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("role"),
                        rs.getInt("salary"),
                        rs.getBoolean("isWorking")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonnelDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (prestmt != null) {
                    prestmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDaoIml.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return personnelList;
    }

    @Override
    public boolean updateWorkingStatus(String username, boolean isWorking) {

        List<PersonnelBean> personnelList = new ArrayList<>();
        try {
            conn = new ConnectionControlBean().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PersonnelDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            String sql = "UPDATE PERSONNEL SET isWorking=? WHERE email='" + username + "'";
            prestmt = conn.prepareStatement(sql);
            prestmt.setBoolean(1, isWorking);
            prestmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PersonnelDaoIml.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {

            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDaoIml.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return true;
    }

    @Override
    public boolean setPersonnelProjectId(int projectId, String email) {
        try {
            conn = new ConnectionControlBean().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PersonnelDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            String sql = "UPDATE PERSONNEL SET projectid=? WHERE email='" + email + "'";
            prestmt = conn.prepareStatement(sql);
            prestmt.setInt(1, projectId);
            prestmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonnelDaoIml.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean getPersonnelByProjectId(int projectId) {
        return false;
    }

    @Override
    public boolean getPersonnelWorkingStateByEmail(String email) {

        boolean isWorking = true;
        try {
            conn = new ConnectionControlBean().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PersonnelDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            String sql = "select isWorking from personnel where email = ?";

            prestmt = conn.prepareStatement(sql);

            prestmt.setString(1, email);

            rs = prestmt.executeQuery();

            while (rs.next()) {
                isWorking = rs.getBoolean("isWorking");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonnelDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (prestmt != null) {
                    prestmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDaoIml.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return isWorking;
    }

    @Override
    public boolean setPersonnelDeactivateOperation(int projectId) {

        List<PersonnelBean> personnelBeanList = getAllPersonnelByProjectId(projectId);

        // TODO DENE!
        System.out.println(personnelBeanList);

        return true;
    }

    @Override
    public boolean setPersonnelProjectOperation(int projectId, String role, int requestCount) {

        try {
            List<PersonnelBean> personnelList = getFreePersonnelByRole(role);
            for (int i = 0; i < requestCount; i++) {
                String email = personnelList.get(i).getEmail();
                setPersonnelProjectId(projectId, email);
                updateWorkingStatus(email, true);
            }
        } catch (Exception ex) {
            Logger.getLogger(PersonnelDaoIml.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }

    @Override
    public boolean isPersonnelActive(int id) {

        boolean isWorking = false;

        try {
            conn = new ConnectionControlBean().getConnection();
            logger.info("Started the getting project from database");

            String getProjectSql = "Select isWorking from personnel where id = ?";
            prestmt = conn.prepareStatement(getProjectSql);
            prestmt.setInt(1, id);
            rs = prestmt.executeQuery();

            while (rs.next()) {
                isWorking = rs.getBoolean("isWorking");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProjectDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (conn != null) {
                    prestmt.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProjectDaoIml.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return isWorking;
    }

    @Override
    public List<PersonnelBean> getAllPersonnelByProjectId(int projectId) {
        List<PersonnelBean> personnelList = new ArrayList<>();
        try {
            conn = new ConnectionControlBean().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PersonnelDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            String sql = "select * from personnel where projectId='" + projectId + "'";
            prestmt = conn.prepareStatement(sql);
            rs = prestmt.executeQuery(sql);

            while (rs.next()) {
                personnelList.add(new PersonnelBean(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("role"),
                        rs.getInt("salary"),
                        rs.getBoolean("isWorking")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonnelDaoIml.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (prestmt != null) {
                    prestmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonnelDaoIml.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return personnelList;
    }
}
