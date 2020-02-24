package entity;
public class Attack {
	
	// Two entities one being the target of the attack and one being the attacker or source of damage
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
	
	public void attack(Entity attacker, Entity target) {
		if (TurnBased.firstTurn() == true) {
			target.removeHealth(attacker.getCurrentWeapon().getDamage());
			attacker.removeHealth(target.getCurrentWeapon().getDamage());
		}
		else {
			attacker.removeHealth(target.getCurrentWeapon().getDamage());
			target.removeHealth(attacker.getCurrentWeapon().getDamage());
		}
	}
}