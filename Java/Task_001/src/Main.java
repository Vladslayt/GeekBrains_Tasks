abstract class Character {
    protected int health;
    protected int strength;
    protected int agility;
    protected int intelligence;

    public Character(int health, int strength, int agility, int intelligence) {
        this.health = health;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack();
    public abstract void heal();
    public abstract void specialAbility();

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}

// Классы наследники
class Peasant extends Character {
    public Peasant() {
        super(50, 10, 10, 5);
    }

    @Override
    public void attack() {
        System.out.println("Peasant attacks with a stick.");
    }

    @Override
    public void heal() {
        System.out.println("Peasant heals himself.");
    }

    @Override
    public void specialAbility() {
        System.out.println("Peasant uses their special ability: Building.");
    }
}

class Bandit extends Character {
    public Bandit() {
        super(60, 15, 15, 5);
    }

    @Override
    public void attack() {
        System.out.println("Bandit attacks with a knife.");
    }

    @Override
    public void heal() {
        System.out.println("Bandit heals himself.");
    }

    @Override
    public void specialAbility() {
        System.out.println("Bandit uses their special ability: Stealth.");
    }
}

class Rogue extends Character {
    public Rogue() {
        super(70, 10, 20, 10);
    }

    @Override
    public void attack() {
        System.out.println("Rogue attacks with a dagger.");
    }

    @Override
    public void heal() {
        System.out.println("Rogue heals themselves with a potion.");
    }

    @Override
    public void specialAbility() {
        System.out.println("Rogue uses their special ability: Backstab.");
    }
}

class Sniper extends Character {
    public Sniper() {
        super(65, 15, 20, 15);
    }

    @Override
    public void attack() {
        System.out.println("Sniper attacks with a bow.");
    }

    @Override
    public void heal() {
        System.out.println("Sniper heals themselves with a tincture.");
    }

    @Override
    public void specialAbility() {
        System.out.println("Sniper uses their special ability: Headshot.");
    }
}

class Wizard extends Character {
    public Wizard() {
        super(55, 10, 10, 20);
    }

    @Override
    public void attack() {
        System.out.println("Wizard attacks with a spell.");
    }

    @Override
    public void heal() {
        System.out.println("Wizard heals themselves with a elixir.");
    }

    @Override
    public void specialAbility() {
        System.out.println("Wizard uses their special ability: Fireball.");
    }
}

class Swordsman extends Character {
    public Swordsman() {
        super(75, 20, 10, 10);
    }

    @Override
    public void attack() {
        System.out.println("Swordsman attacks with a sword.");
    }

    @Override
    public void heal() {
        System.out.println("Swordsman heals themselves with a potion.");
    }

    @Override
    public void specialAbility() {
        System.out.println("Swordsman uses their special ability: Slash.");
    }
}

class Archer extends Character {
    public Archer() {
        super(60, 15, 20, 10);
    }

    @Override
    public void attack() {
        System.out.println("Archer attacks with a bow.");
    }

    @Override
    public void heal() {
        System.out.println("Archer heals themselves with a tincture.");
    }

    @Override
    public void specialAbility() {
        System.out.println("Archer uses their special ability: Rapid Fire.");
    }
}

class Monk extends Character {
    public Monk() {
        super(80, 10, 15, 15);
    }

    @Override
    public void attack() {
        System.out.println("Monk attacks with a fist.");
    }

    @Override
    public void heal() {
        System.out.println("Monk heals themselves with a chi.");
    }

    @Override
    public void specialAbility() {
        System.out.println("Monk uses their special ability: Healing Hand.");
    }
}

// Основная программа
public class Main {
    public static void main(String[] args) {
        Character peasant = new Peasant();
        Character bandit = new Bandit();
        Character rogue = new Rogue();
        Character sniper = new Sniper();
        Character wizard = new Wizard();
        Character swordsman = new Swordsman();
        Character archer = new Archer();
        Character monk = new Monk();

        System.out.println(peasant);
        System.out.println(bandit);
        System.out.println(rogue);
        System.out.println(sniper);
        System.out.println(wizard);
        System.out.println(swordsman);
        System.out.println(archer);
        System.out.println(monk);
    }
}