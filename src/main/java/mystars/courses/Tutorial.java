package mystars.courses;
import mystars.Student;

import java.io.Serializable;

public class Tutorial extends CourseComponent{
    private static final long serialVersionUID = 22;

    /**
     * Constructor to create a Tutorial object.
     *
     * @param numberOfIndexes number of Indexes of a tutorial
     * @param slotsPerIndex  number of total slots per tutorial index
     */
    public Tutorial(int numberOfIndexes, int slotsPerIndex) {
        super("Tutorial", numberOfIndexes);
        for (int i = 0; i < numberOfIndexes; i++) {
            this.listOfIndexes.set(i, new Index(slotsPerIndex));
        }
    }

    /**
     * This method is used to register a student under a tutorial index.
     *
     * @param s           The student object.
     * @param indexNumber The index number of the tutorial index which the student
     *                    wants to register.
     * @return true upon successful registration, false otherwise.
     */
    @Override
    public boolean registerStudent(Student s, int indexNumber) {
        return this.listOfIndexes.get(indexNumber - 1).addStudent(s);
    }

    /**
     * This method is used to check whether the tutorial indexes have vacancies.
     *
     * @return true if the any of the tutorial indexes has vacancies, false if none of
     *         the index has vacancies.
     */
    @Override
    public boolean haveVacancies() {
        boolean bn = false;
        for (Index g : this.listOfIndexes) {
            bn |= (!g.isFull());
        }
        return bn;
    }

    /**
     * This method is used to print all students registered under the each of the
     * tutorial index.
     */
    @Override
    public void printStudentList() {
        System.out.println("+-----------------+---------------------------+");
        System.out.println("| Index           | Name                      |");
        System.out.println("+-----------------+---------------------------+");
        for (int i = 0; i < this.getNumberOfIndexes(); i++) {
            this.listOfIndexes.get(i).printStudentList("Tutorial Grp " + String.valueOf(i + 1));
        }
    }
}
