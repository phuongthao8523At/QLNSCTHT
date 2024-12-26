/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.project.vn.dao;

import com.project.vn.dto.Contract;
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
import com.project.vn.dao.ContractDAO;
import com.project.vn.dto.Contract;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ContractDAOTest {

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
        ContractDAO instance1 = ContractDAO.getInstance();
        ContractDAO instance2 = ContractDAO.getInstance();
        assertNotNull(instance1);
        assertNotNull(instance2);
        assertSame(instance1, instance2);
    }

    @Test
    public void testDelete() {
        // Test deletion of a contract
        ContractDAO instance = ContractDAO.getInstance();
        // You need an actual ID of a contract to test deletion
        int idToDelete = 1; // Replace 1 with a valid contract ID
        instance.delete(idToDelete);
        // You might want to assert something here to ensure the contract was actually deleted
    }

    @Test
    public void testAdd() {
        // Test adding a new contract
        ContractDAO instance = ContractDAO.getInstance();
        // Create a sample Contract object to add
        Contract contractToAdd = new Contract();
        contractToAdd.setEmployeeId(1); // Replace 1 with a valid employee ID
        contractToAdd.setContractType("Full-time");
        contractToAdd.setStartDate("2024-04-23");
        contractToAdd.setEndDate("2025-04-23");
        boolean result = instance.add(contractToAdd);
        assertTrue(result);
    }

    @Test
    public void testUpdate() {
        // Test updating an existing contract
        ContractDAO instance = ContractDAO.getInstance();
        // Create a sample Contract object to update
        Contract contractToUpdate = new Contract();
        contractToUpdate.setId(1); // Replace 1 with a valid contract ID
        contractToUpdate.setContractType("Part-time");
        contractToUpdate.setStartDate("2024-05-01");
        contractToUpdate.setEndDate("2025-05-01");
        boolean result = instance.update(contractToUpdate);
        assertTrue(result);
    }

    @Test
    public void testGetAll() throws Exception {
        // Test retrieving all contracts
        ContractDAO instance = ContractDAO.getInstance();
        List<Contract> contracts = instance.getAll();
        assertNotNull(contracts);
        // You might want to assert something about the size or content of the list
    }
}

