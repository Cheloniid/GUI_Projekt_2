package view;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    int enemyX = 0;
    int enemyY = 0;
    int ENEMY_WIDTH = 40;
    int ENEMY_HEIGHT = 20;
    int playerX = 0;
    int playerY = 0;
    int PLAYER_WIDTH = 20;
    int PLAYER_HEIGHT = 30;
    int PANEL_HEIGHT = 600;
    int PANEL_WIDTH = 800;


    public GamePanel() {
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setBackground(Color.BLACK);

        playerX = PANEL_WIDTH / 2 - PLAYER_WIDTH / 2;
        playerY = PANEL_HEIGHT - PLAYER_HEIGHT - 20;
        System.out.println(this.getWidth());

        Timer timer = new Timer(6, e -> {
            enemyX++;
            enemyY++;
            repaint();
        }
        );
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        g.setColor(Color.WHITE);
//        g.fillRect(100, 100, 50, 50);
//
//        g.setColor(Color.RED);
//        g.fillOval(200, 100, 50, 50);
//
//        g.setColor(Color.CYAN);
//        g.drawString("Gracz: Michał", 10, 20);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(Color.WHITE);
        g.fillRect(enemyX, enemyY, ENEMY_WIDTH, ENEMY_HEIGHT);

        int[] xPoints = {playerX, playerX + PLAYER_WIDTH / 2, playerX + PLAYER_WIDTH};
        int[] yPoints = {playerY + PLAYER_HEIGHT, playerY, playerY + PLAYER_HEIGHT};
        g.fillPolygon(xPoints, yPoints, 3);
        //g.fillRect(playerX, playerY, PLAYER_WIDTH, PLAYER_HEIGHT);

        paintUFO(g2d, 1.0, this.getWidth() / 2, this.getHeight() / 2);
    }

    private void paintUFO(Graphics2D g2d, double sizeFactor, int x, int y) {
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
}
