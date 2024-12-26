package com.project.vn.dao;

import com.project.vn.dto.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDAO {

    private static AccountDAO instance;

    public static AccountDAO getInstance() {
        if (instance == null) {
            instance = new AccountDAO();
        }
        return instance;
    }

    private AccountDAO() {
    }

    public boolean login(String username, String password) {
        String sql = "SELECT * FROM account WHERE username = ?";
        PreparedStatement ps = null;
        try (Connection cnt = DBConnect.getConnection()) {
            if (cnt != null) {
                ps = cnt.prepareStatement(sql);
                ps.setString(1, username);
                var rs = ps.executeQuery();
                if (rs.next()) {
                    return password.equals(rs.getString("password"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("DAO >> login >> " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
