public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void MarkAsDone() {
        this.isDone = true;
    }

    public void UnmarkAsDone() {
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }


    public String toString() {
        return "[" + getStatusIcon() + "]" + " " + description;
    }

    public String toFileFormat() {
        return "T | " + (isDone ? "1" : "0") + " | " + description;
    }
}



