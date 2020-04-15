package entity;

/*
 * Prints the info of an entity's health to the console.
 * Will be converted to GUI in the future.
 */
public class HealthBar {
	
	// The entity associated with the health bar
	private Entity entity;
	
	// General constructor
	public HealthBar(Entity entity) {
		this.entity = entity;
	}

	public void update() {}
	
	/**
	 * Gets the remaining health of the entity as a percentage
	 * 
	 * @return percentage of total health
	 */
	public double getPercentage() {
		return 100.0 * entity.getHealth() / entity.getHealthCap();
	}
	
	@Override
	public String toString() {
		return String.format("Health: %s/%s", entity.getHealth(), entity.getHealthCap());
	}
}