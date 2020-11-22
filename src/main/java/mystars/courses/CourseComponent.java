package mystars.courses;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CourseComponent implements Serializable {
    private static final long serialVersionUID = 421;
    private final String componentName;
    private final String venue;
    private final String startTime;
    private final String endTime;
    private final String day;

    /**
     * Constructor to create Course Component object based on parameters given.
     * Creates course component with venue, start time, end time and day.
     *
     * @param venue         The venue of the course component (Lecture, Tutorial and Laboratory)
     * @param startTime     The start time of the course component (Lecture, Tutorial and Laboratory)
     * @param endTime       The end time of the course component (Lecture, Tutorial and Laboratory)
     * @param day           The day of the course component (Lecture, Tutorial and Laboratory)
     * @param componentName The name of the component (Lecture, Tutorial and Laboratory)
     */

    public CourseComponent(String venue, String startTime, String endTime, String day, String componentName) {
        this.venue = venue;
        this.startTime = startTime;
        this.endTime = endTime;
        this.day = day;
        this.componentName = componentName;

    }

    public LocalTime getStartTime() {

        // create an LocalTime object and
        LocalTime lt = LocalTime.parse(startTime, DateTimeFormatter.ofPattern("HHmm"));

        // print result
        System.out.println("LocalTime : "
                + lt);
        return lt;
    }
    /**
     * Function to get name of component.
     */
    public String getName() {
        return this.componentName;
    }
}
