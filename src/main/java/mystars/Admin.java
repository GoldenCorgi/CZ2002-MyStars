package mystars;

import mystars.courses.Course;
import mystars.courses.CourseIndex;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static mystars.Storage.loadCourses;
import static mystars.Storage.loadStudents;


public class Admin implements Serializable {

//    private static final long serialVersionUID = 26;
//    //    private String name;
//    private HashMap<String, Course> CoursesMap = new HashMap<>();
//    private HashMap<String, String> IndexMap = new HashMap<>();
//    Scanner sc = new Scanner(System.in);

    private HashMap<String, Course> CourseList;
    private HashMap<String, Student> StudentList = new HashMap<>();

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


    public Admin(String sampleadminname) {
        StudentList = loadStudents();
        CourseList = loadCourses();
    }


    public void editStudentAccessPeriod() {

    }

    public void addStudent(Student student) {
        String email = student.getStudentEmail();
        StudentList.put(email,student);
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

        Course course = new Course(courseName,courseCode,courseSchool,AcademicUnits);
        CourseList.put(course.getCourseCode(),course);
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
                    courseIndex.addLecture(LecVenue,LecStart,LecEnd,LecDay);


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
                    courseIndex.addLecture(LecVenue,LecStart,LecEnd,LecDay);
                    System.out.println("Enter Tutorial Venue:");
                    String TutVenue = sc.next();
                    System.out.println("Enter Tutorial StartTime (HHMM):");
                    String TutStart = sc.next();
                    System.out.println("Enter Tutorial EndTime (HHMM):");
                    String TutEnd = sc.next();
                    System.out.println("Enter Tutorial WeekDay:");
                    String TutDay = sc.next();
                    courseIndex.addTutorial(TutVenue,TutStart,TutEnd,TutDay);

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
                    courseIndex.addLecture(LecVenue,LecStart,LecEnd,LecDay);
                    System.out.println("Enter Tutorial Venue:");
                     TutVenue = sc.next();
                    System.out.println("Enter Tutorial StartTime (HHMM):");
                     TutStart = sc.next();
                    System.out.println("Enter Tutorial EndTime (HHMM):");
                     TutEnd = sc.next();
                    System.out.println("Enter Tutorial WeekDay:");
                     TutDay = sc.next();
                    courseIndex.addTutorial(TutVenue,TutStart,TutEnd,TutDay);
                    System.out.println("Enter Lab Venue:");
                    String LabVenue = sc.next();
                    System.out.println("Enter Lab StartTime (HHMM):");
                    String LabStart = sc.next();
                    System.out.println("Enter Lab EndTime (HHMM):");
                    String LabEnd = sc.next();
                    System.out.println("Enter Lab WeekDay:");
                    String LabDay = sc.next();
                    courseIndex.addLaboratory(LabVenue,LabStart,LabEnd,LabDay);

                    break;
                default:
                    System.out.println("Invalid! Please choose again!");
            }

        }
    }


    public void updateCourses() {

    }
    public int checkVacancies(String courseCode, String courseIndex) {
        // fuck this
        return CourseList.get(courseCode).getCourseIndexByIndexName(courseIndex).getNumberOfVacancies();
    }

    public void printStudentListByIndex(String courseCode, String courseIndex){
        CourseList.get(courseCode).getCourseIndexByIndexName(courseIndex).printRegisteredStudent();
    }



    public void printStudentListByCourse(String courseCode) {
        CourseList.get(courseCode).printAllStudentsInIndexes();
    }


}
