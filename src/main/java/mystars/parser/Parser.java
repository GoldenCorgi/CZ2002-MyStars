package mystars.parser;
import mystars.login.User;

import java.time.LocalDate;

/**
 * Makes sense of user command.
 */
public class Parser {

    /**
     * Reads inputted user details and return the user.
     *
     * @param line Input line to parse to user details.
     * @return User object with user details.
     */
    public static User readUser(String line) {
        assert line != null && !line.equals("") : "No users to read!";

        StringBuilder record = new StringBuilder(line);
        String username = record.substring(0, record.indexOf(", "));
        // Deletes first comma separator.
        record.delete(0, record.indexOf(", ") + 2);
        String password = record.toString();
//        String password = record.substring(0, record.indexOf(", "));
//        // Deletes second comma separator.
//        record.delete(0, record.indexOf(", ") + 2);
        return new User(username, password);
    }

//    public static Appointment readAppointment(String line) {
//        String[] appointmentComponents = line.split(", ");
//        LocalDate date = LocalDate.parse(appointmentComponents[0]);
//        String bookedStatus = appointmentComponents[1];
//        String nric = appointmentComponents[2];
//        String doctorName = appointmentComponents[3];
//        Appointment appointment = new Appointment(date);
//        if (bookedStatus.equals("booked")) {
//            appointment.bookUser(Rex.getUsers().getUserFromNric(nric));
//        }
//        if (doctorName != null && !doctorName.equals("null")) {
//            appointment.setDoctor(Rex.getDoctors().getDoctorFromName(doctorName));
//        }
//        return appointment;
//    }

//    /**
//     * Reads and parse command.
//     *
//     * @param fullCommand Input string.
//     * @return Command to be ran.
//     * @throws RexException if command does not exist.
//     */
//    public static Command parse(String fullCommand) throws RexException {
//        assert fullCommand != null && !fullCommand.equals("") : "No command to parse!";
//
//        String trimmedCommand = fullCommand.trim().toLowerCase();
//        Command command;
//        String[] words = trimmedCommand.split(" ");
//        switch (words[0]) {
//            case ExitCommand.COMMAND_WORD:
//                command = new ExitCommand();
//                break;
//            case AddCommand.COMMAND_WORD:
//                command = new AddCommand(trimmedCommand);
//                break;
//            case BookCommand.COMMAND_WORD:
//                command = new BookCommand(trimmedCommand);
//                break;
//            case CreateAppointmentCommand.COMMAND_WORD:
//                command = new CreateAppointmentCommand();
//                break;
//            case EditCommand.COMMAND_WORD:
//                command = new EditCommand(trimmedCommand);
//                break;
//            case DeleteCommand.COMMAND_WORD:
//                command = new DeleteCommand(trimmedCommand);
//                break;
//            case ListAppointmentsCommand.COMMAND_WORD:
//                command = new ListAppointmentsCommand(trimmedCommand);
//                break;
//            case ListUsersCommand.COMMAND_WORD:
//                command = new ListUsersCommand();
//                break;
//            case RetrieveCommand.COMMAND_WORD:
//                command = new RetrieveCommand(trimmedCommand);
//                break;
//            case AddDoctorCommand.COMMAND_WORD:
//                command = new AddDoctorCommand(trimmedCommand);
//                break;
//            case RemoveDoctorCommand.COMMAND_WORD:
//                command = new RemoveDoctorCommand(trimmedCommand);
//                break;
//
//            case EditAppointmentCommand.COMMAND_WORD:
//                command = new EditAppointmentCommand(trimmedCommand);
//                break;
//
//            default:
//                throw new RexException(Command.COMMAND_ERROR);
//        }
//        return command;
//    }
//
//
//    public static Doctor readDoctor(String line) {
//        assert line != null && !line.equals("") : "No doctors to read!";
//
//        String name = line.trim();
//        return new Doctor(name);
//    }
}
