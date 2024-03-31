package personages;

import base.Character;
import base.Coordinates;

public class Sniper extends Character {
    public Sniper(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.initiative = 2;
    }
}
