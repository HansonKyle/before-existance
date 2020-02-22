public class Entity {
	
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name.toUpperCase() + " | " + healthBar.toString();
	}
	
	public void replenishHealth() {
		this.health = healthCap;
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		if (health >= 0) {
			this.health = health;
		}
	}
	
	public void addHealth(int amount) {
		if (health > 0) {
			health += amount;
		}
	}
	
	public void removeHealth(int amount) {
		if (health < 0) {
			health -= amount;
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
}
