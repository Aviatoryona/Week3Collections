package dev.yonathaniel;

/*
   A class to create object for subject details and associated teacher
 */
public class Subject {
    private String title;
    private int score;
    private Teacher teacher;

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
}
