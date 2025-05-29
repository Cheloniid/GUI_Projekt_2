package controller;

import model.GameModel;
import view.MainFrame;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class GameController {
    private final GameModel model;
    private final MainFrame view;
    private final Timer gameTimer;

    public GameController(GameModel model, MainFrame view) {
        this.model = model;
        this.view = view;

        gameTimer = new Timer(1000 / 60, e -> {
            if (view.getPressedKeys().contains(KeyEvent.VK_LEFT)){
                moveLeft();
            }
            if (view.getPressedKeys().contains(KeyEvent.VK_RIGHT)){
                moveRight();
            }
            model.update();
            view.repaintGamePanel();
        });


        setInput();
    }

    public void moveRight(){
        model.moveRigth();
    }

    public void moveLeft(){
        model.moveLeft();
    }

    private void setInput() {

    }

    public void startGame() {
        gameTimer.start();
    }

}
