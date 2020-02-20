public class Entity {
  	private String name;
	private int healthCap;
	private int health;
	private Weapon currentWeapon;
	
	public Entity(String name, int hCap, Weapon startingWeapon) {
		this.name = name;
		if (hCap > 0) {
			healthCap = hCap;
			health = hCap;
		} 
		else {
			healthCap = 1;
			health = 1;
			}
		startingWeapon.equipItem();
		setCurrentWeapon(startingWeapon);
	}
	public Entity(String name, int hCap) {
		if (hCap > 0) {
			healthCap = hCap;
			health = hCap;
		} 
		else {
			healthCap = 1;
			health = 1;
			}
	}
	public Weapon getCurrentWeapon() {
		return currentWeapon;
	}
	public void setCurrentWeapon(Weapon aWeapon) {
		if(aWeapon.getEquipState() == true) {
			this.currentWeapon = aWeapon;
		}
	}
	public void setName(String noime) {
		name = noime;
	}
  	public String getName() {
		String nameCopy = name;
		return nameCopy;
	}
	// Don't think we need this until we begin working with GUI as the healthbar class 
  	//will only be used to display health
//	public HealthBar(int healthCap) {
//		this.healthCap = healthCap;
//		this.health = healthCap;
//	}

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
		return name + "Attack: " + getCurrentWeapon().getDamage() + "| Health: " + health + "/" + healthCap + "(" + getPercentage() + ")";
	}
}
