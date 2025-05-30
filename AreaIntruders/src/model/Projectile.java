package model;

public class Projectile {
    int x;
    int y;
    float floatY;
    float speed;

    public Projectile(int x, int y) {
        this.x = x;
        this.y = y;
        this.floatY = y;
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
}
