package view;

import controller.GameController;
import model.GameModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;
import java.util.Set;

public class MainFrame extends JFrame {
    private final GameModel model;
    private GameController controller;
    private final GamePanel gamePanel;
    private final ControlPanel controlPanel;
    private final HealthPanel healthPanel;
    private final ScorePanel scorePanel;

    public MainFrame(GameModel model) {
        this.model = model;

        gamePanel = new GamePanel(model);
        controlPanel = new ControlPanel();
        healthPanel = new HealthPanel();
        scorePanel = new ScorePanel();

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 3));
        bottomPanel.add(healthPanel);
        bottomPanel.add(controlPanel);
        bottomPanel.add(scorePanel);
        add(gamePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);


        for (JButton button : controlPanel.getButtons()){
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e){
                    if (button.getText().equals("LEFT")){
                        controller.getPressedKeys().add(KeyEvent.VK_LEFT);
                    } else if (button.getText().equals("RIGHT")){
                        controller.getPressedKeys().add(KeyEvent.VK_RIGHT);
                    } else if (button.getText().equals("FIRE!")){
                        controller.fire();
                    }
                }
                public void mouseReleased(MouseEvent e){
                    if (button.getText().equals("LEFT")){
                        controller.getPressedKeys().remove(KeyEvent.VK_LEFT);
                    } else if (button.getText().equals("RIGHT")){
                        controller.getPressedKeys().remove(KeyEvent.VK_RIGHT);
                    } else if (button.getText().equals("FIRE!")){
                        controller.getPressedKeys().remove(KeyEvent.VK_SPACE);
                    }
                }
            });
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Area Intruders");

        pack();
        setResizable(false);
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
}
