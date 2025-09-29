public abstract class Character implements Status {
    final String name;
    int level;
    int maxHP;
    int currentHP;
    int attack;
    int defense;

    Character(String name, int level, int hp, int attack, int defense) {
        this.name = name;
        this.level = level;
        this.maxHP = hp;
        this.currentHP = hp;
        this.attack = attack;
        this.defense = defense;
    }

    boolean isAlive() { return currentHP > 0; }

    void receiveDamage(int dmg) { currentHP = Math.max(0, currentHP - Math.max(0, dmg)); }

    void fullHeal() { currentHP = maxHP; }

    @Override
    public String shortStatus() {
        return String.format("%s HP:%d/%d ATK:%d DEF:%d",
                name, currentHP, maxHP, attack, defense);
    }
}
