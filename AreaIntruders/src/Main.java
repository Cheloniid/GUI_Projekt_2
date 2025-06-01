import controller.GameController;
import model.GameModel;
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
// TODO 1 ekran startowy ze zdjęciem i progressbarem
// TODO 2 optionPane do nicka
// TODO 3 zaczyna się gra
// 4 pauza P + menu
// 5 nowa gra menu
// TODO 6 top 10 nowe okno
// TODO 7 menu pomoc/zasady gry
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
// watki

// TODO server top10
// TODO pobieranie gry ze strony
// TODO large enemy
//  TODO lvle i bonus points