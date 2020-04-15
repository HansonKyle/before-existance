package item;
public class Equippable extends Item {
	
	//Get name of the equippable
	public Equippable(String name) {
		super(name);
	}
	
	//Set the state of equipState to false
	private Boolean equipState = false;
	
	//Set the equipeState to true
	public void equipItem() {
		equipState = true;
	}
	
	//Set the equipeState to false
	public void unequipItem() {
		equipState = false;
	}
	
	//Get the equipeState
	public Boolean getEquipState() {
		return equipState;
	}
	
	@Override
	public void use() {
		//	Bring up a menu of options whether the player
		//	would like to equip the item if it is not equipped and
		//	unequip the item if it is equipped
		equipState = true;
	}
}
