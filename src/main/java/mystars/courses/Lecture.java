package mystars.courses;

import mystars.Student;

/**
 * The Lecture class extends CourseComponent abstract class.
 */
public class Lecture extends CourseComponent {
    // This Lecture class assumes there is only one Lecture group as it is normally
    // the case.

    private static final long serialVersionUID = 3026535502854716051L;

    /**
     * The constructor that creates a Lecture object.
     *
     * @param numberOfVacancies Number of vacancies for a lecture group.
     */
    public Lecture(int numberOfVacancies) {
        super("Lectures", 1);
        this.listOfIndexes.set(0, new Index(numberOfVacancies));
    }

    /**
     * This method is used to register a student under a lecture group.
     *
     * By default, the student is registered to the group indexed 0, since the
     * assumption is that there is only 1 lecture group.
     *
     * @param s           The student object.
     * @param indexNo The index number of the lecture group which the student
     *                    wants to register. This parameter is not used since there
     *                    is only 1 lecture group by default.
     * @return true upon successful registration, false otherwise.
     */
    @Override
    public boolean addStudent(Student s, int indexNo) {
        return this.listOfIndexes.get(0).addStudent(s);
        // Since only 1 lecture group is assumed, students are always added to group 1
        // which is at index 0.
    }

    /**
     * This method is used to check whether the lecture has vacancies.
     *
     * @return true if the lecture has vacancies, false otherwise.
     */
    @Override
    public boolean haveVacancies() {
        return !this.listOfIndexes.get(0).isFull();
    }

    /**
     * This method is used to print all students registered under the lecture.
     */
    @Override
    public void printStudentList() {
        System.out.println("+-----------------+---------------------------+");
        System.out.println("| Index           | Name                      |");
        System.out.println("+-----------------+---------------------------+");

        this.listOfIndexes.get(0).printStudentList("Lecture");
    }
}