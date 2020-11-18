package mystars;

import mystars.courses.Course;
import mystars.courses.CourseIndex;
import mystars.login.Login;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static mystars.Storage.loadCourses;
import static mystars.Storage.loadStudents;


public class Admin implements Serializable {
    private static final long serialVersionUID = 42L;

//    private static final long serialVersionUID = 26;
//    //    private String name;
//    private HashMap<String, Course> CoursesMap = new HashMap<>();
//    private HashMap<String, String> IndexMap = new HashMap<>();
//    Scanner sc = new Scanner(System.in);

    private HashMap<String, Course> CourseList;
    private HashMap<String, Student> StudentList;

    public Admin(String sampleadminname) {
        StudentList = loadStudents();
        CourseList = loadCourses();
    }

    public static Boolean verifyGender(String gender) {
        final Set<String> genderTypes = new HashSet<>() {{
            add("male");
            add("female");
        }};
        return (genderTypes.contains(gender.toLowerCase()));
    }

    public Boolean checkStudentEmailExists(String email) {
        // true if exists
        return (StudentList.get(email) != null);
    }

    public void editStudentAccessPeriod() {

    }

    public void addStudent(Student student) {
        String email = student.getStudentEmail();
        StudentList.put(email, student);
        Storage.saveStudents(StudentList);
    }


