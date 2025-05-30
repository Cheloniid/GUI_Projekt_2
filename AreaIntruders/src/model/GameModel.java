package model;

import model.entities.Enemy;
import model.entities.Player;
import model.entities.PlayerMissile;
import model.entities.SmallEnemy;
import utils.Constants;
import utils.DifficultySettings;

import java.util.ArrayList;
import java.util.List;

public class GameModel {
    private Player player;
    private ArrayList<Enemy> enemies;
    private DifficultySettings difficultySettings;
    private List<PlayerMissile> playerMissiles;
    private long lastPlayersMissileStart = 0;
    private EnemyHitDetector enemyHitDetector;

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

        playerMissiles = new ArrayList<>();
        enemyHitDetector = new EnemyHitDetector(playerMissiles, enemies);
    }

    public void update() {
        enemies.stream().forEach(enemy -> enemy.move());
        playerMissiles.stream().forEach(playerMissile -> playerMissile.move());
        enemyHitDetector.detect();
    }

    public void shootPlayersMissile(){
        if (System.currentTimeMillis() - lastPlayersMissileStart > difficultySettings.playersFireInterval){
            playerMissiles.add(new PlayerMissile(player.getX() + Constants.PLAYER_WIDTH / 2 - 2, player.getY()));
            lastPlayersMissileStart = System.currentTimeMillis();
        }
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public List<PlayerMissile> getPlayerMissiles() {
        return playerMissiles;
    }

    public void moveRigth(){
        player.moveRight();
    }

    public void moveLeft(){
        player.moveLeft();
    }
}
