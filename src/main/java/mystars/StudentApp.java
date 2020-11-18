package mystars;

import mystars.courses.Course;
import mystars.login.Login;
import mystars.login.User;

import java.util.HashMap;
import java.util.Scanner;

import static mystars.Storage.loadCourses;
import static mystars.Storage.loadStudents;

public class StudentApp {

    private static HashMap<String, Student> StudentList = new HashMap<>();
    private final String StudentEmail;
    private final Student student;
    private final HashMap<String, Course> CourseList;

    /**
     * Constructor to create StudentApp object based on parameters given.
     * Creates StudentApp with studentEmail
     *
     * @param StudentEmail The school email of a student
     */
    public StudentApp(String StudentEmail) {
        StudentList = loadStudents();
        this.StudentEmail = StudentEmail;
        this.student = StudentList.get(StudentEmail);
        this.CourseList = loadCourses();

        // load list of students

    }

//    public void addCourse(Student student) {
//        String email = student.getStudentEmail();
//        StudentList.put(email, student);
//        Storage.saveStudents(StudentList);
//    }

    public void addCourse(String courseCode, String courseIndex) {
        student.addCourse(courseCode, courseIndex);

    }

    public void dropCourse(String courseCode) {
        student.dropCourse(courseCode);
    }


    public void printCourse() {
        student.printCourse();

    }

    public int checkVacancies(String courseCode, String courseIndex) {
        // god has forsaken this code, and so will i
        return CourseList.get(courseCode).getCourseIndexByIndexName(courseIndex).getNumberOfVacancies();
    }


    public void runLoop(Login login) throws StarsException {
        final String Choices = "(1) Add course" +
                "\n(2) Drop course" +
                "\n(3) Check/Print Courses Registered" +
                "\n(4) Check Vacancies Available" +
                "\n(5) Change Index Number of Course" +
                "\n(6) Swop Index Number with Another Student" +
                "\n(7) Exit";

        Scanner sc = new Scanner(System.in);


        int choice;
        do {
            System.out.println(Choices);
            System.out.println("Enter the number of your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    // Done
                    System.out.println("(1) Add course");
                    System.out.println("Enter courseCode: ");
                    String courseCode = sc.nextLine();
                    // TODO verify coursecode
                    System.out.println("Enter courseIndex: ");
                    String courseIndex = sc.nextLine();
                    // TODO Verify courseindex

                    // TODO Validate whether course got vacancies etc
                    addCourse(courseCode, courseIndex);
                    break;
                case 2:
                    // Done
                    System.out.println("(2) Drop course");
                    System.out.println("Enter courseCode: ");
                    courseCode = sc.nextLine();
                    // TODO verify coursecode
                    dropCourse(courseCode);

                    break;
                case 3:
                    // Done
                    System.out.println("(3) Check/Print Courses Registered");
                    printCourse();
                    break;
                case 4:
                    // Done
                    System.out.println("(4) Check Vacancies Available");
                    System.out.println("Enter courseCode: ");
                    courseCode = sc.nextLine();
                    // TODO verify coursecode
                    System.out.println("Enter courseIndex: ");
                    courseIndex = sc.nextLine();
                    // TODO Verify courseindex
                    int vacancies = checkVacancies(courseCode, courseIndex);
                    System.out.println("Course Index has " + vacancies + " Vacancies");

                    // use courses class to check vacancies of index
                    break;
                case 5:
                    // Done
                    System.out.println("(5) Change Index Number of Course");
                    System.out.println("Enter courseCode: ");
                    courseCode = sc.nextLine();
                    // TODO verify coursecode
                    System.out.println("Enter new courseIndex: ");
                    courseIndex = sc.nextLine();
                    // TODO Verify courseindex

                    // TODO Validate whether course got vacancies etc
                    addCourse(courseCode, courseIndex);

                    break;
                case 6:
                    System.out.println("(6) Swop Index Number with Another Student");
                    // TODO validate whether current student has any courses registered

                    User SecondUser = login.GetSwoppingStudent();
                    Student SecondStudent = StudentList.get(SecondUser.getName());
                    System.out.println("Enter courseCode: ");
                    courseCode = sc.nextLine();
                    // TODO verify coursecode
                    String index1, index2;
                    index1 = student.getCourseIndex(courseCode);
                    index2 = SecondStudent.getCourseIndex(courseCode);

                    // TODO Validate whether course got vacancies etc
                    student.addCourse(courseCode, index2);
                    SecondStudent.addCourse(courseCode, index1);

                    break;
                case 7:
                    System.out.println("Program terminating..");

            }
        } while (choice != 7);
    }

//    + changeIndex(oldIndex, newIndex): void
//+ swapIndex(oldIndex, peerIndex, peerMatricNo, peerPassword): void
//+ checkVerification(): boolean
//+ updateCourseData(checkVerification :  boolean): void
//+ checkTimingClash(courseCode : String): boolean
}
