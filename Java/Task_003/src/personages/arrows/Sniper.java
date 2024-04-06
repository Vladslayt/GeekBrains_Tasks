package personages.arrows;

import base.models.Arrows;
import base.Coordinates;

/**
 * Снайпер
 */
public class Sniper extends Arrows {
    public Sniper(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.ammunition = 3;
        this.maxAmmunition = 3;
        this.initiative = 3;

        this.health = 2;
        this.maxHealth = 2;

        this.range = 5;
        this.damage = 1;
    }
}
