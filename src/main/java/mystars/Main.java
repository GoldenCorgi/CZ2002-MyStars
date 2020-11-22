package mystars;

import mystars.login.Login;
import mystars.login.User;

import java.util.Scanner;

/**
 * Main class.
 */
public class Main {

    public static void main(String[] args) throws StarsException {
//        Logger logger = Logger.getLogger("MyStars");
        Scanner sc = new Scanner(System.in);
        runLoop(sc);
    }


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
            } else {
                System.out.println("Unknown Role");
            }
        }

        System.out.println("Terminating Program, thanks for using MyStars!");
    }}