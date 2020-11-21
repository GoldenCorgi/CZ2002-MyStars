package mystars;

import mystars.courses.Course;
import mystars.courses.CourseIndex;
import mystars.login.User;
import mystars.login.UserList;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Loads and saves data to file.
 */
public class Storage {
    //    public static final String LOAD_ERROR = "Error loading file.";
//    private static final String READ_ERROR = "Error reading file.";
    private static final String DIRECTORY_ERROR = "Error creating directory.";
    private static final String WRITE_ERROR = "Error writing file.";
    private static final String COURSES_SERIALIZABLE_FILE_NAME = "courses.dat";
    private static final String USERS_FILE = "users.txt";
    private static final String STUDENTS_SERIALIZABLE_FILE_NAME = "students.dat";
    private static String folder = "data";


    /**
     * Initializes path of folder and file.
     *
     * @param folderPath Full folder path.
     */
    public Storage(String folderPath) {
        folder = folderPath;
    }

    /**
     * Reads inputted user details and return the user.
     *
     * @param line Input line to parse to user details.
     * @return User object with user details.
     */
    private static User readUser(String line) {
        assert line != null && !line.equals("") : "No users to read!";

        StringBuilder record = new StringBuilder(line);
        String username = record.substring(0, record.indexOf("||"));
        // Deletes first comma separator.
        record.delete(0, record.indexOf("||") + 2);
        String role = record.substring(0, record.indexOf("||"));
        record.delete(0, record.indexOf("||") + 2);
        String salt = record.substring(0, record.indexOf("||"));
        record.delete(0, record.indexOf("||") + 2);
        String password = record.toString();

//        String password = record.substring(0, record.indexOf(", "));
//        // Deletes second comma separator.
//        record.delete(0, record.indexOf(", ") + 2);
        return new User(username, password, role, salt);
    }

    /**
     * Saves users into file.
     *
     * @param users ArrayList of users to save.
     * @throws StarsException If there is problem writing or saving file.
     */
    public static void saveUsers(UserList users) throws StarsException {
        assert users != null : "Saving null users ArrayList";

        StringBuilder usersFileContent = new StringBuilder();

        for (int i = 0; i < users.getSize(); i++) {
            // Need to format tasks
            usersFileContent.append(users.getUserUsingIndex(i));
            usersFileContent.append(System.lineSeparator());
        }

        writeToFile(usersFileContent, USERS_FILE);
    }

