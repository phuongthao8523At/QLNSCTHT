package com.project.vn.dao;

import com.project.vn.dto.Contract;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContractDAO extends AbstractDAO<Contract>{

    private static ContractDAO instance;

    public static ContractDAO getInstance() {
        if (instance == null) {
            instance = new ContractDAO();
        }
        return instance;
    }

    private ContractDAO() {
    }

    @Override
    public void delete(int id) {
        PreparedStatement ps = null;
        try (Connection cnt = DBConnect.getConnection()) {
            if (cnt != null) {
                String sql = """
                                DELETE FROM contract WHERE id = ?;
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

    @Override
    public Boolean add(Contract item) {
        PreparedStatement ps = null;
        try (Connection cnt = DBConnect.getConnection()) {
            if (cnt != null) {
                String sql = "INSERT INTO contract(employeeId, contractType, startDate, endDate) VALUES (?,?,?,?);";
                ps = cnt.prepareStatement(sql);
                ps.setInt(1, item.getEmployeeId());
                ps.setString(2, item.getContractType());
                ps.setString(3, item.getStartDate());
                ps.setString(4, item.getEndDate());
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
    public Boolean update(Contract item) {
        PreparedStatement ps = null;
        try (Connection cnt = DBConnect.getConnection()) {
            if (cnt != null) {
                String sql = """
                             UPDATE contract
                             SET contractType = ?,
                                 startDate = ?,
                                 endDate = ?
                             WHERE id = ?;
                             """;
                ps = cnt.prepareStatement(sql);
                ps.setString(1, item.getContractType());
                ps.setString(2, item.getStartDate());
                ps.setString(3, item.getEndDate());
                ps.setInt(4, item.getId());
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
    public List<Contract> getAll() throws Exception {
        List<Contract> list = new ArrayList<>();
        PreparedStatement ps = null;
        Connection cnt = DBConnect.getConnection();
        if (cnt != null) {
            String sql = """
                         SELECT c.*, e.fullName, e.position
                         FROM contract c
                         LEFT JOIN employee e on e.id = c.employeeId AND e.isDeleted = 0
                         WHERE c.isDeleted = 0;
                         """;
            ps = cnt.prepareStatement(sql);
            var rs = ps.executeQuery();
            while (rs.next()) {
                var item = new Contract();
                item.setId(rs.getInt("id"));
                item.setEmployeeId(rs.getInt("employeeId"));
                item.setContractType(rs.getString("contractType"));
                item.setStartDate(rs.getString("startDate"));
                item.setEndDate(rs.getString("endDate"));
                item.setIsDeleted(rs.getBoolean("isDeleted"));
                item.setFullName(rs.getString("fullName"));
                item.setPosition(rs.getString("position"));
                list.add(item);
            }
            cnt.close();
        }
        if (ps != null) {
            ps.close();
        }
        return list;
    }
}
