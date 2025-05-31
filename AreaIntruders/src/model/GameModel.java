package model;

import model.entities.*;
import utils.Constants;
import utils.DifficultySettings;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameModel {
    private Player player;
    private ArrayList<Enemy> enemies;
    private DifficultySettings difficultySettings;
    private List<PlayerMissile> playerMissiles;
    private List<EnemyMissile> enemyMissiles;
    private long lastPlayersMissileStart = 0;
    private EnemyHitDetector enemyHitDetector;
    private PlayerHitDetector playerHitDetector;
    Random randomGen;

    public GameModel() {
        this.randomGen = new Random();
        difficultySettings = DifficultySettings.easySettings();

        player = new Player(Constants.PANEL_WIDTH / 2 - Constants.PLAYER_WIDTH / 2,
                Constants.PANEL_HEIGHT - Constants.PLAYER_HEIGHT - 20);

        enemies = new ArrayList<>();
        for (int row = 0; row < Constants.ENEMY_ROWS; row++) {
            for (int col = 0; col < Constants.ENEMY_COLUMNS; col++) {
                enemies.add(new SmallEnemy(
                        Constants.ENEMY_HORIZONTAL_RANGE + 20 + col * Constants.GAP_BETWEEN_ENEMY_COLUMNS,
                        50 + row * Constants.GAP_BETWEEN_ENEMY_ROWS));
            }
        }

        playerMissiles = new ArrayList<>();
        enemyMissiles = new ArrayList<>();
        enemyHitDetector = new EnemyHitDetector(playerMissiles, enemies);
        playerHitDetector = new PlayerHitDetector(player, enemyMissiles);
    }

    public void update() {
        enemies.stream().forEach(enemy -> enemy.move());
        playerMissiles.stream().forEach(playerMissile -> playerMissile.move());
        enemyMissiles.stream().forEach(EnemyMissile::move);

        if (Constants.DETECT_COLLISIONS_WITH_ENEMY) {
            player.addScore(enemyHitDetector.getNumberOfHits());
        }
        if (Constants.DETECT_COLLISIONS_WITH_PLAYER) {
            player.subtractHealth(playerHitDetector.getNumberOfHits());
        }

        if (Constants.SHOOT_ENEMY_MISSILES) {
            for (Enemy enemy : enemies) {
                if (randomGen.nextDouble() < difficultySettings.fireChance) {
                    shootEnemyMissile(enemy);
                }
            }
        }
    }

    public void shootPlayersMissile() {
        if (System.currentTimeMillis() - lastPlayersMissileStart > difficultySettings.playersFireInterval) {
            playerMissiles.add(new PlayerMissile(player.getX() + Constants.PLAYER_WIDTH / 2 - 2, player.getY()));
            lastPlayersMissileStart = System.currentTimeMillis();
        }
    }

    public void shootEnemyMissile(Enemy enemy) {
        enemyMissiles.add(
                new EnemyMissile(
                        enemy.getX() + (int) Constants.SMALL_ENEMY_SIZE * 20,
                        enemy.getY() + (int) Constants.SMALL_ENEMY_SIZE * 10));
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

    public List<EnemyMissile> getEnemyMissiles() {
        return enemyMissiles;
    }

    public void moveRigth() {
        player.moveRight();
    }

    public void moveLeft() {
        player.moveLeft();
    }
}
