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
                    System.out.println(taskList[i]);
                }

                System.out.println(INDENT + LINE);

            } else if (inputParts[0].equals("mark")) {
                int taskNum = Integer.parseInt(inputParts[1]);
                taskList[taskNum - 1].MarkAsDone();
                System.out.println(INDENT + LINE + "\n" + MARKED);
                System.out.println(INDENT + taskList[taskNum - 1]);
                System.out.println(INDENT + LINE);
            } else if (inputParts[0].equals("unmark")) {
                int taskNum = Integer.parseInt(inputParts[1]);
                taskList[taskNum - 1].UnmarkAsDone();
                System.out.println(INDENT + LINE + "\n" + UNMARKED);
                System.out.println(INDENT + taskList[taskNum - 1]);
                System.out.println(INDENT + LINE);
            } else if (inputParts[0].contains("Todo")) {
                taskList[taskCount] = new Todo(inputParts[1]);
                System.out.println(INDENT + LINE + "\n" + INDENT + "Got it. I've added this task: " );
                taskCount += 1;
                System.out.println(INDENT + taskList[taskCount - 1]);
                System.out.println(INDENT + "You now have " + taskCount + " tasks in the list."
                        + "\n" + INDENT + LINE);
            } else if (inputParts[0].contains("Deadline")) {
                String[] deadlineParts = inputParts[1].split("/by", 2);
                taskList[taskCount] = new Deadline(deadlineParts[0].trim(), deadlineParts[1].trim());
                System.out.println(INDENT + LINE + "\n" + INDENT + "Got it. I've added this task: " );
                taskCount += 1;
                System.out.println(INDENT + taskList[taskCount - 1]);
                System.out.println(INDENT + "You now have " + taskCount + " tasks in the list."
                        + "\n" + INDENT + LINE);
            } else {
                String[] eventPartsFrom = inputParts[1].split("/from");
                String[] eventPartsTo = eventPartsFrom[1].split("/to");
                taskList[taskCount] = new Event(eventPartsFrom[0].trim(), eventPartsTo[0].trim(), eventPartsTo[1].trim());
                System.out.println(INDENT + LINE + "\n" + INDENT + "Got it. I've added this task: ");
                taskCount += 1;
                System.out.println(INDENT + taskList[taskCount - 1]);
                System.out.println(INDENT + "You now have " + taskCount + " tasks in the list."
                        + "\n" + INDENT + LINE);
            }
        }

    }
}
