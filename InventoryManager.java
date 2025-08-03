package gameinventorymanager;

// Author: Aeden Vogt

import java.util.HashMap;

//This class uses a HashMap to manage inventory items with names as keys.
public class InventoryManager {
    private HashMap<String, Item> inventory;

    //When created, the inventory is filled with test items.
    public InventoryManager() {
        inventory = new HashMap<>();
        inventory.put("Key", new Item("Key", "Opens a locked door"));
        inventory.put("Potion", new Item("Potion", "Restores health"));
        inventory.put("Map", new Item("Map", "Reveals dungeon layout"));
    }

    //Look up an item by its name.
    public Item getItem(String name) {
        return inventory.get(name);
    }

    //Add a new item to the inventory using its name as key.
    public void addItem(Item item) {
        inventory.put(item.getName(), item);
    }

    //  Remove an item from the inventory by name.
    public Item removeItem(String name) {
        return inventory.remove(name);
    }

    //Check if the item is in the inventory.
    public boolean hasItem(String name) {
        return inventory.containsKey(name);
    }

    //Return the whole HashMap so we can list everything.
    public HashMap<String, Item> getAllItems() {
        return inventory;
    }
}
