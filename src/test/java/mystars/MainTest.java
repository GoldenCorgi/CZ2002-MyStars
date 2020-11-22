package mystars;

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
                "\n2\nadmin\n1234\n9" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "\n3";
        Main.runLoop(new Scanner(inputs));
    }

}
