package gameinventorymanager;

// Author: Aeden Vogt

import java.util.Scanner;

//This class handles user input/output using a simple text menu.
public class InventoryView {

    //Shows menu options to the user and connects with InventoryManager.
    public void menu(InventoryManager manager) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Inventory Menu ---");
            System.out.println("1. View all items");
            System.out.println("2. Search for an item");
            System.out.println("3. Add item");
            System.out.println("4. Remove item");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // clear newline

            //  Handle user choice
            switch (choice) {
                case 1:
                    //  Show all items in inventory
                    for (Item item : manager.getAllItems().values()) {
                        System.out.println(item);
                    }
                    break;
                case 2:
                    //Search for one item by name
                    System.out.print("Enter item name: ");
                    String search = scanner.nextLine();
                    Item found = manager.getItem(search);
                    if (found != null)
                        System.out.println("Found: " + found);
                    else
                        System.out.println("Item not found.");
                    break;
                case 3:
                    // Add new item to inventory
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String desc = scanner.nextLine();
                    manager.addItem(new Item(name, desc));
                    System.out.println("Item added.");
                    break;
                case 4:
                    //Remove item by name
                    System.out.print("Enter item name to remove: ");
                    String remove = scanner.nextLine();
                    Item removed = manager.removeItem(remove);
                    if (removed != null)
                        System.out.println("Removed: " + removed);
                    else
                        System.out.println("Item not found.");
                    break;
                case 5:
                    System.out.println("Exiting inventory...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 5);
    }
}
