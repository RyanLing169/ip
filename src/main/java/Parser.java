public class Parser {
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

    public static int extractTaskNumber(String input) throws TheGroadException {
        try {
            String[] inputParts = input.split(" ", 2);
            return Integer.parseInt(inputParts[1].trim()) ;
        } catch (Exception e) {
            throw new TheGroadException("OOPS!! Please provide a valid task number :(");
        }
    }

    public static String extractDescription(String input) throws TheGroadException {
        String[] inputParts = input.split(" ", 2);
        if (inputParts.length < 2 || inputParts[1].trim().isEmpty()) {
            throw new TheGroadException("OOPS! The description for the task cannot be empty :(");
        }
          return inputParts[1].trim();
    }

    public static String[] extractDeadlineDetails(String input) throws TheGroadException {
        String description = extractDescription(input);
        String[] deadlineParts = description.split("/by", 2);
        if (deadlineParts.length < 2 || deadlineParts[1].trim().isEmpty()) {
            throw new TheGroadException("OOPS! The Task's deadline cannot be  empty!");
        }
        return new String[]{deadlineParts[0].trim(), deadlineParts[1].trim()};
    }

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
