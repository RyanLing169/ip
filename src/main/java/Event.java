public class Event extends Task {

    protected String from;
    protected String to;



    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

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

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }

    public String toFileFormat() {
        return "E | " + (isDone ? "1" : "0") + " | " + description + " | " + from + " | " + to;
    }
}

