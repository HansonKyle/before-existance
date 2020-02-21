public abstract class Item {
	private String name;
	
	public abstract void use();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}