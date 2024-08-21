package ku.cs.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    @Test
    void testAddScore() {
        Student s = new Student("6xxxxxxxx", "StudentTest");
        s.addScore(45.15);
        assertEquals(45.15, s.getScore());
    }
    @Test
    void testCalculateGrade() {
        Student s = new Student("6xxxxxxxx", "StudentTest");
        s.addScore(85);
        assertEquals("A", s.grade());
    }
}