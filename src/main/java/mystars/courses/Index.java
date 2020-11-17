package mystars.courses;

//import java.io.Serializable;

import mystars.Student;

import java.io.Serializable;
import java.util.List;

public class Index implements Serializable {
    private int numberOfSlots;
    private int numberOfVacancies;
    private String indexName;
    private List<Student> addedStudents = null;

    public Index(int numberOfSlots) {
        this.numberOfSlots = numberOfSlots;
        //this.addedStudents = Arrays.asList(new Student[numberOfSlots]);
    }

    public boolean isFull() {
        return this.numberOfVacancies == 0;
    }

    public int getNumberOfVacancies() {
        return (this.numberOfVacancies) - addedStudents.size();
    }

    public int getNumberOfSlots() {
        return this.numberOfSlots;
    }

    public void addIndexName(String indexName) {
        this.indexName = indexName;
    }

    public List<Student> getAddedStudents() {
        return this.addedStudents;
    }
}
