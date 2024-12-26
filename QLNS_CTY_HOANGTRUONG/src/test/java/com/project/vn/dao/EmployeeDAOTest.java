/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.project.vn.dao;

import com.project.vn.dto.Employee;
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
import com.project.vn.dao.EmployeeDAO;
import com.project.vn.dto.Employee;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class EmployeeDAOTest {

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
        EmployeeDAO instance1 = EmployeeDAO.getInstance();
        EmployeeDAO instance2 = EmployeeDAO.getInstance();
        assertNotNull(instance1);
        assertNotNull(instance2);
        assertSame(instance1, instance2);
    }

    @Test
    public void testDelete() {
        // Test deletion of an employee
        EmployeeDAO instance = EmployeeDAO.getInstance();
        // You need an actual ID of an employee to test deletion
        int idToDelete = 1; // Replace 1 with a valid employee ID
        instance.delete(idToDelete);
        // You might want to assert something here to ensure the employee was actually deleted
    }

    @Test
    public void testCheckIsExistPhone() {
        // Test checking if a phone number already exists for another employee
        EmployeeDAO instance = EmployeeDAO.getInstance();
        // Provide a phone number and employee ID for testing
        String phone = "13123123213"; // Replace with a valid phone number
        int id = 1; // Replace 1 with a valid employee ID
        boolean result = instance.checkIsExistPhone(phone, id);
        assertFalse(result); // Assuming the phone number doesn't exist for another employee
    }

    @Test
    public void testUpdate() {
        // Test updating an existing employee
        EmployeeDAO instance = EmployeeDAO.getInstance();
        // Create a sample Employee object to update
        Employee employeeToUpdate = new Employee();
        // Set properties of the employeeToUpdate
        // Add code to set properties of the employeeToUpdate
        boolean result = instance.update(employeeToUpdate);
        assertTrue(result);
    }

    @Test
    public void testAdd() {
        // Test adding a new employee
        EmployeeDAO instance = EmployeeDAO.getInstance();
        // Create a sample Employee object to add
        Employee employeeToAdd = new Employee();
        // Set properties of the employeeToAdd
        // Add code to set properties of the employeeToAdd
        boolean result = instance.add(employeeToAdd);
        assertTrue(result);
    }

    @Test
    public void testGetAllEmployeNotHaveContract() throws Exception {
        // Test retrieving all employees who do not have a contract
        EmployeeDAO instance = EmployeeDAO.getInstance();
        List<Employee> employees = instance.getAllEmployeNotHaveContract();
        assertNotNull(employees);
        // You might want to assert something about the size or content of the list
    }

    @Test
    public void testGetAll() throws Exception {
        // Test retrieving all employees
        EmployeeDAO instance = EmployeeDAO.getInstance();
        List<Employee> employees = instance.getAll();
        assertNotNull(employees);
        // You might want to assert something about the size or content of the list
    }

    @Test
    public void testGetAllWithTextSearch() throws Exception {
        // Test retrieving all employees with a specific text search
        EmployeeDAO instance = EmployeeDAO.getInstance();
        // Provide a search text for testing
        String searchText = "John"; // Replace with a valid search text
        List<Employee> employees = instance.getAll(searchText);
        assertNotNull(employees);
        // You might want to assert something about the size or content of the list
    }
}
