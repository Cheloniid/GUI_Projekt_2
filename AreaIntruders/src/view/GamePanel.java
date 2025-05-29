package view;

import controller.GameController;
import model.Enemy;
import model.GameModel;
import utils.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public class GamePanel extends JPanel {

    private final GameModel model;
    private GameController controller;
    private GameRenderer renderer;
    private InputMap inputMap;
    private ActionMap actionMap;
    private final Set<Integer> pressedKeys;


    public GamePanel(GameModel model) {
        this.model = model;
        renderer = new GameRenderer();
        pressedKeys = new HashSet<>();
        setPreferredSize(new Dimension(Constants.PANEL_WIDTH, Constants.PANEL_HEIGHT));
        setBackground(Constants.GAME_PANEL_BACKGROUND);

        // Key Bindings
        inputMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        actionMap = getActionMap();

        inputMap.put(KeyStroke.getKeyStroke("pressed LEFT"), "pressed left");
        actionMap.put("pressed left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressedKeys.add(KeyEvent.VK_LEFT);
            }
        });

        inputMap.put(KeyStroke.getKeyStroke("released LEFT"), "released left" );
        actionMap.put("released left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressedKeys.remove(KeyEvent.VK_LEFT);
            }
        });

        inputMap.put(KeyStroke.getKeyStroke("pressed RIGHT"), "pressed right");
        actionMap.put("pressed right", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressedKeys.add(KeyEvent.VK_RIGHT);
            }
        });

        inputMap.put(KeyStroke.getKeyStroke("released RIGHT"), "released right" );
        actionMap.put("released right", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressedKeys.remove(KeyEvent.VK_RIGHT);
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
    }

    public void setController(GameController controller) {
        this.controller = controller;
    }

    public Set<Integer> getPressedKeys() {
        return pressedKeys;
    }
}
