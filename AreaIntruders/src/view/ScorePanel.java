package view;

import utils.Constants;

import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel {
    JLabel scoreLabel;

    public ScorePanel() {
        setLayout(new FlowLayout());
        setBackground(Constants.GAME_PANEL_BACKGROUND);
        scoreLabel = new JLabel("0");
        scoreLabel.setForeground(Constants.PLAYER_COLOR);
        scoreLabel.setFont(new Font("Monospaced", Font.BOLD, 36));
        add(scoreLabel);
    }
}
