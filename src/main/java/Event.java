/**
 * Represents an Event type of the task class. An <code>Event</code> object corressponds
 * to a task represented by a start date/time and an ending date/time
 * e.g. <code>9pm, 6pm</code>
 *
 * Extends {@link Task} to provide additional functionality.
 */

public class Event extends Task {

    protected String from;
    protected String to;

    /**
     * Constructs an Event with a specified description, from and to date/time.
     *
     * @param description The details on what the event entails.
     * @param from The starting date/time of the event.
     * @param to The ending date/time of the event.
     */

    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    /**
     *  Creates a new instance of {@link Event}.
     *
     * @param inputParts_1 The neccessary portion of the user input used to create the instance.
     * @return A new instance of {@link Event}.
     * @throws TheGroadException If the neccesary inputs are missing or invalid.
     */
    public static Event of(String inputParts_1) throws TheGroadException {
        if (!inputParts_1.contains("/from")) {
            throw new TheGroadException("OOPS! The from portion of the EVENT cannot be empty!");
        }
        String[] eventPartsFrom = inputParts_1.split("/from");
        if (!eventPartsFrom[1].contains("/to")) {
            throw new TheGroadException("OOPS! The to portion of the EVENT cannot be empty!");
        }
        String[] eventPartsTo = eventPartsFrom[1].split("/to");
        return new Event(eventPartsFrom[0].trim(), eventPartsTo[0].trim(), eventPartsTo[1].trim());
    }

    /**
     * Converts the Event instance to printing format.
     *
     * @return The Event instance in printing format.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }

    /**
     * Converts the Event instance to saving/file format.
     *
     * @return The Event instance in saving/file format.
     */
    public String toFileFormat() {
        return "E | " + (isDone ? "1" : "0") + " | " + description + " | " + from + " | " + to;
    }
}

