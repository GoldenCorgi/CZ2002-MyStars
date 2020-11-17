package mystars;

import mystars.courses.Course;
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
    public static final String LOAD_ERROR = "Error loading file.";
    private static final String READ_ERROR = "Error reading file.";
    private static final String DIRECTORY_ERROR = "Error creating directory.";
    private static final String WRITE_ERROR = "Error writing file.";
    private static final String COURSES_SERIALIZABLE_FILE_NAME = "courses.dat";
    private static final String USERS_FILE = "users.txt";
    private static final String STUDENTS_SERIALIZABLE_FILE_NAME = "students.dat";
    private final String folder;


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
     * Initializes path of folder and file.
     *
     * @param folderPath Full folder path.
     */
    public Storage(String folderPath) {
        folder = folderPath;
    }

    /**
     * Loads users, stores them into ArrayList and returns the ArrayList.
     *
     * @return ArrayList of users.
     * @throws StarsException If there is problem reading file.
     */
    public ArrayList<User> loadUsers() throws StarsException {
        Path path = Paths.get(folder, USERS_FILE);
        ArrayList<User> users = new ArrayList<>();

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
                throw new StarsException(READ_ERROR);
            }
        }

        return users;
    }

    /**
     * Saves users into file.
     *
     * @param users ArrayList of users to save.
     * @throws StarsException If there is problem writing or saving file.
     */
    public void saveUsers(UserList users) throws StarsException {
        assert users != null : "Saving null users ArrayList";

        StringBuilder usersFileContent = new StringBuilder();

        for (int i = 0; i < users.getSize(); i++) {
            // Need to format tasks
            usersFileContent.append(users.getUserUsingIndex(i));
            usersFileContent.append(System.lineSeparator());
        }

        writeToFile(usersFileContent, USERS_FILE);
    }

    /**
     * Writes content to file.
     *
     * @param fileContent String content to write.
     * @param file        Filename to write to.
     * @throws StarsException If there is problem writing files.
     */
    private void writeToFile(StringBuilder fileContent, String file) throws StarsException {
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

    public static HashMap<String, Course> loadCourses() {
        Path path = Paths.get("data", COURSES_SERIALIZABLE_FILE_NAME);
        String filename = path.normalize().toString();
        HashMap<String, Course> CourseHashMap = null;
        if (!Files.exists(path)) {
            return CourseHashMap;
        }

        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis);
            CourseHashMap = (HashMap<String, Course>) in.readObject();
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        // print out the size
        //System.out.println(" Details Size: " + pDetails.size());
        //System.out.println();
        return CourseHashMap;
    }

    public static void saveCourses(HashMap<String, Course> CourseHashMap) {
        String filename = Paths.get("data", COURSES_SERIALIZABLE_FILE_NAME).normalize().toString();
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
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
        HashMap<String, Student> pDetails = new HashMap<>();
        if (!Files.exists(path)) {
            return pDetails;
        }
        String filename = path.normalize().toString();

        FileInputStream fis;
        ObjectInputStream in;
        try {
            fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis);
            pDetails = (HashMap<String, Student>) in.readObject();
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        // print out the size
        //System.out.println(" Details Size: " + pDetails.size());
        //System.out.println();
        return pDetails;
    }

    public static void saveStudents(HashMap<String, Student> studentList) {
        String filename = Paths.get("data", STUDENTS_SERIALIZABLE_FILE_NAME).normalize().toString();
        FileOutputStream fos;
        ObjectOutputStream out;
        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(studentList);
            out.close();
            //	System.out.println("Object Persisted");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        HashMap<String, Course> list = new HashMap<String, Course>();
        try {

            String path = Paths.get("data", COURSES_SERIALIZABLE_FILE_NAME).normalize().toString();
            System.out.println(path);
            list = Storage.loadCourses();
            for (int i = 0; i < list.size(); i++) {
                Course p = list.get(i);
                System.out.println("name is " + p.getCourseName());
                System.out.println("contact is " + p.getCourseCode());
            }
            Course p = new Course("oodp i guess", "cz2002", "SCSE", 21);
            // add to list
            list.put(p.getCourseCode(),p);

            Storage.saveCourses(list);

        } catch (Exception e) {
            System.out.println("Exception >> " + e.getMessage());
        }
    }


}
