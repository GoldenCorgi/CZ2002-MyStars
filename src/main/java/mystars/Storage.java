package mystars;

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
    private static final String APPOINTMENTS_FILE = "appointments.txt";
    private static final String PATIENTS_FILE = "patients.txt";
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
     * Loads patients, stores them into ArrayList and returns the ArrayList.
     *
     * @return ArrayList of patients.
     * @throws StarsException If there is problem reading file.
     */
    public ArrayList<Patient> loadPatients() throws StarsException {
        Path path = Paths.get(folder, PATIENTS_FILE);
        ArrayList<Patient> patients = new ArrayList<>();

        if (Files.exists(path)) {
            try {
                BufferedReader bufferedReader = Files.newBufferedReader(path);

                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }

                    Patient patient = Parser.readPatient(line);
                    patients.add(patient);
                }
            } catch (IOException e) {
                throw new StarsException(READ_ERROR);
            }
        }

        return patients;
    }

    /**
     * Saves patients into file.
     *
     * @param patients ArrayList of patients to save.
     * @throws StarsException If there is problem writing or saving file.
     */
    public void savePatients(PatientList patients) throws StarsException {
        assert patients != null : "Saving null patients ArrayList";

        StringBuilder patientsFileContent = new StringBuilder();

        for (int i = 0; i < patients.getSize(); i++) {
            // Need to format tasks
            patientsFileContent.append(patients.getPatientUsingIndex(i));
            patientsFileContent.append(System.lineSeparator());
        }

        writeToFile(patientsFileContent, PATIENTS_FILE);
    }

    /**
     * Saves appointments into file.
     *
     * @param appointments ArrayList of appointments to save.
     * @throws StarsException If there is problem writing or saving file.
     */
    public void saveAppointments(AppointmentList appointments) throws StarsException {
        assert appointments != null : "Saving null appointments ArrayList";

        StringBuilder appointmentsFileContent = new StringBuilder();

        for (Appointment appointment : appointments.getAppointments()) {
            // Need to format tasks
            appointmentsFileContent.append(appointment);
            appointmentsFileContent.append(System.lineSeparator());
        }

        writeToFile(appointmentsFileContent, APPOINTMENTS_FILE);
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

    /**
     * Loads appointments, stores them into ArrayList and returns the ArrayList.
     *
     * @return ArrayList of appointments.
     * @throws StarsException If there is problem reading file.
     */
    public ArrayList<Appointment> loadAppointments() throws StarsException {
        Path path = Paths.get(folder, APPOINTMENTS_FILE);
        ArrayList<Appointment> appointments = new ArrayList<>();

        if (Files.exists(path)) {
            try {
                BufferedReader bufferedReader = Files.newBufferedReader(path);

                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }

                    Appointment appointment = Parser.readAppointment(line);
                    appointments.add(appointment);
                }
            } catch (IOException e) {
                throw new StarsException(READ_ERROR);
            }
        }

        return appointments;
    }

    /**
     * Loads doctors, stores them into ArrayList and returns the ArrayList.
     *
     * @return ArrayList of doctors.
     * @throws StarsException If there is problem reading file.
     */
    public ArrayList<Doctor> loadDoctors() throws StarsException {
        Path path = Paths.get(folder, DOCTORS_FILE);
        ArrayList<Doctor> doctors = new ArrayList<>();

        if (Files.exists(path)) {
            try {
                BufferedReader bufferedReader = Files.newBufferedReader(path);

                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }

                    Doctor doctor = Parser.readDoctor(line);
                    doctors.add(doctor);
                }
            } catch (IOException e) {
                throw new StarsException(READ_ERROR);
            }
        }

        return doctors;
    }

    public void saveDoctors(DoctorList doctors) throws StarsException {
        assert doctors != null : "Saving null doctors ArrayList";

        StringBuilder doctorsFileContent = new StringBuilder();

        for (int i = 0; i < doctors.getSize(); i++) {
            // Need to format tasks
            doctorsFileContent.append(doctors.getDoctorUsingIndex(i));
            doctorsFileContent.append(System.lineSeparator());
        }

        writeToFile(doctorsFileContent, DOCTORS_FILE);
    }
}
