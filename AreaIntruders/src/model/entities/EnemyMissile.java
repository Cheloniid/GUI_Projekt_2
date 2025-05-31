package model.entities;

import utils.Constants;

public class EnemyMissile extends Projectile {
    public EnemyMissile(int x, int y) {
        super(x, y);
        this.speed = Constants.ENEMY_MISSILE_SPEED;
    }

    public void move(){
        this.floatY += this.speed;
        this.y = (int) floatY;
    }
}
