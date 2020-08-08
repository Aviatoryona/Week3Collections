package dev.yonathaniel;

import java.util.ArrayList;

public interface TeacherI {
    ArrayList<Teacher> getTeachers();

    boolean addTeacher();

    boolean deleteTeacher();

    boolean updateTeacher();
}
