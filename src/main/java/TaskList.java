/**
 * Represents a fixed array of size 100 containing tasks. A <code>TaskList</code> object corresponds to
 * list of tasks represented by an array and a taskcount represented by an integer
 * e.g., <code>taskList[100],2</code>
 */

public class TaskList {
    private Task[] tasks;
    private int taskCount;
    String INDENT = "    ";

    /**
     * Constructs a new instance of the TaskList class.
     */
    public TaskList() {
        this.tasks = new Task[100];
        this.taskCount = 0;
    }

    /**
     * Adds a task to the specified taskList object.
     *
     * @param task The task to add to the taskList.
     */
    public void addTask(Task task) {
        tasks[taskCount] = task;
        taskCount += 1;
        Ui.printAddedTask(taskCount - 1, task, taskCount);
    }

    /**
     * Adds a task to the specified taskList object without printing anything to the user.
     *
     * @param task The task to add to the taskList.
     */
    public void addTaskSilent(Task task) {
        tasks[taskCount] = task;
        taskCount += 1;
    }

    /**
     * Deletes a task from the specified taskList.
     *
     * @param taskNum The index of the task to delete from the taskList
     * @throws TheGroadException If the task number is invalid,
     * meaning there is no task that posseses that index.
     */
    public void deleteTask(int taskNum) throws TheGroadException {
        if (taskNum <= 0 || taskNum > taskCount) {
            throw new TheGroadException("OOPS! This task does not exist");
        }

        Ui.printDeleted(taskNum, this.tasks[taskNum - 1], taskCount - 1);
        for (int i = taskNum - 1; i < taskCount - 1; i += 1) {
            tasks[i] = tasks[i + 1];
        }
        taskCount -= 1;
    }

    /**
     * Marks a specified task of a specified taskList as completed.
     *
     * @param taskNum The index of the task to be marked as completed.
     * @throws TheGroadException If the index is invalid, meaning the index does not
     * belong to any task in the specified taskList.
     */
    public void markTask(int taskNum) throws TheGroadException {
        if (taskNum < 1 || taskNum > taskCount ) {
            throw new TheGroadException("OOPS! That task does not exist!!");
        }
        if (tasks[taskNum - 1].isDone)
        {
            throw new TheGroadException("OOPS! That task has already been marked!");
        }
        tasks[taskNum - 1].MarkAsDone();
        Ui.printMarked(taskNum, this.tasks[taskNum - 1]);
    }

    /**
     * Marks a specified task of a specified taskList as uncompleted.
     *
     * @param taskNum The index of the task to be marked as uncompleted.
     * @throws TheGroadException If the index is invalid, meaning the index does not
     * belong to any task in the specified taskList.
     */
    public void unmarkTask(int taskNum) throws TheGroadException {
        if (taskNum < 1 || taskNum > taskCount ) {
            throw new TheGroadException("OOPS! That task does not exist!!");
        }
        if (!tasks[taskNum - 1].isDone)
        {
            throw new TheGroadException("OOPS! That task has not yet already unmarked!");
        }
        tasks[taskNum - 1].UnmarkAsDone();
        Ui.printUnmarked(taskNum, this.tasks[taskNum - 1]);
    }

    /**
     * Lists the tasks out to the user by printing each task in the taskList.
     *
     * @param ui The Ui class utilised by the parent class.
     */
    public void listTasks(Ui ui) {
        ui.printLine();
        ui.printMessage(INDENT + "Here are your tasks:");
        if (taskCount == 0) {
            ui.printMessage(INDENT + "No tasks available.");
        } else {
            for (int i = 0; i < taskCount; i += 1) {
                ui.printMessage(INDENT + (i + 1) + ". " + tasks[i]);
            }
        }
        ui.printLine();
    }


    /**
     * Returns the tasks in the taskList.
     *
     * @return The tasks in the taskList.
     */

    public void findTask(String keyword) {
        Ui.printLine();

        int count = 1;

        for (int i = 0 ; i < taskCount; i += 1) {
            if (tasks[i].description.contains(keyword)) {
                Ui.printMessage(INDENT + count + "." + tasks[i]);
                count += 1;
            } else if (count == 1 && i == taskCount - 1){
                Ui.printMessage(INDENT + "SORRY! No tasks contain the keyword :");
                Ui.printMessage(INDENT + keyword);
                Ui.printMessage(INDENT + ":-(");
            }
        }

        Ui.printLine();
    }


    public Task[] getTasks() {
        return tasks;
    }

    /**
     * Returns the number of tasks in the taskList.
     *
     * @return The number of tasks in the taskList.
     */
    public int getTaskCount() {
        return taskCount;
    }
}
