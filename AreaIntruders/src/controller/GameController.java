package controller;

import model.GameModel;
import view.MainFrame;

import javax.swing.*;

public class GameController {
    private final GameModel model;
    private final MainFrame view;
    private final Timer gameTimer;

    public GameController(GameModel model, MainFrame view) {
        this.model = model;
        this.view = view;

        gameTimer = new Timer(1000 / 60, e -> {
            model.update();
            view.repaint();
        });


        setInput();
    }

    private void setInput() {

    }

    public void startGame() {
        gameTimer.start();
    }

}
