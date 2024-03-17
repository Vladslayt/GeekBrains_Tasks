package base;

public abstract class Character implements Steppable{
    public String name;
    public Coordinates coordinates;
    public int initiative;
    public boolean isAlive;

    protected Character(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.isAlive = true;
    }
}
