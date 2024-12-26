package com.project.vn.dto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class SalaryTest {
    
    @Test
    public void testGetId() {
        Salary instance = new Salary();
        assertNull(instance.getId());
    }

    @Test
    public void testGetEmployeeId() {
        Salary instance = new Salary();
        assertNull(instance.getEmployeeId());
    }

    @Test
    public void testGetSalaryAmount() {
        Salary instance = new Salary();
        assertNull(instance.getSalaryAmount());
    }

    @Test
    public void testGetSalaryDate() {
        Salary instance = new Salary();
        assertEquals("", instance.getSalaryDate());
    }

    @Test
    public void testGetDetail() {
        Salary instance = new Salary();
        assertEquals("", instance.getDetail());
    }

    @Test
    public void testGetEmployee() {
        Salary instance = new Salary();
        assertNull(instance.getEmployee());
    }

    @Test
    public void testSetId() {
        Salary instance = new Salary();
        instance.setId(1);
        assertEquals(1, instance.getId());
    }

    @Test
    public void testSetEmployeeId() {
        Salary instance = new Salary();
        instance.setEmployeeId(1);
        assertEquals(1, instance.getEmployeeId());
    }

    @Test
    public void testSetSalaryAmount() {
        Salary instance = new Salary();
        instance.setSalaryAmount(1000.0);
        assertEquals(1000.0, instance.getSalaryAmount());
    }

    @Test
    public void testSetSalaryDate() {
        Salary instance = new Salary();
        instance.setSalaryDate("2024-04-30");
        assertEquals("2024-04-30", instance.getSalaryDate());
    }

    @Test
    public void testSetDetail() {
        Salary instance = new Salary();
        instance.setDetail("Bonus: $100");
        assertEquals("Bonus: $100", instance.getDetail());
    }

    @Test
    public void testSetEmployee() {
        Salary instance = new Salary();
        Employee employee = new Employee();
        instance.setEmployee(employee);
        assertEquals(employee, instance.getEmployee());
    }

    @Test
    public void testEquals() {
        Salary instance1 = new Salary();
        Salary instance2 = new Salary();
        assertTrue(instance1.equals(instance2));
    }

    @Test
    public void testCanEqual() {
        Salary instance = new Salary();
        assertTrue(instance.canEqual(new Salary()));
    }

    @Test
    public void testHashCode() {
        Salary instance = new Salary();
        assertEquals(0, instance.hashCode());
    }

    @Test
    public void testToString() {
        Salary instance = new Salary();
        assertEquals("Salary{id=null, employeeId=null, salaryAmount=null, salaryDate='', detail='', employee=null}", instance.toString());
    }
}
