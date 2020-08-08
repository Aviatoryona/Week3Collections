package dev.yonathaniel;

import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

public class SystemDriverClass implements SystemDriverClassI {

    @Override
    public void showMainMenu() throws SQLException, ClassNotFoundException {
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
        Map<Integer, Teacher> teachers = teacher.getTeachers();
        if (teachers.isEmpty()) {
            System.out.println("No Records Available");
        } else {
            for (Integer integer : teachers.keySet()) {
                Teacher teacher1 = teachers.get(integer);
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
            System.out.println("Enter teacher's Id");
            int id = new Scanner(System.in).nextInt();
            System.out.println("Enter teacher's name");
            String name = new Scanner(System.in).nextLine();
            if (!teacher.updateTeacher(id, new Teacher(name))) {
                System.out.println("Failed, please try again");
            } else {
                System.out.println("Success!");
            }

            System.out.println("Proceed? (Y/N)");
            yN = new Scanner(System.in).nextLine().toLowerCase().charAt(0);
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
            System.out.println("Enter teacher's Id");
            int id = new Scanner(System.in).nextInt();

            Teacher teacher = new Teacher();
            if (!teacher.deleteTeacher(id)) {
                System.out.println("Failed, please try again");
            } else {
                System.out.println("Success!");
            }

            System.out.println("Proceed? (Y/N)");
            yN = new Scanner(System.in).nextLine().toLowerCase().charAt(0);
            if (yN == 'n') {
                showTeachersMenu();
            } else {
                yN = 'y';
            }

        } while (yN == 'y');
    }

    @Override
    public void showSubjectsMenu() throws SQLException, ClassNotFoundException {
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
    public void viewSubjects() throws SQLException, ClassNotFoundException {
        Subject subject = new Subject();
        Map<Integer, Subject> subjectMap = subject.getSubjects();
        for (Integer integer :
                subjectMap.keySet()) {
            System.out.println(subjectMap.get(integer).toString());
        }
    }

    @Override
    public void addSubject() throws SQLException, ClassNotFoundException {
        System.out.println("Add Subject(s):");
        char yN = 'y';
        do {
            System.out.println("Enter subject's title");
            String name = new Scanner(System.in).nextLine();
            System.out.println("Enter teacher's name");
            String teacher = new Scanner(System.in).nextLine();

            Subject subject = new Subject();

            if (!subject.addSubject(new Subject(
                    name,
                    new Teacher(
                            teacher
                    )
            ))) {
                System.out.println("Failed, please try again");
            } else {
                System.out.println("Success!");
            }

            System.out.println("Proceed? (Y/N)");
            yN = new Scanner(System.in).nextLine().toLowerCase().charAt(0);
            if (yN == 'n') {
                showSubjectsMenu();
            } else {
                yN = 'y';
            }

        } while (yN == 'y');
    }

    @Override
    public void updateSubject() throws SQLException, ClassNotFoundException {
        System.out.println("Update Subject(s):");
        char yN = 'y';
        do {
            System.out.println("Enter subject Id");
            int id = new Scanner(System.in).nextInt();
            System.out.println("Enter subject's title");
            String name = new Scanner(System.in).nextLine();
            System.out.println("Enter teacher's name");
            String teacher = new Scanner(System.in).nextLine();

            Subject subject = new Subject();
            if (!subject.updateSubject(id, new Subject(
                    name,
                    new Teacher(
                            teacher
                    )
            ))) {
                System.out.println("Failed, please try again");
            } else {
                System.out.println("Success!");
            }

            System.out.println("Proceed? (Y/N)");
            yN = new Scanner(System.in).nextLine().toLowerCase().charAt(0);
            if (yN == 'n') {
                showSubjectsMenu();
            } else {
                yN = 'y';
            }

        } while (yN == 'y');
    }

    @Override
    public void deleteSubject() throws SQLException, ClassNotFoundException {
        System.out.println("Delete Subject(s):");
        char yN = 'y';
        do {
            System.out.println("Enter subject's Id");
            int id = new Scanner(System.in).nextInt();

            Subject subject = new Subject();
            if (!subject.deleteSubject(id)) {
                System.out.println("Failed, please try again");
            } else {
                System.out.println("Success!");
            }

            System.out.println("Proceed? (Y/N)");
            yN = new Scanner(System.in).nextLine().toLowerCase().charAt(0);
            if (yN == 'n') {
                showTeachersMenu();
            } else {
                yN = 'y';
            }

        } while (yN == 'y');
    }

    @Override
    public void showStudentsMenu() throws SQLException, ClassNotFoundException {
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
    public void viewStudents() throws SQLException, ClassNotFoundException {
        Student student = new Student();
        Map<Integer, Student> subjectMap = student.getStudents();
        for (Integer integer :
                subjectMap.keySet()) {
            System.out.println(subjectMap.get(integer).toString());
        }
    }

    @Override
    public void addStudent() throws SQLException, ClassNotFoundException {
        System.out.println("Add Student(s):");
        char yN = 'y';
        do {
            System.out.println("Enter student's name");
            String name = new Scanner(System.in).nextLine();
            System.out.println("Enter student's admission NO:");
            String admNo = new Scanner(System.in).nextLine();

            Student student = new Student();
            if (!student.addStudent(new Student(
                    name,
                    admNo
            ))) {
                System.out.println("Failed, please try again");
            } else {
                System.out.println("Success!");
            }

            System.out.println("Proceed? (Y/N)");
            yN = new Scanner(System.in).nextLine().toLowerCase().charAt(0);
            if (yN == 'n') {
                showSubjectsMenu();
            } else {
                yN = 'y';
            }

        } while (yN == 'y');
    }

    @Override
    public void updateStudent() throws SQLException, ClassNotFoundException {
        System.out.println("Update Student(s):");
        char yN = 'y';
        do {
            System.out.println("Enter student's Id");
            int id = new Scanner(System.in).nextInt();
            System.out.println("Enter student's name");
            String name = new Scanner(System.in).nextLine();
            System.out.println("Enter student's admission NO:");
            String admNo = new Scanner(System.in).nextLine();

            Student student = new Student();
            if (!student.updateStudent(id, new Student(
                    name,
                    admNo
            ))) {
                System.out.println("Failed, please try again");
            } else {
                System.out.println("Success!");
            }

            System.out.println("Proceed? (Y/N)");
            yN = new Scanner(System.in).nextLine().toLowerCase().charAt(0);
            if (yN == 'n') {
                showSubjectsMenu();
            } else {
                yN = 'y';
            }

        } while (yN == 'y');
    }

    @Override
    public void deleteStudent() throws SQLException, ClassNotFoundException {
        System.out.println("Delete Student(s):");
        char yN = 'y';
        do {
            System.out.println("Enter students's Id");
            int id = new Scanner(System.in).nextInt();

            Student student = new Student();
            if (!student.deleteStudent(id)) {
                System.out.println("Failed, please try again");
            } else {
                System.out.println("Success!");
            }

            System.out.println("Proceed? (Y/N)");
            yN = new Scanner(System.in).nextLine().toLowerCase().charAt(0);
            if (yN == 'n') {
                showTeachersMenu();
            } else {
                yN = 'y';
            }

        } while (yN == 'y');
    }

    @Override
    public void showResultsMenu() throws SQLException, ClassNotFoundException {
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
    public void addResult() throws SQLException, ClassNotFoundException {
        System.out.println("Add Result(s):");
        char yN = 'y';
        do {
            System.out.println("Enter student's admission NO:");
            String admNo = new Scanner(System.in).nextLine();
            System.out.println("Enter subject title");
            String subject = new Scanner(System.in).nextLine();
            System.out.println("Enter student's score");
            double score = new Scanner(System.in).nextDouble();

            Result result = new Result();
            if (!result.addResult(new ResultModel(
                    -1,
                    admNo,
                    subject,
                    score

            ))) {
                System.out.println("Failed, please try again");
            } else {
                System.out.println("Success!");
            }

            System.out.println("Proceed? (Y/N)");
            yN = new Scanner(System.in).nextLine().toLowerCase().charAt(0);
            if (yN == 'n') {
                showSubjectsMenu();
            } else {
                yN = 'y';
            }

        } while (yN == 'y');
    }

    @Override
    public void updateResult() throws SQLException, ClassNotFoundException {
        System.out.println("Update Result(s):");
        char yN = 'y';
        do {
            System.out.println("Enter id:");
            int id = new Scanner(System.in).nextInt();
            System.out.println("Enter student's score");
            double score = new Scanner(System.in).nextDouble();

            Result result = new Result();
            if (!result.updateResult(id, new ResultModel(
                    -1,
                    "",
                    "",
                    score

            ))) {
                System.out.println("Failed, please try again");
            } else {
                System.out.println("Success!");
            }

            System.out.println("Proceed? (Y/N)");
            yN = new Scanner(System.in).nextLine().toLowerCase().charAt(0);
            if (yN == 'n') {
                showSubjectsMenu();
            } else {
                yN = 'y';
            }

        } while (yN == 'y');
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
