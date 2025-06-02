package model.entities;

import utils.Constants;

public class Player {
    private int x;
    private int y;
    private int health;
    private int score;
    private int level;
    private String name;


    public Player() {
        this.x = Player.getStartingX();
        this.y = Player.getStartingY();
        this.health = 100;
        this.score = 0;
        this.level = 1;
    }

    public void reset(){
        this.x = Player.getStartingX();
        this.y = Player.getStartingY();
        this.health = 100;
        this.score = 0;
        this.level = 1;
    }

    public static int getStartingX(){
        return Constants.PANEL_WIDTH / 2 - Constants.PLAYER_WIDTH / 2;
    }
    public static int getStartingY(){
        return Constants.PANEL_HEIGHT - Constants.PLAYER_HEIGHT - 20;
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

    public void setName(String name){
        this.name = name;
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
        this.score += score * 10 * level;
    }

    public void subtractHealth(int hits){
        if (this.health > 0){
            this.health -= hits * Constants.PLAYER_HEALTH_LOSS_BY_HIT;
        }
    }

    public void kill(){
        this.health = 0;
    }

    public boolean isDead(){
        return this.health <= 0;
    }

    public int getLevel() {
        return level;
    }

    public void levelUp(){
        this.level++;
    }
}
