package mystars.courses;

import mystars.Student;

import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable{
    private static final long serialVersionUID = 20;
    private String courseName;
    private ArrayList<CourseComponent> courseComponent = new ArrayList<CourseComponent>();

    public Course(String courseName, int lectureVacancies) {
        this.courseName = courseName;

        CourseComponent lecture = new Lecture(lectureVacanies);
        courseComponent.add(lecture);
    }

    /**
     * Constructor to create Course object based on parameters given. Creates course
     * that has both lectures and tutorials.
     *
     * @param courseName             The name of the course.
     * @param lectureVacancies       The number of slots for a lecture group.
     * @param numberOfTutorialGroups The number of tutorial groups of the course.
     * @param slotsPerTutGroup       The number of slots for a tutorial group.
     */

    public Course(String courseName, int lectureVacancies, int numberOfTutorialGroups, int slotsPerTutGroup) {
        this(courseName, lectureVacancies);

        CourseComponent tutorial = new Tutorial(numberOfTutorialGroups, slotsPerTutGroup);
        courseComponent.add(tutorial);
    }

    /**
     * Constructor to create Course object based on parameters given. Creates course
     * that have lectures, tutorials and labs.
     *
     * @param courseName             The name of the course.
     * @param lectureVacancies       The number of slots for a lecture group.
     * @param numberOfTutorialGroups The number of tutorial groups of the course.
     * @param slotsPerTutGroup       The number of slots for a tutorial group.
     * @param numberOfLabGroups      The bumber of lab groups of the course.
     * @param slotsPerLabGroup       The number of slots for a lab group.
     */

    public Course(String courseName, int lectureVacancies, int numberOfTutorialGroups, int slotsPerTutGroup,
                  int numberOfLabGroups, int slotsPerLabGroup) {
        this(courseName, courseCoordinator, lectureVacancies, numberOfTutorialGroups, slotsPerTutGroup);

        CourseComponent lab = new Laboratory(numberOfLabGroups, slotsPerLabGroup);
        CourseComponent.add(lab);
    }

    /**
     * This method is used to register student for a course taht have only lectures.
     * By assumption, there is only one lecture group.
     *
     * @param s The student object.
     */

    public void registerStudent(Student s) {
        this.courseComponent.get(0).addStudent(s, 1);
    }

    /**
     * This method is used to register student for a course that have both lectures
     * and labs.
     *
     * @param s        The student object.
     * @param tutGroup The tutorial group of the course for which a student wants to
     *                 register.
     */

    public void registerStudent(Student s, int tutGroup) {
        this.addStudent(s);
        this.courseComponent.get(1).addStudent(s, tutGroup);
    }

    /**
     * This method is used to register student for a course that have lectures,
     * tutorials and labs.
     *
     * @param s        The student object.
     * @param tutGroup The tutorial group of the course for which a student wants to
     *                 register.
     * @param labGroup The lab group of the course for which a student wants to
     *                 register.
     */

    public void registerStudent(Student s, int tutGroup, int labGroup) {
        this.addedStudents(s, tutGroup);
        this.courseComponent.get(2).addStudent(s, labGroup);
    }

    public boolean haveVacancies() {
        boolean vacant = true;
        for (CourseComponent cc : this.courseComponent) {
            vacant &= cc.haveVacancies();
        }
        return vacant;
    }
}
