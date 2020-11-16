package mystars.courses;

//import java.io.Serializable;
import java.util.List;
import java.util.Arrays;
import mystars.Student;
import

public class Index {
    private int numberOfSlots;
    private int numberOfVacancies;
    private int indexName;
    private List<Student> addedStudents = null;

    public Index(int numberOfSlots) {
        this.numberOfSlots = numberOfSlots;
        this.addedStudents = Arrays.asList(new Student[numberOfSlots]);
    }

    public boolean isFull() {
        return this.numberOfVacancies == 0;
    }

    public int getNumberOfVacancies() {
        return (this.numberOfVacancies)-addedStudents.size();
    }

    public int getNumberOfSlots() {
        return this.numberOfSlots;
    }

    public List<Student> getAddedStudents() {
        return this.addedStudents;
    }
}
