package model.entities;

import utils.Constants;

public class Player {
    private int x;
    private int y;
    private int health;
    private int score;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.health = 100;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void moveRight() {
        if (x < Constants.PANEL_WIDTH - Constants.PLAYER_WIDTH) {
            this.x += Constants.PLAYER_SPEED;
        }
    }

    public void moveLeft() {
        if (x > 0) {
            this.x -= Constants.PLAYER_SPEED;
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public void subtractHealth(int hits){
        this.health -= hits * 10;
    }
}
