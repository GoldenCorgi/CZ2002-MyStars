package mystars.courses;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public abstract class CourseComponent implements Serializable  {
    private String componentName;
    private int numberOfIndexes; // How many lectures/tutorials/labs groups for one course.
    List<Index> listOfIndex = null;

    public CourseComponent(String componentName, int numberOfIndexes) {
        this.componentName = componentName;
        this.numberOfIndexes = numberOfIndexes;
        this.listOfIndex = Arrays.asList(new Index[numberOfIndexes]);
    }

    public abstract boolean haveVacancies();

//    public abstract void printStudentList();

    public String getName() {
        return this.componentName;
    }


    public int getNumberOfIndexes() {
        return this.numberOfIndexes;
    }


    public List<Index> getListOfIndex() {
        return this.listOfIndex;
    }

//    int timing, courseCode, indexNo;
//    String venue;
//
//    public int getTiming(){
//        return timing;
//    };
//    public String getVenue(){
//        return venue;
//    };
//    public int getCourseCode(){
//        return courseCode;
//    };
//    public int getIndexNo(){
//        return indexNo;
//    };
}
