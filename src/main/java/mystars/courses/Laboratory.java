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
    public boolean haveVacancies() {
        boolean bn = false;
        for (Index g : this.listOfIndex) {
            bn |= (!g.isFull());
        }
        return bn;
    }

}
