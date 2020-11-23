package mystars;

import mystars.courses.Course;
import mystars.courses.CourseIndex;
import mystars.login.Login;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static mystars.Storage.*;


public class Admin implements Serializable {
    private static final long serialVersionUID = 420;
    private final HashMap<String, Course> CourseList;
    private final HashMap<String, Student> StudentList;
    private final ArrayList<LocalDateTime> DateList;
//    private final ArrayList<LocalTime> TimeList;

    /**
     * Constructor to create Admin object based on parameters given.
     * Creates admin with adminUserName
     *
     * @param adminUserName The name of an admin.
     */
    public Admin(String adminUserName) {
        StudentList = loadStudents();
        CourseList = loadCourses();
        DateList = loadAccessPeriodDate();
//        TimeList = loadAccessPeriodTime();
    }

    /**
     * Function to verify name input
     *
     * @param name
     * @return
     */
    public static boolean verifyNameInput(String name) {
        String regex = "^[a-zA-Z ]+$";
        return name.matches(regex);
    }

    /**
     * Function to verify gender.
     *
     * @param gender The gender of student.
     * @return
     */
    public static Boolean verifyGender(String gender) {
        final Set<String> genderTypes = new HashSet<>() {{
            add("male");
            add("female");
        }};
        return (genderTypes.contains(gender.toLowerCase()));
    }

    /**
     * Function to verify nationality
     *
     * @param nationality
     * @return
     */
    public static Boolean verifyNationality(String nationality) {
        final Set<String> nationalityTypes = new HashSet<>() {{
            add("singaporean");
            add("malaysian");
            add("indonesian");
            add("chinese");
            add("thai");
        }};
        return (nationalityTypes.contains(nationality.toLowerCase()));
    }

    /**
     * Function to verify the format of matricNo input
     *
     * @param matricNo
     * @return
     */
    public static boolean verifyMatricNoFormat(String matricNo) {
        String regex = "(u)(19)[0-9]{5}[a-z]{1}";
        return matricNo.toLowerCase().matches(regex);
    }

    /**
     * Function to verify the school entered
     *
     * @param school
     * @return
     */
    public static Boolean verifyCourseSchool(String school) {
        final Set<String> courseSchool = new HashSet<>() {{
            add("SCSE");
            add("NBS");
            add("EEE");
            add("CEE");
            add("SPMS");
        }};
        return (courseSchool.contains(school.toUpperCase()));
    }

//    /**
//     * Function to verify the format of email input
//     *
//     * @param email
//     * @return
//     */
//    static boolean isEmailValid(String email) {
//        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
//        return email.matches(regex);
//    }

