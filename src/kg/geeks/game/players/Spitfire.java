package kg.geeks.game.players;

public class Spitfire extends Hero{

    public Spitfire(int health, int damage, String name) {
        super(health, damage, SuperAbility.AGGRESSION, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int counter = 0;
        int dead = 0;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() >= 0){
                counter++;
            }
            boss.setHealth(boss.getHealth() - ((counter - dead) * 80));
            dead = counter;
        }
    }
}
