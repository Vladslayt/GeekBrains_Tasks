package personages.soldiers;

import base.Character;
import base.Coordinates;
import base.models.Arrows;
import base.models.Soldier;

import java.util.ArrayList;
import java.util.List;

import static base.AnsiColors.*;

/**
 * Крестьянин
 */
public class Peasant extends Soldier {
    public Peasant(String name, Coordinates coordinates) {
        super(name, coordinates);
        this.initiative = 0;

        this.health = 5;
        this.maxHealth = 5;

        this.range = 1;
        this.damage = 1;
    }

    @Override
    public void step(List<Character> teammates, List<Character> enemies) {
        if (!isAlive) {
            this.lastAction = ANSI_RESET + this.name + " на позиции (" + this.coordinates.x + ", " + this.coordinates.y + ") мертв";
            return;
        }

        List<Arrows> arrows = new ArrayList<>();
        for (Character hero: teammates){
            if(hero instanceof Arrows)
                arrows.add((Arrows) hero);
        }

        Arrows arrow = findClosestNeededAmmunitionTeammate(arrows);
        if(arrow == null){
            this.lastAction = ANSI_YELLOW + this.name + " на позиции (" + this.coordinates.x + ", " + this.coordinates.y + ") пропустил ход";
            return;
        }

        if(addAmmunitionForArrow(arrow))
            return;

        int dX = arrow.getCoordinates().x - this.coordinates.x;
        int dY = arrow.getCoordinates().y - this.coordinates.y;

        if (Math.abs(dX) > Math.abs(dY)) {
            this.coordinates.x += Integer.compare(dX, 0);
        } else {
            this.coordinates.y += Integer.compare(dY, 0);
        }
        this.lastAction = ANSI_WHITE + this.name + " на позиции (" + this.coordinates.x + ", " + this.coordinates.y + ") сделал ход в направлении раненного союзника";
    }

    public boolean addAmmunitionForArrow(Arrows teammate) {
        if(Coordinates.calculateDistance(this.coordinates, teammate.getCoordinates()) > this.range) {
            this.lastAction = ANSI_BLACK + this.name + " на позиции (" + this.coordinates.x + ", " + this.coordinates.y + ") не достает до тиммейтов с неполным боезапасом";
            return false;
        }
        teammate.setAmmunition(teammate.getAmmunition() + this.damage);
        this.lastAction = ANSI_BLUE + this.name + " на позиции (" + this.coordinates.x + ", " + this.coordinates.y + ") пополнил боезапас на " + this.damage + " " + teammate.getName() + " на позиции (" + teammate.getCoordinates().x + ", " + teammate.getCoordinates().y + ")";
        return true;
    }

    public Arrows findClosestNeededAmmunitionTeammate(List<Arrows> team) {
        Arrows closestNeededAmmunitionTeammate = null;
        double closestDistance = Double.POSITIVE_INFINITY;

        for (Arrows teammate: team) {
            if (teammate.getAlive() && teammate.getAmmunition() != teammate.getMaxAmmunition()) {
                double distance = Math.hypot(teammate.getCoordinates().x - this.coordinates.x, teammate.getCoordinates().y - this.coordinates.y);
                if (distance < closestDistance) {
                    closestDistance = distance;
                    closestNeededAmmunitionTeammate = teammate;
                }
            }
        }

        return closestNeededAmmunitionTeammate;
    }
}
