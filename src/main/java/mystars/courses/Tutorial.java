package mystars.courses;

public class Tutorial extends CourseComponent {
    private static final long serialVersionUID = 22;

    /**
     * Constructor to create a Tutorial object.
     *
     * @param numberOfIndexes number of Indexes of a tutorial
     * @param slotsPerIndex   number of total slots per tutorial index
     */
    public Tutorial(int numberOfIndexes, int slotsPerIndex) {
        super("Tutorial", numberOfIndexes);
        for (int i = 0; i < numberOfIndexes; i++) {
            this.listOfIndex.set(i, new Index(slotsPerIndex));
        }
    }

    @Override
    public boolean haveVacancies() {
        boolean bn = false;
        for (Index g : this.listOfIndex) {
            bn |= (!g.isFull());
        }
        return bn;
    }
}
