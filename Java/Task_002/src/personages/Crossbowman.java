package personages;

import base.Coordinates;
import base.Character;

public class Crossbowman extends Character {
    public Crossbowman(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    // Метод для поиска ближайшего противника
    Crossbowman findClosestEnemy(Crossbowman[] enemies) {
        Crossbowman closestEnemy = null;
        double minDistance = Double.MAX_VALUE;

        for (Crossbowman enemy : enemies) {
            double distance = calculateDistance(this.coordinates, enemy.coordinates);
            if (distance < minDistance) {
                minDistance = distance;
                closestEnemy = enemy;
            }
        }

        return closestEnemy;
    }

    // Метод для вычисления расстояния между двумя координатами
    private double calculateDistance(Coordinates c1, Coordinates c2) {
        return Math.sqrt(Math.pow(c2.x - c1.x, 2) + Math.pow(c2.y - c1.y, 2));
    }
}