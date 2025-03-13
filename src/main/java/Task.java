/**
 * Represents a task to be completed by the user. A <code>Task</code> object corresponds to
 * a description represented by a string and a state of whether it is done represented
 * by a boolean e.g, <code>homework,false</code>
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructs an instance of the Task class with the specified description.
     *
     * @param description The details on what the task entails.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Changes the boolean state representing whether the task has been completed to true.
     */
    public void MarkAsDone() {
        this.isDone = true;
    }

    /**
     * Changes the boolean state representing the completion status of the specified task to false.
     */
    public void UnmarkAsDone() {
        this.isDone = false;
    }

    /**
     * Provides the printable status icon representing completion status of the specified task.
     *
     * @return The respective status icon depending on whether the specified task has been completed.
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    /**
     * Provides the specified task in the printing format.
     *
     * @return The task in printing format.
     */
    public String toString() {
        return "[" + getStatusIcon() + "]" + " " + description;
    }

    /**
     * Provides the specified task in the saving/file format.
     *
     * @return The task in saving/file format.
     */
    public String toFileFormat() {
        return "T | " + (isDone ? "1" : "0") + " | " + description;
    }
}



