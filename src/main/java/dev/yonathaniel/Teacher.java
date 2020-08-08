package dev.yonathaniel;

import java.util.ArrayList;

/*
   A class to create object for teacher details
 */
class Teacher implements TeacherI {
    private String name;
    private int id;

    Teacher() {
    }

    //initialize variables
    Teacher(String name) {
        this.name = name;
    }


    @Override
    public ArrayList<Teacher> getTeachers() {
        return null;
    }

    @Override
    public boolean addTeacher(Teacher teacher) {
        return false;
    }

    @Override
    public boolean deleteTeacher(int id) {
        return false;
    }

    @Override
    public boolean updateTeacher(int id) {
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
