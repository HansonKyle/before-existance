package item;
public class Weapon extends Equippable {
	
	//Create a variable for damage
	private int damage;
	
	//Apply the name and damage
	public Weapon(String name, int damage) {
		super(name);
		this.damage = damage;
	}
	
	//Get the damage
	public int getDamage() {
		return damage;
	}
	
	//Set the damage
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	


}
