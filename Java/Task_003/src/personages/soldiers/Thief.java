package personages.soldiers;

import base.Coordinates;
import base.models.Soldier;

/**
 * Вор
 */
public class Thief extends Soldier {
    public Thief(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.initiative = 2;

        this.health = 7;
        this.maxHealth = 7;

        this.range = 1;
        this.damage = 4;
    }
}
