package entity;
import java.util.Random;
public class Attack {
	
	private static Random random = new Random();
	
	/* This method handles that attack action
	 * Each weapon has a percent chance to successfully hit so the method generates a random number out of 100
	 * to determine whether the attack is successful or not
	 * Every attack also has a 1/100 chance to crit making the attack deal double damage so the method generates
	 * another random number out of 100 and if it is 1 then the damage is doubled.
	 * After determining whether the attack will hit and the damage it will deal the targets health is reduced by
	 * the damage and a statement is printed stating how much damage the attack dealt
	 */
	public static int attacking(Entity attacker, Entity target) {
		int hitRoll = random.nextInt(100);
		int critChance = random.nextInt(100);
		int damageDealt = 0;
		if (hitRoll <= attacker.getCurrentWeapon().getChanceToHit()) {
			damageDealt = attacker.getCurrentWeapon().getDamage();
			if (critChance == 1) {
				damageDealt = damageDealt * 2;
			}
			target.removeHealth(damageDealt);
			//System.out.println("The attack did " + damageDealt + "damage");
		}
		//else System.out.println("The attack missed!");
		return damageDealt;
	}
}