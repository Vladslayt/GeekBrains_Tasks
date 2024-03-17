package personages;

import base.Coordinates;
import base.Character;

public class Archer extends Character {
    public Archer(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    Crossbowman findClosestEnemy(Crossbowman[] enemies) {
        Crossbowman closestEnemy = null;
        double minDistance = Double.MAX_VALUE;

        for (Crossbowman enemy : enemies) {
            double distance = Coordinates.calculateDistance(this.coordinates, enemy.coordinates);
            if (distance < minDistance) {
                minDistance = distance;
                closestEnemy = enemy;
            }
        }

        return closestEnemy;
    }
}