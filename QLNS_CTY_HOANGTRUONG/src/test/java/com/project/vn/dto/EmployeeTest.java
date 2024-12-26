package com.project.vn.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {
    
    @Test
    public void testGetId() {
        Employee instance = new Employee();
        assertNull(instance.getId());
    }

    @Test
    public void testGetFullName() {
        Employee instance = new Employee();
        assertEquals("", instance.getFullName());
    }

    @Test
    public void testGetAddress() {
        Employee instance = new Employee();
        assertEquals("", instance.getAddress());
    }

    @Test
    public void testGetPhone() {
        Employee instance = new Employee();
        assertEquals("", instance.getPhone());
    }

    @Test
    public void testGetGender() {
        Employee instance = new Employee();
        assertEquals("", instance.getGender());
    }

    @Test
    public void testGetPosition() {
        Employee instance = new Employee();
        assertEquals("", instance.getPosition());
    }

    @Test
    public void testGetDepartment() {
        Employee instance = new Employee();
        assertEquals("", instance.getDepartment());
    }

    @Test
    public void testGetIsDeleted() {
        Employee instance = new Employee();
        assertNull(instance.getIsDeleted());
    }

    @Test
    public void testSetId() {
        Employee instance = new Employee();
        instance.setId(1);
        assertEquals(1, instance.getId());
    }

    @Test
    public void testSetFullName() {
        Employee instance = new Employee();
        instance.setFullName("John Doe");
        assertEquals("John Doe", instance.getFullName());
    }

    @Test
    public void testSetAddress() {
        Employee instance = new Employee();
        instance.setAddress("123 Main St");
        assertEquals("123 Main St", instance.getAddress());
    }

    @Test
    public void testSetPhone() {
        Employee instance = new Employee();
        instance.setPhone("123-456-7890");
        assertEquals("123-456-7890", instance.getPhone());
    }

    @Test
    public void testSetGender() {
        Employee instance = new Employee();
        instance.setGender("Male");
        assertEquals("Male", instance.getGender());
    }

    @Test
    public void testSetPosition() {
        Employee instance = new Employee();
        instance.setPosition("Manager");
        assertEquals("Manager", instance.getPosition());
    }

    @Test
    public void testSetDepartment() {
        Employee instance = new Employee();
        instance.setDepartment("IT");
        assertEquals("IT", instance.getDepartment());
    }

    @Test
    public void testSetIsDeleted() {
        Employee instance = new Employee();
        instance.setIsDeleted(true);
        assertTrue(instance.getIsDeleted());
    }

    @Test
    public void testEquals() {
        Employee instance1 = new Employee();
        Employee instance2 = new Employee();
        assertTrue(instance1.equals(instance2));
    }

    @Test
    public void testCanEqual() {
        Employee instance = new Employee();
        assertTrue(instance.canEqual(new Employee()));
    }

    @Test
    public void testHashCode() {
        Employee instance = new Employee();
        assertEquals(0, instance.hashCode());
    }

    @Test
    public void testToString() {
        Employee instance = new Employee();


        assertEquals("Employee{id=null, fullName='', address='', phone='', gender='', position='', department='', isDeleted=null}", instance.toString());
    }
}
