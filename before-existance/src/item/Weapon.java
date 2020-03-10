package item;
public class Weapon extends Item{
	private int damage;
	private int chanceToHit;

	public Weapon(String name, int damage, int chanceToHit) {
		super(name);
		setDamage(damage);
		setChanceToHit(chanceToHit);
	}
	public Weapon(String name, int damage) {
		super(name);
		setDamage(damage);
		setChanceToHit(90);
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getChanceToHit() {
		return chanceToHit;
	}
	public void setChanceToHit(int chanceToHit) {
		this.chanceToHit = chanceToHit;
	}
	public String toString() {
		String str = this.getName() + " : " + String.valueOf(damage);
		return str;
	}
	@Override
	public void use() {
		// TODO Auto-generated method stub
		
	}
}