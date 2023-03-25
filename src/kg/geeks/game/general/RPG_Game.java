package kg.geeks.game.general;

import kg.geeks.game.players.*;

import java.util.Random;

public class RPG_Game {
    private static int roundNumber;
    public static Random random = new Random();

    public static void startGame() {
        Boss boss = new Boss(5000, 50, "Evil");
        Warrior warrior = new Warrior(270, 10, "Ahiles");
        Medic doc = new Medic(250, 5, 15, "Aibolit");
        Magic magic = new Magic(280, 20, 5,"Hendolf");
        Berserk berserk = new Berserk(290, 15, "Takashi");
        Medic assistant = new Medic(300, 5, 5, "Strange");
        Bomber boom = new Bomber(270,10,"Boom");
        Spitfire spitfire = new Spitfire(260,15,"Maito Guy");
        Giant titan = new Giant(270,50,"Titan");
        Hero[] heroes = {warrior, doc, magic, berserk, assistant, boom, spitfire, titan};

        printStatistics(boss, heroes);
        while (!isGameFinished(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " ----------");
        System.out.println(boss);
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]);
        }
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence(heroes);
        boss.attack(heroes);
        for (int i = 0; i < heroes.length; i++) {
            if (boss.getDefence() != heroes[i].getAbility() &&
                    heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                heroes[i].attack(boss);
                heroes[i].applySuperPower(boss, heroes);
            }
        }
        printStatistics(boss, heroes);
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }
}
