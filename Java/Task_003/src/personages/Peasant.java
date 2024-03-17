package personages;

import base.Character;
import base.Coordinates;

public class Peasant extends Character {
    public Peasant(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.initiative = 0;
    }

    @Override
    public void step() {

    }
}
