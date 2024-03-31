package base;

import java.util.List;

public class View {
    public void printSoldierInfo(Character character) {
        System.out.println(character.getInfo());
    }

    public void printGameOver(String winningTeam) {
        System.out.println(AnsiColors.ANSI_GREEN + "Победа! Команда " + winningTeam + " одержала победу!");
    }

    public boolean isAnyoneAlive(List<Character> characters) {
        for (Character character: characters) {
            if (character.isAlive) {
                return false;
            }
        }
        return true;
    }
}
