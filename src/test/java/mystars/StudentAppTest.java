package mystars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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