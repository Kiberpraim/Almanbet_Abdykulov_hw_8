package kg.geeks.game.players;

import kg.geeks.game.players.Boss;
import kg.geeks.game.players.Hero;
import kg.geeks.game.players.SuperAbility;

public class Bomber extends Hero {
    public Bomber(int health, int damage, String name) {
        super(health, damage, SuperAbility.BOOM, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {

    }
}
