package base;

public class Coordinates {
    public int x;
    public int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static double calculateDistance(Coordinates c1, Coordinates c2) {
        return Math.sqrt(Math.pow(c2.x - c1.x, 2) + Math.pow(c2.y - c1.y, 2));
    }
}