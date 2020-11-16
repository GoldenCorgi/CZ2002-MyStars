package mystars.courses;

import mystars.Student;

public class Laboratory extends CourseComponent {
    private static final long serialVersionUID = 25;

    public Laboratory(int numberOfIndexes, int slotsPerIndex) {
        super("Laboratory", numberOfIndexes);
        for (int i = 0; i < numberOfIndexes; i++) {
            this.listOfIndex.set(i, new Index(slotsPerIndex));
        }
    }

    @Override
    public boolean registerStudent(Student s, int indexNumber) {
        return this.listOfIndex.get(indexNumber - 1).addStudent(s);
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
