package entity;

/*
 * Sets up a battle scenario between two entities
 */
public class Attack {
	
	// Two entities one being the target of the attack and one being the attacker or source of damage.
	private Entity target;
	private Entity attacker;
	
	public Attack(Entity target, Entity attacker) {
		this.target = target;
		this.attacker = attacker;
	}
	
	public Entity getTarget() {
		return target;
	}
	
	public void setTarget(Entity target) {
		this.target = target;
	}
	
	public Entity getAttacker() {
		return attacker;
	}
	
	public void setAttacker(Entity attacker) {
		this.attacker = attacker;
	}
	
	/*
	 * One of the entities does damage to the other depending on whose turn it is.
	 * When an entity is finished dealing damage, the other entity will attack if they are still alive.
	 */
	public void attack(Entity attacker, Entity target) {
		if (TurnBased.firstTurn()) {
			// Attacker gets to deal damage before the target
			target.removeHealth(attacker.getCurrentWeapon().getDamage());
			if (target.isAlive()) {
				attacker.removeHealth(target.getCurrentWeapon().getDamage());
			}
		} else {
			// Target gets to deal damage before the attacker
			attacker.removeHealth(target.getCurrentWeapon().getDamage());
			if (attacker.isAlive()) {
				target.removeHealth(attacker.getCurrentWeapon().getDamage());
			}
		}
	}
}
