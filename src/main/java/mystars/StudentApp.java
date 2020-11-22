package mystars;

import mystars.courses.Course;
import mystars.login.Login;
import mystars.login.User;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

import static mystars.Storage.*;

public class StudentApp {

    private final HashMap<String, Student> StudentList;
    private final Student student;
    private final HashMap<String, Course> CourseList;

    /**
     * Constructor to create StudentApp object based on parameters given.
     * Creates StudentApp with studentEmail
     *
     * @param StudentEmail The school email of a student
     */
    public StudentApp(String StudentEmail) {
        this.StudentList = loadStudents();
        if (StudentList.get(StudentEmail) == null) {
            // TODO fix this hardcoded student part lmao
            // I think can do without this after we put in the default values
            StudentList.put(StudentEmail, new Student("?", StudentEmail, StudentEmail, "Male", "NIL"));
        }
        this.student = StudentList.get(StudentEmail);
        this.CourseList = loadCourses();
    }

    /**
     * Add course for a student based on the course code and course index
     *
     * @param courseCode The course code entered by student
     * @param courseIndex The course index entered by student
     */
    public void addCourse(String courseCode, String courseIndex) {
        student.addCourse(courseCode, courseIndex);
        // god has yet again forsaken this line of code
        CourseList.get(courseCode).getCourseIndexByIndexName(courseIndex).addStudent(student);
        // wonho debut as a soloist with a millions of fans,
        // i debut as a soloist for all my scse proj grps and i get shit

    }

    /**
     * Drop course for student based on the course code
     *
     * @param courseCode The course code entered by student
     */

    public void dropCourse(String courseCode) {
        // does god exist, if true, does god code?
        // hopefully this drops the student from the course index, but does anyone know? i sure dont
        CourseList.get(courseCode).getCourseIndexByIndexName(student.getCourseIndex(courseCode)).dropStudent(student);
        student.dropCourse(courseCode);
    }

    /**
     * Print list of registered student courses
     */

    public void printCourse() {
        student.printCourse();
    }

    /**
     * Check for vacancies in course based on the course code and course index
     *
     * @param courseCode The course code entered by student
     * @param courseIndex The course index entered by student
     * @return The number of vacancies in a course
     */

    public int checkVacancies(String courseCode, String courseIndex) {
        // god has forsaken this code, and so will i
        return CourseList.get(courseCode).getCourseIndexByIndexName(courseIndex).getNumberOfVacancies();
    }

    /**
     * Verify if the course code exists
     *
     * @param courseCode The course code entered by student
     * @return <code>true</code> if course code exists; <code>false</code> otherwise.
     */

    public boolean verifyCourseCode(String courseCode) {
        if (CourseList.get(courseCode) == null) {
            System.out.println("Rejected - CourseCode does not exist");
            return false;
        }
        return true;
    }

    /**
     * Verify if the course index exists
     *
     * @param courseCode The course code
     * @param courseIndex The course index
     * @return <code>true</code> if course index exists; <code>false</code> otherwise.
     */

    public boolean verifyCourseIndex(String courseCode, String courseIndex) {
        if (CourseList.get(courseCode).getCourseIndexByIndexName(courseIndex) == null) {
            System.out.println("Rejected - courseIndex does not exist in CourseCode");
            return false;
        }
        return true;
    }

    /**
     * Verify if the course code exists
     *
     * @param student A student object
     * @return <code>true</code> if student has courses; <code>false</code> otherwise.
     */

    public boolean verifyExistingCourse(Student student) {
        if (Objects.equals(student.getNumberOfCoursesRegistered(), 0)) {
            System.out.println("Rejected - student doesn't have any course");
            return false;
        }
        return true;
    }

    /**
     * Verify if student has course code
     *
     * @param courseCode The course code entered
     * @return <code>true</code> if student has course code; <code>false</code> otherwise.
     */

    public boolean verifyStudentHasCourseCode(String courseCode){
        return student.hasCourseCode(courseCode);
    }

    /**
     * Verify if student has course index
     *
     * @param courseIndex The course index entered
     * @return <code>true</code> if student has course index; <code>false</code> otherwise.
     */

    public boolean verifyStudentHasCourseIndex(String courseIndex){
        return student.hasCourseIndex(courseIndex);
    }



