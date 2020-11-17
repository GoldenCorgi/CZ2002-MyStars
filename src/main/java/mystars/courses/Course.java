package mystars.courses;

import java.io.Serializable;
import java.util.ArrayList;


public class Course implements Serializable {
    private String courseName, courseCode, school;
    private int academicUnit;
    private ArrayList<CourseIndex> courseIndex = new ArrayList<CourseIndex>();

    /**
     * Contructor to create Course object based on parameters given. Creates courses with only lectures
     *
     * @param courseName      The name of the course.
     * @param courseCode      The code number of the course.
     * @param courseVacancies The number of vacancies for a course.
     */

    public Course(String courseName, String courseCode, String school, int academicUnit) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.school = school;
        this.academicUnit = academicUnit;
    }



    public void addCourseIndex(CourseIndex index) {
        courseIndex.add(index);
    }
    /* get courseName */
    public String getCourseName() {
        return this.courseName;
    }

    /* get courseName */
    public String getCourseCode() {
        return this.courseCode;
    }

}
