package view;

import controller.GameController;
import model.GameModel;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class MainFrame extends JFrame {
    private final GameModel model;
    private GameController controller;
    private final GamePanel gamePanel;
    private final ControlPanel controlPanel;

    public MainFrame(GameModel model) {
        this.model = model;

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

    public void setController(GameController controller) {
        this.controller = controller;
        this.gamePanel.setController(controller);
    }

    public JPanel getGamePanel() {
        return gamePanel;
    }

    public Set<Integer> getPressedKeys(){
        return gamePanel.getPressedKeys();
    }
}
