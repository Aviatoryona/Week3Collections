package dev.yonathaniel;

import dev.yonathaniel.db.DbConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
  A class to create object to keep student and a associated list of  subjects
 */
public class Result implements ResultI {
    private Student student;
    private ArrayList<Subject> subjects;

    private DbConnection dbConnection;
    public Result() throws SQLException, ClassNotFoundException {
        this.dbConnection=DbConnection.getInstance();
    }

    //initialise variables
    Result(Student student, ArrayList<Subject> subjects) {
        this.student = student;
        this.subjects = subjects;
    }

    /*
          Return the total score of all the subjects for a student
         */
    @Override
    public int getTotal() {
        int sum = 0;
        for (Subject subject :
                this.subjects) {
            sum += subject.getScore();
        }
        return sum;
    }

    /*
       Return the average score of all the subjects for a student
     */
    @Override
    public double getAverage() {
        return this.getTotal() / this.getSize();
    }


    /*
      Returns the number of subjects
     */
    @Override
    public int getSize() {
        return this.subjects.size();
    }

    /*
      Returns the result ie the output
      eg       Student: Yona K
               Admission Number: 900/567/2020
	           Eng-40 Teacher- Brian T
	           Kis-78 Teacher- Mariam M
	           Total- 118
	           Avg- 59
	           Remarks- Passed
     */
    @Override
    public String getResult() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(student.toString());
        for (Subject subject : this.subjects) {
            stringBuilder.append(subject.toString()).append("\n");
        }
        stringBuilder.append("Total- ").append(this.getTotal()).append("\n")
                .append("Avg- ").append(this.getAverage()).append("\n")
                .append("Remarks- ").append(this.getRemarks());
        return stringBuilder.toString();
    }

    @Override
    public String getRemarks() {
        return this.getAverage() < 40 ? "Failed" : "Passed";
    }

    @Override
    public Map<Integer, Result> getResults() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = dbConnection.executeQuery("SELECT * FROM results,students,subjects WHERE results.studentadmno=students.admno &&\n" +
                "results.subjecttitle=subjects.title;");
        Map<Integer, Result> results = new HashMap<Integer, Result>();
        while (resultSet.next()) {
            results.put(
                    resultSet.getInt("id"),
                    new Teacher(
                            resultSet.getString("name"),
                            resultSet.getInt("id")
                    )
            );
        }
        return teachers;
    }

    @Override
    public boolean addResult(Result result) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteResult(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateResult(int id, Result result) throws SQLException {
        return false;
    }

    @Override
    public void clearAll() {

    }

    @Override
    public String toString() {
        return this.getResult();
    }
}
