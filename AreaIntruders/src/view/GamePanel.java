package view;

import model.Enemy;
import model.GameModel;
import utils.Constants;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    GameModel model;
    GameRenderer renderer;

    int enemyX = 0;
    int enemyY = 0;
    int ENEMY_WIDTH = 40;
    int ENEMY_HEIGHT = 20;

    public GamePanel(GameModel model) {
        this.model = model;
        setPreferredSize(new Dimension(Constants.PANEL_WIDTH, Constants.PANEL_HEIGHT));
        setBackground(Constants.GAME_PANEL_BACKGROUND);
        renderer = new GameRenderer();
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


}
