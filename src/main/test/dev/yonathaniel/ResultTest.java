package dev.yonathaniel;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

public class ResultTest {
    private Result result;

    @Before
    public void setUp() {
        ArrayList<Subject> subjects = new ArrayList<Subject>();
        Subject subject = new Subject("Eng", new Teacher("Brian T"));
        subject.setScore(90);
        subjects.add(subject);
        Subject subject1 = new Subject("Kis", new Teacher("Alex M"));
        subject1.setScore(88);
        subjects.add(subject1);
        Subject subject2 = new Subject("Math", new Teacher("Mariam M"));
        subject2.setScore(92);
        subjects.add(subject2);
        result = new Result(
                new Student("Yonathaniel", "78/90/2020"),
                subjects
        );
    }

    @Test
    public void getTotal() {
        assertEquals(270, result.getTotal());
    }

    @Test
    public void getAverage() {
        assertEquals(90, result.getAverage(), 0);
    }

    @Test
    public void getSize() {
        assertEquals(3, result.getSize());
    }

    @Ignore
    @Test
    public void getResult() {
    }

}