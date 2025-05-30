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
        for (int row = 0; row < Constants.ENEMY_ROWS; row++){
            for (int col = 0; col < Constants.ENEMY_COLUMNS; col++){
                enemies.add(new SmallEnemy(
                        Constants.ENEMY_HORIZONTAL_RANGE + 20 + col * Constants.GAP_BETWEEN_ENEMY_COLUMNS,
                        50 + row * Constants.GAP_BETWEEN_ENEMY_ROWS));
            }
        }
    }

    public void update() {
        enemies.stream().forEach(enemy -> enemy.move());
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
