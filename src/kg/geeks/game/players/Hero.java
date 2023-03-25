package kg.geeks.game.players;

public abstract class Hero extends GameEntity
        implements HavingSuperAbility {
    private final SuperAbility ability;

    public Hero(int health, int damage,
                SuperAbility ability, String name) {
        super(health, damage, name);
        this.ability = ability;
    }

    public SuperAbility getAbility() {
        return ability;
    }

    public void attack(Boss boss) {
        if(this instanceof Berserk){
            boss.setHealth(boss.getHealth() - this.getDamage() - ((Berserk) this).getBlockedDamage());
        }else {
            boss.setHealth(boss.getHealth() - this.getDamage());
        }
    }
}
