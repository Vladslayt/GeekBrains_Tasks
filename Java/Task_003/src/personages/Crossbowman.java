package personages;

import base.Character;
import base.Coordinates;

public class Crossbowman extends Character {
    public Crossbowman(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.initiative = 2;
    }

    @Override
    public void step() {

    }
}
