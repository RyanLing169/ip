import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a storage class responsible for saving and loading the task list into a .txt document.
 */
public class Storage {
    private static final String FILE_PATH = "./data/TheGroad.txt";
    private static final int MAX_TASKS = 100;

    /**
     * Checks if the .txt  file exist and creates a new .txt file if there one does not
     * already exist.
     */
    public Storage() {
        ensureFileExists();
    }

    private void ensureFileExists() {
        File file = new File(FILE_PATH);
        File folder = file.getParentFile();
        try {
            if (folder != null && !folder.exists()) {
                folder.mkdirs(); // Create folder if missing
            }
            if (!file.exists()) {
                file.createNewFile(); // Create file if missing
            }
        } catch (IOException e) {
            System.out.println("Error creating save file: " + e.getMessage());
        }
    }

    /**
     * Saves the existing tasklist to the .txt document for future reference.
     * @param taskList The current working tasklist containing all added tasks the user wishes to save.
     * @param taskCount The number of tasks in the task list.
     */
    public void saveTasks(Task[] taskList, int taskCount) {
        try  (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))){
            for (int i = 0; i < taskCount; i++) { // Only save valid tasks
                writer.write(taskList[i].toFileFormat());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    /**
     * Extracts and loads the saved tasks into an instance of the TaskList class from the .txt file.
     *
     * @param taskList The instance of TaskList we load the saved tasks into.
     * @return the number of tasks saved and in the .txt file and hence loaded into the TaskList class.
     */
    public int loadTasks(TaskList taskList) {
        int taskCount = 0;
        try  (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))){
            String line;
            while ((line = reader.readLine()) != null && taskCount < MAX_TASKS) {
                Task task = parseTask(line);
                if (task != null) {
                    taskList.addTaskSilent(task);
                    taskCount++;
                }
            }
        } catch (IOException e) {
            System.out.println("No previous task list found. Starting fresh!");
        }
        return taskCount;
    }

    /**
     * parses the task saved in the .txt file to be added to the taskList.
     *
     * @param line The line in the .txt file that represents the saved task to be added
     *             back to the taskList.
     * @return The saved task converted into an instance of the Task class.
     */
    private Task parseTask(String line) {
        try {
            String[] parts = line.split(" \\| ");
            String type = parts[0];
            boolean isDone = parts[1].equals("1");
            String description = parts[2];

            Task task;
            if (type.equals("T")) {
                task = new Todo(description);
            } else if (type.equals("D")) {
                task = new Deadline(description, LocalDate.parse(parts[3]));
            } else if (type.equals("E")) {
                task = new Event(description, parts[3], parts[4]);
            } else {
                return null; // Invalid format
            }

            if (isDone) {
                task.MarkAsDone();
            }
            return task;
        } catch (Exception e) {
            System.out.println("Error parsing task: " + line);
            return null;
        }
    }
}
