package example;

import base.Coordinates;
import base.Character;
import base.View;
import personages.arrows.Crossbowman;
import personages.arrows.Sniper;
import personages.healers.Monk;
import personages.healers.Wizard;
import personages.soldiers.Peasant;
import personages.soldiers.Pugilist;
import personages.soldiers.Thief;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        ArrayList<base.Character> team1 = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            Coordinates coordinates = new Coordinates(i, 0);
            Character character = switch (random.nextInt(4)) {
                case 0 -> new Peasant("TeamOne " + "Peasant" + i, coordinates);
                case 1 -> new Wizard("TeamOne " + "Wizard" + i, coordinates);
                case 2 -> new Crossbowman("TeamOne " + "Crossbowman" + i, coordinates);
                case 3 -> new Pugilist("TeamOne " + "Pugilist" + i, coordinates);
                default -> throw new IllegalStateException("Unexpected value");
            };
            team1.add(i, character);
            System.out.println(team1.get(i).getName() + " at (" + team1.get(i).getCoordinates().x + ", " + team1.get(i).getCoordinates().y + ")");
        }

        ArrayList<base.Character> team2 = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            Coordinates coordinates = new Coordinates(i, 9);
            Character character = switch (random.nextInt(4)) {
                case 0 -> new Peasant("TeamTwo " + "Peasant" + i, coordinates);
                case 1 -> new Sniper("TeamTwo " + "Sniper" + i, coordinates);
                case 2 -> new Monk("TeamTwo " + "Monk" + i, coordinates);
                case 3 -> new Thief("TeamTwo " + "Thief" + i, coordinates);
                default -> throw new IllegalStateException("Unexpected value");
            };
            team2.add(i, character);
            System.out.println(team2.get(i).getName() + " at (" + team2.get(i).getCoordinates().x + ", " + team2.get(i).getCoordinates().y + ")");
        }
        System.out.println();

        View view = new View();
        ArrayList<base.Character> allCharacters = new ArrayList<>(team1.size() + team2.size());
        allCharacters.addAll(team1);
        allCharacters.addAll(team2);

        int i = 1;
        while (true) {
            System.out.println("---------------------------------- " + i + " ХОД ----------------------------------");
            i++;
            allCharacters.sort(Comparator.comparingInt(c -> -c.getInitiative()));

            for (Character character : allCharacters) {
                if (character.getAlive()) {
                    if (team1.contains(character)){
                        character.step(team1, team2);
                    }
                    else {
                        character.step(team2, team1);
                    }
                    view.printSoldierInfo(character);
                }
            }

            if (view.isAnyoneAlive(team1)) {
                view.printGameOver("1");
                break;
            }

            if (view.isAnyoneAlive(team2)) {
                view.printGameOver("2");
                break;
            }
            System.out.println();
        }
    }
}
