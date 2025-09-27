import java.util.*;

public class Player extends Character {
    final CharacterClass characterClass;
    int xp;
    List<Skill> skills;

    private Player(String name, CharacterClass cClass, int level, int hp, int atk, int def) {
        super(name, level, hp, atk, def);
        this.characterClass = cClass;
        this.xp = 0;
        this.skills = Skill.createSkillsForClass(cClass);
    }

    public static Player createBasic(String name, CharacterClass cClass) {
        return switch (cClass) {
            case WARRIOR -> new Player(name, cClass,1,90,14,10);
            case MAGE -> new Player(name, cClass,1,70,16,6);
            case ARCHER -> new Player(name, cClass,1,80,15,8);
        };
    }

    public void gainXP(int amount) {
        xp += amount;
        while (xp >= xpForNextLevel()) {
            xp -= xpForNextLevel();
            levelUp();
        }
    }

    private int xpForNextLevel() { return 100 * level; }

    private void levelUp() {
        level++;
        switch (characterClass) {
            case WARRIOR -> { maxHP += 15; attack += 4; defense += 3; }
            case MAGE -> { maxHP += 10; attack += 5; defense += 2; }
            case ARCHER -> { maxHP += 12; attack += 4; defense += 2; }
        }
        currentHP = maxHP;
        System.out.printf(">>> %s leveled up to %d! (+HP, +ATK, +DEF)%n", name, level);
    }
}
