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

        while (true) {
            String line = s.nextLine();
            String first_word = line.split(" ")[0].toLowerCase();
            if (first_word.equals("bye")){
                break;
            } else if (line.equals("list")){
                System.out.println("____________________________________________________________");
                for (int i = 0; i < list_of_Tasks.size(); i++){
                    Task t = list_of_Tasks.get(i);
                    System.out.println((i + 1) + "." + t.toString()); // Polymorphism, where child class able to perform same method call as parent
                }
                System.out.println("____________________________________________________________");

            } else if (first_word.equals("mark")) {
                int idx = Integer.parseInt(line.split(" ")[1]) - 1;
                if (idx >= 0 && idx < list_of_Tasks.size()) {
                    list_of_Tasks.get(idx).isDone = true;
                    System.out.println("____________________________________________________________");
                    System.out.println("Marked task " + (idx + 1) + " as done:");
                    // System.out.println("[" + list_of_Tasks.get(idx).getStatusIcon() + "] " + list_of_Tasks.get(idx).description);
                    System.out.println(list_of_Tasks.get(idx).toString());
                    System.out.println("____________________________________________________________");
                }
            } else if (first_word.equals("unmark")) {
                int idx = Integer.parseInt(line.split(" ")[1]) - 1;
                if (idx >= 0 && idx < list_of_Tasks.size()) {
                    list_of_Tasks.get(idx).isDone = false;
                    System.out.println("____________________________________________________________");
                    System.out.println("Unmarked task " + (idx + 1) + " as done.");
                    // System.out.println("[" + list_of_Tasks.get(idx).getStatusIcon() + "] " + list_of_Tasks.get(idx).description);
                    System.out.println(list_of_Tasks.get(idx).toString());
                    System.out.println("____________________________________________________________");
                }
            } else {
                // extract the first word and remove it
                int firstSpaceIndex = line.indexOf(" ");
                String actual_task = line.substring(firstSpaceIndex + 1).trim();

                System.out.println("____________________________________________________________");
                System.out.println("Got it. I've added this task: ");

                Task newTask;

                // As ToDo, Event and Deadline are childs of Task, we can add new instances into the Task Array created
                if (first_word.equals("todo")) {
                    newTask = new ToDo(actual_task);
                }
                else if (first_word.equals("deadline")) {
                    String[] parts = actual_task.split("/");
                    actual_task = parts[0];

                    String deadline_date = parts[1].trim();
                    firstSpaceIndex = deadline_date.indexOf(" ");
                    deadline_date = deadline_date.substring(firstSpaceIndex + 1).trim();

                    newTask = new Deadline(actual_task, deadline_date);
                }
                else if (first_word.equals("event")) {
                    String[] parts = actual_task.split("/");
                    actual_task = parts[0];

                    String startTime = parts[1].trim();
                    firstSpaceIndex = startTime.indexOf(" ");
                    startTime = startTime.substring(firstSpaceIndex + 1);

                    String endTime = parts[2].trim();
                    firstSpaceIndex = endTime.indexOf(" ");
                    endTime = endTime.substring(firstSpaceIndex + 1);
                    newTask = new Event(actual_task, startTime, endTime);
                }
                else {
                    newTask = new Task(actual_task);
                }

                list_of_Tasks.add(newTask);

                System.out.println("    " + newTask.toString());

                System.out.println("Now you have " + list_of_Tasks.size() + 
                                            (list_of_Tasks.size() == 1 ? " task" : " tasks") + " in the list.");
                System.out.println("____________________________________________________________");
            }
        }

        System.out.println("____________________________________________________________");
        System.out.println(" Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }
}
