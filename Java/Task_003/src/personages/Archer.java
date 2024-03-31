package personages;

import base.Character;
import base.Coordinates;

import java.util.List;

import static base.AnsiColors.ANSI_RED;

public class Archer extends Character {
    int arrows;

    public Archer(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.arrows = 10;
        this.initiative = 3;
    }

    @Override
    public void step(List<Character> enemies) {
        if (!isAlive || arrows <= 0) {
            return;
        }

        Character closestEnemy = findClosestEnemy(enemies);

        if (closestEnemy != null) {
            closestEnemy.isAlive = false;
            arrows--;
            this.lastAction = ANSI_RED + this.name + " на позиции (" + this.coordinates.x + ", " + this.coordinates.y + ") убил " + closestEnemy.name + " на позиции (" + closestEnemy.coordinates.x + ", " + closestEnemy.coordinates.y + ")";

        }
    }
}
