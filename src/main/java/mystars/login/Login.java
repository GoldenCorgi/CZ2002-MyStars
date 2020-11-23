package mystars.login;

import mystars.StarsException;
import mystars.Storage;

import java.io.Console;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Login {
    UserList users;

    /**
     * Constructor to create Login object based on parameters given.
     * Creates Login with UserList object users and Storage object storage
     *
     * @param users   The UserList object of a list of users
     */
    public Login(UserList users) {
        this.users = users;
    }

    /**
     * Get user input for password
     *
     * @param sc Scanner for input
     * @return password input by user as String
     */
    public String inputPassword(Scanner sc) {
        Console console = System.console();
        if (console == null) {
            System.out.println("Couldn't get Console instance - Do not run in an IDE");
            System.out.println("Enter your not so secret password: ");
            return sc.nextLine();
        }
        char[] passwordArray = console.readPassword("Enter your secret password: ");
        return new String(passwordArray);
    }

    /**
     * Get user input for role and check input must be 1, 2, 3
     *
     * @param sc Scanner for input
     * @return role input by user as String
     */
    private String inputRole(Scanner sc) {
        System.out.println("\nSelect user type: ");
        System.out.println("1. Student      2. Admin     3. End Program");
        String role;
        String roleName;
        try {
            role = sc.nextLine();
            // Remove non-integer inputs due to buggy java stuff lmao https://stackoverflow.com/questions/27717503/why-does-my-scanner-repeat


        } catch (InputMismatchException e) {
            System.out.println("Incorrect input - Please enter a numeric number");
            return "";
        }
        if (role.equals("1")) {
            roleName = "Student";
        } else if (role.equals("2")) {
            roleName = "Admin";
        } else if (role.equals("3")) {
            return null;
        } else {
            System.out.println("Incorrect input - Please only enter 1, 2 or 3");
            return "";
        }
        return roleName;
    }

    /**
     * Get user input for username
     *
     * @param sc Scanner for input
     * @return username input by user as String
     */
    private String inputUsername(Scanner sc) {

        System.out.println("Enter your username: ");
        return sc.nextLine();
    }

    /**
     * Add new student with password if the student does not exist
     *
     * @param sc Scanner for input
     * @param username Username input
     * @throws StarsException
     */
    public void addNewStudentWithPassword(Scanner sc, String username) throws StarsException {
        String password;
        Console console = System.console();
        if (console == null) {
            System.out.println("Couldn't get Console instance - Do not run in an IDE");
            System.out.println("Enter your not so secret password: ");
            password = sc.nextLine();
        } else {
            char[] passwordArray = console.readPassword("Enter your secret password: ");
            password = new String(passwordArray);
        }

        users.addNewUser(username, password, "student");
        Storage.saveUsers(users);
    }

    /**
     * Verify second student username and password when swapping index in studentApp
     *
     * @param username Username input by second student
     * @param password Password input by second student
     * @return User object of second student
     */
    public User getSwappingStudent(String username, String password) {
        String roleName = "Student";
        boolean validated = false;
        do {
            int matched = users.ValidateUser(username, roleName);

            if (matched == 2) {
                System.out.println("Second user verified - " + username);
                validated = users.validatePassword(username, password);
                if (!validated) {
                    System.out.println("Second user password not verified - Incorrect Password! Please retry your login.\t");
                    return null;
                }
                return users.getExistingUser(username);


            } else if (matched == 0) {
                System.out.println("Second user not verified - You are not registered - " + username);
                break;
            } else {
                System.out.println("Second user not verified - User - " + username + " - is not allowed to log in as a " + roleName);
                break;
            }
        } while (!validated);
        return null;
    }

    /**
     * Run method to run login
     *
     * @param sc Scanner for input
     * @return User object that has successfully signed in
     * @throws StarsException
     */
    public User run(Scanner sc) throws StarsException {
//        Scanner sc = new Scanner(System.in);
        String roleName, username = null;
        boolean validated = false;
        do {

//            LocalDateTime now = LocalDateTime.now();
//            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//            System.out.println(dtf.format(now)); // removing this line until i figure out how to adapt datetime into my testing framework
            roleName = inputRole(sc);
            if (roleName == null) {
                return null;
            }
            else if (roleName.equals("")) {
                continue;
            }
            username = inputUsername(sc);
            int matched = users.ValidateUser(username, roleName);

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
                users.addNewUser(username, password, roleName);
                System.out.println("You have registered as a new user!");
                validated = true;
            } else {
                System.out.println("User - " + username + " - is not allowed to log in as a " + roleName);
            }
        } while (!validated);
        Storage.saveUsers(users);
//        sc.close();
        return users.getExistingUser(username);
        //char[] pw = console.readPassword("Enter password: ");

        //String password = new String(pw);

    }
}