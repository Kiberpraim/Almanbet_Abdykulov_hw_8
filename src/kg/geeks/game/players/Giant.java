package kg.geeks.game.players;

public class Giant extends Hero{
    private int giantDamage;
    public Giant(int health, int damage, String name) {
        super(health, damage, SuperAbility.HIT, name);
        this.giantDamage = damage;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (this.getDamage()>0)
        this.setDamage(0);
        else {
            this.setDamage(giantDamage);
        }
    }

    public int getGiantDamage() {
        return giantDamage;
    }

    public void setGiantDamage(int giantDamage) {
        this.giantDamage = giantDamage;
    }
}
