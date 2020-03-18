package item;

import entity.Enemy;

import java.util.ArrayList;
import java.util.List;

// This class is a database of all items, spells, and entities that can be used in the game
public class Database {
	
	// method will be moved to boss event
	public void BossList() { // List of possible bosses
		List<Enemy> bossList = new ArrayList<>();

		bossList.add(SQUIRREL_QUEEN);
	}

	// Regular Weapons
	public static final Weapon LONGSWORD = new Weapon("Longsword", 20, 90);
	public static final Weapon DAGGER = new Weapon("Dagger", 10, 95);
	public static final Weapon SPEAR = new Weapon("Spear", 25, 90);
	public static final Weapon BATTLEAXE = new Weapon("Battleaxe", 40, 70);
	public static final Weapon RUSTY_KNIFE = new Weapon("Rusty Knife", 5, 100);
	public static final Weapon GREATSWORD = new Weapon("Greatsword", 30, 80);
	public static final Weapon SHORTSWORD = new Weapon("Shortsword", 15, 95);
	public static final Weapon CLUB = new Weapon("Club", 35, 70);
	
	// Regular Enemies
	public static final Enemy GOBLIN = new Enemy("Goblin", 20, Database.DAGGER);
	public static final Enemy OGRE = new Enemy("Ogre", 80, Database.CLUB);
	public static final Enemy SKELETON_SPEARMAN = new Enemy("Skeleton Spearman", 25, Database.SPEAR);
	public static final Enemy SKELETON_SWORDSMAN = new Enemy("Skeleton Swordsman", 25, Database.LONGSWORD);
	public static final Enemy CRAZED_BARBARIAN = new Enemy("Crazed Barbarian", 65, Database.BATTLEAXE);
	
	// Boss Weapons
	public static final Weapon ACORN_STAFF = new Weapon("Acorn Staff", 35, 95);
	
	// Bosses
	public static final Enemy SQUIRREL_QUEEN = new Enemy("Squirrel Queen", 125, Database.ACORN_STAFF);

	// Spells
	public static final DamageSpell SPARK = new DamageSpell("Spark", 5, 10);
	public static final DamageSpell FIREBALL = new DamageSpell("Fireball", 15, 25);
	public static final DamageSpell SMITE = new DamageSpell("Smite", 30, 65);
	public static final HealSpell CURE_WOUNDS = new HealSpell("Cure Wounds", 5, 15);
	public static final HealSpell LAYONHANDS = new HealSpell("Lay on Hands", 25, 65);
	public static final HealSpell BOTASG = new HealSpell("Blessing of the Ancient Squirrel Gods", 30, 100);

	// Armor
	public static final Armor LEATHER_ARMOR = new Armor("Leather armor", 15);
	public static final Armor IRON_ARMOR = new Armor("Iron armor", 25);
	public static final Armor PLATE_ARMOR = new Armor("Heavy Plate Armor", 50);
}
