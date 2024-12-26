package com.project.vn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer id;
    private String fullName;
    private String address;
    private String phone;
    private String gender;
    private String position;
    private String department;
    private Date hireDate;
    private Date leaveDate;
    private Boolean isDeleted;

    public Employee(ResultSet rs) throws SQLException {
        this(
                rs.getInt("id"),
                rs.getString("fullName"),
                rs.getString("address"),
                rs.getString("phone"),
                rs.getString("gender"),
                rs.getString("position"),
                rs.getString("department"),
                rs.getDate("hireDate"),
                rs.getDate("leaveDate"),
                rs.getBoolean("isDeleted")
        );
    }
}
