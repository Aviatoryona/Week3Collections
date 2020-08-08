package dev.yonathaniel;

import dev.yonathaniel.db.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/*
   A class to create object for student details
 */
public class Student implements StudentI {
    private String name;
    private String admissionNumber;

    private DbConnection dbConnection;

    public Student() throws SQLException, ClassNotFoundException {
        this.dbConnection = DbConnection.getInstance();
    }

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
    public Map<Integer, Student> getStudents() throws SQLException {
        ResultSet resultSet = dbConnection.executeQuery("SELECT * FROM students");
        Map<Integer, Student> students = new HashMap<Integer, Student>();
        while (resultSet.next()) {
            students.put(
                    resultSet.getInt(1),
                    new Student(
                            resultSet.getString(2),
                            resultSet.getString(3)
                    )
            );
        }
        return students;
    }

    @Override
    public boolean addStudent(Student student) throws SQLException {
        PreparedStatement preparedStatement = dbConnection
                .getPreparedStatement("INSERT INTO students(name,admno) VALUES(?,?)");
        preparedStatement.setString(1, student.getName());
        preparedStatement.setString(2, student.getAdmissionNumber());
        return dbConnection.execute(preparedStatement);
    }

    @Override
    public boolean deleteStudent(int id) throws SQLException {
        PreparedStatement preparedStatement = dbConnection
                .getPreparedStatement("DELETE FROM students WHERE id=?");
        preparedStatement.setInt(1, id);
        return dbConnection.execute(preparedStatement);
    }

    @Override
    public boolean updateStudent(int id, Student student) throws SQLException {
        PreparedStatement preparedStatement = dbConnection
                .getPreparedStatement("UPDATE students SET name=?,admno=? WHERE id=?");
        preparedStatement.setString(1, student.getName());
        preparedStatement.setString(2, student.getAdmissionNumber());
        preparedStatement.setInt(3, id);
        return dbConnection.execute(preparedStatement);
    }
}
