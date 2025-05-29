import controller.GameController;
import model.GameModel;
import view.GamePanel;
import view.MainFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                GameModel model = new GameModel();
                MainFrame view = new MainFrame(model);
                GameController controller = new GameController(model, view);
                controller.startGame();
            }
        });
    }
}