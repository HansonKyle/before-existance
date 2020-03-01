package entity;
import item.Weapon;

public class Enemy extends Entity {
	
	@SuppressWarnings("unused")
	private double accuracy;
	
	public Enemy(String name, int healthCap, Weapon weapon, double accuracy) {
		super(name, healthCap, weapon);
		this.accuracy = accuracy;
	}
	
	@Override
	public void die() {
		
	}
	
	public void setAccuracy(double newAccuracy) {
		if (newAccuracy <= 1.0 && newAccuracy >= 0) {
			this.accuracy = newAccuracy;
		}
	}

	public Enemy RandomEnemy() {	// picks a random common enemy to spawn and returns it with preset values
		double randomChance = Math.random();
		if (randomChance < 0.25) {
			Weapon goblinWeapon = new Weapon("dagger", 5);
			Enemy goblin = new Enemy("Goblin", 35, goblinWeapon, 0.85);
			return goblin;
			}
		if (randomChance > 0.25 && randomChance < 0.35) {
			Weapon orcWeapon = new Weapon("club", 40);
			Enemy orc = new Enemy("Orc", 75, orcWeapon, 0.15);
			return orc;
		}
		if (randomChance > 0.35 && randomChance < 0.60) {
			Weapon skeletonKnightWeapon = new Weapon("longsword", 20);
			Enemy skeletonKnight = new Enemy("Skelton Knight", 40, skeletonKnightWeapon, 0.65);
			return skeletonKnight;
		}
		if (randomChance > 0.60 && randomChance < 0.80) {
			Weapon hellhoundWeapon = new Weapon("bite", 10);
			Enemy hellhound = new Enemy("Hellhound", 25, hellhoundWeapon, 0.90);
			return hellhound;
		}
		if (randomChance > 0.80 && randomChance <= 1.0) {
			Weapon wraithWeapon = new Weapon("ethereal strike", 30);
			Enemy wraith = new Enemy("Wraith", 15, wraithWeapon, 0.80);
			return wraith;
		}
		return null;	
	}
	
	public Enemy Boss() {	//picks a random boss to spawn, bosses are meant to spawn every 5 dungeons survived
		double randomChance = Math.random();
		if (randomChance <= 1.0) {
			Weapon queenWeapon = new Weapon("Acorn Staff", 25);
			Enemy squirrelQueen= new Enemy("Monarch Squirrel Queen", 125, queenWeapon, 0.75);
			return squirrelQueen;
		}
		/*if (randomChance > 0.5 && randomChance <= 1.0) {
			//Insert new boss here 
		}*/
		return null;
		
	}
}