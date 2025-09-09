import java.util.Scanner;
import java.util.ArrayList;

public class Sugon {
    public static void main(String[] args) {
        String chatName = "Sugon";
        System.out.println("____________________________________________________________");
        System.out.println(" Hello! I'm " + chatName);
        System.out.println(" What can I do for you?");
        System.out.println("____________________________________________________________");
        Scanner s = new Scanner(System.in);
        ArrayList<Task> list_of_Tasks = new ArrayList<>();
        boolean isRunning = true;

        while (isRunning) {
            String line = s.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println("____________________________________________________________");
                System.out.println("Sugon needs a command.");
                System.out.println("____________________________________________________________");
                break;
            }
            String[] words = line.split(" ", 2);
            String first_word = words[0].toLowerCase();

            switch (first_word) {
            case "bye":
                isRunning = false;
                System.out.println("____________________________________________________________");
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println("____________________________________________________________");
                break;
            case "list":
                System.out.println("____________________________________________________________");
                for (int i = 0; i < list_of_Tasks.size(); i++){
                    Task t = list_of_Tasks.get(i);
                    System.out.println((i + 1) + "." + t.toString()); // Polymorphism, where child class able to perform same method call as parent
                }
                System.out.println("____________________________________________________________");
                break;
            case "mark":
            case "unmark":
                if (words.length < 2) {
                System.out.println("____________________________________________________________");
                System.out.println("Sugon needs your task number to " + first_word + ".");
                System.out.println("____________________________________________________________");
                break;
                }
                int idx = Integer.parseInt(line.split(" ")[1]) - 1;
                if (idx < 0 || idx >= list_of_Tasks.size()) {
                    System.out.println("____________________________________________________________");
                    System.out.println("Invalid task number.");
                    System.out.println("____________________________________________________________");
                    break;
                }
                // condition that sets isDone to True or False based on first_word string
                list_of_Tasks.get(idx).isDone = first_word.equals("mark");
                System.out.println("____________________________________________________________");
                System.out.println((first_word.equals("mark") ? "Marked" : "Unmarked") + " task " + (idx + 1) + " as done:");
                System.out.println(list_of_Tasks.get(idx).toString());
                System.out.println("____________________________________________________________");
                break;

            case "todo":
            case "deadline":
            case "event":
                if (words.length < 2 || words[1].trim().isEmpty()) {
                    System.out.println("____________________________________________________________");
                    System.out.println("Sugon Demands a description after your silly command");
                    System.out.println("____________________________________________________________");
                    break;
                }

                String actual_task = words[1].trim();
                Task newTask;
                // As ToDo, Event and Deadline are childs of Task, we can add new instances into the Task Array created
                try {
                    if (first_word.equals("todo")) {
                        newTask = new ToDo(actual_task);
                    } else if (first_word.equals("deadline")) {
                        String[] parts = actual_task.split("/", 2);
                        actual_task = parts[0].trim();
                        String deadline_date = parts[1].replaceFirst("by", "").trim();
                        newTask = new Deadline(actual_task, deadline_date);
                    } else {
                        String[] parts = actual_task.split("/", 3);
                        actual_task = parts[0].trim();
                        String startTime = parts[1].replaceFirst("from", "").trim();
                        String endTime = parts[2].replaceFirst("to", "").trim();
                        newTask = new Event(actual_task, startTime, endTime);
                    } 
                } catch (Exception e) {
                    System.out.println("____________________________________________________________");
                    System.out.println("Invalid format for " + first_word + ". Sugon suggests you double check your input formatting properly.");
                    System.out.println("____________________________________________________________");
                    continue;
                }

                list_of_Tasks.add(newTask);
                System.out.println("____________________________________________________________");
                System.out.println("Got it. I've added this task: ");
                System.out.println("    " + newTask.toString());
                System.out.println("Now you have " + list_of_Tasks.size() +
                        (list_of_Tasks.size() == 1 ? " task" : " tasks") + " in the list.");
                System.out.println("____________________________________________________________");
                break;

            default:
                System.out.println("____________________________________________________________");
                System.out.println("Sorry your command is beyond Sugon's Dictionary");
                System.out.println("____________________________________________________________");
                break;
            }
        }
    }
}
