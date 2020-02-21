public class Enemy extends Entity {
	
	public Enemy(String name, int healthCap, Weapon weapon) {
		super(name, healthCap);
	}
	
	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
}