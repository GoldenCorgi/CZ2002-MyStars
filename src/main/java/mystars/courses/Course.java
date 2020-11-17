package mystars.courses;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class Course implements Serializable {
    private String courseName, courseCode, school;
    private int academicUnit;
//    private ArrayList<CourseIndex> courseIndex = new ArrayList<CourseIndex>();
    private HashMap<String, CourseIndex> courseIndex = new HashMap<String, CourseIndex>();
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
        courseIndex.put(index.getIndexName(),index);
    }
    /* get courseName */
    public String getCourseName() {
        return this.courseName;
    }


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
            // ...
            System.out.println(" ");

        }

    }


}
