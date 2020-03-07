package event;

import core.Game;
import entity.Attack;
import entity.Player;
import entity.Enemy;
import item.database;

// Event: Template
// Creates an event with X choices
public class CombatEvent extends Event {

private Enemy badguy = database.GOBLIN;

	public CombatEvent(Game game) {
		super(game, "Combat", "You encounter a goblin with a sword. He looks at you hungrily and waves his sword around. Definetly not friendly");
		Player player = game.getPlayer();
		super.addChoice(new Choice('1', "Attack") { // add second choice
			public void activate() {
				Attack.attacking(player, badguy);
				setChoiceResult("Result"); // Will happen
			}
		});
		
		super.addChoice(new Choice('2', "Open Inventory") { // add second choice
			public void activate() {
				setChoiceResult("Open Inventory menu"); // Will happen
				System.out.println();
			}
		});
		super.addChoice(new Choice('3', "Open Spellbook") { // add second choice
			public void activate() {
				setChoiceResult("Open Spellboook menu"); // Will happen
				setHealthLost(40);
			}
		});
		super.addChoice(new Choice('4', "Run Away") { // add second choice
			public void activate() {
				double randomChance = Math.random();
				if(randomChance <= 0.50) {
					setChoiceResult("You were hit while trying to escape"); // Will happen
					setHealthLost(40);
				}
				else {
					setChoiceResult("You got away safely");
				}
			}
		});
	}
}
