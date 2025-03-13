/**
 * Represents a deadline task. A <code>Deadline</code> object corresponds to a Task
 * represented by a description and a deadline the task is due by,
 * e.g<code>homework,by tonight</code>
 */

public class Deadline extends Task {

    protected String by;

    /**
     * Constructs a new instance of the Deadline class.
     *
     * @param description The information on what the task entails.
     * @param by The deadline for this Deadline task.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Converts the deadline task to the printing format.
     *
     * @return The Deadline in printing format.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    /**
     * Converts the deadline task to the saving/file format.
     *
     * @return The Deadline in saving/file format.
     */
    public String toFileFormat() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + by;
    }
}


