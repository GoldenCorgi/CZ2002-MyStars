package mystars.login;

import mystars.StarsException;
import mystars.Storage;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

class LoginTest {

    @Test
    void run() throws StarsException {
        Login ad = new Login(Storage.loadUsers());
        String inputs = "1\nstudent\n1234";
        ad.run(new Scanner(inputs));
        inputs = "2\nadmin\n1234";
        ad.run(new Scanner(inputs));
        inputs = "2\nstudent\n3";
        ad.run(new Scanner(inputs));
        inputs = "1\nadmin\n3";
        ad.run(new Scanner(inputs));
        inputs = "555\n1\nnewUser2\nNewPassword";
        ad.run(new Scanner(inputs));

    }


    @Test
    void runSwapStudent() {
        Login ad = new Login(Storage.loadUsers());
        ad.getSwappingStudent("admin","wrongRole");
        ad.getSwappingStudent("student","1234");
        ad.getSwappingStudent("student","wrongPassword");
        ad.getSwappingStudent("nonrealusername","1234");
    }

    @Test
    void runAddNewStudentWithPassword() throws StarsException {
        Login ad = new Login(Storage.loadUsers());
        String inputs = "4321";
        ad.addNewStudentWithPassword(new Scanner(inputs),"newUser");
    }
}