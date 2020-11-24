package mystars;

import mystars.courses.Course;
import mystars.courses.CourseComponent;
import mystars.courses.CourseIndex;
import mystars.login.Login;
import mystars.login.User;

import java.time.LocalTime;
import java.util.*;

import static mystars.Storage.*;

public class StudentApp {

    private final HashMap<String, Student> StudentList;
    private final Student student;
    private final HashMap<String, Course> CourseList;
    private final int maxAcademicUnit = 21;

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
     * Add student into courseIndex object in the courseList hashmap
     *
     * @param courseCode  The course code entered by student
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
     * Drop student from courseIndex object in courseList hashmap
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
        HashMap<String, String> studentCourses = student.getCourse();
        // https://stackoverflow.com/questions/1066589/iterate-through-a-hashmap
        if (studentCourses.size() != 0) {
            for (Map.Entry<String, String> entry : studentCourses.entrySet()) {
                String CourseCode = entry.getKey();
                String courseIndex = entry.getValue();
                CourseIndex CI = CourseList.get(CourseCode).getCourseIndexByIndexName(courseIndex);
                String registration = CI.studentInWhichList(student.getStudentEmail());
                System.out.println("  CourseCode: " + CourseCode + " || Course Index: " + courseIndex + " || " + registration);
            }
        } else {
            System.out.println("Student has no courses registered!");
        }
    }

    /**
     * Check for vacancies in course based on the course code and course index
     *
     * @param courseCode  The course code entered by student
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
     * @param courseCode  The course code
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
     * Verify if student has any courses
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
    public boolean verifyStudentHasCourseCode(String courseCode) {
        return student.hasCourseCode(courseCode);
    }

    /**
     * Verify if student has course index
     *
     * @param courseIndex The course index entered
     * @return <code>true</code> if student has course index; <code>false</code> otherwise.
     */
    public boolean verifyStudentHasCourseIndex(String courseIndex) {
        return student.hasCourseIndex(courseIndex);
    }

    /**
     * Verify if student has exceeded max AUs to be registered
     *
     * @param newCourseCode The courseCode entered by student to be added
     * @return the total number of AUs registered
     */
    public boolean verifyAUsRegisteredExceededMax(String newCourseCode) {
        int au, newAU, totalAU=0;
        for (Map.Entry<String, String> entry : student.getCourse().entrySet()) {
            String courseCode = entry.getKey();
            au = CourseList.get(courseCode).getCourseAcademicUnit();
            totalAU += au;
        }
        newAU = CourseList.get(newCourseCode).getCourseAcademicUnit();
        totalAU += newAU;
        if (totalAU > maxAcademicUnit){
            System.out.println("Maximum Academic Units to be registered exceeded.");
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * Verify if student is in waitList for given courseCode
     *
     * @param courseCode The courseCode entered by student to be dropped
     * @return <code>true</code> if student is in waitlist, <code>false</code> otherwise
     */
    public boolean verifyInWaitList(String courseCode){
        String courseIndex = student.getCourseIndex(courseCode);
        CourseIndex CI = CourseList.get(courseCode).getCourseIndexByIndexName(courseIndex);
        String registration = CI.studentInWhichList(student.getStudentEmail());
        return registration.equals("WaitList");
    }

    /**
     * Using course codes to check if there is a timing clash. This is to ensure that courses added into student time table do not clash
     *
     * @param courseCode1
     * @param courseIndex1
     * @return <code>true</code> if course timing clashes; <code>false</code> otherwise.
     */
    public boolean checkTimingClash(String courseCode1, String courseIndex1) {
//        System.out.println("Check Timing Clashes - ");
        if (student.getCourse().size() > 0) {
            for (Map.Entry<String, String> entry : student.getCourse().entrySet()) {
//                System.out.println("here1");
                String courseCode = entry.getKey();
                String courseIndex = entry.getValue();
                if (courseCode.equals(courseCode1)) {
                    continue;
                } // possible overlap for changing index, ignore same course
                ArrayList<CourseComponent> cc1 = CourseList.get(courseCode).getCourseIndexByIndexName(courseIndex).getCourseComponents();
                ArrayList<CourseComponent> cc2 = CourseList.get(courseCode1).getCourseIndexByIndexName(courseIndex1).getCourseComponents();
                LocalTime Start1, Start2, End1, End2;
                String day1, day2;
                for (CourseComponent num1 : cc1) {
//                    System.out.println("here2");
                    ArrayList<LocalTime> dt1 = num1.getTimeRange();
                    day1 = num1.getDay();
                    Start1 = dt1.get(0);
                    End1 = dt1.get(1);
                    for (CourseComponent num2 : cc2) {
                        ArrayList<LocalTime> dt2 = num2.getTimeRange();
                        day2 = num2.getDay();
                        Start2 = dt2.get(0);
                        End2 = dt2.get(1);
                        if (day2.equals(day1)) {
//                            System.out.println(Start2.compareTo(End1));
//                            System.out.println(Start1.compareTo(End2));
                            if (Start2.compareTo(End1) < 0 & Start1.compareTo(End2) < 0) { // hope this works?'
                                System.out.println("Course will clash with existing - " + courseCode +" - "+ courseIndex);
                                return true;
                            }
                        }
                    }
                }
            }
        } else {
            return false;
        }

        return false;
    }



    /**
     * runLoop to run the student function
     *
     * @param login Login details
     * @param sc    Scanner for input
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
                    // verify if maxAU exceeded
                    if(verifyAUsRegisteredExceededMax(courseCode)) {
                        break;
                    }
                    // verify course code in student
                    if (verifyStudentHasCourseCode(courseCode)) {
                        if (verifyInWaitList(courseCode)){
                            System.out.println("Course code has already been added to waitList."); }
                        else{
                            System.out.println("Course code has already been registered.");}
                        break;
                    }
                    System.out.println("Enter courseIndex: ");
                    String courseIndex = sc.nextLine();
                    // Verify courseIndex
                    if (!verifyCourseIndex(courseCode, courseIndex)) {
                        break;
                    }

                    // validate if timetable clashes
                    if (checkTimingClash(courseCode, courseIndex)){
                        System.out.println("New Course will clash with existing timetable!");
                        break;
                    }

                    // verify if course is already in waitlist

                    // Validate whether course got vacancies etc -- validation done in addcourse itself.
                    addCourse(courseCode, courseIndex);
                    // verify if there is vacancies in courseIndex
                    if (Objects.equals(checkVacancies(courseCode, courseIndex), 0)) {
                        System.out.println("Number of vacancies in courseIndex is 0. Student will be added to waitList.");
                    }
                    else {
                    System.out.println("Course successfully added");}

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
                    // verify if in waitlist
                    if(verifyInWaitList(courseCode)){
                        System.out.println("Student is removed from course waitList.");
                    }
                    else{
                    System.out.println("Course successfully dropped");}
                    dropCourse(courseCode);
                    // Update all waitlists
                    // https://stackoverflow.com/questions/1066589/iterate-through-a-hashmap
                    for (Map.Entry<String, Course> entry : CourseList.entrySet()) {
                        Course courses = entry.getValue();
                        courses.refreshCourseWaitList();
                    }

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
                    // vet if new index will cause clashes
                    if (checkTimingClash(courseCode, courseIndex)){
                        System.out.println("New Course Index will clash with existing timetable!");
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
                    String student2Username = sc.nextLine();
                    System.out.println("Enter second student password: ");
                    String student2Password = sc.nextLine(); // TODO mask password ?

                    // verify student name and student password
                    User SecondUser = login.getSwappingStudent(student2Username, student2Password);

                    if (SecondUser != null) {
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
                        addCourse(courseCode, index2);
                        SecondStudent.addCourse(courseCode, index1);
                        CourseList.get(courseCode).getCourseIndexByIndexName(index1).addStudent(SecondStudent);
                        StudentList.remove(student2Username);
                        StudentList.put(student2Username, SecondStudent);
                    }
                    break;

                case "7":
                    System.out.println("Program terminating..");
                    break;

                default:
                    System.out.println("Unknown Input Choice. Please try again.");
                    break;
            }
            saveCourses(CourseList);
            saveStudents(StudentList);
        } while (!choice.equals("7"));
    }

}
