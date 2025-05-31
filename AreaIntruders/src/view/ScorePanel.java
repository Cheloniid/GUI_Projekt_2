package view;

import model.entities.Player;
import utils.Constants;

import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel {
    JLabel scoreLabel;
    Player player;

    public ScorePanel(Player player) {
        this.player = player;
        setLayout(new FlowLayout());
        setBackground(Constants.GAME_PANEL_BACKGROUND);
        scoreLabel = new JLabel("" + player.getScore());
        scoreLabel.setForeground(Constants.PLAYER_COLOR);
        scoreLabel.setFont(new Font("Monospaced", Font.BOLD, 36));
        add(scoreLabel);
    }

    public void update(){
        this.scoreLabel.setText("" + player.getScore());
    }
}
