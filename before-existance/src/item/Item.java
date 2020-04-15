package item;

/*
 * Items are earned from defeating enemies in the game
 * Class is abstract since an item is a broad classification
 */
public abstract class Item {
	
	private String name;
	
	// General constructor
	public Item(String name) {
		this.name = name;
	}
	
	// Copy constructor
	public Item(Item item) {
		this(item.name);
	}
	
	// Each item will have different effects when used
	public abstract void use();
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}