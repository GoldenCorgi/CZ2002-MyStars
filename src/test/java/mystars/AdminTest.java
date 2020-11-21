package mystars;

import mystars.login.Login;
import mystars.login.UserList;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

class AdminTest {

    @Test
    void verifyGender() {
        Admin ad = new Admin("test");
        ad.checkStudentEmailExists("student");
        ad.addStudent( new Student("U1921001A", "Tim Ho", "timh0011", "Male", "Singaporean"));
        ad.checkVacancies("CZ2001","10027");
        ad.printStudentListByIndex("CZ2001","10027");
        ad.printStudentListByCourse("CZ2001");
        ad.addCourse(new Scanner("hey\nhey\nhey\n1\n60\n1\n1\n1\n1\n1\n1\n1\n1"));
        ad.updateCourses(new Scanner("hey\nhey\nhey\n1\n60\n1\n1\n1\n1\n1\n1\n1\n1"));
    }

    @Test
    void fullLoop() throws StarsException {
        Admin ad = new Admin("test");
        String inputs = "helpe\n8";
        ad.runLoop(new Login(new UserList(),new Storage("data")),new Scanner(inputs));
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