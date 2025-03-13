/**
 * Exception thrown when inputs are invalid or missing.
 */

public class TheGroadException extends Exception {

    /**
     * Constructs a TheGroadException with a specified message.
     *
     * @param error_Message The detailed error message to be diaplyed
     *                      to the user.
     */
    public TheGroadException(String error_Message) {
        super(error_Message);
    }

}
