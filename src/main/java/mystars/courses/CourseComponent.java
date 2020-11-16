package mystars.courses;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import mystars.Student;

public abstract class CourseComponent implements Serializable {
    private String component;
    private int numberOfIndexes;
    List<Index> listOfIndexes = null;

    public CourseComponent(String component, int numOfIndexes){
        this.component = component;
        this.numberOfIndexes = numOfIndexes;
        this.listOfIndexes = Arrays.asList(new Index [numOfIndexes]);
    }

    public abstract boolean addStudent(Student s);

    public abstract boolean hasVacancy();

    public abstract void checkRegistered();

    public String getComponent() {
        return this.component;
    }

    public int getNumberOfIndexes() {
        return this.numberOfIndexes;
    }

    public List<Index> getListIndex() {
        return this.listOfIndexes;
    }



}
