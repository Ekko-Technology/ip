import java.util.Scanner;
import java.util.ArrayList;

public class Sugon {
    public static void main(String[] args) {
        String chatName = "Sugon";
        System.out.println("____________________________________________________________");
        System.out.println(" Hello! I'm " + chatName);
        System.out.println(" What can I do for you?");
        System.out.println("____________________________________________________________");
        String line;
        Scanner s = new Scanner(System.in);
        ArrayList<String> list_of_commands = new ArrayList<>();

        while (true) {
            line = s.nextLine();
            if (line.equals("bye"))
            {
                break;
            }
            else if (line.equals("list")){
                System.out.println("____________________________________________________________");
                for (int i = 0; i < list_of_commands.size(); i++){

                    System.out.println((i+1) + ". " + list_of_commands.get(i));
                }
                System.out.println("____________________________________________________________");

            }
            else {
                list_of_commands.add(line);
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
