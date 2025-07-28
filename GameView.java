// Author: Aiden Acton
// UI view for the main view the player will see
// Room info will change based on the room the player is in, but the controls/buttons won't

import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame {

    private JTextField roomNum;
    private JTextField roomName;
    private JTextArea desc;
    private JTextField ID;
    private JTextField input;

    private JButton backBtn;
    private JButton nextBtn;
    private JButton inventoryBtn;
    private JButton searchRoomBtn;
    private JButton quitButton;

    private GameController controller;

    public GameView(GameController controller) {
        this.controller = controller;

        setTitle("Main Game View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Room Info Panel
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Room #:"), gbc);

        gbc.gridx = 1;
        roomNum = new JTextField(15);
        roomNum.setEditable(false);
        add(roomNum, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Room Name:"), gbc);

        gbc.gridx = 1;
        roomName = new JTextField(15);
        roomName.setEditable(false);
        add(roomName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Description:"), gbc);

        gbc.gridx = 1;
        desc = new JTextArea(3, 15); // 3 rows, 15 columns
        desc.setLineWrap(true);
        desc.setWrapStyleWord(true);
        desc.setEditable(false);
        desc.setBackground(UIManager.getColor("TextField.background")); // Match text field color
        desc.setBorder(UIManager.getBorder("TextField.border"));        // Match text field border
        add(new JScrollPane(desc), gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Room ID:"), gbc);

        gbc.gridx = 1;
        ID = new JTextField(15);
        ID.setEditable(false);
        add(ID, gbc);

        // Separator
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        add(separator, gbc);
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;

        // Bottom Controls
        gbc.gridy = 5;
        gbc.gridx = 0;
        backBtn = new JButton("Back");
        add(backBtn, gbc);

        gbc.gridx = 1;
        input = new JTextField(20);
        add(input, gbc);

        gbc.gridx = 2;
        nextBtn = new JButton("Next");
        add(nextBtn, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        inventoryBtn = new JButton("Inventory");
        add(inventoryBtn, gbc);

        gbc.gridx = 2;
        searchRoomBtn = new JButton("Search Room");
        add(searchRoomBtn, gbc);

        setVisible(true);

        // Button Actions
        backBtn.addActionListener(e -> controller.goBackRoom());
        nextBtn.addActionListener(e -> controller.goNextRoom());
        searchRoomBtn.addActionListener(e -> controller.revealPuzzle());
        inventoryBtn.addActionListener(e -> controller.openInventory());

        // Action for user-Input
        input.addActionListener(e -> {
            String answer = input.getText().trim();
            controller.submitPuzzleAnswer(answer);
            input.setText(""); // optional: clear after submission
        });

        // Quit Button
        quitButton = new JButton("Quit");
        gbc.gridx = 1;
        gbc.gridy = 6; // Adjust row depending on layout
        add(quitButton, gbc);

// Quit action
        quitButton.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to quit?",
                    "Confirm Exit",
                    JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0); // closes the app
            }
        });


    }
    public void setRoomData(RoomModel room) {
        roomNum.setText(String.valueOf(room.getId()));
        roomName.setText(room.getName());
        desc.setText(room.getDescription());
        ID.setText(String.valueOf(room.getId()));
    }

    public String getInputAnswer() {
        return input.getText().trim();
    }
}
