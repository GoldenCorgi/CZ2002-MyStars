package mystars.courses;

public abstract class CourseComponent {
    int timing, courseCode, indexNo;
    String venue;

    public int getTiming(){
        return timing;
    };
    public String getVenue(){
        return venue;
    };
    public int getCourseCode(){
        return courseCode;
    };
    public int getIndexNo(){
        return indexNo;
    };
}
