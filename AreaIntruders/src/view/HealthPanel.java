package view;

import model.entities.Player;
import utils.Constants;

import javax.swing.*;
import java.awt.*;

public class HealthPanel extends JPanel {
    JLabel healthLabel;
    Player player;

    public HealthPanel(Player player) {
        this.player = player;
        setLayout(new FlowLayout());
        setBackground(Constants.GAME_PANEL_BACKGROUND);
        healthLabel = new JLabel("" + player.getHealth());
        healthLabel.setForeground(Constants.PLAYER_COLOR);
        healthLabel.setFont(new Font("Monospaced", Font.BOLD, 36));
        add(healthLabel);
    }

    public void update(){
        this.healthLabel.setText("" + player.getHealth());
    }
}
