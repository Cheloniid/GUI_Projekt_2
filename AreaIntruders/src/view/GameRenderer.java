package view;

import model.entities.*;
import utils.Constants;

import java.awt.*;

public class GameRenderer {

    public void paintUFO(Graphics2D g2d, Enemy enemy) {
        float sizeFactor = 1;
        if (enemy instanceof SmallEnemy) {
            sizeFactor = Constants.SMALL_ENEMY_SIZE;
        } else if (enemy instanceof LargeEnemy) {
            sizeFactor = Constants.LARGE_ENEMY_SIZE;
        }
        int x = (int) enemy.getFloatX();
        int y = enemy.getY();
        int width = (int) (sizeFactor * 40);
        int height = (int) (sizeFactor * 10);

        g2d.setColor(Color.WHITE);
        g2d.fillOval(x, y + (int) sizeFactor, width, height);

        g2d.setColor(Constants.UFO_COLOR);
        g2d.fillOval(x, y, width, height);

        g2d.setColor(Constants.UFO_WINDOW_COLOR);
        g2d.fillOval(x + (int) (0.2 * width), y - (int) (0.15 * height),
                (int) (0.6 * width), (int) ( 0.6 * height));
    }

    public void paintPlayer(Graphics2D g2d, Player player) {
        g2d.setColor(Constants.PLAYER_COLOR);
        int playerX = player.getX();
        int playerY = player.getY();
        int[] xPoints = {playerX, playerX + Constants.PLAYER_WIDTH / 2, playerX + Constants.PLAYER_WIDTH};
        int[] yPoints = {playerY + Constants.PLAYER_HEIGHT, playerY, playerY + Constants.PLAYER_HEIGHT};
        g2d.fillPolygon(xPoints, yPoints, 3);
    }

    public void paintPlayerMissile(Graphics2D g2d, PlayerMissile missile) {
        g2d.setColor(Constants.PLAYERS_MISSILE_COLOR);
        g2d.fillRect(missile.getX(), missile.getY(), 4, 14);
    }

    public void paintEnemyMissile(Graphics2D g2d, EnemyMissile missile) {
        g2d.setColor(Constants.UFO_COLOR);
        g2d.fillOval(missile.getX(), missile.getY(), 4 , 14);
    }

    public void paintLevelText(Graphics2D g2d, int level) {
        g2d.setColor(Constants.UFO_WINDOW_COLOR);
        g2d.setFont(new Font("Monospaced", Font.BOLD, 30));
        g2d.drawString("LEVEL " + level, 20, 33);
    }
}