    /**
     * Function to change time inputs to HHmm format
     *
     * @param sc
     * @param display
     * @return
     */
    private String getHHmmFormat(Scanner sc, String display) {
        boolean x = true;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmm");
        String value = "";
        while (x) {
            System.out.println(display);
            value = sc.nextLine();
            try {
                LocalTime.parse(value, formatter);
                return (value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return value;
    }

    /**
     * Function to check if student's email exists.
     *
     * @param email The email name of the student.
     * @return
     */
    public boolean checkStudentEmailExists(String email) {
        // true if exists
        return (StudentList.get(email) != null);
    }

    /**
     * Function to check if student's matric no already exists
     *
     * @param matricNo
     * @return
     */
    public boolean checkMatricNoExists(String matricNo) {
        // true if exists
        return (StudentList.get(matricNo) != null);
    }

    public void editStudentAccessPeriod(Scanner sc) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedCurrentDT = currentDateTime.format(formatDateTime);
        System.out.println("Current Date and Time: " + formattedCurrentDT);
        LocalDateTime oldStartDate = DateList.get(0);
        LocalDateTime oldEndDate = DateList.get(1);
        System.out.println("Old Start Date : " + oldStartDate.format(formatDateTime));
        System.out.println("Old End Date   : " + oldEndDate.format(formatDateTime));
//        DateList.removeAll(DateList);
//        TimeList.removeAll(TimeList);

        try {
            System.out.println("Enter start date of Student Access Period (dd-MM-yyyy HH:mm:ss): ");
            String date = sc.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            LocalDateTime startDate = LocalDateTime.parse(date, formatter);
            System.out.println("New Start Date : " + startDate.format(formatDateTime));
            DateList.add(0, startDate);
            System.out.println("Enter end date of Student Access Period (dd-MM-yyyy HH:mm:ss): ");
            String date2 = sc.nextLine();
            LocalDateTime endDate = LocalDateTime.parse(date2, formatter);
            System.out.println("New End Time: " + endDate.format(formatDateTime));
            DateList.add(1, endDate);

//            System.out.println("Enter start time of Student Access Period: ");
//            String time = sc.nextLine();
//            LocalTime startTime = LocalTime.parse(time);
//            System.out.println("New Start Date and Time");
//            System.out.println("New Start Time: " + startTime);
//            TimeList.add(0, startTime);
//
//            System.out.println("Enter end time of Student Access Period: ");
//            String time2 = sc.nextLine();
//            LocalTime endTime = LocalTime.parse(time2);
//            System.out.println("New End Date and Time");
//            System.out.println("New End Time: " + endTime);
//            TimeList.add(0, endTime);

        } catch (Exception e) {
            System.out.println("Invalid input try again!");
        }
//        DateList.removeAll(DateList);

    }

    public boolean accessPeriod() {
        LocalDateTime currentDate = LocalDateTime.now();
//        LocalTime currentTime = LocalTime.now();
        LocalDateTime startDate = DateList.get(0);
        LocalDateTime endDate = DateList.get(1);
//        LocalTime startTime = TimeList.get(0);
//        LocalTime endTime = TimeList.get(1);

        if ((DateList.isEmpty())) {
            return false;
        } else if (currentDate.isBefore(startDate)) {
            return false;
        } else if (currentDate.isAfter(startDate) && currentDate.isBefore((endDate))) {
            return true;
        }
//        else if (currentDate.isEqual(startDate) && currentDate.isBefore(endDate)) {
//            if (currentTime.isBefore(startTime)) {
//                return false;
//            }
//            else if (currentTime.isAfter(startTime) || currentTime.equals(startTime)) {
//                return true;
//            }
//        }
        else if (currentDate.isAfter(endDate)) {
            return false;
        }
        return false;
    }

    /**
     * Function to add student.
     *
     * @param student Student object
     */
    public void addStudent(Student student) {
        String email = student.getStudentEmail();
        StudentList.put(email, student);
        Storage.saveStudents(StudentList);
    }

    /**
     * Function to verify if course code exists
     *
     * @param courseCode
     * @return
     */
    public boolean verifyCourseCode(String courseCode) {
        return CourseList.get(courseCode) != null;
    }

    /**
     * Function to verify course code format (CZ1xxx to CZ4xxx)
     *
     * @param courseCode
     * @return
     */
    public static boolean verifyCourseCodeFormat(String courseCode) {
        String regex = "(cz)[1-4]{1}[0-9]{3}";
        return courseCode.toLowerCase().matches(regex);
    }
    /**
     * Function to verify if course index exists
     *
     * @param courseCode
     * @param courseIndex
     * @return
     */
    public boolean verifyCourseIndex(String courseCode, String courseIndex) {
        if (CourseList.get(courseCode).getCourseIndexByIndexName(courseIndex) == null) {
            System.out.println("Rejected - courseIndex does not exist in CourseCode");
            return false;
        }
        return true;
    }

    /**
     * Function to add course.
     *
     * @param sc Scanner object.
     */
    public void addCourse(Scanner sc) {
        System.out.println("Enter Course Name:");
        String courseName = sc.nextLine();
        String courseCode;
        // verify course code does not already exist
        do {
            System.out.println("Enter Course Code:");
            courseCode = sc.nextLine();
            if (verifyCourseCode(courseCode))
                System.out.println("Course code already exists, try again!");
            else if (!verifyCourseCodeFormat(courseCode))
                System.out.println("Invalid course code format, try again!");
        } while (verifyCourseCode(courseCode) || !verifyCourseCodeFormat(courseCode));

        String courseSchool;
        // verify course school
        do {
            System.out.println("Enter Course School:");
            courseSchool = sc.nextLine();
            if (!verifyCourseSchool(courseSchool))
                System.out.println("Invalid Course School, try again!");
        } while (!verifyCourseSchool(courseSchool));

//        System.out.println("Enter AU:");
//        int AcademicUnits = sc.nextInt();
//        // Remove non-integer inputs due to buggy java stuff lmao https://stackoverflow.com/questions/27717503/why-does-my-scanner-repeat
//        sc.nextLine();
        int AcademicUnits;
        do {
            System.out.println("Enter AU:");
            while (!sc.hasNextInt()) {
                System.out.println("Please enter an integer!");
                System.out.println("Enter AU: ");
                sc.next();
            }
            AcademicUnits = sc.nextInt();
            sc.nextLine();
        } while ((AcademicUnits <= 0) || (AcademicUnits > 4));

        int courseVacancies;
        do {
            System.out.println("Enter Course Vacancies:");
            while (!sc.hasNextInt()) {
                System.out.println("Please enter an integer!");
                System.out.println("Enter Course Vacancies:");
                sc.next();
            }
            courseVacancies = sc.nextInt();
            sc.nextLine();
            if ((courseVacancies <= 0) || (courseVacancies > 500)) {
                System.out.println("Invalid, please enter values from 1 to 500 only");
            }

        } while ((courseVacancies <= 0) || (courseVacancies > 500));
//        int courseVacancies = sc.nextInt();
//        // Remove non-integer inputs due to buggy java stuff lmao https://stackoverflow.com/questions/27717503/why-does-my-scanner-repeat
//        sc.nextLine();

        int choice;
        do {
            System.out.println("Enter Course Components:");
            System.out.println("1. Lecture     2. Lecture and Tutorial     3. Lecture, Tutorial and Lab");
            while (!sc.hasNextInt()) {
                System.out.println("Please enter an integer!");
                System.out.println("Enter Course Components:");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine();
        } while ((choice <= 0) || (choice >= 4));

        int numberOfIndexes;
        if (choice == 1) {
            numberOfIndexes = 1;
        } else {
            do {
                System.out.println("Enter Number of Indexes:");
                while (!sc.hasNextInt()) {
                    System.out.println("Please enter an integer!");
                    System.out.println("Enter Number of Indexes:");
                    sc.next();
                }
                numberOfIndexes = sc.nextInt();
                sc.nextLine();
            } while ((numberOfIndexes <= 0) || (numberOfIndexes > 10));
        }

//        System.out.println("Enter Number of Indexes:");
//        int numberOfIndexes = sc.nextInt();
//        // Remove non-integer inputs due to buggy java stuff lmao https://stackoverflow.com/questions/27717503/why-does-my-scanner-repeat
//        sc.nextLine();

//        Index[] index = new Index[numberOfIndexes];

        Course course = new Course(courseName, courseCode, courseSchool, AcademicUnits);
        CourseList.put(course.getCourseCode(), course);
        for (int i = 0; i < numberOfIndexes; i++) {
            System.out.println("Enter Index Name:");
            String indexName = sc.nextLine();
            CourseIndex courseIndex = new CourseIndex(indexName, courseVacancies);
            course.addCourseIndex(courseIndex);

            switch (choice) {
                case 1:
                    System.out.println("You have chosen choice 1 - Lecture Only");
                    System.out.println("Enter Lecture Venue:");
                    String LecVenue = sc.nextLine();
//                    System.out.println();
                    String LecStart = getHHmmFormat(sc, "Enter Lecture StartTime (HHMM):");
//                    System.out.println("Enter Lecture EndTime (HHMM):");
                    String LecEnd = getHHmmFormat(sc, "Enter Lecture EndTime (HHMM):");
                    System.out.println("Enter Lecture WeekDay:");
                    String LecDay = sc.nextLine();
                    courseIndex.addLecture(LecVenue, LecStart, LecEnd, LecDay);


                    break;
                case 2:
                    System.out.println("You have chosen choice 2 - Lecture & Tutorial");
                    System.out.println("Enter Lecture Venue:");
                    LecVenue = sc.nextLine();
//                    System.out.println("Enter Lecture StartTime (HHMM):");
                    LecStart = getHHmmFormat(sc, "Enter Lecture StartTime (HHMM):");
//                    System.out.println("Enter Lecture EndTime (HHMM):");
                    LecEnd = getHHmmFormat(sc, "Enter Lecture EndTime (HHMM):");
                    System.out.println("Enter Lecture WeekDay:"); // TODO ENUM
                    LecDay = sc.nextLine();
                    courseIndex.addLecture(LecVenue, LecStart, LecEnd, LecDay);
                    System.out.println("Enter Tutorial Venue:");
                    String TutVenue = sc.nextLine();
//                    System.out.println("Enter Tutorial StartTime (HHMM):");
                    String TutStart = getHHmmFormat(sc, "Enter Tutorial StartTime (HHMM):");
//                    System.out.println("Enter Tutorial EndTime (HHMM):");
                    String TutEnd = getHHmmFormat(sc, "Enter Tutorial EndTime (HHMM):");
                    System.out.println("Enter Tutorial WeekDay:");
                    String TutDay = sc.nextLine();
                    courseIndex.addTutorial(TutVenue, TutStart, TutEnd, TutDay);

                    break;
                case 3:
                    System.out.println("You have chosen choice 3 - Lecture, Tutorial & Lab");
                    System.out.println("Enter Lecture Venue:");
                    LecVenue = sc.nextLine();
//                    System.out.println("Enter Lecture StartTime (HHMM):");
                    LecStart = getHHmmFormat(sc, "Enter Lecture StartTime (HHMM):");
//                    System.out.println("Enter Lecture EndTime (HHMM):");
                    LecEnd = getHHmmFormat(sc, "Enter Lecture EndTime (HHMM):");
                    System.out.println("Enter Lecture WeekDay:"); // TODO ENUM
                    LecDay = sc.nextLine();
                    courseIndex.addLecture(LecVenue, LecStart, LecEnd, LecDay);
                    System.out.println("Enter Tutorial Venue:");
                    TutVenue = sc.nextLine();
//                    System.out.println("Enter Tutorial StartTime (HHMM):");
                    TutStart = getHHmmFormat(sc, "Enter Tutorial StartTime (HHMM):");
//                    System.out.println("Enter Tutorial EndTime (HHMM):");
                    TutEnd = getHHmmFormat(sc, "Enter Tutorial EndTime (HHMM):");
                    System.out.println("Enter Tutorial WeekDay:");
                    TutDay = sc.nextLine();
                    courseIndex.addTutorial(TutVenue, TutStart, TutEnd, TutDay);
                    System.out.println("Enter Lab Venue:");
                    String LabVenue = sc.nextLine();
//                    System.out.println("Enter Lab StartTime (HHMM):");
                    String LabStart = getHHmmFormat(sc, "Enter Lab StartTime (HHMM):");
//                    System.out.println("Enter Lab EndTime (HHMM):");
                    String LabEnd = getHHmmFormat(sc, "Enter Lab EndTime (HHMM):");
                    System.out.println("Enter Lab WeekDay:");
                    String LabDay = sc.nextLine();
                    courseIndex.addLaboratory(LabVenue, LabStart, LabEnd, LabDay);

                    break;
                default:
                    System.out.println("Invalid! Please choose again!");
            }

        }
        saveCourses(CourseList);
    }


    /**
     * Function to update course.
     *
     * @param sc Scanner object.
     */
    public void updateCourses(Scanner sc) {
        System.out.println("Enter Course Code:");
        String courseCode = sc.nextLine();
        if (!verifyCourseCode(courseCode)) {
            return;
        }
        System.out.println("Now updating course " + courseCode + " ...");
        System.out.println("Enter Course Name:");
        String courseName = sc.nextLine();
        System.out.println("Enter Course School:");
        String courseSchool = sc.nextLine();

        int AcademicUnits;
        do {
            System.out.println("Enter AU:");
            while (!sc.hasNextInt()) {
                System.out.println("Please enter an integer!");
                System.out.println("Enter AU: ");
                sc.next();
            }
            AcademicUnits = sc.nextInt();
            sc.nextLine();
            if ((AcademicUnits <= 0) || (AcademicUnits > 4)) {
                System.out.println("Invalid, please enter values from 1 to 4 only");
            }
        } while ((AcademicUnits <= 0) || (AcademicUnits > 4)); // show a warning message if input not within limits

        int courseVacancies;
        do {
            System.out.println("Enter Course Vacancies:");
            while (!sc.hasNextInt()) {
                System.out.println("Please enter an integer!");
                System.out.println("Enter Course Vacancies:");
                sc.next();
            }
            courseVacancies = sc.nextInt();
            sc.nextLine();
            if ((courseVacancies <= 0) || (courseVacancies > 500)) {
                System.out.println("Invalid, please enter values from 1 to 500 only");
            }
        } while ((courseVacancies <= 0) || (courseVacancies > 500)); // show a warning message if input not within limits

        int choice;
        do {
            System.out.println("Enter Course Components:");
            System.out.println("1. Lecture     2. Lecture and Tutorial     3. Lecture, Tutorial and Lab");
            while (!sc.hasNextInt()) {
                System.out.println("Please enter an integer!");
                System.out.println("Enter Course Vacancies:");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine();
        } while ((choice <= 0) || (choice >= 4));

        int numberOfIndexes;
        if (choice == 1)
            numberOfIndexes = 1;
        else {
            do {
                System.out.println("Enter Number of Indexes:");
                while (!sc.hasNextInt()) {
                    System.out.println("Please enter an integer!");
                    System.out.println("Enter Number of Indexes:");
                    sc.next();
                }
                numberOfIndexes = sc.nextInt();
                sc.nextLine();
                if ((numberOfIndexes <= 0) || (numberOfIndexes > 10)) {
                    System.out.println("Invalid, please enter values from 1 to 4 only");
                }
            } while ((numberOfIndexes <= 0) || (numberOfIndexes > 10)); // show a warning message if input not within limits
        }
//        Index[] index = new Index[numberOfIndexes];

        Course course = new Course(courseName, courseCode, courseSchool, AcademicUnits);
        CourseList.put(course.getCourseCode(), course);
        for (int i = 0; i < numberOfIndexes; i++) {
            System.out.println("Enter Index Name:");
            String indexName = sc.nextLine();
            CourseIndex courseIndex = new CourseIndex(indexName, courseVacancies);
            course.addCourseIndex(courseIndex);


            switch (choice) {
                case 1:
                    System.out.println("You have chosen choice 1 - Lecture Only");
                    System.out.println("Enter Lecture Venue:");
                    String LecVenue = sc.nextLine();
//                    System.out.println();
                    String LecStart = getHHmmFormat(sc, "Enter Lecture StartTime (HHMM):");
//                    System.out.println("Enter Lecture EndTime (HHMM):");
                    String LecEnd = getHHmmFormat(sc, "Enter Lecture EndTime (HHMM):");
                    System.out.println("Enter Lecture WeekDay:");
                    String LecDay = sc.nextLine();
                    courseIndex.addLecture(LecVenue, LecStart, LecEnd, LecDay);


                    break;
                case 2:
                    System.out.println("You have chosen choice 2 - Lecture & Tutorial");
                    System.out.println("Enter Lecture Venue:");
                    LecVenue = sc.nextLine();
//                    System.out.println("Enter Lecture StartTime (HHMM):");
                    LecStart = getHHmmFormat(sc, "Enter Lecture StartTime (HHMM):");
//                    System.out.println("Enter Lecture EndTime (HHMM):");
                    LecEnd = getHHmmFormat(sc, "Enter Lecture EndTime (HHMM):");
                    System.out.println("Enter Lecture WeekDay:"); // TODO ENUM
                    LecDay = sc.nextLine();
                    courseIndex.addLecture(LecVenue, LecStart, LecEnd, LecDay);
                    System.out.println("Enter Tutorial Venue:");
                    String TutVenue = sc.nextLine();
//                    System.out.println("Enter Tutorial StartTime (HHMM):");
                    String TutStart = getHHmmFormat(sc, "Enter Tutorial StartTime (HHMM):");
//                    System.out.println("Enter Tutorial EndTime (HHMM):");
                    String TutEnd = getHHmmFormat(sc, "Enter Tutorial EndTime (HHMM):");
                    System.out.println("Enter Tutorial WeekDay:");
                    String TutDay = sc.nextLine();
                    courseIndex.addTutorial(TutVenue, TutStart, TutEnd, TutDay);

                    break;
                case 3:
                    System.out.println("You have chosen choice 3 - Lecture, Tutorial & Lab");
                    System.out.println("Enter Lecture Venue:");
                    LecVenue = sc.nextLine();
//                    System.out.println("Enter Lecture StartTime (HHMM):");
                    LecStart = getHHmmFormat(sc, "Enter Lecture StartTime (HHMM):");
//                    System.out.println("Enter Lecture EndTime (HHMM):");
                    LecEnd = getHHmmFormat(sc, "Enter Lecture EndTime (HHMM):");
                    System.out.println("Enter Lecture WeekDay:"); // TODO ENUM
                    LecDay = sc.nextLine();
                    courseIndex.addLecture(LecVenue, LecStart, LecEnd, LecDay);
                    System.out.println("Enter Tutorial Venue:");
                    TutVenue = sc.nextLine();
//                    System.out.println("Enter Tutorial StartTime (HHMM):");
                    TutStart = getHHmmFormat(sc, "Enter Tutorial StartTime (HHMM):");
//                    System.out.println("Enter Tutorial EndTime (HHMM):");
                    TutEnd = getHHmmFormat(sc, "Enter Tutorial EndTime (HHMM):");
                    System.out.println("Enter Tutorial WeekDay:");
                    TutDay = sc.nextLine();
                    courseIndex.addTutorial(TutVenue, TutStart, TutEnd, TutDay);
                    System.out.println("Enter Lab Venue:");
                    String LabVenue = sc.nextLine();
//                    System.out.println("Enter Lab StartTime (HHMM):");
                    String LabStart = getHHmmFormat(sc, "Enter Lab StartTime (HHMM):");
//                    System.out.println("Enter Lab EndTime (HHMM):");
                    String LabEnd = getHHmmFormat(sc, "Enter Lab EndTime (HHMM):");
                    System.out.println("Enter Lab WeekDay:");
                    String LabDay = sc.nextLine();
                    courseIndex.addLaboratory(LabVenue, LabStart, LabEnd, LabDay);

                    break;
                default:
                    System.out.println("Invalid! Please choose again!");
            }

        }

    }

    /**
     * Function too check vacancies of course.
     *
     * @param courseCode  The course code of a course.
     * @param courseIndex The course index of a course.
     * @return
     */
    public int checkVacancies(String courseCode, String courseIndex) {
        // fuck this
        return CourseList.get(courseCode).getCourseIndexByIndexName(courseIndex).getNumberOfVacancies();
    }

    /**
     * Function to print student list by index
     *
     * @param courseCode  The course code of a course.
     * @param courseIndex The course index of a course.
     */
    public void printStudentListByIndex(String courseCode, String courseIndex) {
        CourseList.get(courseCode).getCourseIndexByIndexName(courseIndex).printRegisteredStudent();
    }

    /**
     * Function to print student list by course.
     *
     * @param courseCode The course code of a course.
     */
    public void printStudentListByCourse(String courseCode) {
        CourseList.get(courseCode).printAllStudentsInIndexes();
    }

    /**
     * runLoop to run the admin function
     *
     * @param login Login details
     * @param sc    Scanner for input
     * @throws StarsException
     */
    public void runLoop(Login login, Scanner sc) throws StarsException {
        String choice;
        final String Choices = "\n(1) Edit Student Access Period" +
                "\n(2) Add Student" +
                "\n(3) Update Student" +
                "\n(4) Add Course" +
                "\n(5) Update Course" +
                "\n(6) Check Vacancies for a Course Index" +
                "\n(7) Print Student List by Index Number" +
                "\n(8) Print Student List by Course" +
                "\n(9) Print Entire Student List" +
                "\n(10) Print Entire Course List" +
                "\n(11) Exit";
        do {
            System.out.println(Choices);
            System.out.println("Enter the number of your choice: ");
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("\n(1) Edit Student Access Period");
                    editStudentAccessPeriod(sc);
                    System.out.println("Student Access Period Edited!");
                    break;
                case "2":
                    // Done
                    System.out.println("\n(2) Add Student");
                    System.out.println("Enter studentEmail: ");
                    String studentEmail = sc.nextLine();
                    // verify email does not already exist
                    if (checkStudentEmailExists(studentEmail)) {
                        System.out.println("Email already exists!");
                        break;
                    }
                    System.out.println("Enter studentName: ");
                    String studentName = sc.nextLine();
                    // verify name does not contain numbers
                    if (!verifyNameInput(studentName)) {
                        System.out.println("Invalid name input!");
                        break;
                    }
                    System.out.println("Enter matricNo: ");
                    String matricNo = sc.nextLine();
                    // verify matric does not duplicate
                    if (checkMatricNoExists(matricNo)) {
                        System.out.println("matricNo already exists!");
                        break;
                    }
                    // verify matric in correct format
                    else if (!verifyMatricNoFormat(matricNo)) {
                        System.out.println("Invalid Matric No Format!");
                        break;
                    }
                    System.out.println("Enter studentGender: (Male/Female)");
                    String studentGender = sc.nextLine().toLowerCase();
                    // verify gender
                    if (!verifyGender(studentGender)) {
                        System.out.println("Gender incorrect format (Male/Female)!");
                        break;
                    }
                    System.out.println("Enter studentNationality: ");
                    String studentNationality = sc.nextLine();
                    // verify nationality
                    if (!verifyNationality(studentNationality)) {
                        System.out.println("Nationality incorrect!");
                        break;
                    }
                    login.addNewStudentWithPassword(sc, studentEmail);
                    Student newStudent = new Student(matricNo, studentName, studentEmail, studentGender, studentNationality);
                    addStudent(newStudent);
                    System.out.println("Student added");
                    System.out.println();
                    System.out.println("Current Student List:");
                    for (String name : StudentList.keySet()) {
                        System.out.println("Name: " + StudentList.get(name).getStudentName());
                        System.out.println("Matric No: " + StudentList.get(name).getMatricNo());
                        System.out.println("Email: " + StudentList.get(name).getStudentEmail());
                        System.out.println("Gender: " + StudentList.get(name).getStudentGender());
                        System.out.println("Nationality: " + StudentList.get(name).getStudentNationality());
                        System.out.println();
                    }
                    break;
                case "3":
                    // Done
                    System.out.println("\n(3) Update Student");
                    System.out.println("Enter studentEmail: ");
                    String studentEmail1 = sc.nextLine();
                    // verify student email already exist
                    if (!checkStudentEmailExists(studentEmail1)) {
                        System.out.println("Student does not exist!");
                        break;
                    }
                    System.out.println("Updating student "+studentEmail1+"...");
                    System.out.println("Enter studentName: ");
                    String studentName1 = sc.nextLine();
                    if (!verifyNameInput(studentName1)) {
                        System.out.println("Invalid name input!");
                        break;
                    }
                    System.out.println("Enter matricNo: ");
                    String matricNo1 = sc.nextLine();
                    // verify matric does not duplicate
                    if (checkMatricNoExists(matricNo1)) {
                        System.out.println("matricNo already exists!");
                        break;
                    }
                    // verify matric in correct format
                    else if (!verifyMatricNoFormat(matricNo1)) {
                        System.out.println("Invalid Matric No Format!");
                        break;
                    }
                    System.out.println("Enter studentGender: (Male/Female)");
                    String studentGender1 = sc.nextLine().toLowerCase();
                    // verify gender
                    if (!verifyGender(studentGender1)) {
                        System.out.println("Gender incorrect format (Male/Female)!");
                        break;
                    }
                    System.out.println("Enter studentNationality: ");
                    String studentNationality1 = sc.nextLine();
                    // verify nationality
                    if (!verifyNationality(studentNationality1)) {
                        System.out.println("Nationality incorrect!");
                        break;
                    }

                    StudentList.remove(studentEmail1);
                    Student updatedStudent = new Student(matricNo1, studentName1, studentEmail1, studentGender1, studentNationality1);
                    addStudent(updatedStudent);
                    System.out.println("Student information updated.");
                    System.out.println();
                    System.out.println("Current Student List:");
                    for (String name: StudentList.keySet()){
                        System.out.println("Name: "+StudentList.get(name).getStudentName());
                        System.out.println("Matric No: "+StudentList.get(name).getMatricNo());
                        System.out.println("Email: "+StudentList.get(name).getStudentEmail());
                        System.out.println("Gender: "+StudentList.get(name).getStudentGender());
                        System.out.println("Nationality: "+StudentList.get(name).getStudentNationality());
                        System.out.println();
                    }
                    break;

                case "4":
                    System.out.println("\n(4) Add Course");
                    // Done
                    addCourse(sc);
                    System.out.println("Course Added");
                    break;
                case "5":
                    System.out.println("\n(5) Update Course");

                    updateCourses(sc);
                    System.out.println("Program terminating..");
                    break;
                case "6":
                    // Done
                    System.out.println("\n(6) Check Vacancies for a Course Index");
                    System.out.println("Enter courseCode: ");
                    String courseCode = sc.nextLine();
                    // verify coursecode
                    if (!verifyCourseCode(courseCode)) {
                        break;
                    }
                    System.out.println("Enter courseIndex: ");
                    String courseIndex = sc.nextLine();
                    // verify courseindex
                    if (!verifyCourseIndex(courseCode, courseIndex)) {
                        break;
                    }
                    int vacancies = checkVacancies(courseCode, courseIndex);
                    System.out.println("Course Index has " + vacancies + " Vacancies");
                    break;
                case "7":
                    // Done
                    System.out.println("\n(7) Print Student List by Index Number");
                    System.out.println("Enter courseCode: ");
                    courseCode = sc.nextLine();
                    // verify coursecode
                    if (!verifyCourseCode(courseCode)) {
                        break;
                    }
                    System.out.println("Enter courseIndex: ");
                    courseIndex = sc.nextLine();
                    // verify courseindex
                    if (!verifyCourseIndex(courseCode, courseIndex)) {
                        break;
                    }
                    printStudentListByIndex(courseCode, courseIndex);
                    break;
                case "8":
                    // Done
                    System.out.println("\n(8) Print Student List by Course");
                    System.out.println("Enter courseCode: ");
                    courseCode = sc.nextLine();
                    // verify coursecode
                    if (!verifyCourseCode(courseCode)) {
                        break;
                    }
                    printStudentListByCourse(courseCode);
                    break;
                case "9":
                    System.out.println("Current Student List:");
                    for (String name : StudentList.keySet()) {
                        System.out.println("Name: " + StudentList.get(name).getStudentName());
                        System.out.println("Matric No: " + StudentList.get(name).getMatricNo());
                        System.out.println("Email: " + StudentList.get(name).getStudentEmail());
                        System.out.println("Gender: " + StudentList.get(name).getStudentGender());
                        System.out.println("Nationality: " + StudentList.get(name).getStudentNationality());
                        System.out.println();
                    }
                    break;
                case "10":
                    System.out.println("Current Course List:");
                    for (String course: CourseList.keySet()){
                        System.out.println("Course Code: "+ CourseList.get(course).getCourseCode());
                        System.out.println("Course Name: "+ CourseList.get(course).getCourseName());
                        System.out.println("Course School: "+ CourseList.get(course).getCourseSchool());
                        System.out.println("Academic Units (AUs): "+ CourseList.get(course).getCourseAcademicUnit());
                        CourseList.get(course).getCourseIndexAndVacancy();
                        System.out.println();
                    }
                    break;
                case "11":
                    System.out.println("Program terminating..");
                    break;
                default:
                    System.out.println("Unknown Input Choice");

            }


            saveCourses(CourseList);
            saveStudents(StudentList);
            saveAccessPeriodDate(DateList);
        } while (!choice.equals("11"));

    }
}
