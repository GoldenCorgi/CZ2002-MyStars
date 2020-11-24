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
        ad.updateCourses(new Scanner("CZ4098\nAlgos?\nSCSE\n1\n60" +
                "\n3" + // Type of coursecomponent (lecture/tut/lab)
                "\n1" + // number of indexes
                "\nIndexName" +
                "\nVenue\n1000\n1100\nMon" +
                "\nVenue\n1000\n1100\nMon" +
                "\nVenue\n1000\n1100\nMon" ));
    }

    @Test
    void case2AddStudent() throws StarsException {
        Admin ad = new Admin("test");
        String inputs = "2"+
                "\nstudentEmail\nHeyNoNumbersInName\nU1900000F\nMale\nsingaporean" +
                "\n2" +
                "\nstudentEmail1\nHeyNoNumbersInName\nU1900001F\nMale\nwrongNationality" +
                "\n2" +
                "\nstudentEmail2\nHeyNoNumbersInName\nU1900002F\nWrongGender" +
                "\n2" +
                "\nstudentEmail3\nHeyNoNumbersInName\nU1900000F" +
                "\n2" +
                "\nstudentEmail4\nHeyNoNumbersInName\nU19z" +
                "\n2" +
                "\nstudentEmail5\nHeyNumbersInName2" +
                "\n2" +
                "\nstudentEmail" +
                "\n11"
                ;
        ad.runLoop(new Login(new UserList()),new Scanner(inputs));
    }
    @Test
    void case3AddStudent() throws StarsException {
        Admin ad = new Admin("test");
        String inputs = "2"+
                "\nstudentEmail\nHeyNoNumbersInName\nU1900000F\nMale\nsingaporean" +
                "\n2" +
                "\nstudentEmail\nHeyNoNumbersInName\nU1900001F\nMale\nwrongNationality" +
                "\n2" +
                "\nstudentEmail\nHeyNoNumbersInName\nU1900002F\nWrongGender" +
                "\n2" +
                "\nstudentEmail\nHeyNoNumbersInName\nU1900000F" +
                "\n2" +
                "\nstudentEmail\nHeyNoNumbersInName\nU19z" +
                "\n2" +
                "\nstudentEmail\nHeyNumbersInName2" +
                "\n11"
                ;
        ad.runLoop(new Login(new UserList()),new Scanner(inputs));
    }

    @Test
    void case1EditStudentAccessPeriod() throws StarsException {
        Admin ad = new Admin("test");
        String inputs = "1"+
                "\n06-01-2019 02:02:02\n06-01-2019 01:02:02" +
                "\n1\n06-01-2019 02:02:02\n06-01-2021 03:02:02" +
                "\n11"
                ;
        ad.runLoop(new Login(new UserList()),new Scanner(inputs));
    }

    @Test
    void case45addupdateCourse() throws StarsException {
        Admin ad = new Admin("test");
        String inputs = "4"+
                "\nAlgos?\nCZ4098\nSCSE\n1\n60" +
                "\n3" + // Type of coursecomponent (lecture/tut/lab)
                "\n1" + // number of indexes
                "\nIndexName" +
                "\nVenue\n1000\n1100\nMon" +
                "\nVenue\n1000\n1100\nMon" +
                "\nVenue\n1000\n1100\nMon" +
                "\n5" +
                "\nCZ4098\nAlgos?\nSCSE\n1\n60" +
                "\n3" + // Type of coursecomponent (lecture/tut/lab)
                "\n1" + // number of indexes
                "\nIndexName" +
                "\nVenue\n1000\n1100\nMon" +
                "\nVenue\n1000\n1100\nMon" +
                "\nVenue\n1000\n1100\nMon"+
                "\n5" +
                "\nCZ4098\nAlgos?\nSCSE\n1\n60" +
                "\n2" + // Type of coursecomponent (lecture/tut/lab)
                "\n1" + // number of indexes
                "\nIndexName" +
                "\nVenue\n1000\n1100\nMon" +
                "\nVenue\n1000\n1100\nMon" +
                "\n5" +
                "\nCZ4098\nAlgos?\nSCSE\n1\n60" +
                "\n1" + // Type of coursecomponent (lecture/tut/lab)
                "\nIndexName" +
                "\nVenue\n1000\n1100\nMon"+
                "\n4" +
                "\nAlgos?\nCZ4097\nSCSE\n1\n60" +
                "\n2" + // Type of coursecomponent (lecture/tut/lab)
                "\n1" + // number of indexes
                "\nIndexName" +
                "\nVenue\n1000\n1100\nMon" +
                "\nVenue\n1000\n1100\nMon" +
                "\n4" +
                "\nAlgos?\nCZ4096\nSCSE\n1\n60" +
                "\n1" + // Type of coursecomponent (lecture/tut/lab)
                "\nIndexName" +
                "\nVenue\n1000\n1100\nMon" +
                "\n11"
                ;
        ad.runLoop(new Login(new UserList()),new Scanner(inputs));
    }



    @Test
    void CheckIfExitNumberIsStill11() throws StarsException {
        Admin ad = new Admin("test");
        String inputs = "helpe\n11";
        ad.runLoop(new Login(new UserList()),new Scanner(inputs));
    }

    @Test
    void case6heckVacanciesIndex() throws StarsException {
        Admin ad = new Admin("test");
        String inputs = "6\nCZ2001\n10027\n11";
        ad.runLoop(new Login(new UserList()),new Scanner(inputs));
    }

    @Test
    void case7PrintStudentListByIndexNumber() throws StarsException {
        Admin ad = new Admin("test");
        String inputs = "7\nCZ2001\n10027\n11";
        ad.runLoop(new Login(new UserList()),new Scanner(inputs));
    }
    @Test
    void case8PrintStudentListByCourse() throws StarsException {
        Admin ad = new Admin("test");
        String inputs = "8\nCZ2001\n11";
        ad.runLoop(new Login(new UserList()),new Scanner(inputs));
    }
    @Test
    void case9PrintEntireStudentList() throws StarsException {
        Admin ad = new Admin("test");
        String inputs = "9\n11";
        ad.runLoop(new Login(new UserList()),new Scanner(inputs));
    }
    @Test
    void case10PrintEntireCourseList() throws StarsException {
        Admin ad = new Admin("test");
        String inputs = "10\n11";
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