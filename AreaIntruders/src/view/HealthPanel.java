package view;

import utils.Constants;

import javax.swing.*;
import java.awt.*;

public class HealthPanel extends JPanel {
    JLabel healthLabel;

    public HealthPanel() {
        setLayout(new FlowLayout());
        setBackground(Constants.GAME_PANEL_BACKGROUND);
        healthLabel = new JLabel("100");
        healthLabel.setForeground(Constants.PLAYER_COLOR);
        healthLabel.setFont(new Font("Monospaced", Font.BOLD, 36));
        add(healthLabel);
    }
}
