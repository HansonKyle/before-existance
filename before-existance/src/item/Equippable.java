package item;

public class Equippable extends Item {
	
	public Equippable(String name) {
		super(name);
	}

	private Boolean equipState = false;
	
	public void equipItem() {
		equipState = true;
	}
	
	public void unequipItem() {
		equipState = false;
	}
	
	public Boolean getEquipState() {
		return equipState;
	}
	
	//	TODO: Bring up a menu of options whether the player
	//	would like to equip the item if it is not equipped and
	//	unequip the item if it is equipped
	@Override
	public void use() {
		equipState = true;
	}
}