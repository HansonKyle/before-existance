package item;

/*
 * Represents an equippable item that will affect the amount of health the player has
 */
public class Armor extends Equippable {
	
	private int healthIncrease;
	
	// General constructor
	public Armor(String name, int healthIncrease) {
		super(name);
		this.healthIncrease = healthIncrease;
	}
	
	// Copy constructor
	public Armor(Armor armor) {
		this(armor.getName(), armor.healthIncrease);
	}

	public int getHealthIncrease() {
		return healthIncrease;
	}

	public void setHealthIncrease(int healthIncrease) {
		this.healthIncrease = healthIncrease;
	}
}