package item;

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

	@Override
	public void use() {
		// TODO Auto-generated method stub
		
	}
}