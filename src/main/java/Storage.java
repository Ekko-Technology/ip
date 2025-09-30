import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {

    private String filepath;

    public Storage(String filepath) {
        this.filepath = filepath;
    }

    public ArrayList<Task> loadTasks() throws FileNotFoundException {
        ArrayList<Task> tasks = new ArrayList<>();
        File f = new File(filepath);
        if (!f.exists()) {
            return tasks;
        }

        Scanner scanner = new Scanner(f);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(" \\| ");
            if (parts.length < 3) continue;
            String type = parts[0];
            boolean isDone = parts[1].equals("1");
            String description = parts[2];
            Task t;
            switch (type) {
                case "T":
                    t = new ToDo(description);
                    break;
                case "D":
                    if (parts.length < 4) continue;
                    t = new Deadline(description, parts[3]);
                    break;
                case "E":
                    if (parts.length < 4) continue;
                    String[] times = parts[3].split(" to ");
                    if (times.length < 2) continue;
                    t = new Event(description, times[0], times[1]);
                    break;
                default:
                    continue;
            }
            t.isDone = isDone;
            tasks.add(t);
        }
        scanner.close();
        return tasks;
    }


    public void saveTasks(ArrayList<Task> tasks) throws IOException {

        File saveFilePath = new File(filepath);
        // Create file if not exist
        saveFilePath.getParentFile().mkdirs();
        FileWriter writer = new FileWriter(saveFilePath);
        for (Task t: tasks) {
            String line;
            String status = t.isDone ? "1" : "0";
            if (t instanceof ToDo) {
                line = "T | " + status + " | " + t.description;
            } else if (t instanceof Deadline) {
                line = "D | " + status + " | " + t.description + " | " + ((Deadline) t).do_by; // Cast as a Deadline class
            } else if (t instanceof Event) {
                line = "E | " + status + " | " + t.description + " | " + ((Event) t).start_dateTime + " to " + ((Event) t).end_dateTime; // Cast as an Event class
            } else {
                continue;
            }
            writer.write(line + System.lineSeparator());

        }
        writer.close();
    }
}
