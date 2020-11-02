package mystars;

import mystars.login.User;
import mystars.login.UserList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
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
    private static final String MODULES_FILE = "modules.txt";
    private static final String USERS_FILE = "users.txt";
    private static final String DOCTORS_FILE = "doctors.txt";
    private final String folder;

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

                    User user = Parser.readUser(line);
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
}
