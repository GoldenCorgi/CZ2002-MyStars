package mystars.courses;

//import java.io.Serializable;

import mystars.Student;

import java.io.Serializable;
import java.util.List;

public class CourseIndex implements Serializable {
    private static final long serialVersionUID = 42L;

    private int totalVacancies;
    private String indexName;
    private List<Student> registeredStudents = null;
    private List<CourseComponent> courseComponents = null;

    public CourseIndex(String indexName, int totalVacancies) {
        this.totalVacancies = totalVacancies;
        this.indexName = indexName;

        //this.addedStudents = Arrays.asList(new Student[numberOfSlots]);
    }

    /**
     * Constructor to create course index object using the parameters given.
     *
     * @param indexName      The name of the index of the course.
     * @param totalVacancies The total vacancies in the index of the course.
     */

    public String getIndexName() {
        return indexName;
    }

    /**
     * Function to add laboratory to course index.
     *
     * @param venue     The venue of the laboratory.
     * @param startTime The start time of the laboratory.
     * @param endTime   The end time of the laboratory.
     * @param day       The day of the laboratory.
     */
    public void addLaboratory(String venue, String startTime, String endTime, String day) {
        courseComponents.add(new Laboratory(venue, startTime, endTime, day));
    }

    /**
     * Function to add tutorial to course index.
     *
     * @param venue     The venue of the tutorial.
     * @param startTime The start time of the tutorial.
     * @param endTime   The end time of the tutorial.
     * @param day       The day of the tutorial.
     */
    public void addTutorial(String venue, String startTime, String endTime, String day) {
        courseComponents.add(new Tutorial(venue, startTime, endTime, day));
    }

    /**
     * Function to add lecture to course index.
     *
     * @param venue     The venue of the lecture.
     * @param startTime The start time of the lecture.
     * @param endTime   The end time of the lecture.
     * @param day       The day of the lecture.
     */
    public void addLecture(String venue, String startTime, String endTime, String day) {
        courseComponents.add(new Lecture(venue, startTime, endTime, day));
    }

    /**
     * Function to add student into course index.
     *
     * @param student
     */
    public void addStudent(Student student) {
        registeredStudents.add(student);
    }

    /**
     * Function to get number of vacancies of index.
     */
    public int getNumberOfVacancies() {
        return (this.totalVacancies) - registeredStudents.size();
    }

    /**
     * Function to check if course index is full. Returns a boolean value.
     */
    public boolean isFull() {
        return this.getNumberOfVacancies() == 0;
    }

    /**
     * Function to get added students in a list.
     */
    public List<Student> getAddedStudents() {
        return this.registeredStudents;
    }

    public void printRegisteredStudent() {
        for (int i = 0; i < this.registeredStudents.size(); i++) {
            System.out.println(Integer.toString(i + 1) + ": " + this.registeredStudents.get(i).getStudentName());
        }


    }
}
