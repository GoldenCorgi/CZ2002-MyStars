package mystars.courses;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class Course implements Serializable {
    private static final long serialVersionUID = 420;
    // TODO change possibility to edit courses info

    private final String courseName;
    private final String courseCode;
    private final String courseSchool;
    private final int academicUnit;
    private final HashMap<String, CourseIndex> courseIndex = new HashMap<>();

    /**
     * Constructor to create Course object based on parameters given.
     * Creates courses with lectures, tutorial and/or labs.
     *
     * @param courseName   The name of the course.
     * @param courseCode   The code number of the course.
     * @param courseSchool The school offering the course.
     * @param academicUnit The number of vacancies for a course.
     */
    public Course(String courseName, String courseCode, String courseSchool, int academicUnit) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseSchool = courseSchool;
        this.academicUnit = academicUnit;
    }

    /**
     * Function to add course index.
     *
     * @param index The index of the course.
     */

    public void addCourseIndex(CourseIndex index) {
        courseIndex.put(index.getIndexName(), index);
    }

    /**
     * Function to get courseName.
     */
//    public String getCourseName() {
//        return this.courseName;
//    }
//    public String getCourseSchool() {
//        return this.courseSchool;
//    }


    public int getCourseAcademicUnit() {
        return this.academicUnit;
    }


    /**
     * Function to get courseName.
     */

    public CourseIndex getCourseIndexByIndexName(String courseIndexName) {
        return this.courseIndex.get(courseIndexName);
    }

    /* get courseName */
    public String getCourseCode() {
        return this.courseCode;
    }

    public void printAllStudentsInIndexes() {
        // https://stackoverflow.com/questions/1066589/iterate-through-a-hashmap
        for (Map.Entry<String, CourseIndex> entry : this.courseIndex.entrySet()) {
            String CourseIndexName = entry.getKey();
            System.out.println("Printing students for Course Index: " + CourseIndexName);
            entry.getValue().printRegisteredStudent();
            System.out.println(" ");
        }
    }

    public void refreshCourseWaitList() {
        // https://stackoverflow.com/questions/1066589/iterate-through-a-hashmap
        for (Map.Entry<String, CourseIndex> entry : this.courseIndex.entrySet()) {
            CourseIndex CourseIndexName = entry.getValue();
            CourseIndexName.refreshWaitList();
        }
    }

}
