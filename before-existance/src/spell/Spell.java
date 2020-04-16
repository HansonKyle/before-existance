package spell;

public abstract class Spell {
	
	private String name;
	private int manaCost;
	
	// General constructor
	public Spell(String name, int manaCost) {
		this.name = name;
		this.setManaCost(manaCost);
	}
	
	// Get the spell name
	public String getName() {
		return name;
	}
	
	// Set the spell name
	public void setName(String name) {
		this.name = name;
	}

	public int getManaCost() {
		return manaCost;
	}

	public void setManaCost(int manaCost) {
		this.manaCost = manaCost;
	}
}
