package model;

import utils.Constants;

public class EnemyMissile extends Projectile {
    public EnemyMissile(int x, int y) {
        super(x, y);
        this.speed = Constants.ENEMY_MISSILE_SPEED;
    }
}
