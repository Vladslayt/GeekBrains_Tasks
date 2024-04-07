package base;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static base.AnsiColors.ANSI_RESET;

@Getter
@Setter
public abstract class Character implements Steppable {
    protected String name;
    @Getter
    protected Coordinates coordinates;
    protected int initiative;
    protected int health;
    protected int maxHealth;
    protected int range;
    protected int damage;
    public String lastAction = null;
    protected boolean isAlive;

    protected Character(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.isAlive = true;
    }

    public String getInfo() {
        return lastAction;
    }

    public Character findClosestEnemyOrTeammate(List<Character> team) {
        Character closestHero = null;
        double closestDistance = Double.POSITIVE_INFINITY;

        for (Character hero : team) {
            if (hero.isAlive) {
                double distance = Math.hypot(hero.coordinates.x - this.coordinates.x, hero.coordinates.y - this.coordinates.y);
                if (distance < closestDistance) {
                    closestDistance = distance;
                    closestHero = hero;
                }
            }
        }

        return closestHero;
    }

    public boolean getAlive(){
        return isAlive;
    }
    public void setAlive(boolean value){
        isAlive = value;
    }

    @Override
    public String toString(){
        return this.name + " на позиции (" + this.coordinates.x + ", " + this.coordinates.y + ") ";
    }
}
