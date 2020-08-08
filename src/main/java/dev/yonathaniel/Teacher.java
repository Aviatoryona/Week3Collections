package dev.yonathaniel;

import dev.yonathaniel.db.DbConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/*
   A class to create object for teacher details
 */
class Teacher implements TeacherI {
    private String name;
    private int id;

    private DbConnection dbConnection;

    Teacher() throws SQLException, ClassNotFoundException {
        init();
    }

    //initialize variables
    Teacher(String name) throws SQLException, ClassNotFoundException {
        this.name = name;
        init();
    }

    private void init() throws SQLException, ClassNotFoundException {
            this.dbConnection = DbConnection.getInstance();
    }

    @Override
    public ArrayList<Teacher> getTeachers() {
        return null;
    }

    @Override
    public boolean addTeacher(Teacher teacher) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement=dbConnection
                .getConnection()
                .prepareStatement("INSERT INTO teachers(name) VALUES(?)");
        return false;
    }

    @Override
    public boolean deleteTeacher(int id) {
        return false;
    }

    @Override
    public boolean updateTeacher(int id, Teacher teacher) {
        return false;
    }

    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("%s    :   %s", getId(), getName());
    }
}
