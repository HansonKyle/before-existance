package event;

import java.util.ArrayList;
import java.util.Random;
import core.Game;
import entity.Player;
import item.Weapon;
import item.Database;

// Event: Item Drop Event
// Creates an event with 2 choices
public class WeaponDropEvent extends Event {

	public WeaponDropEvent(Game game) {
		super(game, "Weapon Drop", "Weapon Name");
		Weapon weapon = randomWeapon();
		super.setDescription("You found a(n) " + weapon.getName() + " " + "would you like to: ");

		super.addChoice(new Choice('1', "Add to Inventory ") { // add first choice
			public void activate() { // add item to player inventory
				Player player = game.getPlayer();
				player.addItem(weapon);
				setEnded(true);
			}
		});

		super.addChoice(new Choice('2', "Leave it Behind") { // add second choice
			// proceed to next event
			public void activate() {
				System.out.println("You left the  " + weapon.getName() + " " + "behind.");
				setEnded(true);
			}
		});
	}

	public ArrayList<Weapon> WeaponList() { // list of possible weapons
		ArrayList<Weapon> weaponList = new ArrayList<>(8);

		weaponList.add(Database.LONGSWORD);
		weaponList.add(Database.DAGGER);
		weaponList.add(Database.SPEAR);
		weaponList.add(Database.BATTLEAXE);
		weaponList.add(Database.RUSTY_KNIFE);
		weaponList.add(Database.GREATSWORD);
		weaponList.add(Database.SHORTSWORD);
		weaponList.add(Database.CLUB);

		return weaponList;
	}

	public Weapon randomWeapon() {
		ArrayList<Weapon> weaponList = WeaponList();
		int rnd = new Random().nextInt(8);
		Weapon weapon = weaponList.get(rnd);
		return weapon;
	}
}