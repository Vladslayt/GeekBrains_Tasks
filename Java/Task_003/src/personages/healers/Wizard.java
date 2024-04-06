package personages.healers;

import base.models.Arrows;
import base.Coordinates;
import base.models.Healers;

/**
 * Волшебник
 */
public class Wizard extends Healers {
    public Wizard(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.initiative = 1;

        this.health = 1;
        this.maxHealth = 1;

        this.range = 4;
        this.damage = 1;
    }
}
