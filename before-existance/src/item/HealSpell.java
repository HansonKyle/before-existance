package item;

import entity.Player;

public class HealSpell extends Spell{
	private int healthHealed;

	public HealSpell(String name, int manaCost, int healthHealed) {
		super(name, manaCost);
		this.setHealthHealed(healthHealed);
	}

	public int getHealthHealed() {
		return healthHealed;
	}

	public void setHealthHealed(int healthHealed) {
		this.healthHealed = healthHealed;
	}
	public int castHealingSpell(Player player) {
		int healing = getHealthHealed();
		return healing;
	}

}
