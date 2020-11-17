package mystars.courses;

import mystars.Student;

import java.io.Serializable;
import java.util.ArrayList;


public class Course {
    private String courseName, courseCode;
    private ArrayList<CourseComponent> courseComponents = new ArrayList<CourseComponent>();

    /**
     * Contructor to create Course object based on parameters given. Creates courses with only lectures
     *
     * @param courseName        The name of the course.
     * @param courseCode The code number of the course.
     * @param courseVacancies The number of vacancies for a course.
     */

    public Course(String courseName, String courseCode, int courseVacancies) {
        this.courseCode = courseCode;
        this.courseName = courseName;

        CourseComponent lecture = new Lecture(courseVacancies);
        courseComponents.add(lecture);
    }

    /**
     * Contructor to create Course object based on parameters given. Creates courses with only lectures and tutorials/laboratory
     *
     * @param courseName The name of the course.
     * @param courseCode The code number of the course.
     * @param courseVacancies The number of vacancies for a course.
     * @param numberOfIndexes The number of indexes for a course.
     * @param slotsPerIndex The number of slots for an index of a course.
     * @param isTutorialOnly Boolean: true if is tutorial.
     */

    public Course(String courseName, String courseCode, int courseVacancies, int numberOfIndexes, int slotsPerIndex, boolean isTutorialOnly) {
        this.courseCode = courseCode;
        this.courseName = courseName;

        CourseComponent lecture = new Lecture(courseVacancies);
        courseComponents.add(lecture);

        if (isTutorialOnly) {
            CourseComponent tutorial = new Tutorial(numberOfIndexes, slotsPerIndex);
            courseComponents.add(tutorial);
        }
        else {
            CourseComponent laboratory = new Laboratory(numberOfIndexes, slotsPerIndex);
            courseComponents.add(laboratory);
        }
    }

    /**
     * Contructor to create Course object based on parameters given. Creates courses with only lectures, tutorials and labs
     *
     * @param courseName        The name of the course.
     * @param courseCode The code number of the course.
     * @param courseVacancies The number of vacancies for a course.
     * @param numberOfIndexes The number of indexes for a course.
     * @param slotsPerIndex The number of slots for an index of a course.
     */

    public Course(String courseName, String courseCode, int courseVacancies, int numberOfIndexes, int slotsPerIndex) {
        this.courseCode = courseCode;
        this.courseName = courseName;

        CourseComponent lecture = new Lecture(courseVacancies);
        courseComponents.add(lecture);

        CourseComponent tutorial = new Tutorial(numberOfIndexes, slotsPerIndex);
        courseComponents.add(tutorial);

        CourseComponent laboratory = new Laboratory(numberOfIndexes, slotsPerIndex);
        courseComponents.add(laboratory);
    }

//    public void addCourse(String courseCode, String courseName){
//        this.courseCode =  courseCode;
//        this.courseName = courseName;
//    }

    /* get courseName */
    public String getCourseName() {
        return this.courseName;
    }

    /* get courseName */
    public String getCourseCode() {
        return this.courseCode;
    }

    /* get courseName */
    public ArrayList<CourseComponent> getCourseComponents() {
        return this.courseComponents;
    }
}
