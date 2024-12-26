package com.project.vn.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

    static final String URL_DB = "jdbc:mysql://localhost:3306/qlnsHT";
    static final String USER = "root";
    static final String PASS = "1234";

    public static Connection getConnection() {
        Connection cnt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnt = DriverManager.getConnection(URL_DB, USER, PASS);
        } catch (Exception e) {
            System.out.println("Kết nối thất bại: " + e.getMessage());
        }
        return cnt;
    }
}
