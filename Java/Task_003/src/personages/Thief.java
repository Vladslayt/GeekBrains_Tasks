package personages;

import base.Character;
import base.Coordinates;

public class Thief extends Character {
    public Thief(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.initiative = 2;
    }
}
