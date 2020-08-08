package dev.yonathaniel;

import dev.yonathaniel.db.DbConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/*
   A class to create object for subject details and associated teacher
 */
public class Subject implements SubjectI {
    private String title;
    private int score;
    private Teacher teacher;

    private DbConnection dbConnection;

    public Subject() throws SQLException, ClassNotFoundException {
        this.dbConnection = DbConnection.getInstance();
    }

    //initialize variables
    Subject(String title, Teacher teacher) {
        this.title = title;
        this.teacher = teacher;
    }

    /*
       set the score to zero if score>100
     */
    void setScore(int score) {
        if (Math.abs(score) > 100)
            score = 0;
        this.score = Math.abs(score);
    }

    String getTitle() {
        return title;
    }

    int getScore() {
        return score;
    }

    private Teacher getTeacher() {
        return teacher;
    }

    @Override
    public String toString() {
        return String.format("%s-%s Teacher- %s", this.getTitle(), this.getScore(), this.getTeacher().getName());
    }

    @Override
    public Map<Integer, Subject> getSubjects() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = dbConnection.executeQuery("SELECT * FROM subjects");
        Map<Integer, Subject> subjects = new HashMap<Integer, Subject>();
        while (resultSet.next()) {
            subjects.put(
                    resultSet.getInt(1),
                    new Subject(
                            resultSet.getString(2),
                            new Teacher(
                                    resultSet.getString(3)
                            )
                    )
            );
        }
        return subjects;
    }

    @Override
    public boolean addSubject(Subject subject) throws SQLException, ClassNotFoundException {

        return false;
    }

    @Override
    public boolean deleteSubject(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateSubject(int id, Subject subject) throws SQLException {
        return false;
    }
}
