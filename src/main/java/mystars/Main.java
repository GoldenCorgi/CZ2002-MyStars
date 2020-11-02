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
        Login login = new Login(users);
        users = login.run();
        storage.saveUsers(users);

        System.out.println("Terminating Program!");
    }

}
