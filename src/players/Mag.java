package players;

public class Mag extends Hero {

    private int boostAmount;

    public Mag(int health, int damage, String name, int boostAmount) {
        super(health, damage, name, SuperAbilityEnum.BOOST);
        this.boostAmount = boostAmount;
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero != this && hero.getHealth() > 0) {
                hero.setDamage(hero.getDamage() + boostAmount);
                System.out.println(this.getName() + " boosted " + hero.getName() + "'s damage by " + boostAmount);
            }
        }
    }
}
