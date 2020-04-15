package item;

/*
 * Spells will be used to buff the player's stats
 */
public class Spell {
	
	private String name;
	
	// General constructor
	public Spell(String name) {
		this.name = name;
	}
	
	// Get the spell name
	public String getName() {
		return name;
	}
	
	// Set the spell name
	public void setName(String name) {
		this.name = name;
	}
}