    public static HashMap<String, Course> loadCourses() {
        Path path = Paths.get("data", COURSES_SERIALIZABLE_FILE_NAME);
        String filename = path.normalize().toString();
        HashMap<String, Course> CourseHashMap = new HashMap<>();
        if (!Files.exists(path)) {
            System.out.println("No previous data for CourseList");
            System.out.println("Creating 4 default courses: CZ2001, CZ2002, CZ2003, CZ2004");
            Course course1 = new Course("Algorithms", "CZ2001", "SCSE", 3);
            course1.addCourseIndex(new CourseIndex("10027", 10));
            course1.addCourseIndex(new CourseIndex("10028", 10));
            CourseHashMap.put(course1.getCourseCode(), course1);
            Course course2 = new Course("OODP", "CZ2002", "SCSE", 3);
            course2.addCourseIndex(new CourseIndex("30440", 10));
            course2.addCourseIndex(new CourseIndex("30450", 10));
            CourseHashMap.put(course2.getCourseCode(), course2);
            Course course3 = new Course("Computer Graphics and Visualisation", "CZ2003", "SCSE", 3);
            course3.addCourseIndex(new CourseIndex("13044", 10));
            course3.addCourseIndex(new CourseIndex("13045", 10));
            CourseHashMap.put(course3.getCourseCode(), course3);
            Course course4 = new Course("Human Computer Interaction", "CZ2004", "SCSE", 3);
            course4.addCourseIndex(new CourseIndex("10014", 10));
            course4.addCourseIndex(new CourseIndex("10015", 10));
            CourseHashMap.put(course4.getCourseCode(), course4);
            return CourseHashMap;
        }

        FileInputStream fis;
        ObjectInputStream in;
        try {
            fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis);
            CourseHashMap = (HashMap<String, Course>) in.readObject();
            in.close();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        // print out the size
        //System.out.println(" Details Size: " + pDetails.size());
        //System.out.println();
        if (CourseHashMap.size() == 0) {
            System.out.println("No previous data for CourseList");
            System.out.println("Creating 4 default courses: CZ2001, CZ2002, CZ2003, CZ2004");
            Course course1 = new Course("Algorithms", "CZ2001", "SCSE", 3);
            course1.addCourseIndex(new CourseIndex("10027", 10));
            course1.addCourseIndex(new CourseIndex("10028", 10));
            CourseHashMap.put(course1.getCourseCode(), course1);
            Course course2 = new Course("OODP", "CZ2002", "SCSE", 3);
            course2.addCourseIndex(new CourseIndex("30440", 10));
            course2.addCourseIndex(new CourseIndex("30450", 10));
            CourseHashMap.put(course2.getCourseCode(), course2);
            Course course3 = new Course("Computer Graphics and Visualisation", "CZ2003", "SCSE", 3);
            course3.addCourseIndex(new CourseIndex("13044", 10));
            course3.addCourseIndex(new CourseIndex("13045", 10));
            CourseHashMap.put(course3.getCourseCode(), course3);
            Course course4 = new Course("Human Computer Interaction", "CZ2004", "SCSE", 3);
            course4.addCourseIndex(new CourseIndex("10014", 10));
            course4.addCourseIndex(new CourseIndex("10015", 10));
            CourseHashMap.put(course4.getCourseCode(), course4);

            return CourseHashMap;
        }

        return CourseHashMap;
    }

