package dev.yonathaniel;

import java.sql.SQLException;
import java.util.Map;

/*
   A class to create object for student details
 */
public class Student implements StudentI{
    private String name;
    private String admissionNumber;

    //initialize variables
    Student(String name, String admissionNumber) {
        this.name = name;
        this.admissionNumber = admissionNumber;
    }

    private String getName() {
        return name;
    }

    private String getAdmissionNumber() {
        return admissionNumber;
    }

    @Override
    public String toString() {
        return "Student name: " + this.getName() +
                "\n" +
                "Admission Number: " + this.getAdmissionNumber() +
                "\n";
    }

    @Override
    public Map<Integer, Student> getStudents() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean addStudent(Student student) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteStudent(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateStudent(int id, Student student) throws SQLException {
        return false;
    }
}
