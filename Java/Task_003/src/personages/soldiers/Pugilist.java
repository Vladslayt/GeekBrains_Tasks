package personages.soldiers;

import base.Coordinates;
import base.models.Soldier;

/**
 * Копейщик
 */
public class Pugilist extends Soldier {
    public Pugilist(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.initiative = 2;

        this.health = 6;
        this.maxHealth = 6;

        this.range = 1;
        this.damage = 4;
    }
}
