package mystars;

/**
 * Throws exceptions relating to myStars.
 */
public class StarsException extends Exception {

    private static final String OOPS = "Sorry! ";

    /**
     * Initializes message to throw.
     *
     * @param message Exception message to show.
     */
    public StarsException(String message) {
        super(OOPS + message);
    }
}
