package personages.healers;

import base.models.Arrows;
import base.Coordinates;
import base.models.Healers;

/**
 * Монах
 */
public class Monk extends Healers {
    public Monk(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.initiative = 2;

        this.health = 1;
        this.maxHealth = 1;

        this.range = 3;
        this.damage = 1;
    }
}
