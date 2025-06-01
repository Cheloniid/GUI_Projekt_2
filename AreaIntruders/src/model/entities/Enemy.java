package model.entities;

import utils.Constants;
import utils.Direction;

public abstract class Enemy {
    private int x;
    private int y;
    private float floatX;
    private float floatY;
    private int startingX;
    private Direction direction;
    private float speed;
    private float descentRate;

    public Enemy(int x, int y, float descentRate) {
        this.x = x;
        this.floatX = x;
        this.startingX = x;
        this.floatY = y;
        this.y = y;
        this.descentRate = descentRate;
        // Zawsze zaczyna się poruszać w lewo
        this.direction = Direction.LEFT;
        this.speed = Constants.ENEMY_SPEED;
    }

    public void move() {
        if (direction == Direction.LEFT) {
            floatX = floatX - speed;
        } else if (direction == Direction.RIGHT) {
            floatX = floatX + speed;
        }
        if (floatX < startingX - Constants.ENEMY_HORIZONTAL_RANGE || floatX > startingX){
            changeDirection();
        }

        this.floatY += descentRate;

        x = (int) floatX;
        y = (int) floatY;
    }

    private void changeDirection() {
        if (direction == Direction.LEFT) {
            direction = Direction.RIGHT;
        } else if (direction == Direction.RIGHT) {
            direction = Direction.LEFT;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {

        this.x = x;
        this.floatX = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getFloatX() {
        return floatX;
    }
}
