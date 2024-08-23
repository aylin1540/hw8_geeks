package game;

import players.*;

import java.util.Random;

public class RPG_Game {

    public static Random random = new Random();
    private static int round = 0;

    public static void startGame() {
        Boss thanos = new Boss(1000, 50, "Thanos");

        Berserk captainAmerica = new Berserk(300, 15, "Captain America");
        Warrior ironMan = new Warrior(270, 20, "Iron Man");
        Mag thor = new Mag(320, 30, "Thor", 10);
        Medic drStrange = new Medic(220, 10, "DR Strange", 10);
        Medic wong = new Medic(230, 5, "Wong", 5);
        Witcher witcher = new Witcher(300, 0, "Witcher");
        Hacker hacker = new Hacker(280, 20, "Hacker", 30);

        Hero[] avengers = {captainAmerica, ironMan, thor, drStrange, wong, witcher, hacker};

        System.out.println("------------- Start game Assemble -------------");
        printStatistics(thanos, avengers);

        while (!isGameOver(thanos, avengers)) {
            round(thanos, avengers);
        }
    }

    private static boolean isGameOver(Boss thanos, Hero[] heroes) {
        if (thanos.getHealth() <= 0) {
            System.out.println("Avengers won!!!");
            return true;
        }
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                return false;
            }
        }
        System.out.println("Thanos won!!!");
        return true;
    }

    private static void round(Boss thanos, Hero[] avengers) {
        round++;
        thanos.chooseDefence();
        System.out.println("------------- ROUND " + round + " -------------");
        thanos.attackBoss(avengers);
        for (Hero hero : avengers) {
            if (hero.getHealth() > 0 && hero.getSuperAbilityEnum() != thanos.getDefence()) {
                hero.attackHero(thanos);
                hero.applySuperAbility(thanos, avengers);
            }
        }
        printStatistics(thanos, avengers);
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println(boss);
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
    }
}
