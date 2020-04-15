package item;

/*
 * Represents an item in the game that can be used to damage other entities
 */
public class Weapon extends Equippable {
	
	// The amount of health subtracted when weapon is used on another entity
	private int damage;
	
	// General constructor
	public Weapon(String name, int damage) {
		super(name);
		this.damage = damage;
	}

	// Copy constructor
	public Weapon(Weapon weapon) {
		this(weapon.getName(), weapon.damage);
	}
	
	// Get the damage
	public int getDamage() {
		return damage;
	}
	
	// Set the damage
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public String toString() {
		return this.getName() + " : " + String.valueOf(damage);
	}
}
