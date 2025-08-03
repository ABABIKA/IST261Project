package gameinventorymanager;

// Author: Aeden Vogt

//This class connects the view and the model together.
public class InventoryController {
    private InventoryManager manager;
    private InventoryView view;

    //Set up the manager and view when the controller is made.
    public InventoryController() {
        manager = new InventoryManager();
        view = new InventoryView();
    }

    //Start the menu from the view.
    public void run() {
        view.menu(manager);
    }
}

