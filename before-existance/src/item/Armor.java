package item;

import entity.Player;

public class Armor extends Item {
	
	private int healthIncrease;
	
	public Armor(String name, int healthIncrease) {
		super(name);
		this.healthIncrease = healthIncrease;
	}

	public int getHealthIncrease() {
		return healthIncrease;
	}

	public void setHealthIncrease(int healthIncrease) {
		this.healthIncrease = healthIncrease;
	}
	public void equip(Player player) {
		player.setHealthCap(player.getHealthCap() + healthIncrease);
	}
	public void unequip(Player player) {
		player.setHealthCap(player.getHealthCap() - healthIncrease);
	}
}