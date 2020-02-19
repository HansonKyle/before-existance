public class Equippable extends Item {
	private Boolean equipState = false;
	
	public void equipItem(Item i){
		equipState = true;
	}
	public void unequipItem(Item i) {
		equipState = false;
	}
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