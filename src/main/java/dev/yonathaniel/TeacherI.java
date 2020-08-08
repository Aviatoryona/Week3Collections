package dev.yonathaniel;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TeacherI {
    ArrayList<Teacher> getTeachers();

    boolean addTeacher(Teacher teacher) throws SQLException, ClassNotFoundException;

    boolean deleteTeacher(int id);

    boolean updateTeacher(int id,Teacher teacher);
}
