package item;
public class Armor extends Equippable {
	
	//Set variable for armour health
	private int healthIncrease;
	
	//Give health to the specific armour piece
	public Armor(String name, int healthIncrease) {
		super(name);
		this.healthIncrease = healthIncrease;
	}
	
	//Get the armours health
	public int getHealthIncrease() {
		return healthIncrease;
	}
	
	//Set the armours health
	public void setHealthIncrease(int healthIncrease) {
		this.healthIncrease = healthIncrease;
	}
}
