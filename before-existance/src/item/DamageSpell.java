package item;

import entity.Entity;

public class DamageSpell extends Spell {
	private int damage;

	public DamageSpell(String name, int manaCost, int damage) {
		super(name, manaCost);
		this.damage = damage;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int castDamageSpell(Entity target) {
		int damageDealt = getDamage();
		return damageDealt;
	}
	
}
