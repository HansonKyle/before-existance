
public class Entity {
  	private String name;
	private int attack;
	private int healthCap;
	private int health;
	
	public Entity(String nama, int atk, int hCap) {
		name = nama;
		if (atk >= 0){
			attack = atk;
		} else {
			attack = 0;
		}
		if (hCap > 0) {
			healthCap = hCap;
			health = hCap;
		} else {
			healthCap = 1;
			health = 1;
		}
	}
	
	public void addAttack(int addition) {
		if (addition > 0) {
			attack += addition;
		}
	}
	public void reduceAttack(int reduction) {
		if (reduction > 0){
			if (attack - reduction < 0) {
				attack = 0;
			} else {
			attack -= reduction;
			}
		}
	}
	public void setAttack(int toSet) {
		if (toSet >= 0) {
			attack = toSet;
		}
	}
	public int getAttack() {
		int attackCopy = attack;
		return attackCopy;
	}
	public void setName(String noime) {
		name = noime;
	}
  	public String getName() {
		String nameCopy = name;
		return nameCopy;
	}
	
	public void HealthBar(int healthCap) {
		this.healthCap = healthCap;
		this.health = healthCap;
	}

	public void addHealth(int amount) {
		if (amount > 0) {
			if (health + amount > healthCap) {
				health = healthCap;
			} else {
				health += amount;
			}
		}
	}
	
	public void removeHealth(int amount) {
		if (amount > 0) {
			if (health - amount < 0) {
				health = 0;
			} else {
				health -= amount;
			}
		}
	}
	
	public void replenish() {
		this.health = healthCap;
	}
	
	public double getPercentage() {
		return 100.0 * health / healthCap;
	}
	
	public int getHealthCap() {
		int healthCapCopy = healthCap;
		return healthCap;
	}

	public void setHealthCap(int healthCap) {
		if (healthCap > 0) {
			this.healthCap = healthCap;
		}
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		if (health >= 0 && health <= healthCap) {
			this.health = health;
		}
	}
	public String toString() {
		return name + "Attack: " + attack + "| Health: " + health + "/" + healthCap + "(" + getPercentage() + ")";
	}
}
