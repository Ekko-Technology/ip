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
            if (line.equals("bye")){
                break;
            } else if (line.equals("list")){
                System.out.println("____________________________________________________________");
                for (int i = 0; i < list_of_Tasks.size(); i++){
                    Task t = list_of_Tasks.get(i);
                    System.out.println((i + 1) + ". [" + t.getStatusIcon() + "] " + t.description);
                }
                System.out.println("____________________________________________________________");

            } else if (line.startsWith("mark ")) {
                int idx = Integer.parseInt(line.split(" ")[1]) - 1;
                if (idx >= 0 && idx < list_of_Tasks.size()) {
                    list_of_Tasks.get(idx).isDone = true;
                    System.out.println("____________________________________________________________");
                    System.out.println("Marked task " + (idx + 1) + " as done:");
                    System.out.println("[" + list_of_Tasks.get(idx).getStatusIcon() + "] " + list_of_Tasks.get(idx).description);
                    System.out.println("____________________________________________________________");
                }
            } else if (line.startsWith("unmark ")) {
                int idx = Integer.parseInt(line.split(" ")[1]) - 1;
                if (idx >= 0 && idx < list_of_Tasks.size()) {
                    list_of_Tasks.get(idx).isDone = false;
                    System.out.println("____________________________________________________________");
                    System.out.println("Unmarked task " + (idx + 1) + " as done.");
                    System.out.println("[" + list_of_Tasks.get(idx).getStatusIcon() + "] " + list_of_Tasks.get(idx).description);
                    System.out.println("____________________________________________________________");
                }
            } else {
                list_of_Tasks.add(new Task(line));
                System.out.println("____________________________________________________________");
                System.out.println("Added: " + line);
                System.out.println("____________________________________________________________");
            }
        }

        System.out.println("____________________________________________________________");
        System.out.println(" Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }
}
