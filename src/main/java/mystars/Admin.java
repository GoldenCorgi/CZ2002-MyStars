package mystars;

import mystars.courses.Course;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;


public class Admin implements Serializable {

//    private static final long serialVersionUID = 26;
//    //    private String name;
//    private HashMap<String, Course> CoursesMap = new HashMap<>();
//    private HashMap<String, String> IndexMap = new HashMap<>();
//    Scanner sc = new Scanner(System.in);

    public Admin() {
    }


    public void editStudentAccessPeriod() {

    }

    public void addStudent() {

    }

    public void addCourses() {
        System.out.println("Enter Course Name:");
        String courseName = sc.next();
        System.out.println("Enter Course Code:");
        String courseCode = sc.next();
        System.out.println("Enter Course Vacancies:");
        int courseVacancies = sc.nextInt();
        System.out.println("Enter Number of Indexes:");
        int numberOfIndexes = sc.nextInt();
//        Index[] index = new Index[numberOfIndexes];
        for (int i = 0; i < numberOfIndexes; i++) {
            System.out.println("Enter Index Name:");
            String indexName = sc.next();
            IndexMap.put(courseCode, indexName);
        }
        System.out.println("Enter Number of Slots Per Index:");
        int slotsPerIndex = sc.nextInt();
        System.out.println("Enter Course Components:");
        int choice;
        System.out.println("1. Lecture     2. Lecture and Tutorial     3. Lecture and Lab    4. Lecture, Tutorial and Lab");
        choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("You have chosen choice 1 - unimplemented");

//                Course newCourse = new Course(courseName, courseCode, courseVacancies);
//                CoursesMap.put(courseCode, newCourse);
                break;
            case 2:
                System.out.println("You have chosen choice 2 - unimplemented");

//                newCourse = new Course(courseName, courseCode, courseVacancies, numberOfIndexes, slotsPerIndex, true);
//                CoursesMap.put(courseCode, newCourse);
                break;
            case 3:
                System.out.println("You have chosen choice 3 - unimplemented");

//                newCourse = new Course(courseName, courseCode, courseVacancies, numberOfIndexes, slotsPerIndex, false);
//                CoursesMap.put(courseCode, newCourse);
                break;
            case 4:
                System.out.println("You have chosen choice 4 - unimplemented");

//                newCourse = new Course(courseName, courseCode, courseVacancies, numberOfIndexes, slotsPerIndex);
//                CoursesMap.put(courseCode, newCourse);
                break;
            default:
                System.out.println("Invalid! Please choose again!");
        }
    }

    public void updateCourses() {

    }
    public int checkVacancies(String courseCode, String courseIndex) {
        return 1;
    }

    public void printStudentListByIndex(){

    }



    public void printStudentListByCourse() {

    }


}
