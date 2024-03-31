package personages;

import base.Character;
import base.Coordinates;

public class Monk extends Character {
    public Monk(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.initiative = 2;
    }
}
