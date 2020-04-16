package entity;

import item.Weapon;

/*
 * Represents a hostile entity that deals damage to the player
 */
public class Enemy extends Entity {
	
	private String description;
	
	//General constructor
	public Enemy(String name, int healthCap, Weapon weapon, String description) {
		super(name, healthCap, weapon);
		this.setDescription(description);
	}
	
	// General constructor w/default description
	public Enemy(String name, int healthCap, Weapon weapon) {
		super(name, healthCap, weapon);
		this.setDescription("A " + name + " appeared!");
	}
	
	public String toString() {
		return "Name: " + getName() + " Health: " + getHealthCap() + " Weapon: " + getCurrentWeapon();
	}
	
	@Override
	public void die() {}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
