import java.nio.channels.ScatteringByteChannel;
import java.util.Scanner;

public class TheGroad {
    public static void main(String[] args) {
        String INDENT = "    ";
        String MARKED = INDENT + "Nice! I've marked this task as done:";
        String UNMARKED = INDENT + "OK, I've marked this task as not done yet:";

        Ui ui = new Ui();
        ui.showWelcome();

        Scanner scanner = new Scanner(System.in);
        Task[] taskList = new Task[100];

        Storage storage = new Storage();
        int taskCount = storage.loadTasks(taskList);


        while (true) {
            String input = ui.readCommand();
            try {
                if (!(input.contains("Todo") | input.contains("Deadline") |
                        input.contains("bye") | input.contains("list") |
                        input.contains("mark") | input.contains("unmark")|
                        input.contains("Delete") | input.contains("Event"))) {
                    throw new TheGroadException("OOPS!! Sorry, but I don't know what that means :-(");
                }
            } catch (TheGroadException e) {
                ui.printError(INDENT + e.getMessage());
                continue ;
            }

            try {
                check_Description(input);
            } catch (TheGroadException e) {
                ui.printError(INDENT + e.getMessage());
                continue;
            }

            String[] inputParts = input.split(" ", 2);

            if (input.equals("bye")) {
                ui.showGoodbye();
                break;
            }
            try {
                    ui.printLine();
                if (input.equals("list")) {
                    System.out.println(INDENT + "Here are your tasks:");

                    if (taskCount == 0) {
                        System.out.println(INDENT + "No tasks available.");  // 🔹 Show message if empty
                    } else {
                        for (int i = 0; i < taskCount; i++) {
                            System.out.println(INDENT + (i + 1) + ". " + taskList[i]);
                        }
                    }
                    ui.printLine();
                } else if (inputParts[0].equals("mark")) {
                    int taskNum = Integer.parseInt(inputParts[1]) - 1;

                    check_Exists(taskNum, taskCount );
                    check_Markable(taskList[taskNum].isDone);

                    taskList[taskNum].MarkAsDone();
                    storage.saveTasks(taskList, taskCount);

                    ui.printMessage(MARKED);
                    System.out.println(INDENT + taskList[taskNum]);
                    ui.printLine();
                } else if (inputParts[0].equals("unmark")) {
                    int taskNum = Integer.parseInt(inputParts[1]) - 1;

                    check_Exists(taskNum, taskCount);
                    check_Unmarkable(taskList[taskNum].isDone);

                    taskList[taskNum].UnmarkAsDone();
                    storage.saveTasks(taskList, taskCount);

                    ui.printMessage(UNMARKED);
                    ui.printMessage(INDENT + taskList[taskNum]);
                    ui.printLine();
                } else if (inputParts[0].contains("Todo")) {
                    taskList[taskCount] = Todo.of(inputParts[1]);
                    ui.printLine();
                    ui.printMessage(INDENT + "Got it. I've added this task: ");
                    taskCount += 1;

                    storage.saveTasks(taskList, taskCount);

                    ui.printMessage(INDENT + taskList[taskCount - 1]);
                    ui.printMessage(INDENT + "You now have " + taskCount + " tasks in the list.");
                    ui.printLine();
                } else if (inputParts[0].contains("Deadline")) {
                    String[] deadlineParts = inputParts[1].split("/by", 2);
                    taskList[taskCount] = new Deadline(deadlineParts[0].trim(), deadlineParts[1].trim());
                    ui.printLine();
                    ui.printMessage(INDENT + "Got it. I've added this task: ");
                    taskCount += 1;

                    storage.saveTasks(taskList, taskCount);

                    ui.printMessage(INDENT + taskList[taskCount - 1]);
                    ui.printMessage(INDENT + "You now have " + taskCount + " tasks in the list.");
                    ui.printLine();
                } else if (inputParts[0].contains("Delete")) {
                    int taskNum = Integer.parseInt(inputParts[1]);
                    check_Exists(taskNum, taskCount);
                    taskCount -= 1;
                    System.out.println("Noted. I've removed this task");
                    System.out.println(INDENT + taskList[taskNum - 1]);
                    System.out.println("Now you have " + taskCount + " tasks in the list.");
                    for (int i = taskNum - 1 ; i < taskCount ; i += 1)
                    {
                        taskList[i] = taskList[i + 1];
                    }

                    storage.saveTasks(taskList, taskCount);

                    ui.printLine();
                } else {
                    taskList[taskCount] = Event.of(inputParts[1]);
                    ui.printLine();
                    ui.printMessage(INDENT + "Got it. I've added this task: ");
                    taskCount += 1;

                    storage.saveTasks(taskList, taskCount);

                    ui.printMessage(INDENT + taskList[taskCount - 1]);
                    ui.printMessage(INDENT + "You now have " + taskCount + " tasks in the list.");
                    ui.printLine();
                }
            } catch (Exception e) {
                ui.printError(INDENT + e.getMessage());
            }
        }
    }

    static void check_taskCount(int taskCount) throws TheGroadException{
        if (taskCount == 0) {
            throw new TheGroadException("OOPS!! There are no tasks currently!");
        }
    }

    static void check_Exists(int taskNum, int taskCount) throws TheGroadException{
        if (taskNum > taskCount) {
            throw new TheGroadException("OOPS!! That task does not exist!");
        }
    }

    static void check_Unmarkable(boolean is_marked ) throws TheGroadException{
        if(!is_marked){
            throw new TheGroadException("OOPS!! That task is already unmarked!");
        }
    }

    static void check_Markable(boolean is_marked ) throws TheGroadException{
        if(is_marked){
            throw new TheGroadException("OOPS!! That task is already marked!");
        }
    }

    static void check_Description(String input ) throws TheGroadException{
        if (!input.contains(" ") && (input.contains("Todo") | input.contains("Deadline") |
                input.contains("Event"))) {
            throw new TheGroadException("OOPS!! The description for the task cannot be empty!");
        }
    }
}

