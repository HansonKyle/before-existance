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
	public Entity getattacker() {
		return attacker;
	}
	public void setattacker(Entity attacker) {
		this.attacker = attacker;
	}
	public void attacking(Entity attacker, Entity target) {
		target.setHealth(target.getHealth() - attacker.getCurrentWeapon().getDamage());
	}
}
