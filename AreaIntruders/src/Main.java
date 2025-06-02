import controller.GameController;
import model.GameModel;
import view.MainFrame;
import view.SplashScreen;

import javax.swing.*;

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

// TODO Work on diff settings
// ilość wrogów na linię powinna być uzależniona od poziomu trudności
// przesuwanie strzałkami
// przesuwanie JButtonami
// strzelanie spacją
// strzelanie JButtonem
// 1 ekran startowy ze zdjęciem i progressbarem
// TODO 2 optionPane do nicka
// TODO 3 zaczyna się gra
// 4 pauza P + menu
// 5 nowa gra menu
// TODO 6 top 10 nowe okno
// 7 menu pomoc/zasady gry
// poziom trudności w menu
// TODO zapis top 10 do pliku
// TODO dodawanie topscore przy exit i newgame
// rzędy wrogów
// poruszanie wrogów
// opadanie wrogów
// znikanie wrogów po trafieniu
// punktacja
// TODO 8 komponentów swing
// TODO 2 okna
// 4 layouty
// 3 layouty w jednym jframe
// TODO streamy
// TODO interfejsy
// TODO targetpractice/ tower defense
// watki

// TODO server top10
// TODO pobieranie gry ze strony
// TODO large enemy
//  TODO lvle i bonus points