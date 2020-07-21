package dev.yonathaniel;

/*
   A class to create object for student details
 */
public class Student {
    private String name;
    private String admissionNumber;

    //initialize variables
    Student(String name, String admissionNumber) {
        this.name = name;
        this.admissionNumber = admissionNumber;
    }

    private String getName() {
        return name;
    }

    private String getAdmissionNumber() {
        return admissionNumber;
    }

    @Override
    public String toString() {
        return "Student name: " + this.getName() +
                "\n" +
                "Admission Number: " + this.getAdmissionNumber() +
                "\n";
    }
}
