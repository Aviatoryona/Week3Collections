package dev.yonathaniel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubjectTest {
    private Subject subject;

    @Before
    public void setUp() {
        subject = new Subject("Eng", new Teacher("Brian T"));
    }

    @Test
    public void setScore() {
        subject.setScore(89);
        assert subject.getScore()!=0;
        assertEquals(89,subject.getScore());
    }

    @Test
    public void getTitle() {
        assertNotNull(subject.getTitle());
        assertEquals("Eng",subject.getTitle());
    }

    @Test
    public void getScore() {
        subject.setScore(89);
        assert subject.getScore()!=0;
        assertEquals(89,subject.getScore());
    }
}