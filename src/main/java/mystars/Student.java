package mystars;

import java.io.Serializable;
import java.util.HashMap;

// in the main function, create another student class for the peer, to swap index for peer

// check if current index is not equal to newCourseIndex
// check if peerStudID and peerPassword is valid
// put oldCourseIndex to temp int, add newCourseIndex to studCourses
// put temp int to peerStudCourses


public class Student implements Serializable {
    private static final long serialVersionUID = 42L;
    // TODO change possibility to edit courses info
    private final String matricNo;
    private final String studentName;
    private final String studentEmail;
    private final String studentGender;
    private final String studentNationality;
    private final int numberOfCoursesRegistered = 0;
    private final int MaxAcademicUnit = 21;
    private final HashMap<String, String> studentCourses = new HashMap<>();

    /**
     * Constructor to create Student object based on parameters given.
     * Creates Student with matricNo, studentName, studentEmail, studentGender, studentNationality
     *
     * @param matricNo           The matriculation number of a student
     * @param studentName        The full student name of a student
     * @param studentEmail       The student school email of a student
     * @param studentGender      The gender of a student
     * @param studentNationality The nationality of a student
     */

    public Student(String matricNo, String studentName, String studentEmail, String studentGender, String studentNationality) {
        this.matricNo = matricNo;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentGender = studentGender;
        this.studentNationality = studentNationality;
    }

    /**
     * @return The full name of a student
     */

    public String getStudentName() {
        return this.studentName;
    }

    /**
     * @return The matriculation number of a student
     */

    public String getMatricNo() {
        return this.matricNo;
    }

    /**
     * @return The student school email of a student
     */

    public String getStudentEmail() {
        return this.studentEmail;
    }

    /**
     * @return The gender of a student
     */

    public String getStudentGender() {
        return this.studentGender;
    }

    /**
     * @return The nationality of a student
     */

    public String getStudentNationality() {
        return this.studentNationality;
    }

    /**
     * Checks if course code entered is already in list of registered student courses
     *
     * @param courseCode The course code entered by student
     * @return <code>true</code> if course code exists in student courses list; <code>false</code> otherwise.
     */
    public boolean hasCourseCode(String courseCode) {
        return (this.studentCourses.containsKey(courseCode));
    }

    public boolean hasCourseIndex(String courseIndex) {
        return (this.studentCourses.containsValue(courseIndex));
    }

    /**
     * Add a course, based on course code and course index entered, into list of registered student courses
     *
     * @param courseCode  The course code to be added entered by student
     * @param courseIndex The course index to be added entered by student
     */

    public void addCourse(String courseCode, String courseIndex) {
        this.studentCourses.put(courseCode, courseIndex);
    }

    /**
     * Drop a course from list of registered student courses
     *
     * @param courseCode The course code to be dropped entered by student
     */

    public void dropCourse(String courseCode) {
        this.studentCourses.remove(courseCode);
    }

    /**
     * @return hashmap of registered student consisting of coursecode : courseindex
     */

    public HashMap<String, String> getCourse() {
        return this.studentCourses;
    }

    /**
     * Get course index using course code
     *
     * @param CourseCode The course code entered by student
     * @return hashmap of registered student courses
     */

    public String getCourseIndex(String CourseCode) {
        return this.studentCourses.get(CourseCode);
    }

//    /**
//     * Print all registered student courses from studentCourses hashmap if hashmap is not empty
//     * Print "Student has no courses registered!" is not courses registered
//     * !! moved to StudentApp
//     */
//    public void printCourse() {
//        // https://stackoverflow.com/questions/1066589/iterate-through-a-hashmap
//        if (this.studentCourses.size() != 0) {
//            for (Map.Entry<String, String> entry : this.studentCourses.entrySet()) {
//                String CourseCode = entry.getKey();
//                String CourseIndex = entry.getValue();
//                System.out.println("  CourseCode: " + CourseCode + " || Course Index: " + CourseIndex);
//            }
//        } else {
//            System.out.println("Student has no courses registered!");
//        }
//    }


    /**
     * @return the number of courses registered for each student
     */

    public int getNumberOfCoursesRegistered() {
        return this.studentCourses.size();
    }
}