    /**
     * runLoop to run the student function
     *
     * @param login Login details
     * @param sc Scanner for input
     */
    public void runLoop(Login login, Scanner sc) {
        final String Choices = "\n(1) Add course" +
                "\n(2) Drop course" +
                "\n(3) Check/Print Courses Registered" +
                "\n(4) Check Vacancies Available" +
                "\n(5) Change Index Number of Course" +
                "\n(6) Swop Index Number with Another Student" +
                "\n(7) Exit";

//        Scanner sc = new Scanner(System.in);

        String choice;
        do {
            System.out.println(Choices);
            System.out.println("Enter the number of your choice: ");
            choice = sc.nextLine();
            // Remove non-integer inputs due to buggy java stuff lmao https://stackoverflow.com/questions/27717503/why-does-my-scanner-repeat


            switch (choice) {
                case "1":
                    // Done
                    System.out.println("\n(1) Add course");
                    System.out.println("Enter courseCode: ");
                    String courseCode = sc.nextLine();
                    // verify courseCode
                    if (!verifyCourseCode(courseCode)) {
                        break;
                    }
                    // verify course code in student
                    if (verifyStudentHasCourseCode(courseCode)) {
                        System.out.println("Course code has already been added.");
                        break;
                    }
                    System.out.println("Enter courseIndex: ");
                    String courseIndex = sc.nextLine();
                    // Verify courseIndex
                    if (!verifyCourseIndex(courseCode, courseIndex)) {
                        break;
                    }

                    // Validate whether course got vacancies etc -- validation done in addcourse itself.
                    addCourse(courseCode, courseIndex);
                    System.out.println("Course successfully added");

                    break;
                case "2":
                    // Done
                    System.out.println("\n(2) Drop course");
                    System.out.println("Enter courseCode: ");
                    courseCode = sc.nextLine();
                    // verify coursecode in courselist
                    if (!verifyCourseCode(courseCode)) {
                        break;
                    }
                    // verify coursecode in student
                    if (!verifyStudentHasCourseCode(courseCode)) {
                        System.out.println("Course entered is not registered.");
                        break;
                    }
                    dropCourse(courseCode);
                    System.out.println("Course successfully dropped");

                    break;
                case "3":
                    // Done
                    System.out.println("\n(3) Check/Print Courses Registered");
                    printCourse();
                    break;
                case "4":
                    // Done
                    System.out.println("\n(4) Check Vacancies Available");
                    System.out.println("Enter courseCode: ");
                    courseCode = sc.nextLine();
                    // verify coursecode
                    if (!verifyCourseCode(courseCode)) {
                        break;
                    }

                    System.out.println("Enter courseIndex: ");
                    courseIndex = sc.nextLine();
                    //  Verify courseindex
                    if (!verifyCourseIndex(courseCode, courseIndex)) {
                        break;
                    }

                    int vacancies = checkVacancies(courseCode, courseIndex);
                    System.out.println("Course Index has " + vacancies + " Vacancies");
                    break;
                case "5":
                    // Done
                    System.out.println("\n(5) Change Index Number of Course");
                    System.out.println("Enter courseCode: ");
                    courseCode = sc.nextLine();
                    // verify coursecode
                    if (!verifyCourseCode(courseCode)) {
                        break;
                    }
                    // Verify if the student has this bloody course in the first place?
                    if (!verifyStudentHasCourseCode(courseCode)) {
                        System.out.println("Rejected - Course code entered is not registered.");

                        break;
                    }

                    System.out.println("Enter new courseIndex: ");
                    courseIndex = sc.nextLine();
                    // verify course index in student
                    if (verifyStudentHasCourseIndex(courseIndex)) {
                        System.out.println("Rejected - Course index entered is already registered.");
                        break;
                    }

                    //  Verify course index
                    if (!verifyCourseIndex(courseCode, courseIndex)) {
                        break;
                    }

                    // Validate whether course got vacancies etc -- validation done in addcourse itself.
                    addCourse(courseCode, courseIndex);
                    System.out.println("Course Changed");

                    break;
                case "6":
                    System.out.println("\n(6) Swop Index Number with Another Student");
                    // validate whether current student has any courses registered
                    if (!verifyExistingCourse(student)) {
                        break;
                    }
                    System.out.println("Enter second student username: ");
                    String student2Username= sc.nextLine();
                    System.out.println("Enter second student password: ");
                    String student2Password= sc.nextLine();

                    // verify student name and student password
                    User SecondUser = login.getSwappingStudent(student2Username, student2Password);

                    if(SecondUser != null) {
                        Student SecondStudent = StudentList.get(SecondUser.getName());

                        // validate whether other student has any courses registered
                        if (!verifyExistingCourse(SecondStudent)) {
                            break;
                        }

                        System.out.println("Enter courseCode: ");
                        courseCode = sc.nextLine();
                        String index1, index2;
                        index1 = student.getCourseIndex(courseCode);
                        index2 = SecondStudent.getCourseIndex(courseCode);
                        // verify coursecode
                        if (index1 == null || index2 == null) {
                            System.out.println("Rejected - student doesn't have course specified");
                            break;
                        }
                        if (index1.equals(index2)) {
                            System.out.println("Rejected - both students have the same index");
                            break;
                        }


                        // TODO Validate whether need to drop before add
                        // probably need to drop before add
                        student.dropCourse(courseCode);
                        SecondStudent.dropCourse(courseCode);
                        student.addCourse(courseCode, index2);
                        SecondStudent.addCourse(courseCode, index1);
                        StudentList.remove(student2Username);
                        StudentList.put(student2Username, SecondStudent);
                    }
                    break;

                case "7":
                    System.out.println("Program terminating..");
                    break;

                default:
                    System.out.println("Unknown Input Choice");
                    break;
            }
            saveCourses(CourseList);
            saveStudents(StudentList);
        } while (!choice.equals("7"));
    }

}
