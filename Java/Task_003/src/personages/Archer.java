package personages;

import base.Character;
import base.Coordinates;

public class Archer extends Character {
    int arrows;

    public Archer(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.arrows = 10;
        this.initiative = 3;
    }

    Archer findClosestEnemy(Archer[] enemies) {
        Archer closestEnemy = null;
        double minDistance = Double.MAX_VALUE;

        for (Archer enemy : enemies) {
            double distance = Coordinates.calculateDistance(this.coordinates, enemy.coordinates);
            if (distance < minDistance) {
                minDistance = distance;
                closestEnemy = enemy;
            }
        }

        return closestEnemy;
    }

    @Override
    public void step() {
        if (!isAlive || arrows <= 0) {
            return;
        }

        Archer[] enemies = new Archer[10];
        Archer closestEnemy = findClosestEnemy(enemies);

        if (closestEnemy != null) {
            closestEnemy.isAlive = false;
            arrows--;
        }
    }
}
