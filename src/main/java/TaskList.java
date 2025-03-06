public class TaskList {
    private Task[] tasks;
    private int taskCount;
    String INDENT = "    ";

    public TaskList() {
        this.tasks = new Task[100];
        this.taskCount = 0;
    }

    public void addTask(Task task) {
        tasks[taskCount] = task;
        taskCount += 1;
        Ui.printAddedTask(taskCount - 1, task, taskCount);
    }

    public void addTaskSilent(Task task) {
        tasks[taskCount] = task;
        taskCount += 1;
    }

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

    public int getTaskCount() {
        return taskCount;
    }
}
