// By
import javax.swing.*;
import java.awt.*;

public class RiddleView extends JFrame {
    private GameController controller;

    public RiddleView(GameController controller) {
        this.controller = controller;

        setTitle("Riddle Challenge");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel riddleLabel = new JLabel("<html><center>I have keys but no locks,<br>space but no room.<br>You can enter but not go outside.<br>What am I?</center></html>", SwingConstants.CENTER);
        add(riddleLabel, BorderLayout.CENTER);

        JButton closeBtn = new JButton("Close");
        closeBtn.addActionListener(e -> dispose());
        add(closeBtn, BorderLayout.SOUTH);

        setVisible(true);
    }
}