    public void addCourse(Scanner sc) {
        System.out.println("Enter Course Name:");
        String courseName = sc.next();
        System.out.println("Enter Course Code:");
        String courseCode = sc.next();
        System.out.println("Enter Course School:");
        String courseSchool = sc.next();
        System.out.println("Enter AU:");
        int AcademicUnits = sc.nextInt();

        System.out.println("Enter Course Vacancies:");
        int courseVacancies = sc.nextInt();
        System.out.println("Enter Number of Indexes:");
        int numberOfIndexes = sc.nextInt();
//        Index[] index = new Index[numberOfIndexes];

        Course course = new Course(courseName, courseCode, courseSchool, AcademicUnits);
        CourseList.put(course.getCourseCode(), course);
        for (int i = 0; i < numberOfIndexes; i++) {
            System.out.println("Enter Index Name:");
            String indexName = sc.next();
            CourseIndex courseIndex = new CourseIndex(indexName, courseVacancies);
            course.addCourseIndex(courseIndex);
            System.out.println("Enter Course Components:");
            int choice;
            System.out.println("1. Lecture     2. Lecture and Tutorial     3. Lecture, Tutorial and Lab");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("You have chosen choice 1 - Lecture Only");
                    System.out.println("Enter Lecture Venue:");
                    String LecVenue = sc.next();
                    System.out.println("Enter Lecture StartTime (HHMM):");
                    String LecStart = sc.next();
                    System.out.println("Enter Lecture EndTime (HHMM):");
                    String LecEnd = sc.next();
                    System.out.println("Enter Lecture WeekDay:");
                    String LecDay = sc.next();
                    courseIndex.addLecture(LecVenue, LecStart, LecEnd, LecDay);


                    break;
                case 2:
                    System.out.println("You have chosen choice 2 - Lecture & Tutorial");
                    System.out.println("Enter Lecture Venue:");
                    LecVenue = sc.next();
                    System.out.println("Enter Lecture StartTime (HHMM):");
                    LecStart = sc.next();
                    System.out.println("Enter Lecture EndTime (HHMM):");
                    LecEnd = sc.next();
                    System.out.println("Enter Lecture WeekDay:");
                    LecDay = sc.next();
                    courseIndex.addLecture(LecVenue, LecStart, LecEnd, LecDay);
                    System.out.println("Enter Tutorial Venue:");
                    String TutVenue = sc.next();
                    System.out.println("Enter Tutorial StartTime (HHMM):");
                    String TutStart = sc.next();
                    System.out.println("Enter Tutorial EndTime (HHMM):");
                    String TutEnd = sc.next();
                    System.out.println("Enter Tutorial WeekDay:");
                    String TutDay = sc.next();
                    courseIndex.addTutorial(TutVenue, TutStart, TutEnd, TutDay);

                    break;
                case 3:
                    System.out.println("You have chosen choice 3 - Lecture, Tutorial & Lab");
                    System.out.println("Enter Lecture Venue:");
                    LecVenue = sc.next();
                    System.out.println("Enter Lecture StartTime (HHMM):");
                    LecStart = sc.next();
                    System.out.println("Enter Lecture EndTime (HHMM):");
                    LecEnd = sc.next();
                    System.out.println("Enter Lecture WeekDay:");
                    LecDay = sc.next();
                    courseIndex.addLecture(LecVenue, LecStart, LecEnd, LecDay);
                    System.out.println("Enter Tutorial Venue:");
                    TutVenue = sc.next();
                    System.out.println("Enter Tutorial StartTime (HHMM):");
                    TutStart = sc.next();
                    System.out.println("Enter Tutorial EndTime (HHMM):");
                    TutEnd = sc.next();
                    System.out.println("Enter Tutorial WeekDay:");
                    TutDay = sc.next();
                    courseIndex.addTutorial(TutVenue, TutStart, TutEnd, TutDay);
                    System.out.println("Enter Lab Venue:");
                    String LabVenue = sc.next();
                    System.out.println("Enter Lab StartTime (HHMM):");
                    String LabStart = sc.next();
                    System.out.println("Enter Lab EndTime (HHMM):");
                    String LabEnd = sc.next();
                    System.out.println("Enter Lab WeekDay:");
                    String LabDay = sc.next();
                    courseIndex.addLaboratory(LabVenue, LabStart, LabEnd, LabDay);

                    break;
                default:
                    System.out.println("Invalid! Please choose again!");
            }

        }
    }


    public void updateCourses(Scanner sc) {
        System.out.println("Enter Course Code:");
        String courseCode = sc.next();
        System.out.println("Enter Course Name:");
        String courseName = sc.next();
        System.out.println("Enter Course School:");
        String courseSchool = sc.next();
        System.out.println("Enter AU:");
        int AcademicUnits = sc.nextInt();

        System.out.println("Enter Course Vacancies:");
        int courseVacancies = sc.nextInt();
        System.out.println("Enter Number of Indexes:");
        int numberOfIndexes = sc.nextInt();
//        Index[] index = new Index[numberOfIndexes];

        Course course = new Course(courseName, courseCode, courseSchool, AcademicUnits);
        CourseList.put(course.getCourseCode(), course);
        for (int i = 0; i < numberOfIndexes; i++) {
            System.out.println("Enter Index Name:");
            String indexName = sc.next();
            CourseIndex courseIndex = new CourseIndex(indexName, courseVacancies);
            course.addCourseIndex(courseIndex);
            System.out.println("Enter Course Components:");
            int choice;
            System.out.println("1. Lecture     2. Lecture and Tutorial     3. Lecture, Tutorial and Lab");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("You have chosen choice 1 - Lecture Only");
                    System.out.println("Enter Lecture Venue:");
                    String LecVenue = sc.next();
                    System.out.println("Enter Lecture StartTime (HHMM):");
                    String LecStart = sc.next();
                    System.out.println("Enter Lecture EndTime (HHMM):");
                    String LecEnd = sc.next();
                    System.out.println("Enter Lecture WeekDay:");
                    String LecDay = sc.next();
                    courseIndex.addLecture(LecVenue, LecStart, LecEnd, LecDay);


                    break;
                case 2:
                    System.out.println("You have chosen choice 2 - Lecture & Tutorial");
                    System.out.println("Enter Lecture Venue:");
                    LecVenue = sc.next();
                    System.out.println("Enter Lecture StartTime (HHMM):");
                    LecStart = sc.next();
                    System.out.println("Enter Lecture EndTime (HHMM):");
                    LecEnd = sc.next();
                    System.out.println("Enter Lecture WeekDay:");
                    LecDay = sc.next();
                    courseIndex.addLecture(LecVenue, LecStart, LecEnd, LecDay);
                    System.out.println("Enter Tutorial Venue:");
                    String TutVenue = sc.next();
                    System.out.println("Enter Tutorial StartTime (HHMM):");
                    String TutStart = sc.next();
                    System.out.println("Enter Tutorial EndTime (HHMM):");
                    String TutEnd = sc.next();
                    System.out.println("Enter Tutorial WeekDay:");
                    String TutDay = sc.next();
                    courseIndex.addTutorial(TutVenue, TutStart, TutEnd, TutDay);

                    break;
                case 3:
                    System.out.println("You have chosen choice 3 - Lecture, Tutorial & Lab");
                    System.out.println("Enter Lecture Venue:");
                    LecVenue = sc.next();
                    System.out.println("Enter Lecture StartTime (HHMM):");
                    LecStart = sc.next();
                    System.out.println("Enter Lecture EndTime (HHMM):");
                    LecEnd = sc.next();
                    System.out.println("Enter Lecture WeekDay:");
                    LecDay = sc.next();
                    courseIndex.addLecture(LecVenue, LecStart, LecEnd, LecDay);
                    System.out.println("Enter Tutorial Venue:");
                    TutVenue = sc.next();
                    System.out.println("Enter Tutorial StartTime (HHMM):");
                    TutStart = sc.next();
                    System.out.println("Enter Tutorial EndTime (HHMM):");
                    TutEnd = sc.next();
                    System.out.println("Enter Tutorial WeekDay:");
                    TutDay = sc.next();
                    courseIndex.addTutorial(TutVenue, TutStart, TutEnd, TutDay);
                    System.out.println("Enter Lab Venue:");
                    String LabVenue = sc.next();
                    System.out.println("Enter Lab StartTime (HHMM):");
                    String LabStart = sc.next();
                    System.out.println("Enter Lab EndTime (HHMM):");
                    String LabEnd = sc.next();
                    System.out.println("Enter Lab WeekDay:");
                    String LabDay = sc.next();
                    courseIndex.addLaboratory(LabVenue, LabStart, LabEnd, LabDay);

                    break;
                default:
                    System.out.println("Invalid! Please choose again!");
            }

        }

    }

    public int checkVacancies(String courseCode, String courseIndex) {
        // fuck this
        return CourseList.get(courseCode).getCourseIndexByIndexName(courseIndex).getNumberOfVacancies();
    }

    public void printStudentListByIndex(String courseCode, String courseIndex) {
        CourseList.get(courseCode).getCourseIndexByIndexName(courseIndex).printRegisteredStudent();
    }


    public void printStudentListByCourse(String courseCode) {
        CourseList.get(courseCode).printAllStudentsInIndexes();
    }


    public void runLoop(Login login) throws StarsException {
        int choice;
        Scanner sc = new Scanner(System.in);
        final String Choices = "(1) Edit Student Access Period" +
                "\n(2) Add Student" +
                "\n(3) Add Course" +
                "\n(4) Update Course" +
                "\n(5) Check Vacancies for a Course Index" +
                "\n(6) Print Student List by Index Number" +
                "\n(7) Print Student List by Course" +
                "(8) Exit";
        do {
            System.out.println(Choices);
            System.out.println("Enter the number of your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    LocalDateTime currentDateTime = LocalDateTime.now();
                    DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                    String formattedCurrentDT = currentDateTime.format(formatDateTime);
                    System.out.println("Current Date and Time: " + formattedCurrentDT);
                    System.out.println("Enter start date of Student Access Period (dd-MM-yyyy): ");
                    String date = sc.next();
                    System.out.println("Enter start time of Student Access Period: ");
                    String time = sc.next();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    LocalDate startDate = LocalDate.parse(date, formatter);
                    LocalTime timeFormat = LocalTime.parse(time);
                    System.out.println("date: " + startDate);
                    System.out.println("time: " + timeFormat);

                    System.out.println("Enter end date of Student Access Period (dd-MM-yyyy): ");
                    String date2 = sc.next();
                    System.out.println("Enter end time of Student Access Period: ");
                    String time2 = sc.next();
                    LocalDate endDate = LocalDate.parse(date2, formatter);
                    LocalTime timeFormat2 = LocalTime.parse(time2);
                    System.out.println("date: " + endDate);
                    System.out.println("time: " + timeFormat2);
                    break;
                case 2:
                    // Done
                    System.out.println("(2) Add Student");
                    System.out.println("Enter studentEmail: ");
                    String studentEmail = sc.nextLine();
                    if (checkStudentEmailExists(studentEmail)) {
                        // True = already exists
                        System.out.println("Email already exists!");
                        break;
                    }
                    ;
                    System.out.println("Enter studentName: ");
                    String studentName = sc.nextLine();
                    System.out.println("Enter matricNo: ");
                    String matricNo = sc.nextLine();
                    // TODO Verify matric does not duplicate
                    System.out.println("Enter studentGender: ");
                    String studentGender = sc.nextLine().toLowerCase();
                    // TODO verify gender lmao
//                        if (admin.verifyGender(studentGender)){
//                            // True = correct input
//                            System.out.println("Gender incorrect format (Male/Female)!");
//                            break;
//                        };
                    System.out.println("Enter studentNationality: ");
                    String studentNationality = sc.nextLine();
                    // TODO verify nationality?
                    login.addNewStudentWithPassword(sc, studentEmail);
                    Student newStudent = new Student(matricNo, studentName, studentEmail, studentGender, studentNationality);
                    addStudent(newStudent);
                    System.out.println("Student added");
                    break;

                case 3:
                    // Done
                    addCourse(sc);
                    System.out.println("Course Added");
                    break;
                case 4:
                    updateCourses(sc);
                    System.out.println("Program terminating..");
                    break;
                case 5:
                    // Done
                    System.out.println("(5) Check Vacancies for a Course Index");
                    System.out.println("Enter courseCode: ");
                    String courseCode = sc.nextLine();
                    // TODO verify coursecode
                    System.out.println("Enter courseIndex: ");
                    String courseIndex = sc.nextLine();
                    // TODO Verify courseindex
                    int vacancies = checkVacancies(courseCode, courseIndex);
                    System.out.println("Course Index has " + String.valueOf(vacancies) + " Vacancies");
                    break;
                case 6:
                    // Done
                    System.out.println("(6) Print Student List by Index Number");
                    System.out.println("Enter courseCode: ");
                    courseCode = sc.nextLine();
                    // TODO verify coursecode
                    System.out.println("Enter courseIndex: ");
                    courseIndex = sc.nextLine();
                    // TODO Verify courseindex
                    printStudentListByIndex(courseCode, courseIndex);
                    System.out.println("Program terminating..");
                    break;
                case 7:
                    // Done
                    System.out.println("(7) Print Student List by Course");
                    System.out.println("Enter courseCode: ");
                    courseCode = sc.nextLine();
                    // TODO verify coursecode
                    printStudentListByCourse(courseCode);
                    System.out.println("Program terminating..");
                    break;
                case 8:
                    System.out.println("Program terminating..");
            }
        } while (choice != 8);

    }
}
