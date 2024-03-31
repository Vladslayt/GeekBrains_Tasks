package base;

import java.util.List;

public class Soldier {
    private int x;
    private int y;
    private boolean isAlive;

    public Soldier(int x, int y) {
        this.x = x;
        this.y = y;
        this.isAlive = true;
    }

    public void step(List<Soldier> enemies) {
        if (!isAlive) {
            return;
        }

        Soldier closestEnemy = findClosestEnemy(enemies);
        if (closestEnemy == null) {
            return;
        }

        int dX = closestEnemy.x - this.x;
        int dY = closestEnemy.y - this.y;

        if (Math.abs(dX) <= 1 && Math.abs(dY) <= 1) {
            closestEnemy.isAlive = false;
        } else {
            if (Math.abs(dX) > Math.abs(dY)) {
                this.x += Integer.compare(dX, 0);
            } else {
                this.y += Integer.compare(dY, 0);
            }
        }
    }

    private Soldier findClosestEnemy(List<Soldier> enemies) {
        Soldier closestEnemy = null;
        double closestDistance = Double.POSITIVE_INFINITY;

        for (Soldier enemy : enemies) {
            double distance = Math.hypot(enemy.x - this.x, enemy.y - this.y);
            if (distance < closestDistance) {
                closestDistance = distance;
                closestEnemy = enemy;
            }
        }

        return closestEnemy;
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

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}