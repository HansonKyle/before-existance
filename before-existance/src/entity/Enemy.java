package entity;
import item.Weapon;

public class Enemy extends Entity {
	
	private String description;
	
	public Enemy(String name, int healthCap, Weapon weapon) {
		super(name, healthCap, weapon);
	}
	
	public Enemy(String name, int healthCap, Weapon weapon, String description) {
		super(name, healthCap, weapon);
		this.setDescription(description);
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