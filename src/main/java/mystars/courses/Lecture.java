package mystars.courses;

public class Lecture extends CourseComponent {
    public Lecture(String venue, String startTime, String endTime, String day) {
        super(venue, startTime, endTime, day, "Lecture");
    }
}
