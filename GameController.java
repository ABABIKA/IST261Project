// Author: Hafsah
/*
This is the controller when launching the app.
All functions that will load upon launching is directed from here!
*/

import javax.swing.*;
import java.util.ArrayList;

public class GameController {

    private StartView startUI;
    private GameView mainUI;
    private InventoryView inventoryUI;

    private ArrayList<RoomModel> rooms = new ArrayList<>();
    private ArrayList<ItemModel> inventory = new ArrayList<>();
    private int currentRoomIndex = 0;

    // Constructor - now launches the Start Screen
    public GameController() {
        rooms = RoomBuilderModel.buildRooms();
        startUI = new StartView(this);
        startUI.setVisible(true);
    }

    // ---- Called when "Start Game" is clicked ----
    public void launchGame() {
        startUI.dispose(); // close the start screen
        mainUI = new GameView(this);
        mainUI.setRoomData(getCurrentRoom());
        mainUI.setVisible(true);
    }

    // ---- Launch inventory popup ----
    public void openInventory() {
        inventoryUI = new InventoryView(this);
        inventoryUI.setVisible(true);
        updateInventoryView();
    }

    // ---- Update the inventory view ----
    public void updateInventoryView() {
        if (inventoryUI != null) {
            RoomModel current = rooms.get(currentRoomIndex);
            inventoryUI.setRoomData(current);
            inventoryUI.setInventoryDropdown(inventory);
        }
    }

    // ---- Navigation ----
    public void goNextRoom() {
        if (currentRoomIndex < rooms.size() - 1) {
            RoomModel nextRoom = rooms.get(currentRoomIndex + 1);
            int nextRoomID = nextRoom.getId();

            // Lock conditions based on room ID
            switch (nextRoomID) {
                case 2: // Room 2 requires "Key"
                    if (!hasItem("Key")) {
                        JOptionPane.showMessageDialog(null, "You need the Key to enter the Library.");
                        return;
                    }
                    break;
                case 3: // Room 3 requires "Library Clue"
                    if (!hasItem("Library Clue")) {
                        JOptionPane.showMessageDialog(null, "You need the Library Clue to proceed.");
                        return;
                    }
                    break;
                case 4: // Room 4 requires "Starlit Note"
                    if (!hasItem("Starlit Note")) {
                        JOptionPane.showMessageDialog(null, "You need the Starlit Note to enter the Garden.");
                        return;
                    }
                    break;
                // You can add more room checks here if needed
            }

            currentRoomIndex++;
            mainUI.setRoomData(getCurrentRoom());
            updateInventoryView();
        } else {
            JOptionPane.showMessageDialog(null, "You're already in the latest room!");
        }
    }

    public void goBackRoom() {
        if (currentRoomIndex > 0) {
            currentRoomIndex--;
            mainUI.setRoomData(getCurrentRoom());
            updateInventoryView();
        } else if (inventoryUI != null) {
            inventoryUI.showMessage("You're already in the first room!");
        }
    }

    // ---- Inventory Actions ----
    // Overloaded method with optional message
    public void pickupItem(ItemModel item, boolean showMessage) {
        if (hasItem(item.getName())) return;

        inventory.add(item);

        if (inventoryUI != null && showMessage) {
            inventoryUI.showMessage(item.getName() + " has been added to your inventory!");
        }

        updateInventoryView();

    }

    // Default version stays the same
    public void pickupItem(ItemModel item) {
        pickupItem(item, true);
    }


    public void dropItem(ItemModel item) {
        if (inventory.contains(item)) {
            int result = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to drop \"" + item.getName() + "\"?\n" +
                            "You may need this item to progress.",
                    "Drop Item?", JOptionPane.YES_NO_OPTION);

            if (result != JOptionPane.YES_OPTION) return;

            inventory.remove(item);
            if (inventoryUI != null)
                inventoryUI.showMessage(item.getName() + " has been dropped!");
            updateInventoryView();
        } else {
            if (inventoryUI != null)
                inventoryUI.showMessage("That item isn't in your inventory.");
        }

    }

    // ------Adds a new item to the inventory----------
    public void addItemToInventory(String name, String description, boolean collectible) {
        if (hasItem(name)) {
            JOptionPane.showMessageDialog(null, "You already have an item named \"" + name + "\".");
            return;
        }

        ItemModel newItem = new ItemModel(name, description, collectible);
        inventory.add(newItem);

        if (inventoryUI != null) {
            inventoryUI.showMessage(name + " was added to your inventory!");
            updateInventoryView();
        }
    }



    // ---- Get item descriptions ----
    public String getItemDescription(String itemName) {
        for (ItemModel item : inventory) {
            if (item.getName().equals(itemName)) {
                return item.getDescription();
            }
        }
        return "No Description available.";
    }

    // ---- Get inventory list for InventoryUI ----
    public ArrayList<ItemModel> getInventory() {
        return inventory;
    }

    // ---- Riddle search (triggered from inventory popup) ----
    public void searchRoom() {
        RoomModel current = getCurrentRoom();
        PuzzleModel puzzle = current.getPuzzle();

        if (puzzle == null) {
            JOptionPane.showMessageDialog(null, "There is nothing to search in this room.");
            return;
        }

        if (puzzle.isSolved()) {
            JOptionPane.showMessageDialog(null, "You've already solved this puzzle.");
            return;
        }

        String input = mainUI.getInputAnswer();

        if (input == null || input.isBlank()) {
            JOptionPane.showMessageDialog(null, "Please type an answer in the input field.");
            return;
        }

        if (puzzle.attemptSolve(input)) {
            if (!hasItem(puzzle.getReward().getName())) {
                pickupItem(puzzle.getReward());
                JOptionPane.showMessageDialog(null, "Correct! You received: " + puzzle.getReward().getName());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect answer. Try again.");
        }
    }

    // ------ Helper to check if item is already in inventory ------
    private boolean hasItem(String itemName) {
        for (ItemModel item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }

    // ---- Access to current room info for main UI ----
    public RoomModel getCurrentRoom() {
        return rooms.get(currentRoomIndex);
    }

    //------Reveal the Puzzle if the user searches the room----
    public void revealPuzzle() {
        RoomModel current = getCurrentRoom();
        PuzzleModel puzzle = current.getPuzzle();

        if (puzzle == null) {
            JOptionPane.showMessageDialog(null, "There is nothing to search here.");
            return;
        }

        // If puzzle solved but player dropped the reward, show it again
        if (puzzle.isSolved() && !hasItem(puzzle.getReward().getName())) {
            JOptionPane.showMessageDialog(null, puzzle.getPuzzleDescription());
            return;
        }

        if (puzzle.isSolved()) {
            JOptionPane.showMessageDialog(null, "You've already solved this puzzle!");
        } else {
            JOptionPane.showMessageDialog(null, puzzle.getPuzzleDescription());
        }
    }


    //--------Submission for the User Input-------
    public void submitPuzzleAnswer(String answer) {
        RoomModel current = getCurrentRoom();
        PuzzleModel puzzle = current.getPuzzle();

        if (puzzle == null) {
            JOptionPane.showMessageDialog(null, "There's no puzzle in this room.");
            return;
        }

        ItemModel reward = puzzle.getReward();

        // Re-solve if you lost the reward
        if (puzzle.attemptSolve(answer)) {
            if (!hasItem(reward.getName())) {
                pickupItem(reward, false);
                JOptionPane.showMessageDialog(null, "Correct! You received: " + reward.getName());
            } else {
                JOptionPane.showMessageDialog(null, "Correct! You've already received this item.");
              
            }
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect answer. Try again!");
        }
    }

}
