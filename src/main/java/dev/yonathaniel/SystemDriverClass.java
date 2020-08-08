package dev.yonathaniel;

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
                    showTeachersMenu();
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
    public void showTeachersMenu() {
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
    public void viewTeacher() {

    }

    @Override
    public void addTeacher() {

    }

    @Override
    public void updateTeacher() {

    }

    @Override
    public void deleteTeacher() {

    }

    @Override
    public void showSubjectsMenu() {

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
