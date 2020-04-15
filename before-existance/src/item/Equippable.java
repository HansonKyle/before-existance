package item;

/*
 * Represents an item that can be equipped by the player
 */
public class Equippable extends Item {
	
	private Boolean equipState = false;
	
	// General constructor
	public Equippable(String name) {
		super(name);
	}
	
	public void equipItem() {
		equipState = true;
	}
	
	public void unequipItem() {
		equipState = false;
	}
	
	/**
	 * @return whether or not the item is equipped
	 */
	public Boolean getEquipState() {
		return equipState;
	}
	
	// Effects of using the item
	@Override
	public void use() {}
}