package dev.yonathaniel;

import java.sql.SQLException;

public interface SystemDriverClassI {
    void showMainMenu();

    void showTeachersMenu() throws SQLException, ClassNotFoundException;

    void viewTeacher() throws SQLException, ClassNotFoundException;

    void addTeacher() throws SQLException, ClassNotFoundException;

    void updateTeacher() throws SQLException, ClassNotFoundException;

    void deleteTeacher() throws SQLException, ClassNotFoundException;

    void showSubjectsMenu();

    void viewSubjects();

    void addSubject();

    void updateSubject();

    void deleteSubject();

    void showStudentsMenu();


    void viewStudents();

    void addStudent();

    void updateStudent();

    void deleteStudent();

    void showResultsMenu();

    void addResult();

    void updateResult();

    void deleteResult();

    void viewResults();

    void clearResults();
}
