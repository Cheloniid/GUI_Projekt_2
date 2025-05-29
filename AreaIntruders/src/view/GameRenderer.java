package view;

import model.Enemy;
import model.LargeEnemy;
import model.Player;
import model.SmallEnemy;
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
        int x = enemy.getX();
        int y = enemy.getY();
        int width = (int) (sizeFactor * 40);
        int height = (int) (sizeFactor * 10);

        g2d.setColor(new Color(180, 0, 255));
        g2d.fillOval(x, y + (int) sizeFactor, width, height);

        g2d.setColor(new Color(0, 0, 255));
        g2d.fillOval(x, y, width, height);

        g2d.setColor(new Color(0, 255, 255, 150));
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
}
