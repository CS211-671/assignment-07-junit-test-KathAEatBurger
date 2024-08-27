package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {

    @Test
    @DisplayName("Student should be found in StudentList")
    public void testStudentListFindStudent() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("6xxxxxxxx1", "student1", "password1");
        studentList.addNewStudent("6xxxxxxxx2", "student2", "password2");
        studentList.addNewStudent("6xxxxxxxx3", "student3", "password3");

        Student foundStudent = studentList.findStudentById("6xxxxxxxx3");

        assertNotNull(foundStudent, "Student should be found");
        assertEquals("student3", foundStudent.getName(), "Student name should match");
    }

    @Test
    @DisplayName("Student can change password")
    public void testStudentCanChangePassword() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("6xxxxxxxx1", "student1", "password1");

        boolean isPasswordChanged = studentList.changePassword("6xxxxxxxx1", "password1", "newPassword");

        assertTrue(isPasswordChanged, "Password should be changed successfully");

        Student student = studentList.login("6xxxxxxxx1", "newPassword");
        assertNotNull(student, "Student should be logged in with the new password");
        assertEquals("6xxxxxxxx1", student.getId(), "Student ID should match");
    }

    @Test
    @DisplayName("Student with correct password can login")
    public void testStudentListShouldReturnObjectIfIdAndPasswordIsCorrect() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("6xxxxxxxx1", "student1", "password1");
        studentList.addNewStudent("6xxxxxxxx2", "student2", "password2");
        studentList.addNewStudent("6xxxxxxxx3", "student3", "password3");

        Student student = studentList.login("6xxxxxxxx2", "password2");

        assertNotNull(student, "Student should be logged in successfully");
        assertEquals("6xxxxxxxx2", student.getId(), "Student ID should match");
    }

    @Test
    @DisplayName("Student with incorrect password cannot login")
    public void testStudentListShouldReturnNullIfIdAndPasswordIsIncorrect() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("6xxxxxxxx1", "student1", "password1");
        studentList.addNewStudent("6xxxxxxxx2", "student2", "password2");
        studentList.addNewStudent("6xxxxxxxx3", "student3", "password3");

        Student student = studentList.login("6xxxxxxxx2", "wrongPassword");

        assertNull(student, "Login should fail with incorrect password");
    }

}
