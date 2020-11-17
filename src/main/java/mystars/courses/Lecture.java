package mystars.courses;

public class Lecture extends CourseComponent {
    /**
     * Constructor to create lecture object based on parameters given.
     * Creates lecture with venue, start time, end time and day.
     *
     * @param venue The venue of the course component (Lecture, Tutorial and Laboratory)
     * @param startTime The start time of the course component (Lecture, Tutorial and Laboratory)
     * @param endTime The end time of the course component (Lecture, Tutorial and Laboratory)
     * @param day The day of the course component (Lecture, Tutorial and Laboratory)
     */

    public Lecture(String venue, String startTime, String endTime, String day) {
        super(venue, startTime, endTime, day, "Lecture");
    }
}
