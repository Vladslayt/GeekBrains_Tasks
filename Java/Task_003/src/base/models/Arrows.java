package base.models;

import base.Character;
import base.Coordinates;
import base.Steppable;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static base.AnsiColors.*;

@Getter
@Setter
public class Arrows extends Character implements Steppable {

    protected int ammunition;
    protected int maxAmmunition;
    protected Arrows(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void step(List<Character> teammate, List<Character> enemies) {
        if (!isAlive) {
            this.lastAction = ANSI_RESET + this.name + " на позиции (" + this.coordinates.x + ", " + this.coordinates.y + ") мертв";
            return;
        }
        if(ammunition <= 0){
            this.lastAction = ANSI_YELLOW + this.name + " на позиции (" + this.coordinates.x + ", " + this.coordinates.y + ") закончились боеприпасы!!!";
            return;
        }

        Character closestEnemy = findClosestEnemyOrTeammate(enemies);
        if(damageClosestEnemy(closestEnemy))
            return;

        int dX = closestEnemy.getCoordinates().x - this.coordinates.x;
        int dY = closestEnemy.getCoordinates().y - this.coordinates.y;

        if (Math.abs(dX) > Math.abs(dY)) {
            this.coordinates.x += Integer.compare(dX, 0);
        } else {
            this.coordinates.y += Integer.compare(dY, 0);
        }
        this.lastAction = ANSI_WHITE + this.name + " на позиции (" + this.coordinates.x + ", " + this.coordinates.y + ") сделал ход в направлении противника";
    }

    public boolean damageClosestEnemy(Character enemy) {
        if(Coordinates.calculateDistance(this.coordinates, enemy.getCoordinates()) > this.range) {
            this.lastAction = ANSI_BLACK + this.name + " на позиции (" + this.coordinates.x + ", " + this.coordinates.y + ") не достает до ближайших врагов";
            return false;
        }
        this.ammunition--;

        if(enemy.getHealth() - this.damage < 1){
            enemy.setAlive(false);
            enemy.setHealth(enemy.getMaxHealth());
            this.lastAction = ANSI_PURPLE + this.name + " на позиции (" + this.coordinates.x + ", " + this.coordinates.y + ") убил " + enemy.getName() + " на позиции (" + enemy.getCoordinates().x + ", " + enemy.getCoordinates().y + ")";
        } else {
            enemy.setHealth(enemy.getHealth() - this.damage);
            this.lastAction = ANSI_RED + this.name + " на позиции (" + this.coordinates.x + ", " + this.coordinates.y + ") нанес " + this.damage + " урона " + enemy.getName() + " на позиции (" + enemy.getCoordinates().x + ", " + enemy.getCoordinates().y + ")";
        }
        return true;
    }
}
