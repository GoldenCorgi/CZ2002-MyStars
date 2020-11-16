package mystars.courses;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import mystars.Student;

public abstract class CourseComponent implements Serializable {
    private String component;
    private int numOfIndex;
    List<Index> listIndex = null;

    public CourseComponent(String component, int numOfGroups){
        this.component = component;
        this.numOfIndex = numOfGroups;
        this.listIndex = Arrays.asList(new Index [numOfGroups]);
    }

    public abstract boolean addStudent(Student stud);

    public abstract boolean hasVacancy();

    public abstract void checkRegistered();

    public String getComponent() {
        return this.component;
    }

    public int getNumOfIndex() {
        return this.numOfIndex;
    }

    public List<Index> getListIndex() {
        return this.listIndex;
    }



}
