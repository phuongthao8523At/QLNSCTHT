package com.project.vn.dao;

import com.project.vn.dto.Recuitment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RecuitmentDAO extends AbstractDAO<Recuitment>{

    private static RecuitmentDAO instance;

    public static RecuitmentDAO getInstance() {
        if (instance == null) {
            instance = new RecuitmentDAO();
        }
        return instance;
    }

    private RecuitmentDAO() {

    }

    @Override
    public Boolean add(Recuitment item) {
        PreparedStatement ps = null;
        try (Connection cnt = DBConnect.getConnection()) {
            if (cnt != null) {
                String sql = """
                             INSERT INTO recuitment(position, quantity, deadline, jobDescription) VALUES(?,?,?,?);
                             """;
                ps = cnt.prepareStatement(sql);
                ps.setString(1, item.getPosition());
                ps.setInt(2, item.getQuantity());
                ps.setString(3, item.getDeadline());
                ps.setString(4, item.getJobDescription());
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
    public Boolean update(Recuitment item) {
        PreparedStatement ps = null;
        try (Connection cnt = DBConnect.getConnection()) {
            if (cnt != null) {
                String sql = """
                             UPDATE recuitment
                             SET position = ?,
                                 quantity = ?,
                                 deadline = ?,
                                 jobDescription = ?
                             WHERE id = ?;
                             """;
                ps = cnt.prepareStatement(sql);
                ps.setString(1, item.getPosition());
                ps.setInt(2, item.getQuantity());
                ps.setString(3, item.getDeadline());
                ps.setString(4, item.getJobDescription());
                ps.setInt(5, item.getId());
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
    public void delete(int id) {
        PreparedStatement ps = null;
        try (Connection cnt = DBConnect.getConnection()) {
            if (cnt != null) {
                String sql = """
                             DELETE FROM recuitment WHERE id = ?;
                             """;
                ps = cnt.prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
                cnt.close();
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
    public List<Recuitment> getAll() throws Exception {
        List<Recuitment> list = new ArrayList<>();
        String sql = """
                     SELECT *
                     FROM recuitment;
                     """;
        PreparedStatement ps = null;
        Connection cnt = DBConnect.getConnection();
        if (cnt != null) {
            ps = cnt.prepareStatement(sql);
            var rs = ps.executeQuery();
            while (rs.next()) {
                var item = new Recuitment();
                item.setId(rs.getInt("id"));
                item.setDeadline(rs.getString("deadline"));
                item.setJobDescription(rs.getString("jobDescription"));
                item.setPosition(rs.getString("position"));
                item.setQuantity(rs.getInt("quantity"));
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
