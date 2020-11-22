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