package entity;
import java.util.Random;

import item.Weapon;

/*
 * Represents a character in game that can be damaged and is prone to dying
 */
public abstract class Entity {
	
	// Used to generate random integers for determining whether or not player dealt damage successfully/dealt critical damage
	private final Random ATTACK_RANDOMIZER = new Random();
	
	private String name;
	private int health;
	private int healthCap;
	private HealthBar healthBar;
	private Weapon currentWeapon;
	
	// General constructor
	public Entity(String name, int healthCap) {
		this.name = name;
		this.healthBar = new HealthBar(this);
		this.healthCap = healthCap;
		this.health = healthCap;
	}
	
	// General constructor
	public Entity(String name, int healthCap,  Weapon currentWeapon) {
		this(name, healthCap);
		this.currentWeapon = currentWeapon;
	}
	
	// Copy constructor
	public Entity(Entity entity) {
		this(entity.name, entity.healthCap, entity.currentWeapon);
	}
	
	public abstract void die();
	
	public int attack(Entity target) {
		int hitRoll = ATTACK_RANDOMIZER.nextInt(100);
		int critChance = ATTACK_RANDOMIZER.nextInt(100);
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
	
	@Override
	public String toString() {
		return "| Name: " + name.toUpperCase() + " | " + healthBar.toString() + " |";
	}
	
	// Health related methods
	
	public boolean isAlive() {
		return health > 0;
	}
	
	// Sets health to max value
	public void replenishHealth() {
		this.health = healthCap;
	}
	
	/**
	 * Adds health points to current total
	 * 
	 * @param amount
	 */
	public void addHealth(int amount) {
		if (amount > 0) {
			health += amount;
			if (health > healthCap) {
				replenishHealth();
			}
		}
	}
	
	/**
	 * Subtracts health points from current value
	 * 
	 * @param amount
	 */
	public void removeHealth(int amount) {
		if (amount > 0) {
			health -= amount;
			// If the new health is <= 0 then kill entity
			if (health <= 0) {
				health = 0;
				die();
			}
		}
	}

	public void setHealth(int health) {
		if (health >= 0) {
			this.health = health;
			// If the new health is <= 0 then kill entity
			if (health <= 0) {
				health = 0;
				die();
			}
		}
	}
	
	public void setHealthCap(int healthCap) {
		if (healthCap > 0) {
			this.healthCap = healthCap;
		}
	}
	
	public int getHealth() {
		return health;
	}

	public int getHealthCap() {
		return healthCap;
	}
	
	public HealthBar getHealthBar() {
		return healthBar;
	}
	
	// Getters and Setters
	
	public Weapon getCurrentWeapon() {
		return currentWeapon;
	}
	
	public void setCurrentWeapon(Weapon currentWeapon) {
		this.currentWeapon = currentWeapon;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
