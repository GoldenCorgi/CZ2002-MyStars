package mystars;

import mystars.login.Login;
import mystars.login.UserList;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

class AdminTest {

    @Test
    void CheckEveryFunction() {
        Admin ad = new Admin("test");
        ad.checkStudentEmailExists("student");
        ad.addStudent( new Student("U1921001A", "Tim Ho", "timh0011", "Male", "Singaporean"));
        ad.checkVacancies("CZ2001","10027");
        ad.printStudentListByIndex("CZ2001","10027");
        ad.printStudentListByCourse("CZ2001");
        ad.addCourse(new Scanner("Algos?\nCZ4098\nSCSE\n1\n60" +
                "\n3" + // Type of coursecomponent (lecture/tut/lab)
                "\n1" + // number of indexes
                "\nIndexName" +
                "\nVenue\n1000\n1100\nMon" +
                "\nVenue\n1000\n1100\nMon" +
                "\nVenue\n1000\n1100\nMon" ));
        ad.updateCourses(new Scanner("Algos?\nCZ4098\nSCSE\n1\n60" +
                "\n3" + // Type of coursecomponent (lecture/tut/lab)
                "\n1" + // number of indexes
                "\nIndexName" +
                "\nVenue\n1000\n1100\nMon" +
                "\nVenue\n1000\n1100\nMon" +
                "\nVenue\n1000\n1100\nMon" ));
    }

    @Test
    void CheckIfExitNumberIsStill10() throws StarsException {
        Admin ad = new Admin("test");
        String inputs = "helpe\n10";
        ad.runLoop(new Login(new UserList()),new Scanner(inputs));
    }

    @Test
    void case6heckVacanciesIndex() throws StarsException {
        Admin ad = new Admin("test");
        String inputs = "6\nCZ2001\n10027\n10";
        ad.runLoop(new Login(new UserList()),new Scanner(inputs));
    }

    @Test
    void case7PrintStudentListByIndexNumber() throws StarsException {
        Admin ad = new Admin("test");
        String inputs = "7\nCZ2001\n10027\n10";
        ad.runLoop(new Login(new UserList()),new Scanner(inputs));
    }
    @Test
    void case8PrintStudentListByCourse() throws StarsException {
        Admin ad = new Admin("test");
        String inputs = "8\nCZ2001\n10";
        ad.runLoop(new Login(new UserList()),new Scanner(inputs));
    }
    @Test
    void case9PrintEntireStudentList() throws StarsException {
        Admin ad = new Admin("test");
        String inputs = "9\n10";
        ad.runLoop(new Login(new UserList()),new Scanner(inputs));
    }

    @Test
    void editStudentAccessPeriod() {
    }

    @Test
    void addStudent() {
    }

    @Test
    void addCourse() {
    }

    @Test
    void updateCourses() {
    }

    @Test
    void checkVacancies() {
    }

    @Test
    void printStudentListByIndex() {
    }

    @Test
    void printStudentListByCourse() {
    }
}