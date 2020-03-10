package entity;
import java.util.ArrayList;

import item.Item;
import item.Spell;
import item.Weapon;

public class Player extends Entity {
	
	private ArrayList<Item> itemInventory = new ArrayList<Item>();
	private ArrayList<Spell> spellbook = new ArrayList<Spell>();
	private ArrayList<Weapon> weaponInventory = new ArrayList<Weapon>();
	
	private int dungeonsSurvived = 0;

	public Player(String name, int healthCap, Weapon weapon) {
		super(name, healthCap, weapon);
	}
	
	public Player(String name, int healthCap) {
		super(name, healthCap);
	}
	
	@Override
	public void die() {
		
	}
	
	@Override
	public String toString() {
		return super.toString() + " Dungeons survived: " + dungeonsSurvived + " |";
	}
	
	public void addItem(Item i) {
		itemInventory.add(i);
	}
	
	public void removeItem(Item i) {
		itemInventory.remove(i);
	}
	
	public ArrayList<Item> getInventory() {
		return itemInventory;
	}
	
	public void learnSpell(Spell s) {
		spellbook.add(s);
	}
	
	public ArrayList<Spell> getSpellbook() {
		return spellbook;
	}
	
	public void addWeapon(Weapon w) {
		weaponInventory.add(w);
	}
	
	public void removeWeapon(Weapon w) {
		weaponInventory.remove(w);
	}
	
	public ArrayList<Weapon> getWeaponInventory(){
		return weaponInventory;
	}
	
	public int getDungeonsSurvived() {
		return dungeonsSurvived;
	}

	public void setDungeonsSurvived(int dungeonsSurvived) {
		if (dungeonsSurvived >= 0) {
			this.dungeonsSurvived = dungeonsSurvived;
		}
	}
	
	public void dungeonSurvived() {
		dungeonsSurvived++;
	}
}