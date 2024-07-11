import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TodoApp {
    public static void main(String[] args) {
        TodoList myList = new TodoList();
        Scanner scanner = new Scanner(System.in);

        // First 3 tasks (pre-populated for example)
        myList.addTodoItem(new TodoItem("Study Coding", LocalDate.of(2024, 11, 30)));
        myList.addTodoItem(new TodoItem("Study TOPIK", LocalDate.of(2024, 7, 14)));
        myList.addTodoItem(new TodoItem("Study IELTS", LocalDate.of(2024, 8, 30)));

        int choice;
        do {
            System.out.println("\nWelcome!!");
            int incompleteTasks = myList.countIncompletedTodoItems();
            if (incompleteTasks == 0) {
                System.out.println("You have no more TODOs left! Woohoooo!!");
            } else {
                System.out.println("You have " + incompleteTasks + " TODOs left! Womp womp");
            }
            myList.displayTodoItems();
            System.out.println("\n1. Create TODO");
            System.out.println("2. Edit TODO");
            System.out.println("3. Finish TODO");
            System.out.println("4. Delete TODO");
            System.out.println("5. Exit TODO");
            System.out.print("Input: ");

            // Input validation loop
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume leftover newline

            switch (choice) {
                case 1: // Create TODO
                    System.out.print("Enter task description: ");
                    String newTask = scanner.nextLine();
                    System.out.print("Enter due date (YYYY-MM-DD): ");
                    LocalDate newDueDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_LOCAL_DATE);
                    myList.addTodoItem(new TodoItem(newTask, newDueDate));
                    break;
                case 2: // Edit TODO
                    // ... (code to edit a TODO) ...
                    break;
                case 3: // Finish TODO
                    System.out.print("Finish TODO number: ");
                    int finishIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consume leftover newline
                    myList.markTodoItemAsCompleted(finishIndex);
                    break;
                case 4: // Delete TODO
                    // ... (code to delete a TODO) ...
                    break;
                case 5: // Exit
                    System.out.println("Exiting...Bye bye >v< ");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }
}
