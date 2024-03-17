package base;

public abstract class Character {
    public String name;
    public Coordinates coordinates;

    protected Character(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }
}