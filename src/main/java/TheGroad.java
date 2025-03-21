import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a chatbot designed to help users track different kinds of tasks.
 */
public class TheGroad {
    private Ui ui;              // Handles user interaction
    private Storage storage;    // Handles file storage
    private TaskList taskList;  // Manages task data
    private  Parser parser;      // Parses user input

    /**
     * Constructs a new instance of TheGroad class.
     *
     * @param filePath The location where the class will be instantiated.
     */
    public TheGroad(String filePath) {
        this.ui = new Ui();
        this.storage = new Storage();
        this.taskList = new TaskList();
        this.parser = new Parser();

        storage.loadTasks(taskList); // Load saved tasks from file
    }

    /**
     * Constantly loops to take in user input and output replies.
     */
    public void run() {
        ui.showWelcome();
        while (true) {
            String input = ui.readCommand();
            try {
                CommandType command = parser.parseCommand(input);
                processCommand(command, input);
            } catch (TheGroadException e) {
                ui.printError(e.getMessage());
            }
        }
    }

    /**
     * Processes all commands that the user inputs and executes them as instructed.
     *
     * @param command The enum classifying the command to be executed.
     * @param input The user's input.
     * @throws TheGroadException If the input is invalid or missing.
     */
    private void processCommand(CommandType command, String input) throws TheGroadException {
        switch (command) {
        case LIST:
            taskList.listTasks(ui);
            break;
        case MARK:
            int markIndex = parser.extractTaskNumber(input);
            taskList.markTask(markIndex);
            ui.printLine();
            storage.saveTasks(taskList.getTasks(), taskList.getTaskCount());
            break;
        case UNMARK:
            int unmarkIndex = parser.extractTaskNumber(input);
            taskList.unmarkTask(unmarkIndex);
            storage.saveTasks(taskList.getTasks(), taskList.getTaskCount());
            break;
        case TODO:
            String todoDescription = parser.extractDescription(input);
            taskList.addTask(new Todo(todoDescription));
            storage.saveTasks(taskList.getTasks(), taskList.getTaskCount());
            break;
        case DEADLINE:
            String[] deadlineDetails = parser.extractDeadlineDetails(input);
            taskList.addTask(new Deadline(deadlineDetails[0], LocalDate.parse(deadlineDetails[1])));
            storage.saveTasks(taskList.getTasks(), taskList.getTaskCount());
            break;
        case EVENT:
            String[] eventDetails = parser.extractEventDetails(input);
            taskList.addTask(new Event(eventDetails[0], eventDetails[1], eventDetails[2]));
            storage.saveTasks(taskList.getTasks(), taskList.getTaskCount());
            break;
        case DELETE:
            int deleteIndex = parser.extractTaskNumber(input);
            taskList.deleteTask(deleteIndex);
            storage.saveTasks(taskList.getTasks(), taskList.getTaskCount());
            break;
        case FIND:
            String keyword = parser.extractDescription(input);
            taskList.findTask(keyword);
            break;
        case BYE:
            ui.showGoodbye();
            System.exit(0);
            break;
        }
    }


    public static void main(String[] args) {
        new TheGroad("data/TheGroad.txt").run();
    }
}
