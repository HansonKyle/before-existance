public class HealthBar {
	
	private int healthCap;
	private int health;
	
	public HealthBar(int healthCap) {
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
	
	@Override
	public String toString() {
		return String.format("Health: %s/%s (%.1f %%)", health, healthCap, getPercentage());
	}
	
	public int getHealthCap() {
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
}
