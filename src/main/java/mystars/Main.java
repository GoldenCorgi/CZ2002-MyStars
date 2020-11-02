package mystars;
import mystars.UserInterface;
import mystars.login.Login;
import mystars.login.UserList;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main class.
 */
public class Main {

    public static void main(String[] args) throws StarsException {
        final UserInterface userInterface = new UserInterface();
        Logger logger = Logger.getLogger("MyStars");
        final Storage storage = new Storage("data");
        UserList users;

        try {
//            logger.log(Level.INFO, "going to load users");
            users = new UserList(storage.loadUsers());
//            logger.log(Level.INFO, "loaded users");
        } catch (StarsException e) {
//            logger.log(Level.INFO, "No users found. Creating new users list.");
            userInterface.showLoadingError();
            users = new UserList();
        }
        Login login = new Login(users, storage);
        String rolename = login.run();


        if (rolename.equals("Student")) {
            // TODO add student actions
            System.out.println("Welcome Student");
        }
        else if (rolename.equals("Admin")) {
            // TODO add admin actions
            System.out.println("Welcome Admin");
        }
        else {
            System.out.println("Unknown Role");
        }


        System.out.println("Terminating Program!");
    }

}
