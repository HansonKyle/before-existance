public class Enemy extends Entity {
	
	private Weapon weapon;

	public Enemy(String name, int healthCap, Weapon weapon) {
		super(name, healthCap);
		this.weapon = weapon;
	}
	
	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
}