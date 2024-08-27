package ku.cs.models;

import java.util.ArrayList;

public class StudentList {
    private ArrayList<Student> students;

    public StudentList() {
        students = new ArrayList<>();
    }

    public void addNewStudent(String id, String name, String password) {
        id = id.trim();
        name = name.trim();
        password = password.trim();
        if (!id.isEmpty() && !name.isEmpty() && !password.isEmpty()) {
            Student exist = findStudentById(id);
            if (exist == null) {
                students.add(new Student(id, name, 0, password)); // Default score is 0
            }
        }
    }

    public void addNewStudent(String id, String name, double score, String password) {
        id = id.trim();
        name = name.trim();
        password = password.trim();
        if (!id.isEmpty() && !name.isEmpty() && !password.isEmpty()) {
            Student exist = findStudentById(id);
            if (exist == null) {
                students.add(new Student(id, name, score, password));
            }
        }
    }

    public Student findStudentById(String id) {
        for (Student student : students) {
            if (student.isId(id)) {
                return student;
            }
        }
        return null;
    }

    public void giveScoreToId(String id, double score) {
        Student exist = findStudentById(id);
        if (exist != null) {
            exist.addScore(score);
        }
    }

    public String viewGradeOfId(String id) {
        Student exist = findStudentById(id);
        if (exist != null) {
            return exist.grade();
        }
        return null;
    }

    public boolean changePassword(String id, String oldPassword, String newPassword) {
        Student student = findStudentById(id);
        if (student != null) {
            return student.changePassword(oldPassword, newPassword);
        }
        return false;
    }

    public Student login(String id, String password) {
        Student student = findStudentById(id);
        if (student != null && student.checkPassword(password)) {
            return student;
        }
        return null;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}
