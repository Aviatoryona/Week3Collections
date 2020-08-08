package dev.yonathaniel;

import dev.yonathaniel.db.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
  A class to create object to keep student and a associated list of  subjects
 */
public class Result implements ResultI {
    private Student student;
    private ArrayList<Subject> subjects;

    private DbConnection dbConnection;

    public Result() throws SQLException, ClassNotFoundException {
        this.dbConnection = DbConnection.getInstance();
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

    // TODO: 8/8/2020
    @Override
    public ArrayList<ResultModel> viewAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = dbConnection.executeQuery("SELECT * FROM results");
        ArrayList<ResultModel> results = new ArrayList<ResultModel>();
        while (resultSet.next()) {
            results.add(
                    new ResultModel(
                            resultSet.getInt("id"),
                            resultSet.getString("studentadmno"),
                            resultSet.getString("subjecttitle"),
                            resultSet.getDouble("score")
                    )
            );
        }
        return results;
    }

    // TODO: 8/8/2020
    @Override
    public Result getResults(String admNo) throws SQLException {
        PreparedStatement preparedStatement = dbConnection.getPreparedStatement("SELECT * FROM results,students,subjects WHERE results.studentadmno=students.admno &&\n" +
                "results.subjecttitle=subjects.title && results.studentadmno=?;");
        preparedStatement.setString(1, admNo);
        ResultSet resultSet = dbConnection.executeQuery(preparedStatement);
        ArrayList<Subject> subjects = new ArrayList<Subject>();
        Student student1 = null;
        while (resultSet.next()) {
            if (student1 == null)
                student1 = new Student(
                        resultSet.getString("name"),
                        resultSet.getString("admno")
                );

            Subject subject = new Subject(
                    resultSet.getString("title"),
                    new Teacher(
                            resultSet.getString("teachername")
                    )
            );
            subjects.add(subject);

        }

        return new Result(
                student1,
                subjects
        );
    }

    @Override
    public boolean addResult(ResultModel resultModel) throws SQLException {
        PreparedStatement preparedStatement = dbConnection
                .getPreparedStatement("INSERT INTO results(studentadmno,subjecttitle,score) VALUES(?,?,?)");
        preparedStatement.setString(1, resultModel.getStudentadmno());
        preparedStatement.setString(2, resultModel.getSubject());
        preparedStatement.setDouble(3, resultModel.getScore());
        return dbConnection.execute(preparedStatement);
    }

    @Override
    public boolean deleteResult(int id) throws SQLException {
        PreparedStatement preparedStatement = dbConnection
                .getPreparedStatement("DELETE FROM results WHERE id=?");
        preparedStatement.setInt(1, id);
        return dbConnection.execute(preparedStatement);
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
