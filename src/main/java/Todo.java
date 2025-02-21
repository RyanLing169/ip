public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    public static Todo of(String inputPart) throws TheGroadException {
        if ( inputPart.isEmpty())
        {
            throw new TheGroadException("OOPS!! The description of a todo cannot be empty.");
        }
        return new Todo(inputPart);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}

