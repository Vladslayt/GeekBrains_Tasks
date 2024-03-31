package example;

import base.Coordinates;
import base.Character;
import base.View;
import personages.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        ArrayList<base.Character> team1 = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            String name = "TeamOne" + i;
            Coordinates coordinates = new Coordinates(i, 0);
            Character character = switch (random.nextInt(4)) {
                case 0 -> new Peasant(name, coordinates);
                case 1 -> new Wizard(name, coordinates);
                case 2 -> new Crossbowman(name, coordinates);
                case 3 -> new Pugilist(name, coordinates);
                default -> throw new IllegalStateException("Unexpected value");
            };
            team1.add(i, character);
            System.out.println(team1.get(i).name + " at (" + team1.get(i).coordinates.x + ", " + team1.get(i).coordinates.y + ")");
        }

        ArrayList<base.Character> team2 = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            String name = "TeamTwo" + i;
            Coordinates coordinates = new Coordinates(i, 9);
            Character character = switch (random.nextInt(4)) {
                case 0 -> new Peasant(name, coordinates);
                case 1 -> new Sniper(name, coordinates);
                case 2 -> new Monk(name, coordinates);
                case 3 -> new Thief(name, coordinates);
                default -> throw new IllegalStateException("Unexpected value");
            };
            team2.add(i, character);
            System.out.println(team2.get(i).name + " at (" + team2.get(i).coordinates.x + ", " + team2.get(i).coordinates.y + ")");
        }

        View view = new View();
        while (true) {
            ArrayList<base.Character> allCharacters = new ArrayList<>(team1.size() + team2.size());
            allCharacters.addAll(team1);
            allCharacters.addAll(team2);

            allCharacters.sort(Comparator.comparingInt(c -> -c.initiative));

            for (Character character : allCharacters) {
                if (character.isAlive) {
                    if (team1.contains(character)){
                        character.step(team2);
                    }
                    else {
                        character.step(team1);
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
        }
    }
}
