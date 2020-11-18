package mystars.courses;

import java.io.Serializable;

public class CourseComponent implements Serializable {
    private String componentName, venue, startTime, endTime, day;

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

    /**
     * Function to get name of component.
     */
    public String getName() {
        return this.componentName;
    }
}
