package mystars;

import java.io.Serializable;
import java.util.Scanner;

public class Admin implements Serializable {
    private static final long serialVersionUID = 26;
    private String name;

    /**
     * The constructor for an admin.
     *
     * @param name The name of the admin.
     */

    public Admin(String name) {
        this.name = name;
    }

    public void addStudent(Scanner sc) {
        System.out.println("Enter Student's name:");
        String name = sc.next();
        System.out.println("Enter the ");
    }

    public void addCourses() {}

    public void updateCourses() {}

    public void checkSlots() {}

    public void studentListIndex() {}

    public void studentListCourses() {}

}
