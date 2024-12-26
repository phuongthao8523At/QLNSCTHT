package com.project.vn.dao;

import com.project.vn.dto.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDAO extends AbstractDAO<Employee> {

    private static EmployeeDAO instance;

    public static EmployeeDAO getInstance() {
        if (instance == null) {
            instance = new EmployeeDAO();
        }
        return instance;
    }

    private EmployeeDAO() {
    }

    @Override
    public void delete(int id) {
        PreparedStatement ps = null;
        try (Connection cnt = DBConnect.getConnection()) {
            if (cnt != null) {
                String sql = """
                           UPDATE employee
                           SET leaveDate = CURRENT_TIMESTAMP
                           WHERE id = ?;
                        """;
                ps = cnt.prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public Boolean checkIsExistPhone(String phone, Integer id) {
        PreparedStatement ps = null;
        try (Connection cnt = DBConnect.getConnection()) {
            if (cnt != null) {
                String sql = """
                           SELECT COUNT(1) as t FROM employee WHERE phone = ? AND id <> ?
                        """;
                ps = cnt.prepareStatement(sql);
                ps.setString(1, phone);
                ps.setObject(2, id);
                var rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getInt("t") > 0;
                }
                cnt.close();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    @Override
    public Boolean update(Employee emp) {
        PreparedStatement ps = null;
        try (Connection cnt = DBConnect.getConnection()) {
            if (cnt != null) {
                String sql = """
                           UPDATE employee
                           SET fullName = ?,
                               address = ?,
                               phone = ?,
                               gender = ?,
                               position = ?,
                               department = ?
                           WHERE id = ?;
                        """;
                ps = cnt.prepareStatement(sql);
                ps.setString(1, emp.getFullName());
                ps.setString(2, emp.getAddress());
                ps.setString(3, emp.getPhone());
                ps.setString(4, emp.getGender());
                ps.setString(5, emp.getPosition());
                ps.setString(6, emp.getDepartment());
                ps.setInt(7, emp.getId());
                ps.executeUpdate();
                cnt.close();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    @Override
    public Boolean add(Employee emp) {
        PreparedStatement ps = null;
        try (Connection cnt = DBConnect.getConnection()) {
            if (cnt != null) {
                String sql = "INSERT INTO employee(fullName, address, phone, gender, position, department) VALUES (?,?,?,?,?,?);";
                ps = cnt.prepareStatement(sql);
                ps.setString(1, emp.getFullName());
                ps.setString(2, emp.getAddress());
                ps.setString(3, emp.getPhone());
                ps.setString(4, emp.getGender());
                ps.setString(5, emp.getPosition());
                ps.setString(6, emp.getDepartment());
                ps.executeUpdate();
                cnt.close();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public List<Employee> getAllEmployeNotHaveContract() throws Exception {
        String sql = """
                SELECT e.*
                FROM employee e
                LEFT JOIN contract c on e.id = c.employeeId
                WHERE c.id IS NULL;
                """;
        List<Employee> list = new ArrayList<>();
        PreparedStatement ps = null;
        Connection cnt = DBConnect.getConnection();
        if (cnt != null) {
            ps = cnt.prepareStatement(sql);
            var rs = ps.executeQuery();
            while (rs.next()) {
                Employee item = new Employee(rs);
                list.add(item);
            }
            cnt.close();
        }
        if (ps != null) {
            ps.close();
        }
        return list;
    }

    @Override
    public List<Employee> getAll() throws Exception {
        List<Employee> list = new ArrayList<>();
        PreparedStatement ps = null;
        Connection cnt = DBConnect.getConnection();
        if (cnt != null) {
            String sql = "SELECT * FROM employee WHERE isDeleted = 0;";
            ps = cnt.prepareStatement(sql);
            var rs = ps.executeQuery();
            while (rs.next()) {
                Employee item = new Employee(rs);
                list.add(item);
            }
            cnt.close();
        }
        if (ps != null) {
            ps.close();
        }
        return list;
    }

    public List<Employee> getEmployeeNoSalary() throws Exception {
        List<Employee> list = new ArrayList<>();
        PreparedStatement ps = null;
        Connection cnt = DBConnect.getConnection();
        if (cnt != null) {
            String sql = """
                        SELECT *
                        FROM employee e
                        WHERE e.id NOT IN (SELECT s.employee_id
                                           FROM salary s);
            """;
            ps = cnt.prepareStatement(sql);
            var rs = ps.executeQuery();
            while (rs.next()) {
                Employee item = new Employee(rs);
                list.add(item);
            }
            cnt.close();
        }
        if (ps != null) {
            ps.close();
        }
        return list;
    }

    public List<Employee> getAll(String textSearch) throws Exception {
        List<Employee> list = new ArrayList<>();
        PreparedStatement ps = null;
        Connection cnt = DBConnect.getConnection();
        if (cnt != null) {
            String sql = "SELECT * FROM employee WHERE isDeleted = 0 AND fullName LIKE ?";
            ps = cnt.prepareStatement(sql);
            ps.setString(1, "%" + textSearch + "%");
            var rs = ps.executeQuery();
            while (rs.next()) {
                Employee item = new Employee(rs);
                list.add(item);
            }
            cnt.close();
        }
        if (ps != null) {
            ps.close();
        }
        return list;
    }

    public ArrayList<Integer> getStatisticEmployee() throws SQLException {
        ArrayList<Integer> list = new ArrayList<>();
        PreparedStatement ps = null;
        Connection cnt = DBConnect.getConnection();
        if (cnt != null) {
            String sql = """
                        select t1.active, t2.deleted, t3.leftThisYear, t4.joinedThisYear
                        from (select count(1) as active
                              from employee
                              where isDeleted = 0) as t1
                                 inner join (select count(1) as deleted
                                             from employee
                                             where isDeleted = 1) as t2 on true
                                 inner join (select count(1) as leftThisYear
                                             from employee
                                             where isDeleted = 1
                                               and YEAR(leaveDate) = YEAR(CURRENT_DATE)) as t3 on true
                                 inner join (select count(1) as joinedThisYear
                                             from employee
                                             where YEAR(hireDate) = YEAR(CURRENT_DATE)) as t4 on true;
                    """;
            try {
                ps = cnt.prepareStatement(sql);
                var rs = ps.executeQuery();
                if (rs.next()) {
                    list.add(rs.getInt("active"));
                    list.add(rs.getInt("deleted"));
                    list.add(rs.getInt("leftThisYear"));
                    list.add(rs.getInt("joinedThisYear"));
                }
                cnt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (ps != null) {
            ps.close();
        }
        return list;

    }
}
