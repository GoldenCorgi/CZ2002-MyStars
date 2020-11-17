package mystars.login;

import mystars.StarsException;
import mystars.Storage;

import java.io.Console;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Login {
    UserList users;
    Storage storage;

    public Login(UserList users, Storage storage) {
        this.users = users;
        this.storage = storage;
    }

    public String inputPassword(Scanner sc) {
        Console console = System.console();
        if (console == null) {
            System.out.println("Couldn't get Console instance - Do not run in an IDE");
            System.out.println("Enter your not so secret password: ");
            return sc.next();
        }
        char[] passwordArray = console.readPassword("Enter your secret password: ");
        return new String(passwordArray);
    }

    private String inputRole(Scanner sc) {
        System.out.println("Select user type: ");
        System.out.println("1. Student      2. Admin");
        int role;
        String rolename;
        try {
            role = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Incorrect input - Please enter a numeric number");
            return "";
        }
        if (role == 1) {
            rolename = "Student";
        } else if (role == 2) {
            rolename = "Admin";
        } else {
            System.out.println("Incorrect input - Please only enter 1 or 2");
            return "";
        }
        return rolename;
    }

    private String inputUsername(Scanner sc) {

        System.out.println("Enter your username: ");
        return sc.next();
    }


    public void addNewStudentWithPassword(Scanner sc, String username) throws StarsException {
        String password;
        Console console = System.console();
            if (console == null) {
                System.out.println("Couldn't get Console instance - Do not run in an IDE");
                System.out.println("Enter your not so secret password: ");
                password = sc.next();
            }
            else {
            char[] passwordArray = console.readPassword("Enter your secret password: ");
                password =  new String(passwordArray);
        }

        users.addNewUser(username, password, "student");
        storage.saveUsers(users);
    }


    public User run() throws StarsException {
        Scanner sc = new Scanner(System.in);
        String rolename = "", username = null;
        boolean validated = false;
        do {

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");


//            System.out.println(dtf.format(now)); // removing this line until i figure out how to adapt datetime into my testing framework
            rolename = inputRole(sc);
            if (rolename.equals("")) {
                continue;
            }
            username = inputUsername(sc);
            int matched = users.ValidateUser(username, rolename);

            if (matched == 2) {
                System.out.println("Welcome back - " + username);
                String password = inputPassword(sc);
                validated = users.validatePassword(username, password);
                if (!validated) {
                    System.out.println("Incorrect Password! Please retry your login.\t");
                }

            } else if (matched == 0) {
                System.out.println("You are registering as a new user - " + username);
                String password = inputPassword(sc);
                users.addNewUser(username, password, rolename);
                System.out.println("You have registered as a new user!");
                validated = true;
            } else {
                System.out.println("User - " + username + " - is not allowed to log in as a " + rolename);
            }
        } while (!validated);
        storage.saveUsers(users);
        sc.close();
        return users.getExistingUser(username);
        //char[] pw = console.readPassword("Enter password: ");

        //String password = new String(pw);

    }
}