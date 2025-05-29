package view;

import model.GameModel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private final GameModel gameModel;
    private final GamePanel gamePanel;
    private final ControlPanel controlPanel;

    public MainFrame(GameModel model) {
        this.gameModel = model;

        gamePanel = new GamePanel(model);
        controlPanel = new ControlPanel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Area Intruders");
        add(gamePanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void repaintGamePanel(){
        this.gamePanel.repaint();
    }
}
