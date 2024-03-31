package personages;

import base.Character;
import base.Coordinates;

public class Pugilist extends Character {
    public Pugilist(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.initiative = 2;
    }
}
