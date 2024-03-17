package personages;

import base.Character;
import base.Coordinates;

public class Wizard extends Character {
    public Wizard(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.initiative = 1;
    }

    @Override
    public void step() {

    }
}
