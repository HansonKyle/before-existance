package item;

/*
 * Represents an item in the game that can be used to damage other entities
 */
public class Weapon extends Item {
	
	// The amount of health subtracted when weapon is used on another entity
	private int damage;
	private int chanceToHit;

	// General constructor
	public Weapon(String name, int damage, int chanceToHit) {
		super(name);
		setDamage(damage);
		setChanceToHit(chanceToHit);
	}
	
	// General constructor w/default change to hit
	public Weapon(String name, int damage) {
		super(name);
		setDamage(damage);
		setChanceToHit(90);
	}
	
	// Get the damage
	public int getDamage() {
		return damage;
	}
	
	// Set the damage
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public int getChanceToHit() {
		return chanceToHit;
	}
	
	public void setChanceToHit(int chanceToHit) {
		if (chanceToHit > 0 && chanceToHit <= 100) {
			this.chanceToHit = chanceToHit;
		}
	}
	
	public String toString() {
		String str = this.getName() + " : " + String.valueOf(damage);
		return str;
	}
}
