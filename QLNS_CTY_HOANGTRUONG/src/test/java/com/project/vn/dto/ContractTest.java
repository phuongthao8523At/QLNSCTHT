package com.project.vn.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContractTest {
    
    @Test
    public void testGetId() {
        Contract instance = new Contract();
        assertNull(instance.getId());
    }

    @Test
    public void testGetEmployeeId() {
        Contract instance = new Contract();
        assertNull(instance.getEmployeeId());
    }

    @Test
    public void testGetContractType() {
        Contract instance = new Contract();
        assertEquals("", instance.getContractType());
    }

    @Test
    public void testGetStartDate() {
        Contract instance = new Contract();
        assertEquals("", instance.getStartDate());
    }

    @Test
    public void testGetEndDate() {
        Contract instance = new Contract();
        assertEquals("", instance.getEndDate());
    }

    @Test
    public void testGetIsDeleted() {
        Contract instance = new Contract();
        assertNull(instance.getIsDeleted());
    }

    @Test
    public void testSetId() {
        Contract instance = new Contract();
        instance.setId(1);
        assertEquals(1, instance.getId());
    }

    @Test
    public void testSetEmployeeId() {
        Contract instance = new Contract();
        instance.setEmployeeId(1);
        assertEquals(1, instance.getEmployeeId());
    }

    @Test
    public void testSetContractType() {
        Contract instance = new Contract();
        instance.setContractType("Full-time");
        assertEquals("Full-time", instance.getContractType());
    }

    @Test
    public void testSetStartDate() {
        Contract instance = new Contract();
        instance.setStartDate("2024-01-01");
        assertEquals("2024-01-01", instance.getStartDate());
    }

    @Test
    public void testSetEndDate() {
        Contract instance = new Contract();
        instance.setEndDate("2024-12-31");
        assertEquals("2024-12-31", instance.getEndDate());
    }

    @Test
    public void testSetIsDeleted() {
        Contract instance = new Contract();
        instance.setIsDeleted(true);
        assertTrue(instance.getIsDeleted());
    }

    @Test
    public void testEquals() {
        Contract instance1 = new Contract();
        Contract instance2 = new Contract();
        assertTrue(instance1.equals(instance2));
    }

    @Test
    public void testCanEqual() {
        Contract instance = new Contract();
        assertTrue(instance.canEqual(new Contract()));
    }

    @Test
    public void testHashCode() {
        Contract instance = new Contract();
        assertEquals(0, instance.hashCode());
    }

    @Test
    public void testToString() {
        Contract instance = new Contract();
        assertEquals("Contract{id=null, employeeId=null, contractType='', startDate='', endDate='', isDeleted=null}", instance.toString());
    }
}
