import java.util.Scanner;

public class Sugon {
    public static void main(String[] args) {
        String chatName = "Sugon";
        System.out.println("____________________________________________________________");
        System.out.println(" Hello! I'm " + chatName);
        System.out.println(" What can I do for you?");
        System.out.println("____________________________________________________________");
        String line;
        while (true) {
            Scanner s = new Scanner(System.in);
            line = s.nextLine();
            if (line.equals("bye"))
            {
                break;
            }
            System.out.println(line);
        }

        System.out.println("____________________________________________________________");
        System.out.println(" Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }
}
