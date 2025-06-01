package controller;

import model.GameModel;
import view.MainFrame;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public class GameController {
    private final Set<Integer> pressedKeys;
    private GameModel model;
    private MainFrame view;
    private Timer gameTimer;
    private boolean isGameStarted;
    private boolean isGamePaused;
    private boolean isGameOver;
    private int frames;
    private long start;
    private long end;

    public GameController(GameModel model, MainFrame view) {
        this.model = model;
        this.view = view;
        pressedKeys = new HashSet<>();
        isGameStarted = false;
        isGamePaused = false;
        isGameOver = false;

        startNewGame();
    }

    private void onTimer() {
        if (pressedKeys.contains(KeyEvent.VK_LEFT)) {
            moveLeft();
        }
        if (pressedKeys.contains(KeyEvent.VK_RIGHT)) {
            moveRight();
        }
        model.update();
        view.repaintGamePanel();
        view.getScorePanel().update();
        view.getHealthPanel().update();

        if (model.getPlayer().isDead()){
            onGameOver();
        }
    }

    public void pauseResumeGame() {
        if (isGameStarted && !isGamePaused && !isGameOver) {
            isGamePaused = true;
            gameTimer.stop();
        } else if (isGameStarted && isGamePaused && !isGameOver) {
            isGamePaused = false;
            gameTimer.restart();
        }
    }

    public void startNewGame() {
        model.reset();
        if (this.gameTimer != null && this.gameTimer.isRunning()){
            this.gameTimer.stop();
        }
        this.gameTimer = new Timer(1000 / 60, e -> {
            onTimer();
        });
        this.gameTimer.start();
        isGameStarted = true;
        isGamePaused = false;
        isGameOver = false;
    }

    public void onGameOver() {
        gameTimer.stop();
        isGameOver = true;
        isGameStarted = false;
        isGamePaused = false;
        view.showEndGameMsg(model.getPlayer().getScore());
    }

    public void moveRight() {
        model.moveRigth();
    }

    public void moveLeft() {
        model.moveLeft();
    }

    public void fire() {
        model.shootPlayersMissile();
    }

    public Set<Integer> getPressedKeys() {
        return pressedKeys;
    }

    public void setModel(GameModel model) {
        this.model = model;
    }
}
