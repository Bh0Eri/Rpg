import java.util.*;

public class Skill {
    final String name;
    final DamageType type;
    final double multiplier;
    final String description;

    public Skill(String name, DamageType type, double multiplier, String description) {
        this.name = name;
        this.type = type;
        this.multiplier = multiplier;
        this.description = description;
    }

    public static List<Skill> createSkillsForClass(CharacterClass c) {
        List<Skill> list = new ArrayList<>();
        switch (c) {
            case WARRIOR -> {
                list.add(new Skill("Sword Slash", DamageType.PHYSICAL,1.0,"Basic sword attack."));
                list.add(new Skill("Spinning Slash", DamageType.PHYSICAL,1.4,"High physical damage."));
                list.add(new Skill("Charge", DamageType.PHYSICAL,1.2,"May stun the enemy."));
            }
            case MAGE -> {
                list.add(new Skill("Arcane Bolt", DamageType.MAGICAL,1.0,"Basic magic attack."));
                list.add(new Skill("Fireball", DamageType.MAGICAL,1.5,"Powerful magic."));
                list.add(new Skill("Frost", DamageType.MAGICAL,1.2,"Reduces enemy defense."));
            }
            case ARCHER -> {
                list.add(new Skill("Arrow", DamageType.PHYSICAL,1.0,"Basic shot."));
                list.add(new Skill("Arrow Barrage", DamageType.PHYSICAL,1.3,"Multiple fast shots."));
                list.add(new Skill("Precise Shot", DamageType.PHYSICAL,1.1,"High crit chance."));
            }
        }
        return list;
    }
}
