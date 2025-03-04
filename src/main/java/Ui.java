import java.util.Scanner;

public class Ui {
    private static final String LINE = "______________________________" +
            "__________________________";
    private static final String INDENT = "    ";
    private Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    public void showWelcome() {
        System.out.println(LINE + "____");
        System.out.println("Hello! I'm THE GROAD");
        System.out.println("What can I do for you?");
        System.out.println(LINE + "____");
    }

    public void showGoodbye() {
        System.out.println(INDENT + LINE);
        System.out.println("    Bye. Hope to see you again soon!");
        System.out.println(INDENT + LINE);
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public static void printLine() {
        System.out.println(LINE);
    }
    public void printError(String message) {
        System.out.println(INDENT + "Error:" + message);
    }

    public static void printMessage(String message) {
        System.out.println(INDENT + message);
    }

    public static void printMarked(int taskNum, Task task) {
        printLine();
        printMessage("Nice! I've marked this task as done:");
        printMessage(taskNum + task.toString());
        printLine();
    }

    public static void printUnmarked(int taskNum, Task task) {
        printLine();
        printMessage("Nice! I've marked this task as not done yet:");
        printMessage(taskNum + task.toString());
        printLine();
    }

    public static void printAddedTask(int taskNum, Task task, int taskCount) {
        printLine();
        printMessage("Got it. I've added this task:");
        printMessage(task.toString());
        printMessage("You now have " + taskCount + " tasks in the list.");
        printLine();
    }

    public static void printDeleted(int taskNum, Task task, int taskCount) {
        printLine();
        printMessage("Noted. I've removed this task:");
        printMessage(task.toString());
        printMessage("You now have " + taskCount + " tasks in the list.");
        printLine();
    }
}
