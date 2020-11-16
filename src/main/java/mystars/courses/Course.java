package mystars.courses;

import mystars.Student;

import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable{
    private static final long serialVersionUID = 20;
    private String courseName;
    private int courseCode;
    private ArrayList<CourseComponent> courseComponents = new ArrayList<CourseComponent>();

    /**
     * Contructor to create Course object based on parameters given. Creates courses with only lectures
     *
     * @param courseName        The name of the course.
     * @param courseCode The code number of the course.
     * @param courseVacancies The number of vacancies for a course.
     */

    public Course(String courseName, int courseCode, int courseVacancies) {
        this.courseName = courseName;
        this.courseCode = courseCode;

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

    public Course(String courseName, int courseCode, int courseVacancies, int numberOfIndexes, int slotsPerIndex, boolean isTutorialOnly) {
        this.courseName = courseName;
        this.courseCode = courseCode;

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

    public Course(String courseName, int courseCode, int courseVacancies, int numberOfIndexes, int slotsPerIndex) {
        this.courseName = courseName;
        this.courseCode = courseCode;

        CourseComponent lecture = new Lecture(courseVacancies);
        courseComponents.add(lecture);

        CourseComponent tutorial = new Tutorial(numberOfIndexes, slotsPerIndex);
        courseComponents.add(tutorial);

        CourseComponent laboratory = new Laboratory(numberOfIndexes, slotsPerIndex);
        courseComponents.add(laboratory);
    }

    /* get courseName */
    public String getCourseName() {
        return this.courseName;
    }

    /* get courseName */
    public int getCourseCode() {
        return this.courseCode;
    }

    /* get courseName */
    public ArrayList<CourseComponent> getCourseComponents() {
        return this.courseComponents;
    }
}
