import java.util.ArrayList;

public class Player extends Entity {
	
	private ArrayList<Item> inventory = new ArrayList<Item>();
	private ArrayList<Spell> spellbook = new ArrayList<Spell>();
	
	public Player(String name, int healthCap) {
		super(name, healthCap);
	}
	
	public ArrayList<Item> getInventory() {
		return inventory;
	}
	
	public void addItem(Item i){
		inventory.add(i);
	}
	
	public void removeItem(Item i) {
		inventory.remove(i);
	}
	
	public ArrayList<Spell> getSpellbook() {
		return spellbook;
	}
	
	public void learnSpell(Spell s) {
		spellbook.add(s);
	}
}