    public static void saveCourses(HashMap<String, Course> CourseHashMap) {
        String filename = Paths.get("data", COURSES_SERIALIZABLE_FILE_NAME).normalize().toString();
        FileOutputStream fos;
        ObjectOutputStream out;
        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(CourseHashMap);
            out.close();
            //	System.out.println("Object Persisted");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static HashMap<String, Student> loadStudents() {
        Path path = Paths.get("data", STUDENTS_SERIALIZABLE_FILE_NAME);
        HashMap<String, Student> StudentHashMap = new HashMap<>();
        if (!Files.exists(path)) {
            System.out.println("No previous data");
            System.out.println("Creating 15 default students");
            Student student1 = new Student("U1921001A", "Tim Ho", "timh0011", "Male", "Singaporean");
            StudentHashMap.put(student1.getStudentEmail(), student1);
            Student student2 = new Student("U1921002B", "Ben Choi", "benc0012", "Male", "Singaporean");
            StudentHashMap.put(student2.getStudentEmail(), student2);
            Student student3 = new Student("U1921003C", "David Lim", "limd0013", "Male", "Malaysian");
            StudentHashMap.put(student3.getStudentEmail(), student3);
            Student student4 = new Student("U1921004D", "Tommy Chua", "chua0014", "Male", "Singaporean");
            StudentHashMap.put(student4.getStudentEmail(), student4);
            Student student5 = new Student("U1921005E", "Jim Tan", "jtan0015", "Male", "Malaysian");
            StudentHashMap.put(student5.getStudentEmail(), student5);
            Student student6 = new Student("U1921006F", "Ian Tan", "iant0016", "Male", "Singaporean");
            StudentHashMap.put(student6.getStudentEmail(), student6);
            Student student7 = new Student("U1921007G", "Sean Lau", "sean0017", "Male", "Singaporean");
            StudentHashMap.put(student7.getStudentEmail(), student7);
            Student student8 = new Student("U1921008H", "James Ong", "jong0018", "Male", "Singaporean");
            StudentHashMap.put(student8.getStudentEmail(), student8);
            Student student9 = new Student("U1921009I", "Jane Ho", "jane0011", "Female", "Singaporean");
            StudentHashMap.put(student9.getStudentEmail(), student9);
            Student student10 = new Student("U1921010J", "Rachel Tan", "rach0012", "Female", "Malaysian");
            StudentHashMap.put(student10.getStudentEmail(), student10);
            Student student11 = new Student("U1921011K", "Cheryl Lim", "cher0013", "Female", "Singaporean");
            StudentHashMap.put(student11.getStudentEmail(), student11);
            Student student12 = new Student("U1921012L", "Jamie Tan", "jami0014", "Female", "Malaysian");
            StudentHashMap.put(student12.getStudentEmail(), student12);
            Student student13 = new Student("U1921013M", "Hilary Ng", "hiln0015", "Female", "Singaporean");
            StudentHashMap.put(student13.getStudentEmail(), student13);
            Student student14 = new Student("U1921014N", "Natasha Ang", "angn0016", "Female", "Singaporean");
            StudentHashMap.put(student14.getStudentEmail(), student14);
            Student student15 = new Student("U1921015P", "Nicole Ong", "ongn0017", "Female", "Singaporean");
            StudentHashMap.put(student15.getStudentEmail(), student15);

            return StudentHashMap;

        }

        String filename = path.normalize().toString();
        FileInputStream fis;
        ObjectInputStream in;

        try {
            fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis);
            StudentHashMap = (HashMap<String, Student>) in.readObject();
            in.close();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        if (StudentHashMap.size() == 0) {
            System.out.println("No previous data");
            System.out.println("Creating 15 default students");
            Student student1 = new Student("U1921001A", "Tim Ho", "timh0011", "Male", "Singaporean");
            StudentHashMap.put(student1.getStudentEmail(), student1);
            Student student2 = new Student("U1921002B", "Ben Choi", "benc0012", "Male", "Singaporean");
            StudentHashMap.put(student2.getStudentEmail(), student2);
            Student student3 = new Student("U1921003C", "David Lim", "limd0013", "Male", "Malaysian");
            StudentHashMap.put(student3.getStudentEmail(), student3);
            Student student4 = new Student("U1921004D", "Tommy Chua", "chua0014", "Male", "Singaporean");
            StudentHashMap.put(student4.getStudentEmail(), student4);
            Student student5 = new Student("U1921005E", "Jim Tan", "jtan0015", "Male", "Malaysian");
            StudentHashMap.put(student5.getStudentEmail(), student5);
            Student student6 = new Student("U1921006F", "Ian Tan", "iant0016", "Male", "Singaporean");
            StudentHashMap.put(student6.getStudentEmail(), student6);
            Student student7 = new Student("U1921007G", "Sean Lau", "sean0017", "Male", "Singaporean");
            StudentHashMap.put(student7.getStudentEmail(), student7);
            Student student8 = new Student("U1921008H", "James Ong", "jong0018", "Male", "Singaporean");
            StudentHashMap.put(student8.getStudentEmail(), student8);
            Student student9 = new Student("U1921009I", "Jane Ho", "jane0011", "Female", "Singaporean");
            StudentHashMap.put(student9.getStudentEmail(), student9);
            Student student10 = new Student("U1921010J", "Rachel Tan", "rach0012", "Female", "Malaysian");
            StudentHashMap.put(student10.getStudentEmail(), student10);
            Student student11 = new Student("U1921011K", "Cheryl Lim", "cher0013", "Female", "Singaporean");
            StudentHashMap.put(student11.getStudentEmail(), student11);
            Student student12 = new Student("U1921012L", "Jamie Tan", "jami0014", "Female", "Malaysian");
            StudentHashMap.put(student12.getStudentEmail(), student12);
            Student student13 = new Student("U1921013M", "Hilary Ng", "hiln0015", "Female", "Singaporean");
            StudentHashMap.put(student13.getStudentEmail(), student13);
            Student student14 = new Student("U1921014N", "Natasha Ang", "angn0016", "Female", "Singaporean");
            StudentHashMap.put(student14.getStudentEmail(), student14);
            Student student15 = new Student("U1921015P", "Nicole Ong", "ongn0017", "Female", "Singaporean");
            StudentHashMap.put(student15.getStudentEmail(), student15);

            return StudentHashMap;
        }

        return StudentHashMap;
    }

