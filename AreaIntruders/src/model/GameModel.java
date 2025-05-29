package model;

import utils.Constants;
import utils.DifficultySettings;

import java.util.ArrayList;

public class GameModel {
    private Player player;
    private ArrayList<Enemy> enemies;
    private DifficultySettings difficultySettings;

    public GameModel() {
        difficultySettings = DifficultySettings.easySettings();

        player = new Player(Constants.PANEL_WIDTH / 2 - Constants.PLAYER_WIDTH / 2,
                Constants.PANEL_HEIGHT - Constants.PLAYER_HEIGHT - 20);

        enemies = new ArrayList<>();
        enemies.add(new SmallEnemy(100, 100));
        enemies.add(new LargeEnemy(200, 200));
    }

    public void update() {
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public void moveRigth(){
        player.moveRight();
    }

    public void moveLeft(){
        player.moveLeft();
    }
}
