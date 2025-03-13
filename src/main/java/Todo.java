/**
 * Represents the Todo type of Task class. A <code>Todo</code> object corresponds to
 * a description represented by a string e.g., <code>Proposal</code>
 *
 * Extends {@link Task} to provide added functionality.
 */
public class Todo extends Task {

    /**
     * Constructs a new instance of the Todo task.
     *
     * @param description The description which entails details on the Todo Task.
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Creates a new instance of {@link Todo}.
     *
     * @param inputPart The user input.
     * @return A new instance of {@link Todo}.
     * @throws TheGroadException If the input is invalid or missing.
     */
    public static Todo of(String inputPart) throws TheGroadException {
        if ( inputPart.isEmpty())
        {
            throw new TheGroadException("OOPS!! The description of a todo cannot be empty.");
        }
        return new Todo(inputPart);
    }

    /**
     * Converts the Todo task to printing format.
     * @return The Todo task as a printable String.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * Converts the Todo task to saving/file format.
     *
     * @return The Todo task as a savable String.
     */
    public String toFileFormat() {
        return "T | " + (isDone ? "1" : "0") + " | " + description;
    }
}

