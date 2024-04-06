package base;

import java.util.List;

public interface Steppable {
    void step(List<Character> teammate, List<Character> enemies);
    String getInfo();
}
