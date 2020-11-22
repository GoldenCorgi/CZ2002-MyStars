package mystars.courses;

public class Laboratory extends CourseComponent {
    private static final long serialVersionUID = 420;
    /**
     * Constructor to create Laboratory object based on parameters given.
     * Creates laboratory with venue, start time, end time and day.
     *
     * @param venue     The venue of the course component (Lecture, Tutorial and Laboratory)
     * @param startTime The start time of the course component (Lecture, Tutorial and Laboratory)
     * @param endTime   The end time of the course component (Lecture, Tutorial and Laboratory)
     * @param day       The day of the course component (Lecture, Tutorial and Laboratory)
     */

    public Laboratory(String venue, String startTime, String endTime, String day) {
        super(venue, startTime, endTime, day, "Laboratory");
    }
}
