
package com.project.vn.dto;

import lombok.Data;


@Data
public class Salary {
    private Integer id;
    private Integer employeeId;
    private Double salaryAmount;
    private Double wage;
    private Integer workingDay;
    private String salaryDate;
    private String detail;
    private Employee employee;
}
