package item;

public class Armor extends Equippable {
	
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
}