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
public class WeaponDropEvent extends Event {

	
	public WeaponDropEvent(Game game) {
		super(game, "Weapon Drop","Weapon Name");
		Weapon weapon = randomWeapon();
		super.setDescription("You found a(n) " + weapon.getName() + " " + "would you like to: ");
		
		super.addChoice(new Choice('1', "Add to Inventory ") { // add first choice
			public void activate() {	// add item to player inventory
				Player player = game.getPlayer();
				player.addItem(weapon);
			}
		});
		
		super.addChoice(new Choice('2', "Leave it Behind") { // add second choice
			//proceed to next event
			public void activate() {
				System.out.println("You left the  " + weapon.getName() + " " + "behind.");
				//end event
			}
		});
	}
	public ArrayList<Weapon> WeaponList() {	//list of possible weapons
		ArrayList<Weapon> weaponList = new ArrayList<>(8);
		
		weaponList.add(database.LONGSWORD);
		weaponList.add(database.DAGGER);
		weaponList.add(database.SPEAR);
		weaponList.add(database.BATTLEAXE);
		weaponList.add(database.RUSTY_KNIFE);
		weaponList.add(database.GREATSWORD);
		weaponList.add(database.SHORTSWORD);
		weaponList.add(database.CLUB);
		
		return weaponList;
	}
	public Weapon randomWeapon() {
		ArrayList<Weapon> weaponList = WeaponList();
		int rnd = new Random().nextInt(8);
		Weapon weapon = weaponList.get(rnd);
		return weapon;
	}
}

