package item;

import entity.Player;

/*
 * A health potion is a spell that replenishes some of the player's health
 */
public class HealthPotion extends Item {
	
	private Player player;
	private int healthHealed;
	
	// General constructor
	public HealthPotion(String name, int healthHealed) {
		super(name);
		this.setHealthHealed(healthHealed);
	}
	
	/**
	 * Uses the potion on the player
	 * 
	 * @param player an instance of the player object
	 * @return amount of health player gained by using the potion
	 */
	public int use(Player player) {
		int healing = getHealthHealed();
		player.getInventory().remove(this);
		return healing;
	}
	
	public int getHealthHealed() {
		return healthHealed;
	}

	public void setHealthHealed(int healthHealed) {
		this.healthHealed = healthHealed;
	}
}
