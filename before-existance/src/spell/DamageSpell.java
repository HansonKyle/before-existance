package spell;

import entity.Entity;

public class DamageSpell extends Spell {
	
	// The amount of damage that an entity will take when spell is used on them
	private int damage;

	// General constructor
	public DamageSpell(String name, int manaCost, int damage) {
		super(name, manaCost);
		this.damage = damage;
	}
	
	/**
	 * Uses the spell on an entity in the game
	 * 
	 * @param target victim of the spell
	 * @return amount of damage the spell dealt
	 */
	public int castDamageSpell(Entity target) {
		int damageDealt = getDamage();
		return damageDealt;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
}
