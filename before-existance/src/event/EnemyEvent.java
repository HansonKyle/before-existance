package event;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import core.Game;
import entity.Enemy;
import item.Weapon;
import item.database;

public class EnemyEvent extends Event {
	
	private Enemy enemy;

	public EnemyEvent(Game game, Enemy enemy) {
		super(game, "Enemy Appeared", "A wild " + enemy.getName() + " has appeared!");
		this.enemy = enemy;
		
		super.addChoice(new Choice('1', "Attack") {
			@Override
			public void activate() {
				System.out.println("*attack*");
			}
		});
		
		super.addChoice(new Choice('2', "View Inventory") {
			@Override
			public void activate() {
				System.out.println("*Print items in inventory*");
			}
		});
		
		super.addChoice(new Choice('3', "Inspect Enemy") {
			@Override
			public void activate() {
				System.out.println(enemy);
			}
		});
		
		super.addChoice(new Choice('4', "Retreat") {
			@Override
			public void activate() {
				System.out.println("*end battle*");
			}
		});
	}
	
	public Enemy getEnemy() {
		return enemy;
	}
	
	public ArrayList<Enemy> EnemyList() {	//List of possible enemies
		ArrayList<Enemy> enemyList = new ArrayList<>(5);
		
		enemyList.add(database.GOBLIN);
		enemyList.add(database.OGRE);
		enemyList.add(database.SKELETON_SPEARMAN);
		enemyList.add(database.SKELETON_SWORDSMAN);
		enemyList.add(database.CRAZED_BARBARIAN);
		
		return enemyList;
	}
	
	public Enemy randomEnemy() {
		ArrayList<Enemy> enemyList = EnemyList();
		int rnd = new Random().nextInt(5);
		Enemy enemy = enemyList.get(rnd);
		return enemy;
	}
}
