package item;

/*
 * Represents an item that can be consumed/eaten by the player
 */
public class Consumable extends Item {
	
	// General constructor
	public Consumable(String name) {
		super(name);
	}
	
	// Copy constructor
	public Consumable(Consumable consumable) {
		this(consumable.getName());
	}

	// Effects of using the item
	@Override
	public void use() {}
}