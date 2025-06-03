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

// TODO Work on diff settings
// ilość wrogów na linię powinna być uzależniona od poziomu trudności
// przesuwanie strzałkami
// przesuwanie JButtonami
// strzelanie spacją
// strzelanie JButtonem
// 1 ekran startowy ze zdjęciem i progressbarem
// optionPane do nicka
// zaczyna się gra
// 4 pauza P + menu
// 5 nowa gra menu
// TODO 6 top 10 nowe okno
// TODO wczytywanie top10 z pliku, jeżeli serwer niedostępny
// TODO zapisywanie topscore offline, jeżeli nie ma potwierdzenia z serwera o zapisaniu
// 7 menu pomoc/zasady gry
// poziom trudności w menu
// TODO zapis top 10 do pliku
// TODO dodawanie topscore przy exit i newgame
// TODO zapisywanie nieudanego wprowadzenia nicka na serwer
// TODO nick score godzina
// rzędy wrogów
// poruszanie wrogów
// opadanie wrogów
// znikanie wrogów po trafieniu
// punktacja
// TODO 8 komponentów swing
// TODO 2 okna
// 4 layouty
// 3 layouty w jednym jframe
// streamy
// TODO interfejsy
// TODO targetpractice/ tower defense
// watki

// TODO server top10
// TODO pobieranie gry ze strony

/*
System.out.println(System.getProperty("user.name"));
                try {
                    System.out.println(InetAddress.getLocalHost().getHostName());
                } catch (UnknownHostException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(System.getProperty("user.dir"));
                System.out.println(System.getProperty("user.home"));
                System.out.println(System.getProperty("os.name"));
 */