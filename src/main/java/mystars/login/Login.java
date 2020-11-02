package mystars.login;

import java.io.Console;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Login {
    private String username, password;
    private int user;
    Scanner sc = new Scanner(System.in);
    String[][] studentAcc = {{"andy", "super"}, {"sally", "cz2002"}};
    String[][] adminAcc = {{"betty", "star"}, {"sally", "oodp"}};

    public Login() {
        boolean validated = false;
        while (!validated) {
            Console console = System.console();

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");


            System.out.println(dtf.format(now));
            System.out.println("Select user type: ");
            System.out.println("1. Student      2. Admin");
            int user = sc.nextInt();
            UserList users = new UserList();

            System.out.println("Enter your username: ");
            String username = sc.next();
            if (users.isExistingUser(username)) {
                System.out.println("Welcome back {USERNAME}");
                System.out.println("Enter your password: ");
                String password = sc.next();
                validated = users.validatePassword(username, password)

            } else {
                System.out.println("You are registering as a new user {USERNAME}");
                System.out.println("Enter your password: ");
                String password = sc.next();
                users.addNewUser(username, password);
                System.out.println("You have registered as a new user!");
                validated = true;
            }
        }

        //char[] pw = console.readPassword("Enter password: ");

        //String password = new String(pw);

    }
}