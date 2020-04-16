package entity;

import java.util.ArrayList;

import item.Item;
import item.Weapon;
import spell.Spell;

public class Player extends Entity {
	
	// Holds all items that have been collected
	private ArrayList<Item> inventory = new ArrayList<Item>();
	// Hold all spells that have been unlocked
	private ArrayList<Spell> spellbook = new ArrayList<Spell>();
	
	private int dungeonsSurvived = 0;

	// General Constructor
	public Player(String name, int healthCap, Weapon weapon) {
		super(name, healthCap, weapon);
	}
	
	// Copy Constructor
	public Player(String name, int healthCap) {
		super(name, healthCap);
	}
	
	// Print death screen in console
	@Override
	public void die() {
		System.out.println("\n----------------------------------");
		System.out.println("Game over.");
		System.out.println("----------------------------------");
		dungeonsSurvived = 0;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Dungeons survived: " + dungeonsSurvived + " |";
	}
	
	// Inventory management methods
	
	public void addItem(Item i) {
		inventory.add(i);
	}
	
	public void removeItem(Item i) {
		inventory.remove(i);
	}
	
	public ArrayList<Item> getInventory() {
		return inventory;
	}
	
	// Spell management methods
	
	public void learnSpell(Spell s) {
		spellbook.add(s);
	}
	
	public ArrayList<Spell> getSpellbook() {
		return spellbook;
	}
	
	// Dungeon counter methods
	
	public void dungeonSurvived() {
		dungeonsSurvived++;
	}
	
	public int getDungeonsSurvived() {
		return dungeonsSurvived;
	}

	public void setDungeonsSurvived(int dungeonsSurvived) {
		if (dungeonsSurvived >= 0) {
			this.dungeonsSurvived = dungeonsSurvived;
		}
	}
}