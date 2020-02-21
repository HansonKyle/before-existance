public class Attack {

	private int damage;

	public Attack(int damage) {
		this.damage = damage;
	}
	
	public Attack(Attack attack) {
		this.damage = attack.damage;
	}
	
	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
}