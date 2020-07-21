package dev.yonathaniel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	/*
	    1. Capture subject(s) and respective teacher and put in a collection
	       eg Title-Eng ,Teacher- Brian T

	    2. Loop n times, capture student name and admission number, and prompt for scores of each subject as provide in (1) above.
	       This info store in a Result object. Push the result object in a collection.

	    3. For collection result in (2) above, print the output. Eg
	           Student: Yona K
	           Admission Number: 900/567/2020
	           Eng-40 Teacher- Brian T
	           Kis-78 Teacher- Mariam M
	           Total- 118
	           Avg- 59
	           ...

	 */


        //   Capture subjects
        List<Subject> subjects = new ArrayList<Subject>();
        boolean isTakeSubjects = true;
        System.out.println("Provide all subjects");
        do {
            String title, teacherName;
            char yN;
            Scanner in = new Scanner(System.in);
            System.out.println("Subject title:");
            title = in.nextLine();
            System.out.println("Teacher's name:");
            teacherName = in.nextLine();

            Teacher teacher = new Teacher(teacherName);
            Subject subject = new Subject(title, teacher);

            //add subject to list
            subjects.add(subject);

            System.out.println("Add more subject? (Y/N):");
            yN = in.nextLine().toUpperCase().charAt(0);
            if (yN == 'N') {
                isTakeSubjects = false;
            }

        } while (isTakeSubjects);

        //  End capture subjects

        //  Capture student(s) info and respective subject scores

        System.out.println("");
        System.out.println("Enter student(s) details");
        boolean takeMoreStudents = true;
        ArrayList<Result> results = new ArrayList<Result>();
        do {
            Scanner in = new Scanner(System.in);
            String studentName, studentAdmissionNumber;
            System.out.println("Student name:");
            studentName = in.nextLine();
            System.out.println("Student admission number:");
            studentAdmissionNumber = in.nextLine();

            ArrayList<Subject> subjectScores = new ArrayList<Subject>();
            for (Subject subject :
                    subjects) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter " + subject.getTitle() + " score:");
                int score = scanner.nextInt();
                subject.setScore(score);
                subjectScores.add(subject);
            }

            Student student = new Student(studentName, studentAdmissionNumber);
            Result result = new Result(student, subjectScores);
            //add result to collection
            results.add(result);

            char yN;
            System.out.println("Add another record? (Y/N)");
            yN = in.nextLine().toUpperCase().charAt(0);
            if (yN == 'N') {
                takeMoreStudents = false;
            }

        } while (takeMoreStudents);

        //  End Capture student(s) info

        //print output
        System.out.println("");
        if (results.isEmpty()) {
            System.out.println("No students in record");
        } else {
            for (Object result : results) {
                System.out.println(result.toString());
                System.out.println("");
            }
        }

    }
}
