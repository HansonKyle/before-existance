package item;

public abstract class Spell {
	
	private String name;
	private int manaCost;
	public Spell(String name, int manaCost) {
		this.name = name;
		this.setManaCost(manaCost);
	}
	
	public String getName() {
		return name;
	}
	
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