package mystars.courses;

import java.io.Serializable;
import java.util.List;
import java.util.Arrays;
import mystars.Student;

public class Index implements Serializable {
    private static final long serialVersionUID = -2445920414804040966L;
    private int numberOfSlots;
    private int numberOfVacancies;
    private List<Student> addedStudents = null;

    public Index(int numberOfSlots) {
        this.numberOfSlots = numberOfSlots;
        this.numberOfVacancies = numberOfSlots;
        this.addedStudents = Arrays.asList(new Student[numberOfSlots]);
    }

    public boolean isFull() {
        return this.numberOfVacancies == 0;
    }

    public int getNumberOfVacancies() {
        return this.numberOfVacancies;
    }

    public int getNumberOfSlots() {
        return this.numberOfSlots;
    }

    public List<Student> getAddedStudents() {
        return this.addedStudents;
    }
}
