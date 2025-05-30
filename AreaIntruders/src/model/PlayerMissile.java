package model;

import utils.Constants;

public class PlayerMissile extends Projectile{
    public PlayerMissile(int x, int y) {
        super(x, y);
        this.speed = Constants.PLAYER_MISSILE_SPEED;
    }

    public void move() {
        this.floatY -= speed;
        this.y = (int) this.floatY;
    }
}
