package mystars.courses;

import java.io.Serializable;
import java.util.ArrayList;


public class Course implements Serializable {
    private String courseName, courseCode, school;
    private int academicUnit;
    private ArrayList<CourseIndex> courseIndex = new ArrayList<CourseIndex>();

    /**
     * Contructor to create Course object based on parameters given.
     * Creates courses with lectures, tutorial and/or labs.
     *
     * @param courseName The name of the course.
     * @param courseCode The code number of the course.
     * @param school The school offering the course.
     * @param academicUnit The number of vacancies for a course.
     */

    public Course(String courseName, String courseCode, String school, int academicUnit) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.school = school;
        this.academicUnit = academicUnit;
    }

    /**
     * Function to add course index.
     *
     * @param index The index of the course.
     */

    public void addCourseIndex(CourseIndex index) {
        courseIndex.add(index);
    }

    /**
     * Function to get courseName.
     */
    public String getCourseName() {
        return this.courseName;
    }

    /**
     * Function to get courseName.
     */
    public String getCourseCode() {
        return this.courseCode;
    }

}
