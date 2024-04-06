package personages.arrows;

import base.models.Arrows;
import base.Coordinates;

/**
 * Лучник
 */
public class Archer extends Arrows {
    public Archer(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.ammunition = 3;
        this.maxAmmunition = 3;
        this.initiative = 3;

        this.health = 4;
        this.maxHealth = 4;

        this.range = 4;
        this.damage = 2;
    }
}
