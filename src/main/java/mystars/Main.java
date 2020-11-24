package mystars;

import mystars.login.Login;
import mystars.login.User;

import java.util.Scanner;

/**
 * Main class.
 */
public class Main {

    /**
     * main method to run the whole program
     *
     * @throws StarsException Error handling
     */
    public static void main(String[] args) throws StarsException {
//        Logger logger = Logger.getLogger("MyStars");
        Scanner sc = new Scanner(System.in);
        runLoop(sc);
    }

    /**
     * runLoop to run the program
     *
     * @param sc Scanner for input
     * @throws StarsException Error handling
     */
    public static void runLoop(Scanner sc) throws StarsException {
        while (true) {
            Login login = new Login(Storage.loadUsers());
            // return user class instead, so can get their username and role
            User user = login.run(sc);
            if (user == null) {
                // user input specifies exit
                break;
            }
            String roleName = user.getRole();

            if (roleName.equals("Student")) {
                System.out.println("Welcome Student - " + user.getName());
                StudentApp StudentApp = new StudentApp(user.getName());
                StudentApp.runLoop(login,sc);
            } else if (roleName.equals("Admin")) {
                System.out.println("Welcome Admin - " + user.getName());
                Admin admin = new Admin(user.getName());
                admin.runLoop(login,sc);
            }
        }

        System.out.println("Terminating Program, thanks for using MyStars!");
    }}