package spell;

import entity.Player;

public class HealthSpell extends Spell {
	
	private int healthHealed;

	// General constructor
	public HealthSpell(String name, int manaCost, int healthHealed) {
		super(name, manaCost);
		this.setHealthHealed(healthHealed);
	}

	public int getHealthHealed() {
		return healthHealed;
	}

	public void setHealthHealed(int healthHealed) {
		this.healthHealed = healthHealed;
	}
	
	/**
	 * Uses the spell on the player
	 * 
	 * @param player an instance of the player object
	 * @return amount of health player gained by using the spell
	 */
	public int castHealingSpell(Player player) {
		int healing = getHealthHealed();
		return healing;
	}
}
