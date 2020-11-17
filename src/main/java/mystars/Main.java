package mystars;
import mystars.login.Login;
import mystars.login.UserList;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main class.
 */
public class Main {

    public static void main(String[] args) throws StarsException {
        Logger logger = Logger.getLogger("MyStars");
        final Storage storage = new Storage("data");
        UserList users;

        try {
//            logger.log(Level.INFO, "going to load users");
            users = new UserList(storage.loadUsers());
//            logger.log(Level.INFO, "loaded users");
        } catch (StarsException e) {
//            logger.log(Level.INFO, "No users found. Creating new users list.");
            System.out.println("Error loading user file.");
            users = new UserList();
        }
        Login login = new Login(users, storage);
        // TODO return user class instead, so can get their username and role
        String rolename = login.run();


        if (rolename.equals("Student")) {
            System.out.println("Welcome Student");
            // TODO add student actions
            int choice;
            System.out.println("(1) Add course");
            System.out.println("(2) Drop course");
            System.out.println("(3) Check/Print Courses Registered");
            System.out.println("(4) Check Vacancies Available");
            System.out.println("(5) Change Index Number of Course");
            System.out.println("(6) Swop Index Number with Another Student");
            System.out.println("(7) Exit");
            Student Student1 = new Student();
            Scanner sc = new Scanner(System.in);
            do {
                System.out.println("Enter the number of your choice: ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Please enter index number: ");
                        int index = sc.nextInt();
                        String indexNum = String.valueOf(index);
                        System.out.println("Enter 'OK' to confirm add course");
                        String confirm1 = sc.nextLine();
                        Student1.addCourse(indexNum, confirm1);
                        break;
                    case 2:
                        System.out.println("These are the courses that you have registered:");
                        //Display the course index, course code, and status of the course
                        HashMap coursesRegistered = Student1.getCourses();
                        System.out.println(coursesRegistered);
                        System.out.println("Enter what Course Index you want to drop: ");
                        int index1 = sc.nextInt();
                        String indexNum1 = String.valueOf(index1);
                        System.out.println("Enter 'OK' to confirm drop course");
                        String confirm2 = sc.nextLine();
                        Student1.dropCourse(indexNum1, confirm2);
                        break;
                    case 3:
                        Student1.getCourses();
                        break;
                    case 4:
                        System.out.println("Enter Course Index: ");
                        int index2 = sc.nextInt();
                        String indexNum2 = String.valueOf(index2);

                        break;
                    case 5:
                        System.out.println("Enter Current Index: ");
                        int index3 = sc.nextInt();
                        String indexNum3 = String.valueOf(index3);
                        System.out.println("Enter New Index: ");
                        int index4 = sc.nextInt();
                        String indexNum4 = String.valueOf(index4);
                        System.out.println("Enter 'OK' to confirm drop course");
                        String confirm3 = sc.nextLine();
                        Student1.changeIndex(indexNum3, indexNum4, confirm3);

                        break;
                    case 6:
                        System.out.println("Enter Your Index: ");
                        int index5 = sc.nextInt();
                        String indexNum5 = String.valueOf(index5);
                        System.out.println("Enter Peer's Username: ");
                        String peerUN = sc.nextLine();
                        System.out.println("Enter Peer's Password: ");
                        String peerPW = sc.nextLine();
                        System.out.println("Enter Peer's Index: ");
                        int index6 = sc.nextInt();
                        String indexNum6 = String.valueOf(index6);
                        System.out.println("Enter 'OK' to confirm drop course");
                        String confirm4 = sc.nextLine();
                        // check if peerStudID and peerPassword is valid
                        Student1.swapIndex(indexNum5, indexNum6, confirm4);


                        break;
                    case 7:
                        System.out.println("Program terminating..");

                }
            } while(choice < 7);
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
