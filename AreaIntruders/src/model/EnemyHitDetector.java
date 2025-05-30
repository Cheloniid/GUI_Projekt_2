package model;

import model.entities.Enemy;
import model.entities.Projectile;
import utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class EnemyHitDetector implements HitDetector {
    private List<Projectile> projectiles;
    private List<Enemy> enemies;

    public EnemyHitDetector(List projectiles, List enemies) {
        this.projectiles = projectiles;
        this.enemies = enemies;
    }

    public void detect() {
        List<Projectile> projectilesToRemove = new ArrayList<>();
        List<Enemy> enemiesToRemove = new ArrayList<>();
        for (Projectile projectile : projectiles) {
            int x = projectile.getX() + 2;
            int y = projectile.getY();
            for (Enemy enemy : enemies) {
                if (x >= enemy.getX() - 2 && x <= enemy.getX() + 40 * Constants.SMALL_ENEMY_SIZE + 2
                    && y >= enemy.getY() && y <= enemy.getY() + 10 * Constants.SMALL_ENEMY_SIZE){
                    projectilesToRemove.add(projectile);
                    enemiesToRemove.add(enemy);
                }
            }
        }
        projectiles.removeAll(projectilesToRemove);
        enemies.removeAll(enemiesToRemove);
    }
}
