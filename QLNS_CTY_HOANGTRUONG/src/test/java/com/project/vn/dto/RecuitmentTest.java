package com.project.vn.dto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class RecuitmentTest {
    @Test
    public void testGetId() {
        Recuitment instance = new Recuitment();
        assertNull(instance.getId());
    }

    @Test
    public void testGetPosition() {
        Recuitment instance = new Recuitment();
        assertEquals("", instance.getPosition());
    }

    @Test
    public void testGetQuantity() {
        Recuitment instance = new Recuitment();
        assertNull(instance.getQuantity());
    }

    @Test
    public void testGetDeadline() {
        Recuitment instance = new Recuitment();
        assertEquals("", instance.getDeadline());
    }

    @Test
    public void testGetJobDescription() {
        Recuitment instance = new Recuitment();
        assertEquals("", instance.getJobDescription());
    }

    @Test
    public void testSetId() {
        Recuitment instance = new Recuitment();
        instance.setId(1);
        assertEquals(1, instance.getId());
    }

    @Test
    public void testSetPosition() {
        Recuitment instance = new Recuitment();
        instance.setPosition("Software Engineer");
        assertEquals("Software Engineer", instance.getPosition());
    }

    @Test
    public void testSetQuantity() {
        Recuitment instance = new Recuitment();
        instance.setQuantity(5);
        assertEquals(5, instance.getQuantity());
    }

    @Test
    public void testSetDeadline() {
        Recuitment instance = new Recuitment();
        instance.setDeadline("2024-04-30");
        assertEquals("2024-04-30", instance.getDeadline());
    }

    @Test
    public void testSetJobDescription() {
        Recuitment instance = new Recuitment();
        instance.setJobDescription("Responsibilities: ...");
        assertEquals("Responsibilities: ...", instance.getJobDescription());
    }

    @Test
    public void testEquals() {
        Recuitment instance1 = new Recuitment();
        Recuitment instance2 = new Recuitment();
        assertTrue(instance1.equals(instance2));
    }

    @Test
    public void testCanEqual() {
        Recuitment instance = new Recuitment();
        assertTrue(instance.canEqual(new Recuitment()));
    }

    @Test
    public void testHashCode() {
        Recuitment instance = new Recuitment();
        assertEquals(0, instance.hashCode());
    }

    @Test
    public void testToString() {
        Recuitment instance = new Recuitment();
        assertEquals("Recuitment{id=null, position='', quantity=null, deadline='', jobDescription=''}", instance.toString());
    }
}
