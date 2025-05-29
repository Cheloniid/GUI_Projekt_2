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
                view.setController(controller);
                controller.startGame();
            }
        });
    }
}
// TODO Work on diff settings
// TODO przesuwanie strzałkami
// TODO przesuwanie JButtonami
// TODO strzelanie spacją
// TODO strzelanie JButtonem
// TODO ekran startowy ze zdjęciem
// TODO rzędy wrogów
// TODO poruszanie wrogów
// TODO opadanie wrogów
// TODO znikanie wrogów po trafieniu
// TODO punktacja
// TODO nick
// TODO zasady gry
// TODO ponowna rozgrywka
// TODO pauza
// TODO top 10
// TODO zapis top 10 do pliku
// TODO 8 komponentów swing
// TODO JMenuBar
// TODO 2 okna
// TODO 4 layouty
// TODO 3 layouty w jednym jframe
// TODO streamy
// TODO interfejsy
// TODO watki
// TODO