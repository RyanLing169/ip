/**
 * Utility class for parsing operations
 */

public class Parser {

    /**
     * Parses the command from the user into specified enums for better processing.
     *
     * @param input The user input.
     * @return The specified enum for the command input by user for classification of user's intention.
     * @throws TheGroadException If the input command is unrecognisable.
     */
    public static CommandType parseCommand(String input) throws TheGroadException {
        String[] inputParts = input.split(" ", 2);
        String command = inputParts[0].toLowerCase();

        switch (command) {
        case "list":
            return CommandType.LIST;
        case "mark":
            return CommandType.MARK;
        case "unmark":
            return CommandType.UNMARK;
        case "todo":
            return CommandType.TODO;
        case "deadline":
            return CommandType.DEADLINE;
        case "event":
            return CommandType.EVENT;
        case "delete":
            return CommandType.DELETE;
        case "bye":
            return CommandType.BYE;
        case "find":
            return CommandType.FIND;
        default:
            throw new TheGroadException("OOPS!! Sorry, but I don't know what that means :-(");
        }
    }

    /**
     * Extracts an integer representing the required task number from the specified input.
     *
     * @param input The input from the user containing the task number that they wish to perform
     *              an action on.
     * @return The specified task number as an integer.
     * @throws TheGroadException If the task number is missing or invalid.
     */
    public static int extractTaskNumber(String input) throws TheGroadException {
        try {
            String[] inputParts = input.split(" ", 2);
            return Integer.parseInt(inputParts[1].trim()) ;
        } catch (Exception e) {
            throw new TheGroadException("OOPS!! Please provide a valid task number :(");
        }
    }

    /**
     * Extracts a string representing the description of a certain task from the specified input.
     *
     * @param input The input from the user containing the description for the task they wish to add.
     * @return The specified task description as a string.
     * @throws TheGroadException If the task description is missing.
     */
    public static String extractDescription(String input) throws TheGroadException {
        String[] inputParts = input.split(" ", 2);
        if (inputParts.length < 2 || inputParts[1].trim().isEmpty()) {
            throw new TheGroadException("OOPS! The description for the task cannot be empty :(");
        }
          return inputParts[1].trim();
    }

    /**
     * Extracts the strings representing the description of the deadline and the due date of the deadline.
     *
     * @param input The portion of the input from the user containing the description and details of the deadline.
     * @return An array of strings, containing the description of the deadline and the due date.
     * @throws TheGroadException If the description or due date is missing.
     */
    public static String[] extractDeadlineDetails(String input) throws TheGroadException {
        String description = extractDescription(input);
        String[] deadlineParts = description.split("/by", 2);
        if (deadlineParts.length < 2 || deadlineParts[1].trim().isEmpty()) {
            throw new TheGroadException("OOPS! The Task's deadline cannot be  empty!");
        }
        return new String[]{deadlineParts[0].trim(), deadlineParts[1].trim()};
    }

    /**
     * Extracts the strings representing the description of the event, the start date/time of the Event and the
     * ending date/time of the Event.
     *
     * @param input The portion of the input from the user containing the description and details of the Event.
     * @return An array of strings, containing the description of the Event and the starting and ending date/times.
     * @throws TheGroadException If the description or starting/ending date/times is missing.
     */
    public static String[] extractEventDetails(String input) throws TheGroadException {
        String description = extractDescription(input);
        String[] eventParts = description.split("/from", 2);

        if(eventParts.length < 2 || eventParts[1].trim().isEmpty()) {
            throw new TheGroadException("OOPS! The from portion of the event is missing or incomplete!");
        }

        String[] fromToParts = eventParts[1].split("/to", 2);
        if (fromToParts.length <2 || fromToParts[1].trim().isEmpty()) {
            throw new TheGroadException("OOPS! The to portion of the event is missing or incomplete!");
        }
        return new String[] {eventParts[0].trim(), fromToParts[0].trim(), fromToParts[1].trim()};
    }
}
