package mystars;

import mystars.login.Login;
import mystars.login.User;
import mystars.login.UserList;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Logger;
/**
 * Main class.
 */
public class Main {

    public static void main(String[] args) throws StarsException {
        Logger logger = Logger.getLogger("MyStars");
        final Storage storage = new Storage("data");
        UserList users;
        Scanner sc = new Scanner(System.in);

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
        User user = login.run();
        String rolename = user.getRole();

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
//            Scanner sc = new Scanner(System.in);
            StudentApp StudentApp = new StudentApp(user.getName());

            do {
                System.out.println("Enter the number of your choice: ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        // Done
                        System.out.println("(1) Add course");
                        System.out.println("Enter courseCode: ");
                        String courseCode = sc.nextLine();
                        // TODO verify coursecode
                        System.out.println("Enter courseIndex: ");
                        String courseIndex = sc.nextLine();
                        // TODO Verify courseindex

                        // TODO Validate whether course got vacancies etc
                        StudentApp.addCourse(courseCode,courseIndex);
                        break;
                    case 2:
                        // Done
                        System.out.println("(2) Drop course");
                        System.out.println("Enter courseCode: ");
                        courseCode = sc.nextLine();
                        // TODO verify coursecode
                        StudentApp.dropCourse(courseCode);

                        break;
                    case 3:
                        // Done
                        System.out.println("(3) Check/Print Courses Registered");
                        StudentApp.printCourse();
                        break;
                    case 4:
                        // Done
                        System.out.println("(4) Check Vacancies Available");
                        System.out.println("Enter courseCode: ");
                         courseCode = sc.nextLine();
                        // TODO verify coursecode
                        System.out.println("Enter courseIndex: ");
                         courseIndex = sc.nextLine();
                        // TODO Verify courseindex
                        int vacancies = StudentApp.checkVacancies(courseCode,courseIndex);
                        System.out.println("Course Index has " + String.valueOf(vacancies) + " Vacancies");

                        // use courses class to check vacancies of index
                        break;
                    case 5:
                        // Done
                          System.out.println("(5) Change Index Number of Course");
                        System.out.println("Enter courseCode: ");
                         courseCode = sc.nextLine();
                        // TODO verify coursecode
                        System.out.println("Enter new courseIndex: ");
                         courseIndex = sc.nextLine();
                        // TODO Verify courseindex

                        // TODO Validate whether course got vacancies etc
                        StudentApp.addCourse(courseCode,courseIndex);

                        break;
                    case 6:
                        System.out.println("(6) Swop Index Number with Another Student");

//                        String peerUserName = Student1.swapIndex();
//                        Student Student2 = new Student();
                        //Student2.swapIndex(oldIndex, newIndex); -- need to do method overloading i think?

                        break;
                    case 7:
                        System.out.println("Program terminating..");

                }
            } while (choice != 7);
        } else if (rolename.equals("Admin")) {
            // TODO add admin actions
            System.out.println("Welcome Admin");
            Admin admin = new Admin(user.getName());
            // admin actions
            int choice;
            do {
                System.out.println("(1) Edit Student Access Period");
                System.out.println("(2) Add Student");
                System.out.println("(3) Add Course");
                System.out.println("(4) Update Course");
                System.out.println("(5) Check Vacancies for a Course Index");
                System.out.println("(6) Print Student List by Index Number");
                System.out.println("(7) Print Student List by Course");
                System.out.println("(8) Exit");
//                Scanner sc = new Scanner(System.in);

                System.out.println("Enter the number of your choice: ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        LocalDateTime currentDateTime = LocalDateTime.now();
                        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                        String formattedCurrentDT = currentDateTime.format(formatDateTime);
                        System.out.println("Current Date and Time: " + formattedCurrentDT);
                        System.out.println("Enter start date of Student Access Period (dd-MM-yyyy): ");
                        String date = sc.next();
                        System.out.println("Enter start time of Student Access Period: ");
                        String time = sc.next();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        LocalDate startDate = LocalDate.parse(date, formatter);
                        LocalTime timeFormat = LocalTime.parse(time);
                        System.out.println("date: " + startDate);
                        System.out.println("time: " + timeFormat);

                        System.out.println("Enter end date of Student Access Period (dd-MM-yyyy): ");
                        String date2 = sc.next();
                        System.out.println("Enter end time of Student Access Period: ");
                        String time2 = sc.next();
                        LocalDate endDate = LocalDate.parse(date2, formatter);
                        LocalTime timeFormat2 = LocalTime.parse(time2);
                        System.out.println("date: " + endDate);
                        System.out.println("time: " + timeFormat2);
                        break;
                    case 2:
                        // Done
                        System.out.println("(2) Add Student");
                        System.out.println("Enter studentEmail: ");
                        String studentEmail = sc.nextLine();
                        if (admin.checkStudentEmailExists(studentEmail)){
                            // True = already exists
                            System.out.println("Email already exists!");
                            break;
                        };
                        System.out.println("Enter studentName: ");
                        String studentName = sc.nextLine();
                        System.out.println("Enter matricNo: ");
                        String matricNo = sc.nextLine();
                        // TODO Verify matric does not duplicate
                        System.out.println("Enter studentGender: ");
                        String studentGender = sc.nextLine().toLowerCase();
                        // TODO verify gender lmao
//                        if (admin.verifyGender(studentGender)){
//                            // True = correct input
//                            System.out.println("Gender incorrect format (Male/Female)!");
//                            break;
//                        };
                        System.out.println("Enter studentNationality: ");
                        String studentNationality = sc.nextLine();
                        // TODO verify nationality?
                        login.addNewStudentWithPassword(sc,studentEmail);
                        Student newStudent = new Student(matricNo, studentName, studentEmail,  studentGender,  studentNationality);
                        admin.addStudent(newStudent);
                        System.out.println("Student added");
                        break;

                    case 3:
                        // Done
                        admin.addCourse(sc);
                        System.out.println("Course Added");
                        break;
                    case 4:
                        System.out.println("Program terminating..");
                        break;
                    case 5:
                        // Done
                        System.out.println("(5) Check Vacancies for a Course Index");
                        System.out.println("Enter courseCode: ");
                        String courseCode = sc.nextLine();
                        // TODO verify coursecode
                        System.out.println("Enter courseIndex: ");
                        String courseIndex = sc.nextLine();
                        // TODO Verify courseindex
                        int vacancies = admin.checkVacancies(courseCode,courseIndex);
                        System.out.println("Course Index has " + String.valueOf(vacancies) + " Vacancies");
                        break;
                    case 6:
                        // Done
                        System.out.println("(6) Print Student List by Index Number");
                        System.out.println("Enter courseCode: ");
                        courseCode = sc.nextLine();
                        // TODO verify coursecode
                        System.out.println("Enter courseIndex: ");
                        courseIndex = sc.nextLine();
                        // TODO Verify courseindex
                        admin.printStudentListByIndex(courseCode,courseIndex);
                        System.out.println("Program terminating..");
                        break;
                    case 7:
                        // Done
                        System.out.println("(7) Print Student List by Course");
                        System.out.println("Enter courseCode: ");
                        courseCode = sc.nextLine();
                        // TODO verify coursecode
                        admin.printStudentListByCourse(courseCode);
                        System.out.println("Program terminating..");
                        break;
                    case 8:
                        System.out.println("Program terminating..");
                }
            } while (choice != 8);
        } else {
            System.out.println("Unknown Role");
        }


        System.out.println("Terminating Program!");
    }

}
