package mystars.courses;

//import java.io.Serializable;

import mystars.Student;

import java.io.Serializable;
import java.util.List;

public class CourseIndex implements Serializable {
    private int totalVacancies;
    private String indexName;
    private List<Student> registeredStudents = null;
    private List<CourseComponent> courseComponents = null;

    public CourseIndex(String indexName, int totalVacancies) {
        this.totalVacancies = totalVacancies;
        this.indexName = indexName;

        //this.addedStudents = Arrays.asList(new Student[numberOfSlots]);
    }

    public void addLaboratory(String venue, String startTime, String endTime, String day) {
        courseComponents.add(new Laboratory(venue, startTime, endTime, day));
    }
    public void addTutorial(String venue, String startTime, String endTime, String day) {
        courseComponents.add(new Tutorial(venue, startTime, endTime, day));
    }
    public void addLecture(String venue, String startTime, String endTime, String day) {
        courseComponents.add(new Lecture(venue, startTime, endTime, day));
    }
    public void addStudent(Student student) {
        registeredStudents.add(student);
    }

    public int getNumberOfVacancies() {
        return (this.totalVacancies) - registeredStudents.size();
    }

    public boolean isFull() {
        return this.getNumberOfVacancies() == 0;
    }

    public List<Student> getAddedStudents() {
        return this.registeredStudents;
    }
}
