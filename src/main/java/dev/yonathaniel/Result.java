package dev.yonathaniel;

import java.util.ArrayList;
/*
  A class to create object to keep student and a associated list of  subjects
 */
public class Result implements ResultI {
    private Student student;
    private ArrayList<Subject> subjects;

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
     */
    @Override
    public String getResult() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(student.toString());
        for (Subject subject : this.subjects) {
           stringBuilder.append(subject.toString()).append("\n");
        }
        stringBuilder.append("Total- ").append(this.getTotal()).append("\n");
        stringBuilder.append("Avg- ").append(this.getAverage());
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return this.getResult();
    }
}
