public class HealthBar {
	
	private Entity entity;
	
	public HealthBar(Entity entity) {
		this.entity = entity;
	}

	public void update() {}
	
	public double getPercentage() {
		return 100.0 * entity.getHealth() / entity.getHealthCap();
	}
	
	@Override
	public String toString() {
		return String.format("Health: %s/%s", entity.getHealth(), entity.getHealthCap());
	}
}