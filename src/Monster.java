import java.util.*;

public class Monster extends Character {
    final String name;
    final Difficulty difficulty;

    public Monster(String name, Difficulty diff, int hp, int atk, int def) {
        super(name,1,hp,atk,def);
        this.name = name;
        this.difficulty = diff;
    }

    public int attackDamage(Random rng) {
        boolean heavy = rng.nextInt(100) < 20;
        double mult = heavy ? 1.4 : 1.0;
        return (int)Math.round(attack * mult);
    }

    public Monster cloneForBattle() {
        return new Monster(this.name, this.difficulty, this.maxHP, this.attack, this.defense);
    }

    public int getCurrentHP() { return currentHP; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }

    public static void seedMonsters(List<Monster> monsters) {
        monsters.add(new Monster("Slime", Difficulty.EASY,40,6,2));
        monsters.add(new Monster("Giant Rat", Difficulty.EASY,45,7,2));
        monsters.add(new Monster("Goblin", Difficulty.EASY,50,8,3));

        monsters.add(new Monster("Orc", Difficulty.NORMAL,70,12,6));
        monsters.add(new Monster("Alpha Wolf", Difficulty.NORMAL,65,13,5));
        monsters.add(new Monster("Bandit", Difficulty.NORMAL,60,14,4));

        monsters.add(new Monster("Cave Troll", Difficulty.HARD,100,18,10));
        monsters.add(new Monster("Specter", Difficulty.HARD,85,20,7));

        monsters.add(new Monster("Ancient Dragon", Difficulty.IMPOSSIBLE,180,28,14));
    }
}
