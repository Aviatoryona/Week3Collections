package dev.yonathaniel;

import dev.yonathaniel.db.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
   A class to create object for teacher details
 */
class Teacher implements TeacherI {
    private String name;
    private int id;

    private DbConnection dbConnection;

    private Teacher() throws SQLException, ClassNotFoundException {
        init();
    }

    //initialize variables
    Teacher(String name) {
        setName(name);
    }

    private Teacher(String name, int id) {
        setName(name);
        setId(id);
    }

    private void init() throws SQLException, ClassNotFoundException {
        this.dbConnection = DbConnection.getInstance();
    }

    @Override
    public ArrayList<Teacher> getTeachers() throws SQLException {
        ResultSet resultSet = dbConnection.executeQuery("SELECT * FROM teachers");
        ArrayList<Teacher> teachers = new ArrayList<Teacher>();
        while (resultSet.next()) {
            teachers.add(
                    new Teacher(
                            resultSet.getString("name"),
                            resultSet.getInt("id")
                    )
            );
        }
        return teachers;
    }

    @Override
    public boolean addTeacher(Teacher teacher) throws SQLException {
        PreparedStatement preparedStatement = dbConnection.getPreparedStatement("INSERT INTO teachers(name) VALUES(?)");
        preparedStatement.setString(1, teacher.getName());
        return dbConnection.execute(preparedStatement);
    }

    @Override
    public boolean deleteTeacher(int id) throws SQLException {
        PreparedStatement preparedStatement = dbConnection
                .getPreparedStatement("DELETE FROM teachers WHERE id=?");
        preparedStatement.setInt(1, id);
        return dbConnection.execute(preparedStatement);
    }

    @Override
    public boolean updateTeacher(int id, Teacher teacher) throws SQLException {
        PreparedStatement preparedStatement = dbConnection
                .getPreparedStatement("UPDATE teachers SET name=? WHERE id=?");
        preparedStatement.setString(1, teacher.getName());
        preparedStatement.setInt(2, id);
        return dbConnection.execute(preparedStatement);
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
