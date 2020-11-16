package mystars.courses;

import mystars.Student;

public class Laboratory {
    private static final long serialVersionUID = 25;

    /**
     * Constructor to create a Laboratory object.
     *
     * @param numberOfIndexes number of Indexes of a lab
     * @param slotsPerIndex  number of total slots per lab Index
     */
    public Laboratory(int numberOfIndexes, int slotsPerIndexes) {
        super("Laboratory", numberOfIndexes);
        for (int i = 0; i < numberOfIndexes; i++) {
            this.listOfIndexes.set(i, new Index(slotsPerIndex));
        }
    }

    /**
     * This method is used to register a student under a lab index.
     *
     * @param s           The student object.
     * @param IndexNumber The index number of the lab index which the student
     *                    wants to register.
     * @return true upon successful registration, false otherwise.
     */
    @Override
    public boolean registerStudent(Student s, int IndexNumber) {
        return this.listOfIndexes.get(IndexNumber - 1).registerStudent(s);
    }

    /**
     * This method is used to check whether the lab indexes have vacancies.
     *
     * @return true if the any of the lab index has vacancies, false if none of
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
     * lab index.
     */
    @Override
    public void printStudentList() {
        System.out.println("+-----------------+---------------------------+");
        System.out.println("| Index           | Name                      |");
        System.out.println("+-----------------+---------------------------+");
        for (int i = 0; i < this.getNumberOfIndexes(); i++) {
            this.listOfIndexes.get(i).printStudentList("Lab Grp " + String.valueOf(i + 1));
        }
    }
}
