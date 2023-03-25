package kg.geeks.game.players;

public class Magic extends Hero {
    private int boostPoints;
    public Magic(int health, int damage, int boostPoints, String name) {
        super(health, damage, SuperAbility.BOOST, name);
        this.boostPoints = boostPoints;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth()>0){
                if(heroes[i] instanceof Giant){
                    ((Giant)heroes[i]).setGiantDamage(((Giant)heroes[i]).getGiantDamage() + this.boostPoints);
                }else {
                    heroes[i].setDamage(heroes[i].getDamage() + this.boostPoints);
                }
            }
        }
    }
}
