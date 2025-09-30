import java.util.ArrayList;

public class Ui {

    public void showHelp() {
    sugonPrint(
        "Available commands:",
        "  list                        - Show all tasks",
        "  todo <desc>                - Add a ToDo task",
        "  deadline <desc> /by <date> - Add a Deadline",
        "  event <desc> /from <start> /to <end> - Add an Event",
        "  mark <num>                 - Mark a task as done",
        "  unmark <num>               - Unmark a task",
        "  delete <num>               - Delete a task",
        "  bye                        - Exit program",
        "  help                       - Show command message"
    );
}

    public void showLine() {
        System.out.println("____________________________________________________________");
    }

    private static void sugonPrint(String... messages) {
        System.out.println("____________________________________________________________");
        for (String msg : messages) {
            System.out.println(msg);
        }
        System.out.println("____________________________________________________________");
    }

    public void showError(String... errors) {
        StringBuilder sb = new StringBuilder();
        for (String e : errors) {
            sb.append(e).append(" ");
        }
        sugonPrint("Error: " + sb.toString().trim());
    }

    public void showWelcome() {
        sugonPrint("Hello! I'm Sugon", "What can I do for you?");
    }

    public void showGoodbye() {
        sugonPrint("Bye. Hope to see you again soon!");
    }

    public void showTaskList(ArrayList<Task> taskList) {
        showLine();
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println((i + 1) + "." + taskList.get(i));
        }
        showLine();
    }

    public void showTaskAdded(Task task, int totalTasks) {
        showLine();
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + totalTasks + 
            (totalTasks == 1 ? " task" : " tasks") + " in the list.");
        showLine();
    }

    public void showTaskRemoved(Task task, int totalTasks) {
        showLine();
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + totalTasks + 
            (totalTasks == 1 ? " task" : " tasks") + " in the list.");
        showLine();
    }

}
