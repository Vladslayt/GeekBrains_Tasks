package org.example;

import base.Coordinates;
import personages.*;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        base.Character[] team1 = new base.Character[10];
        for (int i = 0; i < 10; i++) {
            String name = "TeamOne" + i;
            Coordinates coordinates = new Coordinates(i, 0);
            team1[i] = switch (random.nextInt(4)) {
                case 0 -> new Peasant(name, coordinates);
                case 1 -> new Wizard(name, coordinates);
                case 2 -> new Crossbowman(name, coordinates);
                case 3 -> new Pugilist(name, coordinates);
                default -> throw new IllegalStateException("Unexpected value");
            };
            System.out.println(team1[i].name + " at (" + team1[i].coordinates.x + ", " + team1[i].coordinates.y + ")");
        }

        base.Character[] team2 = new base.Character[10];
        for (int i = 0; i < 10; i++) {
            String name = "TeamTwo" + i;
            Coordinates coordinates = new Coordinates(i, 9);
            team2[i] = switch (random.nextInt(4)) {
                case 0 -> new Peasant(name, coordinates);
                case 1 -> new Sniper(name, coordinates);
                case 2 -> new Monk(name, coordinates);
                case 3 -> new Thief(name, coordinates);
                default -> throw new IllegalStateException("Unexpected value");
            };
            System.out.println(team2[i].name + " at (" + team2[i].coordinates.x + ", " + team2[i].coordinates.y + ")");
        }
    }
}