package event;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import core.Game;
import entity.Player;
import item.Item;
import item.Weapon;
import item.database;
// Event: Item Drop Event
// Creates an event with 2 choices
public class ItemDropEvent extends Event {

	
	public ItemDropEvent(Game game) {
		super(game, "Item Drop","Item Name");
		Item item = randomItem();
		super.setDescription("You found a(n) " + item.getName() + " " + "would you like to: ");
		
		super.addChoice(new Choice('1', "Add to Inventory ") { // add first choice
			public void activate() {
			// add item to player inventory
				
			}
		});
		
		super.addChoice(new Choice('2', "Leave it Behind") { // add second choice
			//proceed to next event
			public void activate() {
			}
		});
	}
	
	public ArrayList<Item> ItemList() {	//list of possible items
		ArrayList<Item> itemList = new ArrayList<>(1); // set parameter int to array length
		
	
		
		return itemList;
	}
	public Item randomItem() {
		ArrayList<Item> itemList = ItemList();
		int rnd = new Random().nextInt(1);
		Item item = itemList.get(rnd);
		return item;
	}
}

