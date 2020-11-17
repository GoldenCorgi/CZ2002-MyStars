package mystars.courses;

import java.io.Serializable;

public abstract class CourseComponent implements Serializable  {
    private String componentName, venue, startTime, endTime, day;

    public CourseComponent(String venue, String startTime, String endTime, String day, String componentName) {
        this.venue = venue;
        this.startTime = startTime;
        this.endTime = endTime;
        this.day = day;
        this.componentName = componentName;

    }

    public String getName() {
        return this.componentName;
    }
}
