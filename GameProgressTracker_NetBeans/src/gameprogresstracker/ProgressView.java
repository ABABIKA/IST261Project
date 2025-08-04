// Author: Aeden Vogt
package gameprogresstracker;

import java.util.Scanner;

//View class to interact with the user using console input/output
public class ProgressView {

    public void menu(ProgressManager manager) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Game Progress Menu ---");
            System.out.println("1. View all completed tasks");
            System.out.println("2. Search for a completed task");
            System.out.println("3. Add a completed task");
            System.out.println("4. Remove a completed task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // clear newline

            switch (choice) {
                case 1:
                    for (Task task : manager.getAllTasks()) {
                        System.out.println(task);
                    }
                    break;
                case 2:
                    System.out.print("Enter task name to search: ");
                    String search = scanner.nextLine();
                    if (manager.hasTask(new Task(search))) {
                        System.out.println("Task found!");
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter new task name: ");
                    String name = scanner.nextLine();
                    manager.addTask(new Task(name));
                    System.out.println("Task added.");
                    break;
                case 4:
                    System.out.print("Enter task name to remove: ");
                    String remove = scanner.nextLine();
                    boolean removed = manager.removeTask(new Task(remove));
                    if (removed)
                        System.out.println("Task removed.");
                    else
                        System.out.println("Task not found.");
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid input.");
            }

        } while (choice != 5);
    }
}