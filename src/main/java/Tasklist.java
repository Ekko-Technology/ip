import java.util.ArrayList;


public class Tasklist {
    // loads the saved ArrayList of Tasks
    private ArrayList<Task> tasks;

    public Tasklist() {
        this.tasks = new ArrayList<>();
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void markTask(int index) {
        tasks.get(index).isDone = true;
    }

    public void unmarkTask(int index) {
        tasks.get(index).isDone = false;
    }

    public void addTask(Task t) {
        tasks.add(t);
    }

    public Task deleteTask(int index) {
        return tasks.remove(index);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
    
}
