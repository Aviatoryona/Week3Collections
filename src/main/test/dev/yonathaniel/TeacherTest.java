package dev.yonathaniel;

import org.junit.Test;

import static org.junit.Assert.*;

public class TeacherTest {

    @Test
    public void getName() {
        Teacher teacher=new Teacher("Brian Itur");
        assertEquals("Brian Itur",teacher.getName());
    }
}