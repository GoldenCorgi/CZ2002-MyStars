package mystars;

import mystars.login.Login;
import mystars.login.UserList;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {
    @Test
    public void sampleTest() {
        assertTrue(true);
    }
    @Test
    void caseRunLoop() throws StarsException {
        String inputs = "a" +
                "\n1\nstudent\nWrongPassword" +
                "\n2\nadmin\nWrongPassword" +
                "\n1\nstudent\n1234\n7" +
                "\n2\nadmin\n1234\n10" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "\n3";
        Main.runLoop(new Scanner(inputs));
    }

    @Test
    void MakeCourseOverflowWaitList() {
        Admin ad = new Admin("test");
        ad.addCourse(new Scanner("CourseName\nCZ4099\nSCSE\n1" +
                "\n1" + // Vacancies
                "\n3" + // Type of coursecomponent (lecture/tut/lab)
                "\n1" + // number of indexes
                "\n54345" +
                "\nVenue\n1000\n1100\nMon" +
                "\nVenue\n1000\n1100\nMon" +
                "\nVenue\n1000\n1100\nMon" ));

        StudentApp f = new StudentApp("student");
        String inputs = "" +
                "\n1\nCZ4099\n54345" +
                "\n7";
        f.runLoop(new Login(new UserList()),new Scanner(inputs));
        StudentApp f2 = new StudentApp("timh0011");
        String inputs2 = "" +
                "\n1\nCZ4099\n54345" +
                "\n2\nCZ4099" +
                "\n1\nCZ4099\n54345" +
                "\n7";
        f2.runLoop(new Login(Storage.loadUsers()),new Scanner(inputs2));
        inputs = "" +
                "\n2\nCZ4099" +
                "\n7";
        f.runLoop(new Login(new UserList()),new Scanner(inputs));


    }

}
