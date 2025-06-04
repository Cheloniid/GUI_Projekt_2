import controller.GameController;
import model.GameModel;
import view.MainFrame;
import view.SplashScreen;

import javax.swing.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                SplashScreen splashScreen = new SplashScreen();

                Timer mainTimer = new Timer(1000, e -> {


                    GameModel model = new GameModel();
                    MainFrame view = new MainFrame(model);
                    GameController controller = new GameController(model, view);
                    view.setController(controller);
                });

                mainTimer.setRepeats(false);
                mainTimer.start();

                Timer splashTimer = new Timer(1200, e -> {splashScreen.dispose();});
                splashTimer.setRepeats(false);
                splashTimer.start();
            }
        });
    }
}
