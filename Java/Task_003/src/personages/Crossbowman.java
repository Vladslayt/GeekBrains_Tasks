package personages;

import base.Character;
import base.Coordinates;

import java.util.List;

public class Crossbowman extends Character {
    public Crossbowman(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.initiative = 2;
    }
}
