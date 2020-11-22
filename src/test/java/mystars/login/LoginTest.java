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

    }
}