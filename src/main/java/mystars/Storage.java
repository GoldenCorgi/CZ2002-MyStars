package mystars;

import mystars.courses.Course;
import mystars.login.User;
import mystars.login.UserList;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Loads and saves data to file.
 */
public class Storage {
    public static final String LOAD_ERROR = "Error loading file.";
    private static final String READ_ERROR = "Error reading file.";
    private static final String DIRECTORY_ERROR = "Error creating directory.";
    private static final String WRITE_ERROR = "Error writing file.";
    private static final String COURSES_FILE = "courses.txt";
    private static final String USERS_FILE = "users.txt";
    private static final String DOCTORS_FILE = "doctors.txt";
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
     * Saves modules into file.
     *
     * @param modules ArrayList of modules to save.
     * @throws StarsException If there is problem writing or saving file.
     */
//    public void saveAppointments(AppointmentList modules) throws StarsException {
//        assert modules != null : "Saving null modules ArrayList";
//
//        StringBuilder modulesFileContent = new StringBuilder();
//
//        for (Appointment appointment : modules.getAppointments()) {
//            // Need to format tasks
//            modulesFileContent.append(appointment);
//            modulesFileContent.append(System.lineSeparator());
//        }
//
//        writeToFile(modulesFileContent, MODULES_FILE);
//    }

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

    /**
     * Loads modules, stores them into ArrayList and returns the ArrayList.
     *
     * @return ArrayList of modules.
     * @throws StarsException If there is problem reading file.
     */
//    public ArrayList<Appointment> loadAppointments() throws StarsException {
//        Path path = Paths.get(folder, MODULES_FILE);
//        ArrayList<Appointment> modules = new ArrayList<>();
//
//        if (Files.exists(path)) {
//            try {
//                BufferedReader bufferedReader = Files.newBufferedReader(path);
//
//                while (true) {
//                    String line = bufferedReader.readLine();
//                    if (line == null) {
//                        break;
//                    }
//
//                    Appointment appointment = Parser.readAppointment(line);
//                    modules.add(appointment);
//                }
//            } catch (IOException e) {
//                throw new StarsException(READ_ERROR);
//            }
//        }
//
//        return modules;
//    }

    /**
     * Loads doctors, stores them into ArrayList and returns the ArrayList.
     *
     * @return ArrayList of doctors.
     * @throws StarsException If there is problem reading file.
     */
//    public ArrayList<Doctor> loadDoctors() throws StarsException {
//        Path path = Paths.get(folder, DOCTORS_FILE);
//        ArrayList<Doctor> doctors = new ArrayList<>();
//
//        if (Files.exists(path)) {
//            try {
//                BufferedReader bufferedReader = Files.newBufferedReader(path);
//
//                while (true) {
//                    String line = bufferedReader.readLine();
//                    if (line == null) {
//                        break;
//                    }
//
//                    Doctor doctor = Parser.readDoctor(line);
//                    doctors.add(doctor);
//                }
//            } catch (IOException e) {
//                throw new StarsException(READ_ERROR);
//            }
//        }
//
//        return doctors;
//    }
//
//    public void saveDoctors(DoctorList doctors) throws StarsException {
//        assert doctors != null : "Saving null doctors ArrayList";
//
//        StringBuilder doctorsFileContent = new StringBuilder();
//
//        for (int i = 0; i < doctors.getSize(); i++) {
//            // Need to format tasks
//            doctorsFileContent.append(doctors.getDoctorUsingIndex(i));
//            doctorsFileContent.append(System.lineSeparator());
//        }
//
//        writeToFile(doctorsFileContent, DOCTORS_FILE);
//    }

    public static ArrayList<Course> readSerializedObject(String filename) {
        ArrayList<Course> pDetails = null;
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis);
            pDetails = (ArrayList) in.readObject();
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

        public static void writeSerializedObject(String filename, ArrayList<Course> list) {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(list);
            out.close();
            //	System.out.println("Object Persisted");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArrayList<Course> list = new ArrayList<>();
        try	{
            // read from serialized file the list of professors
            list = Storage.readSerializedObject("data/courses.dat");
            for (int i = 0 ; i < list.size() ; i++) {
                Course p = (Course)list.get(i);
                System.out.println("name is " + p.getCourseName() );
                System.out.println("contact is " + p.getCourseCode() );
            }
            // write to serialized file - update/insert/delete
            // example - add one more professor
            Course p = new Course("2","jos@ntu.edu.sg",67909999);
            // add to list
            list.add(p);
            // list.remove(p);  // remove if p equals object in the list

            Storage.writeSerializedObject("data/courses.dat", list);

        }  catch ( Exception e ) {
            System.out.println( "Exception >> " + e.getMessage() );
        }
    }


}
