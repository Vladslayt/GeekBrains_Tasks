package personages.arrows;

import base.models.Arrows;
import base.Coordinates;

/**
 * Арбалетчик
 */
public class Crossbowman extends Arrows {
    public Crossbowman(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.ammunition = 3;
        this.maxAmmunition = 3;
        this.initiative = 3;

        this.health = 2;
        this.maxHealth = 2;

        this.range = 3;
        this.damage = 3;
    }
}
