package mystars;

import mystars.login.Login;
import mystars.login.User;
import mystars.login.UserList;

/**
 * Main class.
 */
public class Main {

    public static void main(String[] args) throws StarsException {
//        Logger logger = Logger.getLogger("MyStars");
        Storage storage = new Storage("data");
        UserList users;
        users = storage.loadUsers();

        Login login = new Login(users, storage);
        // return user class instead, so can get their username and role
        User user = login.run();
        String roleName = user.getRole();

        if (roleName.equals("Student")) {
            System.out.println("Welcome Student - " + user.getName());
            StudentApp StudentApp = new StudentApp(user.getName());
            StudentApp.runLoop(login);
        } else if (roleName.equals("Admin")) {
            System.out.println("Welcome Admin - " + user.getName());
            Admin admin = new Admin(user.getName());
            admin.runLoop(login);
        } else {
            System.out.println("Unknown Role");
        }


        System.out.println("Terminating Program!");
    }

}
