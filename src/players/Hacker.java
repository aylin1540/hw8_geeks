package players;

public class Hacker extends Hero {

    private int stealAmount;
    private boolean canSteal = true;

    public Hacker(int health, int damage, String name, int stealAmount) {
        super(health, damage, name, SuperAbilityEnum.STEAL_HEALTH);
        this.stealAmount = stealAmount;
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        if (canSteal) {
            boss.setHealth(boss.getHealth() - stealAmount);
            Hero targetHero = heroes[(int) (Math.random() * heroes.length)];
            targetHero.setHealth(targetHero.getHealth() + stealAmount);
            System.out.println(this.getName() + " stole " + stealAmount + " health from Boss and gave it to " + targetHero.getName());
            canSteal = false;
        } else {
            canSteal = true;
        }
    }
}
