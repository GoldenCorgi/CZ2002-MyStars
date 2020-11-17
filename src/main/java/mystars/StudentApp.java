package mystars;

import mystars.courses.Course;

import java.io.Serializable;
import java.util.HashMap;

import static mystars.Storage.loadCourses;
import static mystars.Storage.loadStudents;

public class StudentApp implements Serializable  {

    private static HashMap<String, Student> StudentList = new HashMap<>();
    private String StudentEmail;
    private Student student;
    private HashMap<String, Course> CourseList;

    public StudentApp(String StudentEmail) {
        StudentList = loadStudents();
        this.StudentEmail = StudentEmail;
        this.student = StudentList.get(StudentEmail);
        this.CourseList = loadCourses();

        // load list of students

    }

    public void addCourse(Student student) {
        String email = student.getStudentEmail();
        StudentList.put(email,student);
        Storage.saveStudents(StudentList);
    }

    public void addCourse(String courseCode, String courseIndex) {
        student.addCourse(courseCode,courseIndex);

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

//    + changeIndex(oldIndex, newIndex): void
//+ swapIndex(oldIndex, peerIndex, peerMatricNo, peerPassword): void
//+ checkVerification(): boolean
//+ updateCourseData(checkVerification :  boolean): void
//+ checkTimingClash(courseCode : String): boolean
}
