package model;

import utils.Constants;

public class Player {
    private int x;
    private int y;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
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
}
