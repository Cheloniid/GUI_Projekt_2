package controller;

import model.GameModel;
import view.MainFrame;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public class GameController {
    private final GameModel model;
    private final MainFrame view;
    private final Timer gameTimer;
    private final Set<Integer> pressedKeys;

    public GameController(GameModel model, MainFrame view) {
        this.model = model;
        this.view = view;
        pressedKeys = new HashSet<>();

        gameTimer = new Timer(1000 / 60, e -> {
            if (pressedKeys.contains(KeyEvent.VK_LEFT)){
                moveLeft();
            }
            if (pressedKeys.contains(KeyEvent.VK_RIGHT)){
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

    public void fire(){
        System.out.println("FIRE!");
        model.shootPlayersMissile();
    }

    public void startGame() {
        gameTimer.start();
    }

    public Set<Integer> getPressedKeys() {
        return pressedKeys;
    }
}
