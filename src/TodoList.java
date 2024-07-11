import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class TodoList {
    private List<TodoItem> todoItems;

    public TodoList() {
        todoItems = new ArrayList<>();
    }

    public void addTodoItem(TodoItem todoItem) {
        todoItems.add(todoItem);
    }

    public void markTodoItemAsCompleted(int index) {
        if (index >= 0 && index < todoItems.size()) {
            todoItems.get(index).markCompleted();
        }
    }
    public int countIncompletedTodoItems() {
        int count = 0;
        for (TodoItem todoItem : todoItems) {
            if (!todoItem.isCompleted()) {
                count++;
            }
        }
        return count;
    }
    public void displayTodoItems() {
        if (todoItems.isEmpty()) {
            System.out.println("You have no more TODOs left! Woohoooo!!");
        } else {
            for (int i = 0; i < todoItems.size(); i++) {
                System.out.println((i + 1) + ". " + todoItems.get(i).displayTask());
            }
        }
    }
    public void updateTodoItem(int index, String newTask, LocalDate newDueDate) {
        if (index >= 0 && index < todoItems.size()) {
            TodoItem item = todoItems.get(index);
            item.setTask(newTask);  // Assuming you have setters in TodoItem
            item.setDue(newDueDate);
        } else {
            System.out.println("Invalid TODO number.");
        }
    }

    public void deleteTodoItem(int index) {
        if (index >= 0 && index < todoItems.size()) {
            todoItems.remove(index);
        } else {
            System.out.println("Invalid TODO number.");
        }
    }
}