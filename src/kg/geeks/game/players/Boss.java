package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Boss extends GameEntity {
    private SuperAbility defence;

    public Boss(int health, int damage, String name) {
        super(health, damage, name);
    }

    public SuperAbility getDefence() {
        return defence;
    }

    public void chooseDefence(Hero[] heroes) {
        int randomIndex = RPG_Game.random.nextInt(heroes.length);
        this.defence = heroes[randomIndex].getAbility();
    }

    public void attack(Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                if (heroes[i] instanceof Berserk){
                    ((Berserk)heroes[i]).setBlockedDamage(this.getDamage()/5);
                    heroes[i].setHealth(heroes[i].getHealth() - (this.getDamage() - ((Berserk)heroes[i]).getBlockedDamage()));
                } else if (heroes[i] instanceof Bomber) {
                    if ((heroes[i].getHealth() - this.getDamage()) <= 0)
                        this.setHealth(this.getHealth()-100);
                    heroes[i].setHealth(heroes[i].getHealth() - this.getDamage());
                } else {
                    heroes[i].setHealth(heroes[i].getHealth() - this.getDamage());
                }
            }
        }
    }

    @Override
    public String toString() {
        return "BOSS " + super.toString() + " defence: " + this.defence;
    }
}
