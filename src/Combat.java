import java.util.*;

public class Combat {
    public enum Winner { PLAYER, MONSTER, ESCAPE }
    public static class Result { public final Winner winner; Result(Winner w){ this.winner=w; } }

    private final Random rng;
    public Combat(Random rng) { this.rng = rng; }

    public Result start(Player p, Monster m, Scanner sc) {
        while (p.isAlive() && m.isAlive()) {
            System.out.println("\n--- Turn ---");
            System.out.println("Player: " + p.shortStatus());
            System.out.println("Monster: " + m.shortStatus());

            int skillIdx = chooseSkill(p, sc);
            Skill s = p.skills.get(skillIdx);

            int dmg = calculatePlayerDamage(p,m,s);
            m.receiveDamage(dmg);
            System.out.printf("%s uses [%s] and deals %d damage!%n", p.name, s.name, Math.max(0,dmg));

            if (!m.isAlive()) break;

            int monsterDmg = Math.max(0, m.attackDamage(rng) - p.defense);
            p.receiveDamage(monsterDmg);
            System.out.printf("%s attacks and deals %d damage!%n", m.name, monsterDmg);
        }

        if (p.isAlive() && !m.isAlive()) return new Result(Winner.PLAYER);
        if (!p.isAlive() && m.isAlive()) return new Result(Winner.MONSTER);
        return new Result(p.isAlive()? Winner.PLAYER : Winner.MONSTER);
    }

    private int chooseSkill(Player p, Scanner sc) {
        for (int i = 0; i < p.skills.size(); i++) {
            Skill s = p.skills.get(i);
            System.out.printf("%d) %s [%s x%.1f] - %s%n", i+1, s.name, s.type, s.multiplier, s.description);
        }
        System.out.print("Choose skill: ");
        int idx = readIntInRange(sc,1,p.skills.size());
        return idx-1;
    }

    private int calculatePlayerDamage(Player p, Monster m, Skill s) {
        double base = p.attack * s.multiplier;
        return Math.max(0,(int)Math.round(base - m.defense));
    }

    private static int readIntInRange(Scanner sc,int min,int max) {
        while(true){
            try{
                int v = Integer.parseInt(sc.nextLine().trim());
                if(v>=min && v<=max) return v;
            } catch(NumberFormatException ignored){}
            System.out.print("Invalid, enter "+min+"-"+max+": ");
        }
    }

    public static int xpReward(Difficulty d){
        return switch(d){
            case EASY -> 50; case NORMAL -> 100; case HARD -> 200; case IMPOSSIBLE -> 500;
        };
    }
}
