package mystars;


import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * Interacts with user.
 */

public class UserInterface {
    private static final String DOTTED_LINE = "____________________________________________________________";
    private static final String DATE_ERROR = "Error in date format.";
    private final Scanner in = new Scanner(System.in);

    /**
     * Prints string with indent.
     *
     * @param string String to print.
     */
    private void printWithIndent(String string) {
        System.out.println("\t " + string);
    }

    /**
     * Prints dotted line.
     */
    public void showLine() {
        System.out.println("\t" + DOTTED_LINE);
    }

    /**
     * Prints error message.
     *
     * @param message Error message to print.
     */
    public void showError(String message) {
        printWithIndent(message);
    }

    /**
     * Prints welcome message.
     */
//    public void showWelcome() {
//        showLine();
//        printWithIndent(Command.MESSAGE);
//        showLine();
//    }

    /**
     * Prints loading error message.
     */
    public void showLoadingError() {
        showError(Storage.LOAD_ERROR);
    }

    /**
     * Prints exit message.
     */
//    public void showExit() {
//        printWithIndent(ExitCommand.MESSAGE);
//    }

    /**
     * Prints date error message.
     */
    public void showDateInputError() {
        showError(DATE_ERROR);
    }




    /**
     * Reads command from user.
     *
     * @return String command from user.
     */
    public String readCommand() {
        System.out.println("Enter command: ");
        return in.nextLine();
    }

    /**
     * Reads the name of a new patient from the user.
     *
     * @return The name of the patient to be added.
     */
    public String getPatientName() {
        printWithIndent("Enter patient name: ");
        return in.nextLine().trim();
    }

    /**
     * Reads the date of birth of a new patient from the user.
     *
     * @return The date of birth of the patient.
     */
    public LocalDate getPatientDateOfBirth() {
        while (true) {
            try {
                printWithIndent("Enter patient date of birth (YYYY-MM-DD) including the dashes: ");
                return LocalDate.parse(in.nextLine().trim());
            } catch (DateTimeParseException e) {
                showLine();
                showDateInputError();
                showLine();
            }
        }
    }

    /**
     * Prints patient not found message.
     *
     * @param nric NRIC inputted.
     */
    public void printPatientNotFound(String nric) {
        printWithIndent("Patient " + nric + " not found in database!");
    }

    /**
     * Gets appointment date from user.
     *
     * @return User input string.
     */
    public String getNewAppointmentDate() {
        printWithIndent("Please enter the date of appointment in YYYY-MM-DD.");
        showLine();
        return in.nextLine();
    }

    /**
     * Prints appointment creation message.
     */
    public void showAppointmentCreatedMessage() {
        showLine();
        printWithIndent("New appointment created!");
    }



    /**
     * Prints patient creation message.
     *
     * @param nric Patient's NRIC.
     */
    public void showCreatePatientMessage(String nric) {
        printWithIndent("Creating patient " + nric);
    }

    /**
     * Prints patient's appointment list header.
     *
     * @param nric Patient's NRIC
     */
    public void showAppointmentsListHeader(String nric) {
        printWithIndent("Listing appointments for patient " + nric + ": ");
    }



    public String getDoctorName() {
        printWithIndent("Enter doctor name: ");
        return in.nextLine().toUpperCase().trim();
    }

//    public void showDoctorAdded(Doctor newDoctor) {
//        printWithIndent("Doctor added: " + newDoctor.getName());
//    }
//
//    public void showDoctorDeleted(Doctor deletedDoctor) {
//        printWithIndent("Doctor successfully deleted: ");
//        printWithIndent(deletedDoctor.toString());
//    }
//
//    public void printDoctorNotFound(String doctorName) {
//        printWithIndent("Patient " + doctorName + " not found in database!");
//    }

}
