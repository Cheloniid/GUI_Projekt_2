package model;

import model.entities.*;
import utils.Constants;
import utils.Difficulty;
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
        difficultySettings = DifficultySettings.normalSettings();

        player = new Player();

        enemies = new ArrayList<>();
        generateEnemies(enemies);

        playerMissiles = new ArrayList<>();
        enemyMissiles = new ArrayList<>();
        enemyHitDetector = new EnemyHitDetector(playerMissiles, enemies);
        playerHitDetector = new PlayerHitDetector(player, enemyMissiles);
    }

    public void update() {
        enemies.stream().forEach(Enemy::move);
        playerMissiles.stream().forEach(PlayerMissile::move);
        enemyMissiles.stream().forEach(EnemyMissile::move);

        if (Constants.DETECT_COLLISIONS_WITH_ENEMY) {
            player.addScore(enemyHitDetector.getNumberOfHits());
        }
        if (Constants.DETECT_COLLISIONS_WITH_PLAYER) {
            player.subtractHealth(playerHitDetector.getNumberOfHits());
        }

        if (checkPlayerEnemyCollision(player, enemies)) {
            player.kill();
        }

        if (Constants.SHOOT_ENEMY_MISSILES) {
            for (Enemy enemy : enemies) {
                if (randomGen.nextDouble() < difficultySettings.fireChance) {
                    shootEnemyMissile(enemy);
                }
            }
        }

        if (enemies.isEmpty()) {
            generateEnemies(enemies);
            difficultySettings.increaseDifficulty();
        }
    }

    public void reset(){
        if (difficultySettings.description == Difficulty.EASY){
            difficultySettings = DifficultySettings.easySettings();
        } else if (difficultySettings.description == Difficulty.NORMAL){
            difficultySettings = DifficultySettings.normalSettings();
        }

        player.reset();

        enemies = new ArrayList<>();
        generateEnemies(enemies);

        playerMissiles = new ArrayList<>();
        enemyMissiles = new ArrayList<>();
        lastPlayersMissileStart = 0;

        enemyHitDetector = new EnemyHitDetector(playerMissiles, enemies);
        playerHitDetector = new PlayerHitDetector(player, enemyMissiles);
    }

    public void changeDifficulty(DifficultySettings difficultySettings) {
        System.out.println("changeDifficulty");
        this.difficultySettings = difficultySettings;
    }

    public void generateEnemies(List<Enemy> enemies) {
        for (int row = 0; row < Constants.ENEMY_ROWS; row++) {
            for (int col = 0; col < difficultySettings.enemyColumns; col++) {
                enemies.add(new SmallEnemy(
                        Constants.ENEMY_HORIZONTAL_RANGE + 20 + col * Constants.GAP_BETWEEN_ENEMY_COLUMNS,
                        50 + row * Constants.GAP_BETWEEN_ENEMY_ROWS,
                                difficultySettings.enemiesDescentRate)
                            );
            }
        }
    }

    public void shootPlayersMissile() {
        if (System.currentTimeMillis() - lastPlayersMissileStart > Constants.PLAYER_FIRE_INTERVAL) {
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

    private boolean checkPlayerEnemyCollision(Player player, ArrayList<Enemy> enemies){
        if (enemies.isEmpty()) {
            return false;
        }
        Enemy lastEnemy = enemies.getLast();
        if (lastEnemy.getY() + 10 >= player.getY()) {
            return true;
        }
        return false;
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
