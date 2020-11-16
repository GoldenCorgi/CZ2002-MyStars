package mystars.courses;

import mystars.Student;

public class Lecture extends CourseComponent {
    private int courseCode;
    private int timing;
    private String venue;
    private int indexNo;
    private int numberOfVacancies;


    public Lecture(int numberOfVacancies) {
        super("Lecture", 1);
        this.listOfIndex.set(0, new Index(numberOfVacancies));
    }

    public int getNumberOfVacancies() {
        return numberOfVacancies;
    }

    public boolean haveVacancies(){
        if (numberOfVacancies==0)
            return false;
        else
            return true;
    };

//    void timing(int timing){
//        this.timing = timing;
//    };
//
//    void courseCode(int courseCode){
//        this.courseCode = courseCode;
//    }
//
//    void venue(String venue){
//        this.venue = venue;
//    }
//
//    void indexNo(int indexNo){
//        this.indexNo = indexNo;
//    }

}