package event;

import core.Database;
import core.Game;
import entity.Player;
import entity.Enemy;

// Event: Combat
// Combat event handles each round of combat by giving the player 4 different choices to perform
// then having the enemy attack the player at the end of each round
// The rounds continue until either the player or the enemy is dead
public class CombatEvent extends Event {
	
	// The enemy that the player will battle (by default player will fight a goblin)
	private Enemy enemy = Database.GOBLIN;
	
	public CombatEvent(Game game, Enemy enemy) {
		super(game, "Player's Turn", "Select your action:");
		Player player = game.getPlayer();
		
		super.addChoice(new Choice('1', "Attack") { // add second choice
			public void activate() {
				int playerDamage = player.attack(enemy);
				String choiceResult = "";
				if (playerDamage > 0) {
					choiceResult = "The attack did " + playerDamage + "damage";
				}
				else {
					choiceResult = "Your attack missed!";
				}
				if(enemy.getHealth() <= 0) {
					setEnded(true);
				}
				int enemyDamage = enemy.attack(player);
				if (enemyDamage > 0) {
					choiceResult += "/n" + enemy.getName() + "'s attack " + enemyDamage + "damage";
				}
				else {
					choiceResult += "/n" + enemy.getName() + "'s attack missed!";
				}
				setChoiceResult(choiceResult);
				if(player.getHealth() <= 0) {
					setEnded(true);
					player.die();
				}
			}
		});
		
		super.addChoice(new Choice('2', "Open Inventory") { // add second choice
			public void activate() {
				setChoiceResult(""); // Will happen
				// Here the inventory needs to be displayed and if the player 
				// chooses to cast the spell then end the turn
			}
		});
		super.addChoice(new Choice('3', "Open Spellbook") { // add second choice
			public void activate() {
				setChoiceResult("Open Spellboook menu");
				// Here the spellbook needs to be displayed and if the player 
				// chooses to cast the spell then end the turn
				System.out.println(player.getSpellbook());
			}
		});
		super.addChoice(new Choice('4', "Run Away") { // add second choice
			public void activate() {
				double randomChance = Math.random();
				
				if(randomChance <= 0.50) {
					setChoiceResult("You were hit while trying to escape");
					game.getPlayer().removeHealth(40);
				}
				else {
					setChoiceResult("You got away safely");
					setEnded(true);
				}
			}
		});
	}
}
