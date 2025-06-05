package controller;

import model.DataToUpload;
import model.GameModel;
import utils.*;
import view.MainFrame;
import view.NicknameDialog;

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
    private boolean scoresUploaded;
    private String playerName;


    public GameController(GameModel model, MainFrame view) {
        this.model = model;
        this.view = view;
        pressedKeys = new HashSet<>();
        isGameStarted = false;
        isGamePaused = false;
        isGameOver = false;
        scoresUploaded = false;

        do {
            playerName = NicknameDialog.show(
                    view,
                    "Enter your nickname.\n\nIt will be sent along with your score\n" +
                            "and basic system info to the game server.\n\n", "Nickname");
        } while (playerName.isEmpty() || playerName.length() > 20 || !NickValidator.validate(playerName));

        model.getPlayer().setName(playerName);

        view.showInstructionsDialog(view, this, "Start Game");
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

        if (Constants.DEBUG_MODE && isGamePaused){
            DataUploader.uploadData(JSONConverter.toJSON(new DataToUpload(model.getPlayer())));
            System.out.println(DataFetcher.fetchData());
        }


    }

    public void startNewGame() {
        // Upload scores from the previous game
        if(isGameStarted) {
            uploadScores();
        }

        model.reset();
        pressedKeys.clear();
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
        scoresUploaded = false;
    }

    public void onGameOver() {
        gameTimer.stop();
        isGameOver = true;
        isGameStarted = false;
        isGamePaused = false;

        uploadScores();

        //DataUploader.uploadData(JSONConverter.toJSON(new DataToUpload(model.getPlayer())));
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

    public boolean isGameOver() {
        return isGameOver;
    }

    public boolean isGamePaused() {
        return isGamePaused;
    }

    public boolean isGameStarted() {
        return isGameStarted;
    }

    public void uploadScores(){
        if (!scoresUploaded){
            DataUploader.uploadData(JSONConverter.toJSON(new DataToUpload(model.getPlayer())));
        }
        scoresUploaded = true;
    }

    public boolean isScoresUploaded() {
        return scoresUploaded;
    }
}
