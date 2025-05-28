package view;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    int ovalX, ovalY;

    public GamePanel() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(100, 100, 50, 50);

        g.setColor(Color.RED);
        g.fillOval(200, 100, 50, 50);

        g.setColor(Color.CYAN);
        g.drawString("Gracz: Michał", 10, 20);

        ovalX = getWidth() / 2;
        ovalY = getHeight() / 2;
        Timer timer = new Timer(200, e -> {
            g.fillOval(ovalX++, ovalY++, 50, 50);
            repaint();
        });
        timer.start();
    }
}
