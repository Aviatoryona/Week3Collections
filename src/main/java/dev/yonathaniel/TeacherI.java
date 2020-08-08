package dev.yonathaniel;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TeacherI {
    ArrayList<Teacher> getTeachers() throws SQLException, ClassNotFoundException;

    boolean addTeacher(Teacher teacher) throws SQLException, ClassNotFoundException;

    boolean deleteTeacher(int id) throws SQLException;

    boolean updateTeacher(int id,Teacher teacher) throws SQLException;
}
