import java.util.Scanner;

/**
 * Utility class handling User interface operations.
 */
public class Ui {
    private static final String LINE = "______________________________" +
            "__________________________";
    private static final String INDENT = "    ";
    private Scanner scanner;

    /**
     * Constructs a new instance of a Ui class, instantiating a scanner to read user inputs.
     */
    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Prints the welcome message.
     */
    public void showWelcome() {
        System.out.println(LINE + "____");
        System.out.println("Hello! I'm THE GROAD");
        System.out.println("      _     _   ");
        System.out.println("     (o\\~~~/o)  ");
        System.out.println("      \\_   _/   ");
        System.out.println("     (_     _)  ");
        System.out.println("       \\_._/   ");
        System.out.println("What can I do for you?");
        System.out.println(LINE + "____");
    }

    /**
     * Prints the goodbye message.
     */
    public void showGoodbye() {
        System.out.println(INDENT + LINE);
        System.out.println("    Bye. Hope to see you again soon!");
        System.out.println(INDENT + LINE);
    }

    /**
     * Reads the next line of the user's input and returns it as a string.
     * @return The User's input as a string.
     */
    public String readCommand() {
        return scanner.nextLine();
    }

    /**
     * Prints a line.
     */
    public static void printLine() {
        System.out.println(LINE);
    }

    /**
     * Prints a specified error message
     * @param message
     */
    public void printError(String message) {
        System.out.println(INDENT + "Error:" + message);
    }

    /**
     * Prints a specified message.
     * @param message
     */
    public static void printMessage(String message) {
        System.out.println(INDENT + message);
    }

    /**
     * Prints the standard message for when a Task gets marked as completed.
     *
     * @param taskNum The index of the Task that got marked as completed.
     * @param task The task that got marked as completed.
     */
    public static void printMarked(int taskNum, Task task) {
        printLine();
        printMessage("Nice! I've marked this task as done:");
        printMessage(taskNum + task.toString());
        printLine();
    }

    /**
     * Prints the standard message for when a task gets marked as uncompleted.
     *
     * @param taskNum The index of the task that got marked as uncompleted.
     * @param task The task that got marked as uncompleted.
     */
    public static void printUnmarked(int taskNum, Task task) {
        printLine();
        printMessage("Nice! I've marked this task as not done yet:");
        printMessage(taskNum + task.toString());
        printLine();
    }

    /**
     * Prints the standard message for when a task gets added to the taskList.
     *
     * @param taskNum The index of the task that just got added
     * @param task The task task that got added to the taskList.
     * @param taskCount The resultant number of tasks in the taskList post addition.
     */
    public static void printAddedTask(int taskNum, Task task, int taskCount) {
        printLine();
        printMessage("Got it. I've added this task:");
        printMessage(task.toString());
        printMessage("You now have " + taskCount + " tasks in the list.");
        printLine();
    }

    /**
     * Prints a standard message for when a task gets deleted from the taskList.
     *
     * @param taskNum The index of the task that got deleted.
     * @param task The task that got deleted.
     * @param taskCount The resultant number of tasks in the taskList post deletion.
     */
    public static void printDeleted(int taskNum, Task task, int taskCount) {
        printLine();
        printMessage("Noted. I've removed this task:");
        printMessage(task.toString());
        printMessage("You now have " + taskCount + " tasks in the list.");
        printLine();
    }
}
