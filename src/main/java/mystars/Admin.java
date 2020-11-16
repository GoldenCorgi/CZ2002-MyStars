package mystars;

import java.io.Serializable;

public class Admin implements Serializable {
    private static final long serialVersionUID = 26;
    private String name;

    /**
     * The constructor for a professor.
     *
     * @param name The name of the professor.
     */

    public Admin(String name) {
        this.name = name;
    }

    public void addStudent() {}

    public void addCourses() {}

    public void updateCourses() {}

    public void checkSlots() {}

    public void studentListIndex() {}

    public void studentListCourses() {}

}
