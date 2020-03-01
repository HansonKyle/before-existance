package item;
public class Weapon extends Equippable {
	
	private int damage;
	
	public Weapon(String name, int damage) {
		super(name);
		this.damage = damage;
	}

	public int getDamage() {
		return damage;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	


}