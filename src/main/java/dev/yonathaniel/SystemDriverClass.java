package dev.yonathaniel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class SystemDriverClass implements SystemDriverClassI {

    @Override
    public void showMainMenu() {
        System.out.println("    SELECT OPTION:  ");
        System.out.println("1. Manage Teachers");
        System.out.println("2. Manage Students");
        System.out.println("3. Manage Subjects");
        System.out.println("4. Manage Results");
        System.out.println("X. Exit");
        System.out.println("");

        char choice = '0';
        do {

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextLine().toLowerCase().charAt(0);

            switch (choice) {
                case '1': {
                    try {
                        showTeachersMenu();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case '2': {
                    showStudentsMenu();
                    break;
                }
                case '3': {
                    showSubjectsMenu();
                    break;
                }
                case '4': {
                    showResultsMenu();
                    break;
                }
                case 'x': {
                    System.out.println("Bye!");
                    break;
                }

                default:
                    System.out.println("Invalid choice");
                    choice = '0';
            }

        } while (choice == '0');
    }

    @Override
    public void showTeachersMenu() throws SQLException, ClassNotFoundException {
        System.out.println("");
        System.out.println("    Teachers Manage:    ");
        System.out.println("1. View All");
        System.out.println("2. Add Teacher(s)");
        System.out.println("3. Delete Teacher(s)");
        System.out.println("4. Update Teacher(s)");
        System.out.println("X. Back");
        char choice = '0';
        do {

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextLine().toLowerCase().charAt(0);

            switch (choice) {
                case '1': {
                    viewTeacher();
                    break;
                }
                case '2': {
                    addTeacher();
                    break;
                }
                case '3': {
                    deleteTeacher();
                    break;
                }
                case '4': {
                    updateTeacher();
                    break;
                }

                case 'x': {
                    showMainMenu();
                    break;
                }

                default:
                    System.out.println("Invalid choice");
                    choice = '0';
            }

        } while (choice == '0');
    }

    @Override
    public void viewTeacher() throws SQLException, ClassNotFoundException {
        Teacher teacher = new Teacher();
        ArrayList<Teacher> teachers = teacher.getTeachers();
        if (teachers.isEmpty()) {
            System.out.println("No Records Available");
        } else {
            for (Teacher teacher1 : teachers) {
                System.out.println(teacher1.toString());
            }
        }

        //back to menu
        showTeachersMenu();
    }

    @Override
    public void addTeacher() throws SQLException, ClassNotFoundException {
        System.out.println("Add Teacher(s):");
        char yN = 'y';
        do {
            System.out.println("Enter teacher's name");
            Scanner in = new Scanner(System.in);
            String name = in.nextLine();

            Teacher teacher = new Teacher();
            if (!teacher.addTeacher(new Teacher(name))) {
                System.out.println("Failed, please try again");
            } else {
                System.out.println("Success!");
            }

            System.out.println("Proceed? (Y/N)");
            yN = in.nextLine().toLowerCase().charAt(0);
            if (yN == 'n') {
                showTeachersMenu();
            } else {
                yN = 'y';
            }

        } while (yN == 'y');
    }

    @Override
    public void updateTeacher() throws SQLException, ClassNotFoundException {
        Teacher teacher = new Teacher();
        System.out.println("Update Teacher(s):");
        char yN = 'y';
        do {
            Scanner scannerU = new Scanner(System.in);
            System.out.println("Enter teacher's Id");
            int id = scannerU.nextInt();
            System.out.println("Enter teacher's name");
            String name = scannerU.nextLine();
            if (!teacher.updateTeacher(id, new Teacher(name))) {
                System.out.println("Failed, please try again");
            } else {
                System.out.println("Success!");
            }

            System.out.println("Proceed? (Y/N)");
            yN = scannerU.nextLine().toLowerCase().charAt(0);
            if (yN == 'n') {
                showTeachersMenu();
            } else {
                yN = 'y';
            }

        } while (yN == 'y');
    }

    @Override
    public void deleteTeacher() throws SQLException, ClassNotFoundException {
        System.out.println("Delete Teacher(s):");
        char yN = 'y';
        do {
            Scanner scannerd = new Scanner(System.in);
            System.out.println("Enter teacher's Id");
            int id = scannerd.nextInt();

            Teacher teacher = new Teacher();
            if (!teacher.deleteTeacher(id)) {
                System.out.println("Failed, please try again");
            } else {
                System.out.println("Success!");
            }

            System.out.println("Proceed? (Y/N)");
            yN = scannerd.nextLine().toLowerCase().charAt(0);
            if (yN == 'n') {
                showTeachersMenu();
            } else {
                yN = 'y';
            }

        } while (yN == 'y');
    }

    @Override
    public void showSubjectsMenu() {
        System.out.println("");
        System.out.println("    Subjects Manage:    ");
        System.out.println("1. View All");
        System.out.println("2. Add Subject(s)");
        System.out.println("3. Delete Subject(s)");
        System.out.println("4. Update Subject(s)");
        System.out.println("X. Back");
        char choice = '0';
        do {

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextLine().toLowerCase().charAt(0);

            switch (choice) {
                case '1': {
                    viewSubjects();
                    break;
                }
                case '2': {
                    addSubject();
                    break;
                }
                case '3': {
                    deleteSubject();
                    break;
                }
                case '4': {
                    updateSubject();
                    break;
                }

                case 'x': {
                    showMainMenu();
                    break;
                }

                default:
                    System.out.println("Invalid choice");
                    choice = '0';
            }

        } while (choice == '0');
    }

    @Override
    public void viewSubjects() {

    }

    @Override
    public void addSubject() {

    }

    @Override
    public void updateSubject() {

    }

    @Override
    public void deleteSubject() {

    }

    @Override
    public void showStudentsMenu() {
        System.out.println("");
        System.out.println("    Students Manage:    ");
        System.out.println("1. View All");
        System.out.println("2. Add Student(s)");
        System.out.println("3. Delete Student(s)");
        System.out.println("4. Update Student(s)");
        System.out.println("X. Back");
        char choice = '0';
        do {

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextLine().toLowerCase().charAt(0);

            switch (choice) {
                case '1': {
                    viewStudents();
                    break;
                }
                case '2': {
                    addStudent();
                    break;
                }
                case '3': {
                    deleteStudent();
                    break;
                }
                case '4': {
                    updateStudent();
                    break;
                }

                case 'x': {
                    showMainMenu();
                    break;
                }

                default:
                    System.out.println("Invalid choice");
                    choice = '0';
            }

        } while (choice == '0');

    }

    @Override
    public void viewStudents() {

    }

    @Override
    public void addStudent() {

    }

    @Override
    public void updateStudent() {

    }

    @Override
    public void deleteStudent() {

    }

    @Override
    public void showResultsMenu() {
        System.out.println("");
        System.out.println("    Results Manage:    ");
        System.out.println("1. View All");
        System.out.println("2. Add Result(s)");
        System.out.println("3. Delete Result(s)");
        System.out.println("4. Update Result(s)");
        System.out.println("5. Clear All");
        System.out.println("X. Back");
        char choice = '0';
        do {

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextLine().toLowerCase().charAt(0);

            switch (choice) {
                case '1': {
                    viewResults();
                    break;
                }
                case '2': {
                    addResult();
                    break;
                }
                case '3': {
                    deleteResult();
                    break;
                }
                case '4': {
                    updateResult();
                    break;
                }

                case '5': {
                    clearResults();
                    break;
                }

                case 'x': {
                    showMainMenu();
                    break;
                }

                default:
                    System.out.println("Invalid choice");
                    choice = '0';
            }

        } while (choice == '0');
    }

    @Override
    public void addResult() {

    }

    @Override
    public void updateResult() {

    }

    @Override
    public void deleteResult() {

    }

    @Override
    public void viewResults() {

    }

    @Override
    public void clearResults() {

    }
}
