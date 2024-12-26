/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.project.vn.dao;

import com.project.vn.dto.Salary;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author PHUONG THAO
 */
import com.project.vn.dao.SalaryDAO;
import com.project.vn.dto.Salary;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class SalaryDAOTest {

    @BeforeAll
    public static void setUpClass() {
        // Any setup tasks that need to be performed once before all tests
    }

    @AfterAll
    public static void tearDownClass() {
        // Any teardown tasks that need to be performed once after all tests
    }

    @BeforeEach
    public void setUp() {
        // Any setup tasks that need to be performed before each test method
    }

    @AfterEach
    public void tearDown() {
        // Any teardown tasks that need to be performed after each test method
    }

    @Test
    public void testGetInstance() {
        // Test the singleton instance creation
        SalaryDAO instance1 = SalaryDAO.getInstance();
        SalaryDAO instance2 = SalaryDAO.getInstance();
        assertNotNull(instance1);
        assertNotNull(instance2);
        assertSame(instance1, instance2);
    }

    @Test
    public void testAdd() {
        // Test adding a new salary record
        SalaryDAO instance = SalaryDAO.getInstance();
        // Create a sample Salary object to add
        Salary salaryToAdd = new Salary();
        // Set properties of the salaryToAdd
        // Add code to set properties of the salaryToAdd
        boolean result = instance.add(salaryToAdd);
        assertTrue(result);
    }

    @Test
    public void testUpdate() {
        // Test updating an existing salary record
        SalaryDAO instance = SalaryDAO.getInstance();
        // Create a sample Salary object to update
        Salary salaryToUpdate = new Salary();
        // Set properties of the salaryToUpdate
        // Add code to set properties of the salaryToUpdate
        boolean result = instance.update(salaryToUpdate);
        assertTrue(result);
    }

    @Test
    public void testDelete() {
        // Test deletion of a salary record
        SalaryDAO instance = SalaryDAO.getInstance();
        // You need an actual ID of a salary record to test deletion
        int idToDelete = 1; // Replace 1 with a valid salary record ID
        instance.delete(idToDelete);
        // You might want to assert something here to ensure the salary record was actually deleted
    }

    @Test
    public void testGetAll() throws Exception {
        // Test retrieving all salary records
        SalaryDAO instance = SalaryDAO.getInstance();
        List<Salary> salaries = instance.getAll();
        assertNotNull(salaries);
        // You might want to assert something about the size or content of the list
    }
}

