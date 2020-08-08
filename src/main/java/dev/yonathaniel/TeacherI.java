package dev.yonathaniel;

import java.util.ArrayList;

public interface TeacherI {
    ArrayList<Teacher> getTeachers();

    boolean addTeacher(Teacher teacher);

    boolean deleteTeacher(int id);

    boolean updateTeacher(int id,Teacher teacher);
}
