package base.models;

import base.Character;
import base.Coordinates;
import base.Steppable;

import java.util.List;

import static base.AnsiColors.*;

public class Soldier extends Character implements Steppable {

    protected Soldier(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void step(List<Character> teammate, List<Character> enemies) {
        if (!isAlive) {
            this.lastAction = ANSI_RESET + this.name + " на позиции (" + this.coordinates.x + ", " + this.coordinates.y + ") мертв";
            return;
        }

        Character closestEnemy = findClosestEnemyOrTeammate(enemies);
        if (closestEnemy == null) {
            this.lastAction = ANSI_YELLOW + this.name + " на позиции (" + this.coordinates.x + ", " + this.coordinates.y + ") пропустил ход";
            return;
        }

        int dX = closestEnemy.getCoordinates().x - this.coordinates.x;
        int dY = closestEnemy.getCoordinates().y - this.coordinates.y;

        if (Math.abs(dX) <= 1 && Math.abs(dY) <= 1) {
            if(closestEnemy.getHealth() - this.damage < 1){
                closestEnemy.setAlive(false);
                closestEnemy.setHealth(closestEnemy.getMaxHealth());
                this.lastAction = ANSI_PURPLE + this.name + " на позиции (" + this.coordinates.x + ", " + this.coordinates.y + ") убил " + closestEnemy.getName() + " на позиции (" + closestEnemy.getCoordinates().x + ", " + closestEnemy.getCoordinates().y + ")";
            } else {
                closestEnemy.setHealth(closestEnemy.getHealth() - this.damage);
                this.lastAction = ANSI_RED + this.name + " на позиции (" + this.coordinates.x + ", " + this.coordinates.y + ") нанес " + this.damage + " урона " + closestEnemy.getName() + " на позиции (" + closestEnemy.getCoordinates().x + ", " + closestEnemy.getCoordinates().y + ")";
            }
        } else {
            if (Math.abs(dX) > Math.abs(dY)) {
                this.coordinates.x += Integer.compare(dX, 0);
            } else {
                this.coordinates.y += Integer.compare(dY, 0);
            }
            this.lastAction = ANSI_WHITE + this.name + " на позиции (" + this.coordinates.x + ", " + this.coordinates.y + ") сделал ход в направлении противника";
        }
    }
}
