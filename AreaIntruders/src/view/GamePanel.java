package view;

import controller.GameController;
import model.entities.Enemy;
import model.GameModel;
import model.entities.EnemyMissile;
import model.entities.PlayerMissile;
import utils.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {

    private final GameModel model;
    private GameController controller;
    private GameRenderer renderer;
    private InputMap inputMap;
    private ActionMap actionMap;



    public GamePanel(GameModel model) {
        this.model = model;
        renderer = new GameRenderer();
        setPreferredSize(new Dimension(Constants.PANEL_WIDTH, Constants.PANEL_HEIGHT));
        setBackground(Constants.GAME_PANEL_BACKGROUND);

        // Key Bindings
        inputMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        actionMap = getActionMap();

        inputMap.put(KeyStroke.getKeyStroke("P"), "pressed P");
        actionMap.put("pressed P", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.pauseResumeGame();
            }
        });

        inputMap.put(KeyStroke.getKeyStroke("pressed LEFT"), "pressed left");
        actionMap.put("pressed left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.getPressedKeys().add(KeyEvent.VK_LEFT);
            }
        });

        inputMap.put(KeyStroke.getKeyStroke("released LEFT"), "released left" );
        actionMap.put("released left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.getPressedKeys().remove(KeyEvent.VK_LEFT);
            }
        });

        inputMap.put(KeyStroke.getKeyStroke("pressed RIGHT"), "pressed right");
        actionMap.put("pressed right", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.getPressedKeys().add(KeyEvent.VK_RIGHT);
            }
        });

        inputMap.put(KeyStroke.getKeyStroke("released RIGHT"), "released right" );
        actionMap.put("released right", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.getPressedKeys().remove(KeyEvent.VK_RIGHT);
            }
        });

        inputMap.put(KeyStroke.getKeyStroke("SPACE"), "space" );
        actionMap.put("space", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.fire();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        renderer.paintPlayer(g2d, model.getPlayer());
        for (Enemy enemy : model.getEnemies()) {
            renderer.paintUFO(g2d, enemy);
        }
        for (PlayerMissile missile : model.getPlayerMissiles()){
            renderer.paintPlayerMissile(g2d, missile);
        }
        for (EnemyMissile missile : model.getEnemyMissiles()){
            renderer.paintEnemyMissile(g2d, missile);
        }
    }

    public void setController(GameController controller) {
        this.controller = controller;
    }
}
