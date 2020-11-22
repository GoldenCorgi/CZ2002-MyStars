package mystars;

import mystars.login.Login;
import mystars.login.UserList;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

class StudentAppTest {

    @Test
    void addCourse() {
        StudentApp f = new StudentApp("student");
        f.addCourse("CZ2001","10027");
        f.dropCourse("CZ2001");
        f.printCourse();
        f.checkVacancies("CZ2001","10027");
        f.verifyCourseCode("CZ2001");
        f.verifyCourseIndex("CZ2001","10027");
        f.verifyStudentHasCourseIndex("10027");
        f.verifyStudentHasCourseCode("CZ2001");
        String inputs = "8\n3" +
                "\n1\nCZ2001\n10027" +
                "\n2\nCZ2001" +
                "\n3" +
                "\n4\nCZ2001\n10027" +
                "\n1\nCZ2001\n10027" +
                "\n5\nCZ2001\n10027" +
                "\n5\nCZ2001\n10028" +
                "\n2\nCZ2001" +
                "\n7";
        f.runLoop(new Login(new UserList()),new Scanner(inputs));

    }
    @Test
    void Case1Loop() {
        StudentApp f = new StudentApp("student");
        String inputs = "" +
                "\n1\nNonExistingCourseCode" +
                "\n1\nCZ2001\nNonExistingIndex" +
                "\n1\nCZ2001\n10027" +
                "\n1\nCZ2001\n10027" +
                "\n1\nCZ2002\n30440" +
                "\n2\nCZ2001" +
                "" +
                "" +
                "" +
                "\n7";
        f.runLoop(new Login(new UserList()),new Scanner(inputs));
    }
    @Test
    void Case6Loop() {
        StudentApp f = new StudentApp("student");
        String inputs = "" +
                "\n1\nCZ2001\n10027" +
                "\n7";
        f.runLoop(new Login(new UserList()),new Scanner(inputs));
        StudentApp f2 = new StudentApp("timh0011");
        String inputs2 = "" +
                "\n1\nCZ2001\n10028" +
                "\n6\nstudent\n1234" +
                "\nCZ2001" +
                "\n6\nstudent\n1234" +
                "\nCZ2001" +
                "\n6\nstudent\n1234" +
                "\nCZ2003" +
                "\n7";
        f2.runLoop(new Login(Storage.loadUsers()),new Scanner(inputs2));

    }

    @Test
    void dropCourse() {
    }

    @Test
    void printCourse() {
    }

    @Test
    void checkVacancies() {
    }

    @Test
    void verifyCourseCode() {
    }

    @Test
    void verifyCourseIndex() {
    }

    @Test
    void verifyExistingCourse() {
    }
}