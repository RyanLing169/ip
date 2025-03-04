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

    public void printLine() {
        System.out.println(LINE);
    }
    public void printError(String message) {
        System.out.println(INDENT + "Error:" + message);
    }

    public void printMessage(String message) {
        System.out.println(INDENT + message);
    }
}
