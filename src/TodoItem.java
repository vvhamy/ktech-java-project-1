import java.time.LocalDate;

public class TodoItem {
    private String task;
    private LocalDate due;
    private boolean completed;

    public TodoItem(String task, LocalDate due) {
        this.task = task;
        this.due = due;
        this.completed = false; // New task - not done yet

    }

    public void markCompleted() {
        this.completed = true;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String displayTask() {
        return task + " (Until: " + due + (completed ? " - Completed" : "") + ")";
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setDue(LocalDate due) {
        this.due = due;
    }
}