    public static void saveStudents(HashMap<String, Student> StudentHashMap) {
        String filename = Paths.get("data", STUDENTS_SERIALIZABLE_FILE_NAME).normalize().toString();
        FileOutputStream fos;
        ObjectOutputStream out;
        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(StudentHashMap);
            out.close();
            //	System.out.println("Object Persisted");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Loads users, stores them into ArrayList and returns the ArrayList.
     *
     * @return ArrayList of users.
     */
    public static UserList loadUsers() {
        Path path = Paths.get(folder, USERS_FILE);
        ArrayList<User> users = new ArrayList<>();
//            logger.log(Level.INFO, "going to load users");

        if (Files.exists(path)) {
            try {
                BufferedReader bufferedReader = Files.newBufferedReader(path);

                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }

                    User user = readUser(line);
                    users.add(user);
                }
            } catch (IOException e) {
                System.out.println("Error loading user file.");
                //            logger.log(Level.INFO, "No users found. Creating new users list.");
                System.out.println("Creating new admin user defaults");
                UserList newUserList = new UserList();
                newUserList.addNewUser("admin", "1234", "Admin");
                newUserList.addNewUser("timh0011", "1234", "Student");
                newUserList.addNewUser("benc0012", "1234", "Student");
                newUserList.addNewUser("limd0013", "1234", "Student");
                newUserList.addNewUser("chua0014", "1234", "Student");
                newUserList.addNewUser("jtan0015", "1234", "Student");
                newUserList.addNewUser("iant0016", "1234", "Student");
                newUserList.addNewUser("sean0017", "1234", "Student");
                newUserList.addNewUser("jong0018", "1234", "Student");
                newUserList.addNewUser("jane0011", "1234", "Student");
                newUserList.addNewUser("rach0012", "1234", "Student");
                newUserList.addNewUser("cher0013", "1234", "Student");
                newUserList.addNewUser("jami0014", "1234", "Student");
                newUserList.addNewUser("hiln0015", "1234", "Student");
                newUserList.addNewUser("angn0016", "1234", "Student");
                newUserList.addNewUser("ongn0017", "1234", "Student");

                return newUserList;

//                throw new StarsException(READ_ERROR);
            }
        }
        UserList usersList;
//            logger.log(Level.INFO, "loaded users");
        usersList = new UserList(users);
        if (users.size() == 0) {
            System.out.println("No previous data for UserList");
            System.out.println("Creating new admin user defaults");
            usersList.addNewUser("admin", "1234", "Admin");
            // TODO consider adding student defaults
            usersList.addNewUser("student", "1234", "Student");

        }

        return usersList;
    }

    /**
     * Writes content to file.
     *
     * @param fileContent String content to write.
     * @param file        Filename to write to.
     * @throws StarsException If there is problem writing files.
     */
    private static void writeToFile(StringBuilder fileContent, String file) throws StarsException {
        Path folderPath = Paths.get(folder);
        if (!Files.exists(folderPath) && !new File(folder).mkdir()) {
            throw new StarsException(DIRECTORY_ERROR);
        }

        Path filePath = Paths.get(folder, file);
        try {
            BufferedWriter bufferedWriter = Files.newBufferedWriter(filePath);
            bufferedWriter.write(fileContent.toString());
            bufferedWriter.close();
        } catch (IOException e) {
            throw new StarsException(WRITE_ERROR);
        }
    }


}
