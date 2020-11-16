package mystars.courses;

import mystars.Student;

public class Lecture extends CourseComponent {
    private int courseCode;
    private int timing;
    private String venue;
    private int indexNo;


    public Lecture(int numberOfVacancies) {
        super("Lecture", 1);
        this.listOfIndexes.set(0, new Index(numberOfVacancies));
    }



    public Lecture(int courseCode, int indexNo, int timing, String venue){
        super(courseCode, indexNo, timing, venue);

    }

    void timing(int timing){
        this.timing = timing;
    };

    void courseCode(int courseCode){
        this.courseCode = courseCode;
    }

    void venue(String venue){
        this.venue = venue;
    }

    void indexNo(int indexNo){
        this.indexNo = indexNo;
    }

}