import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class Sugon {
    private static final String filepath = "data/sugon.txt";

    private Ui ui;
    private Storage storage;
    private ArrayList<Task> list_of_Tasks;

    // Constructor for loading UI class, storage class for loading saved files
    public Sugon(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            list_of_Tasks = storage.loadTasks();
        } catch (FileNotFoundException e) {
            ui.showError("unable to find filepath to load tasks");
            list_of_Tasks = new ArrayList<>();
        }
    }   

    // The main program loop
    public void run() {
        ui.showWelcome();
        ui.showHelp();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        Tasklist tasklist = new Tasklist();
        tasklist.setTasks(list_of_Tasks); // Add a setter in Tasklist if needed

        while (isRunning) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                ui.showError("Sugon needs a command.");
                continue;
            }
            // Split command and arguments to only 2 substrings
            String[] words = line.split(" ", 2);
            String command = words[0].toLowerCase();
            String args = (words.length > 1) ? words[1].trim() : "";

            isRunning = Parser.executeCommand(command, args, tasklist, ui, storage);
        }
        scanner.close();
    }


    // Proper JVM entry point
    public static void main(String[] args) {
        Sugon app = new Sugon(filepath);
        app.run();
    }
}
