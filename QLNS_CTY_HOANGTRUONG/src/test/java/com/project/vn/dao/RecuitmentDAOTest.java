/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.project.vn.dao;

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

public class RecuitmentDAOTest {

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
        RecuitmentDAO instance1 = RecuitmentDAO.getInstance();
        RecuitmentDAO instance2 = RecuitmentDAO.getInstance();
        assertNotNull(instance1);
        assertNotNull(instance2);
        assertSame(instance1, instance2);
    }

    @Test
    public void testAdd() {
        // Test adding a new recruitment
        RecuitmentDAO instance = RecuitmentDAO.getInstance();
        // Create a sample Recuitment object to add
        Recuitment recruitmentToAdd = new Recuitment();
        // Set properties of the recruitmentToAdd
        // Add code to set properties of the recruitmentToAdd
        boolean result = instance.add(recruitmentToAdd);
        assertTrue(result);
    }

    @Test
    public void testUpdate() {
        // Test updating an existing recruitment
        RecuitmentDAO instance = RecuitmentDAO.getInstance();
        // Create a sample Recuitment object to update
        Recuitment recruitmentToUpdate = new Recuitment();
        // Set properties of the recruitmentToUpdate
        // Add code to set properties of the recruitmentToUpdate
        boolean result = instance.update(recruitmentToUpdate);
        assertTrue(result);
    }

    @Test
    public void testDelete() {
        // Test deletion of a recruitment
        RecuitmentDAO instance = RecuitmentDAO.getInstance();
        // You need an actual ID of a recruitment to test deletion
        int idToDelete = 1; // Replace 1 with a valid recruitment ID
        instance.delete(idToDelete);
        // You might want to assert something here to ensure the recruitment was actually deleted
    }

    @Test
    public void testGetAll() throws Exception {
        // Test retrieving all recruitments
        RecuitmentDAO instance = RecuitmentDAO.getInstance();
        List<Recuitment> recruitments = instance.getAll();
        assertNotNull(recruitments);
        // You might want to assert something about the size or content of the list
    }
}

