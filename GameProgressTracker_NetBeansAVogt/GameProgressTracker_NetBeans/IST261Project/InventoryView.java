/*
 Author: Cody Impson
 This is where the view for User Inventory is made.
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InventoryView extends JFrame {

    private JComboBox<String> dropdown;
    private JTextField itemNameField;
    private JTextField itemDescField;
    private JTextField collectibleField;

    private JButton addButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JButton quitButton;

    private GameController controller;
    private ArrayList<ItemModel> inventory;

    public InventoryView(GameController controller) {
        this.controller = controller;

        setTitle("Inventory");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        inventory = controller.getInventory();

        // Dropdown
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        dropdown = new JComboBox<>();
        add(dropdown, gbc);

        // Item Name
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(new JLabel("Item Name:"), gbc);

        gbc.gridx = 1;
        itemNameField = new JTextField(20);
        itemNameField.setEditable(false);
        add(itemNameField, gbc);

        // Item Description
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Item Description:"), gbc);

        gbc.gridx = 1;
        itemDescField = new JTextField(20);
        itemDescField.setEditable(true);
        add(itemDescField, gbc);

        // Collectible status
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Collectible (true/false):"), gbc);

        gbc.gridx = 1;
        collectibleField = new JTextField(20);
        collectibleField.setEditable(false);
        add(collectibleField, gbc);

        // Buttons
        gbc.gridy = 4;
        gbc.gridx = 0;
        addButton = new JButton("Add");
        add(addButton, gbc);

        gbc.gridx = 1;
        deleteButton = new JButton("Delete");
        add(deleteButton, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        updateButton = new JButton("Update");
        add(updateButton, gbc);

        gbc.gridx = 1;
        quitButton = new JButton("Close");
        add(quitButton, gbc);

        // Event Handlers
        dropdown.addActionListener(e -> {
            int index = dropdown.getSelectedIndex();
            if (index >= 0 && index < inventory.size()) {
                ItemModel selected = inventory.get(index);
                itemNameField.setText(selected.getName());
                itemDescField.setText(selected.getDescription());
                collectibleField.setText(String.valueOf(selected.isCollectible()));
            }
        });

        deleteButton.addActionListener(e -> {
            int index = dropdown.getSelectedIndex();
            if (index >= 0 && index < inventory.size()) {
                ItemModel toDrop = inventory.get(index);
                controller.dropItem(toDrop);
                controller.updateInventoryView(); // refresh list
            } else {
                showMessage("Please select an item to drop.");
            }
        });

        updateButton.addActionListener(e -> {
            int index = dropdown.getSelectedIndex();
            if (index >= 0 && index < inventory.size()) {
                ItemModel selected = inventory.get(index);
                String newDesc = itemDescField.getText();
                selected.setDescription(newDesc);
                controller.updateInventoryView(); // refresh
                showMessage(selected.getName() + " was updated!");
            }
        });

        addButton.addActionListener(e -> {
            String name = promptUser("Enter item name:");
            String desc = promptUser("Enter item description:");
            String isCollectibleStr = promptUser("Is it collectible? (true/false)");

            if (name != null && desc != null && isCollectibleStr != null) {
                boolean isCollectible = Boolean.parseBoolean(isCollectibleStr);
                controller.addItemToInventory(name, desc, isCollectible);
            }
        });

        quitButton.addActionListener(e -> dispose());

        // Enable all relevant buttons
        addButton.setVisible(false);
        updateButton.setEnabled(true);
        deleteButton.setEnabled(true);
    }

    // Called by GameController
    public void setRoomData(RoomModel room) {
        System.out.println("setRoomData called for " + room.getName());
    }

    public void setInventoryDropdown(ArrayList<ItemModel> items) {
        this.inventory = items;

        dropdown.removeAllItems();
        for (ItemModel item : items) {
            dropdown.addItem(item.getName());
        }

        if (!items.isEmpty()) {
            dropdown.setSelectedIndex(0); // triggers listener
        } else {
            itemNameField.setText("");
            itemDescField.setText("");
            collectibleField.setText("");
        }
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public String promptUser(String message) {
        return JOptionPane.showInputDialog(this, message);
    }
}
