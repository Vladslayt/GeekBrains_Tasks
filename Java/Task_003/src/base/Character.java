package base;

import java.util.List;

import static base.AnsiColors.ANSI_RED;
import static base.AnsiColors.ANSI_RESET;

public abstract class Character implements Steppable{
    public String name;
    public Coordinates coordinates;
    public int initiative;
    public boolean isAlive;
    public String lastAction = null;

    protected Character(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.isAlive = true;
    }

    public String getInfo() {
        return lastAction;
    }
    public Character findClosestEnemy(List<Character> enemies) {
        Character closestEnemy = null;
        double closestDistance = Double.POSITIVE_INFINITY;

        for (Character enemy : enemies) {
            if (enemy.isAlive) {
                double distance = Math.hypot(enemy.coordinates.x - this.coordinates.x, enemy.coordinates.y - this.coordinates.y);
                if (distance < closestDistance) {
                    closestDistance = distance;
                    closestEnemy = enemy;
                }
            }
        }

        return closestEnemy;
    }
    @Override
    public void step(List<Character> enemies) {
        if (!isAlive) {
            return;
        }

        Character closestEnemy = findClosestEnemy(enemies);
        if (closestEnemy == null) {
            return;
        }

        int dX = closestEnemy.coordinates.x - this.coordinates.x;
        int dY = closestEnemy.coordinates.y - this.coordinates.y;

        if (Math.abs(dX) <= 1 && Math.abs(dY) <= 1) {
            closestEnemy.isAlive = false;
            this.lastAction = ANSI_RED + this.name + " на позиции (" + this.coordinates.x + ", " + this.coordinates.y + ") убил " + closestEnemy.name + " на позиции (" + closestEnemy.coordinates.x + ", " + closestEnemy.coordinates.y + ")";
        } else {
            if (Math.abs(dX) > Math.abs(dY)) {
                this.coordinates.x += Integer.compare(dX, 0);
            } else {
                this.coordinates.y += Integer.compare(dY, 0);
            }
            this.lastAction = ANSI_RESET + this.name + " на позиции (" + this.coordinates.x + ", " + this.coordinates.y + ") сделал ход в направлении противника";
        }
    }
}
