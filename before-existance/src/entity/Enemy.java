package entity;
import item.Weapon;

public class Enemy extends Entity {
	//Constructor
	public Enemy(String name, int healthCap, Weapon weapon) {
		super(name, healthCap, weapon);
	}
	
	@Override
	public void die() {
		
	}
}