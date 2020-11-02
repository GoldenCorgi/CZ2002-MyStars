package mystars.login;

import mystars.StarsException;
import mystars.Storage;

import java.io.Console;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Login {
    Scanner sc = new Scanner(System.in);
    UserList users;
    Storage storage;
    public Login(UserList users, Storage storage) {
        this.users = users;
        this.storage = storage;
    }
    public String run() throws StarsException {
        int role;
        String rolename = "";
        boolean validated = false;
        while (!validated) {
            Console console = System.console();

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");


//            System.out.println(dtf.format(now)); // removing this line until i figure out how to adapt datetime into my testing framework
            System.out.println("Select user type: ");
            // TODO add error handling for not 1/2
            System.out.println("1. Student      2. Admin");
            role = sc.nextInt();
            if (role == 1){rolename="Student";}
            if (role == 2){rolename="Admin";}
            // TODO add role
//            UserList users = new UserList();

            System.out.println("Enter your username: ");
            String username = sc.next();
            if (users.isExistingUser(username)) {
                System.out.println("Welcome back {USERNAME}");
                System.out.println("Enter your password: ");
                String password = sc.next();
                validated = users.validatePassword(username, password);
                if (!validated) {System.out.println("Incorrect Password! Please retry your login.\t");}

            } else {
                System.out.println("You are registering as a new user {USERNAME}");
                System.out.println("Enter your password: ");
                String password = sc.next();
                users.addNewUser(username, password);
                System.out.println("You have registered as a new user!");
                validated = true;
            }
        }
        storage.saveUsers(users);
        return rolename;
        //char[] pw = console.readPassword("Enter password: ");

        //String password = new String(pw);

    }
}