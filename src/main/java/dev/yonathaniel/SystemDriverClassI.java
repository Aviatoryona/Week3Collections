package dev.yonathaniel;

import java.sql.SQLException;

public interface SystemDriverClassI {
    void showMainMenu() throws SQLException, ClassNotFoundException;

    void showTeachersMenu() throws SQLException, ClassNotFoundException;

    void viewTeacher() throws SQLException, ClassNotFoundException;

    void addTeacher() throws SQLException, ClassNotFoundException;

    void updateTeacher() throws SQLException, ClassNotFoundException;

    void deleteTeacher() throws SQLException, ClassNotFoundException;

    void showSubjectsMenu() throws SQLException, ClassNotFoundException;

    void viewSubjects() throws SQLException, ClassNotFoundException;

    void addSubject() throws SQLException, ClassNotFoundException;

    void updateSubject() throws SQLException, ClassNotFoundException;

    void deleteSubject() throws SQLException, ClassNotFoundException;

    void showStudentsMenu() throws SQLException, ClassNotFoundException;


    void viewStudents() throws SQLException, ClassNotFoundException;

    void addStudent() throws SQLException, ClassNotFoundException;

    void updateStudent() throws SQLException, ClassNotFoundException;

    void deleteStudent() throws SQLException, ClassNotFoundException;

    void showResultsMenu() throws SQLException, ClassNotFoundException;

    void addResult();

    void updateResult();

    void deleteResult();

    void viewResults();

    void clearResults();
}
