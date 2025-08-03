package gameinventorymanager;

// Author: Aeden Vogt

//This class holds item info (name and description). Each inventory item is an instance of this class.
public class Item {
    private String name;
    private String description;

    // When we make an Item, we set its name and description.
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Return the item's name.
    public String getName() {
        return name;
    }

    // Return the item's description.
    public String getDescription() {
        return description;
    }

    // Show the item in a readable way when printed.
    public String toString() {
        return name + ": " + description;
    }
}

