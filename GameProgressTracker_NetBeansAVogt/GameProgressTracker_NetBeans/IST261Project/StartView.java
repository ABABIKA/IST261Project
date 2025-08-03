// The start view of the game - By Hafsah

import javax.swing.*;
import java.awt.*;

public class StartView extends JFrame {

    private GameController controller;

    public StartView(GameController controller) {
        this.controller = controller;

        setTitle("Welcome to the Game!");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);

        // Title Label
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel title = new JLabel("Adventure Game");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title, gbc);

        // Start Game Button
        gbc.gridy++;
        JButton startBtn = new JButton("Start Game");
        startBtn.addActionListener(e -> {
            dispose(); // Close StartView
            controller.launchGame(); // Move to GameView
        });
        add(startBtn, gbc);

        // About Button
        gbc.gridy++;
        JButton aboutBtn = new JButton("About");
        aboutBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                    "This is a room riddle game made for IST 261.\nCreated by Group 5 of IST 261!",
                    "About This Game",
                    JOptionPane.INFORMATION_MESSAGE);
        });
        add(aboutBtn, gbc);

        // Quit Button
        gbc.gridy++;
        JButton quitBtn = new JButton("Quit");
        quitBtn.addActionListener(e -> System.exit(0));
        add(quitBtn, gbc);

        setVisible(true);
    }
}
