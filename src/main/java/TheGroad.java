import java.util.Scanner;

public class TheGroad {
    public static void main(String[] args) {
        String LINE = "______________________________" +
                "__________________________" ;
        String GREETING = LINE + "____\n"+
                "Hello! I'm THE GROAD \n" +
                "What can I do for you?\n" +
                LINE + "____";
        String BYE = "    Bye. Hope to see you again soon!\n";
        String INDENT = "    ";
        String MARKED = INDENT + "Nice! I've marked this task as done:";
        String UNMARKED = INDENT + "OK, I've marked this task as not done yet:";

        System.out.println(GREETING);

        Scanner scanner = new Scanner(System.in);
        Task[] taskList = new Task[100];
        int taskCount = 0;

        while (true) {
            String input = scanner.nextLine();
            String[] inputParts = input.split(" ", 2);

            if (input.equals("bye")) {
                System.out.println(INDENT + LINE +"\n" + BYE + INDENT + LINE);
                break;
            }
            if (input.equals("list")) {
                System.out.println(INDENT + LINE);
                for (int i = 0 ; i < taskCount ; i += 1) {
                    System.out.print(INDENT + (i + 1) + ". ");
                    System.out.println("[" + taskList[i].getStatusIcon() + "] "
                            + taskList[i].description);
                }
                System.out.println(INDENT + LINE);
            } else if (inputParts[0].equals("mark")) {
                int taskNum = Integer.parseInt(inputParts[1]);
                taskList[taskNum - 1].MarkAsDone();
                System.out.println(INDENT + LINE + "\n" + MARKED);
                System.out.println(INDENT + "[X] " + taskList[taskNum - 1].description);
            } else if (inputParts[0].equals("unmark")) {
                int taskNum = Integer.parseInt(inputParts[1]);
                taskList[taskNum - 1].UnmarkAsDone();
                System.out.println(INDENT + LINE + "\n" + UNMARKED);
                System.out.println(INDENT + "[ ] " + taskList[taskNum - 1].description);
            } else {
                System.out.println(INDENT + LINE + "\n" + INDENT + "added: " + input + "\n" + INDENT + LINE);
                taskList[taskCount] = new Task(input);
                taskCount += 1;
            }
        }

    }
}
