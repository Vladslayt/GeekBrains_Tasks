package base.models;

import base.Character;
import base.Coordinates;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static base.AnsiColors.*;

@Getter
@Setter
public class Healers extends Soldier {
    protected int mana = 40;
    protected Healers(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void step(List<Character> teammates, List<Character> enemies) {
        if (!isAlive) {
            this.lastAction = ANSI_RESET + this + "мертв";
            return;
        }

        int deadCount = 0;
        for (Character hero: teammates){
            if(!hero.getAlive())
                deadCount++;
        }

        if(deadCount > 3) {
            if(this.mana >= 50)
                renaissanceClosestDeadTeammate(findClosestDeadTeammate(teammates));
            else
                hoardMana();
            return;
        }

        Character closestNearestWoundedTeammate = findClosestNearestWoundedTeammate(teammates);
        if(closestNearestWoundedTeammate == null){
            hoardMana();
            return;
        }

        if(this.mana >= 10) {
            if (healClosestNearestWoundedTeammate(closestNearestWoundedTeammate)) {
                this.mana -= 10;
                return;
            }
        } else {
            hoardMana();
        }


        int dX = closestNearestWoundedTeammate.getCoordinates().x - this.coordinates.x;
        int dY = closestNearestWoundedTeammate.getCoordinates().y - this.coordinates.y;

        if (Math.abs(dX) > Math.abs(dY)) {
            this.coordinates.x += Integer.compare(dX, 0);
        } else {
            this.coordinates.y += Integer.compare(dY, 0);
        }
        this.lastAction = ANSI_WHITE + this + "сделал ход в направлении раненного союзника";
    }

    public void renaissanceClosestDeadTeammate(Character teammate) {
        teammate.setAlive(true);
        this.lastAction = ANSI_CYAN + this + "возродил " + teammate;
    }

    public Character findClosestDeadTeammate(List<Character> team) {
        Character closestDeadTeammate = null;
        double closestDistance = Double.POSITIVE_INFINITY;

        for (Character teammate: team) {
            double distance = Math.hypot(teammate.getCoordinates().x - this.coordinates.x, teammate.getCoordinates().y - this.coordinates.y);
            if (!teammate.getAlive() && distance < closestDistance) {
                closestDistance = distance;
                closestDeadTeammate = teammate;
            }
        }

        return closestDeadTeammate;
    }

    public boolean healClosestNearestWoundedTeammate(Character teammate) {
        if(Coordinates.calculateDistance(this.coordinates, teammate.getCoordinates()) > this.range) {
            this.lastAction = ANSI_BLACK + this + "не достает до раненных тиммейтов";
            return false;
        }
        teammate.setHealth(teammate.getHealth() + this.damage);
        this.lastAction = ANSI_GREEN + this + "вылечил " + this.damage + " единиц здоровья " + teammate;
        return true;
    }

    public Character findClosestNearestWoundedTeammate(List<Character> team) {
        Character closestNearestWoundedTeammate = null;
        double closestDistance = Double.POSITIVE_INFINITY;

        for (Character teammate: team) {
            if (teammate.getAlive() && teammate.getHealth() != teammate.getMaxHealth()) {
                double distance = Math.hypot(teammate.getCoordinates().x - this.coordinates.x, teammate.getCoordinates().y - this.coordinates.y);
                if (distance < closestDistance) {
                    closestDistance = distance;
                    closestNearestWoundedTeammate = teammate;
                }
            }
        }

        return closestNearestWoundedTeammate;
    }

    public void hoardMana(){
        this.mana += 10;
        this.lastAction = ANSI_BLACK + this + "пополнил ману на 10";
    }
}
