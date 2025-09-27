import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    private static final List<Player> players = new ArrayList<>();
    private static final List<Monster> monsters = new ArrayList<>();
    private static Player activePlayer = null;

    public static void main(String[] args) {
        Monster.seedMonsters(monsters);
        mainMenu();
    }

    private static void mainMenu() {
        while (true) {
            System.out.println("\n=== Eric's RPG ===");
            System.out.println("1) Create character");
            System.out.println("2) List characters");
            System.out.println("3) Select active character");
            System.out.println("4) List monsters");
            System.out.println("5) Fight (active player vs monster)");
            System.out.println("6) Heal active player");
            System.out.println("0) Exit");
            System.out.print("Choose: ");

            String option = scanner.nextLine().trim();
            switch (option) {
                case "1": createCharacter(); break;
                case "2": listPlayers(); break;
                case "3": selectActivePlayer(); break;
                case "4": listMonsters(); break;
                case "5": startFight(); break;
                case "6": healActive(); break;
                case "0": System.out.println("Thanks! See you next time."); return;
                default: System.out.println("Invalid option.");
            }
        }
    }

    private static void createCharacter() {
        System.out.print("Character name: ");
        String name = scanner.nextLine().trim();

        System.out.println("Class:");
        for (int i = 0; i < CharacterClass.values().length; i++) {
            System.out.printf("%d) %s%n", i+1, CharacterClass.values()[i]);
        }
        System.out.print("Choose class (number): ");
        int idx = readIntInRange(1, CharacterClass.values().length);
        CharacterClass characterClass = CharacterClass.values()[idx-1];

        Player p = Player.createBasic(name, characterClass);
        players.add(p);
        activePlayer = p;
        System.out.println("Character created and set as active:");
        System.out.println(p.shortStatus());
    }

    // Character list

    private static void listPlayers() {
        if (players.isEmpty()) {
            System.out.println("No characters created yet.");
            return;
        }
        System.out.println("\n--- Characters ---");
        for (int i = 0; i < players.size(); i++) {
            Player p = players.get(i);
            System.out.printf("%d) %s%s%n", i+1, p.shortStatus());
        }
    }
    // Choose a character

    private static void selectActivePlayer() {
        if (players.isEmpty()) {
            System.out.println("Create a character first.");
            return;
        }
        listPlayers();
        System.out.print("Select character number: ");
        int idx = readIntInRange(1, players.size());
        activePlayer = players.get(idx-1);
        System.out.println("Active -> " + activePlayer.shortStatus());
    }

    private static void healActive() {
        if (activePlayer == null) {
            System.out.println("No active character.");
            return;
        }
        activePlayer.fullHeal();
        System.out.println("Healed: " + activePlayer.shortStatus());
    }

    private static void listMonsters() {
        System.out.println("\n--- Monsters ---");
        for (int i = 0; i < monsters.size(); i++) {
            Monster m = monsters.get(i);
            System.out.printf("%d) [%s] %s  HP:%d  ATK:%d  DEF:%d%n",
                    i+1, m.difficulty, m.name, m.getCurrentHP(), m.getAttack(), m.getDefense());
        }
    }

    private static void startFight() {
        if (activePlayer == null) {
            System.out.println("Select/create an active character first.");
            return;
        }
        listMonsters();
        System.out.print("Choose monster number: ");
        int idx = readIntInRange(1, monsters.size());
        Monster target = monsters.get(idx-1).cloneForBattle();

        System.out.printf("%n>>> %s (Lv.%d) will fight %s [%s]!%n",
                activePlayer.name, activePlayer.level, target.name, target.difficulty);

        Combat combat = new Combat(new Random());
        Combat.Result result = combat.start(activePlayer, target, scanner);

        if (result.winner == Combat.Winner.PLAYER) {
            int xp = Combat.xpReward(target.difficulty);
            System.out.printf("Victory! You gained %d XP.%n", xp);
            activePlayer.gainXP(xp);
        } else if (result.winner == Combat.Winner.MONSTER) {
            System.out.println("Defeat... Come back stronger!");
        } else {
            System.out.println("Combat ended.");
        }
        System.out.println("Final player status: " + activePlayer.shortStatus());
    }

    private static int readIntInRange(int min, int max) {
        while (true) {
            String s = scanner.nextLine().trim();
            try {
                int v = Integer.parseInt(s);
                if (v >= min && v <= max) return v;
            } catch (NumberFormatException ignored) {}
            System.out.print("Invalid value. Enter from " + min + " to " + max + ": ");
        }
    }
}
