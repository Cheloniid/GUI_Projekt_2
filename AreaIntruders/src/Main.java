import view.GamePanel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame("Area Intruders");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new GamePanel());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                // Comment df
            }
        });
    }
}