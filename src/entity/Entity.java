package entity;
import java.util.Random;

import item.Weapon;
import java.util.Random;

// Represents a character in game that can be damaged and is prone to dying
public abstract class Entity {
	
	private String name;
	private int health;
	private int healthCap;
	private HealthBar healthBar;
	private Weapon currentWeapon;
	
	public Entity(String name, int healthCap) {
		this.name = name;
		this.healthBar = new HealthBar(this);
		this.healthCap = healthCap;
		this.health = healthCap;
	}
	
	public Entity(String name, int healthCap,  Weapon currentWeapon) {
		this(name, healthCap);
		this.currentWeapon = currentWeapon;
	}
	
	public abstract void die();
	
	@Override
	public String toString() {
		return "| Name: " + name.toUpperCase() + " | " + healthBar.toString() + " |";
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isAlive() {
		return health > 0;
	}
	
	public void replenishHealth() {
		this.health = healthCap;
	}
	
	public void addHealth(int amount) {
		if (amount > 0) {
			health += amount;
			if (health > healthCap) {
				replenishHealth();
			}
		}
	}
	
	public void removeHealth(int amount) {
		if (amount > 0) {
			health -= amount;
			if (health < 0) {
				health = 0;
				die();
			}
		}
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		if (health >= 0) {
			this.health = health;
			if (health == 0) {
				die();
			}
		}
	}

	public int getHealthCap() {
		return healthCap;
	}

	public void setHealthCap(int healthCap) {
		if (healthCap > 0) {
			this.healthCap = healthCap;
		}
	}
	
	public HealthBar getHealthBar() {
		return healthBar;
	}
	
	public Weapon getCurrentWeapon() {
		return currentWeapon;
	}
	
	public void setCurrentWeapon(Weapon currentWeapon) {
		this.currentWeapon = currentWeapon;
	}
	private Random random = new Random();
	
	public int attack(Entity target) {
		int hitRoll = random.nextInt(100);
		int critChance = random.nextInt(100);
		int damageDealt = 0;
		if (hitRoll <= getCurrentWeapon().getChanceToHit()) {
			damageDealt = getCurrentWeapon().getDamage();
			if (critChance == 1) {
				damageDealt = damageDealt * 2;
			}
			target.removeHealth(damageDealt);
		}
		return damageDealt;
}

}
