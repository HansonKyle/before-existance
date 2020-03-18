package item;

import entity.Player;

public class HealthPotion extends Item {
	private int healthHealed;
	
	public HealthPotion(String name, int healthHealed) {
		super(name);
		this.setHealthHealed(healthHealed);
	}
	public int getHealthHealed() {
		return healthHealed;
	}

	public void setHealthHealed(int healthHealed) {
		this.healthHealed = healthHealed;
	}
	public int useHealthPot(Player player) {
		int healing = getHealthHealed();
		player.getInventory().remove(this);
		return healing;
	}
}