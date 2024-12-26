package com.project.vn.dto;

import lombok.Data;


@Data
public class Contract extends Employee{
    private Integer id;
    private Integer employeeId;
    private String contractType;
    private String startDate;
    private String endDate;
    private Boolean isDeleted;
}
