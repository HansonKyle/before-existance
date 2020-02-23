package event;
import core.Game;
import entity.Enemy;

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
}
