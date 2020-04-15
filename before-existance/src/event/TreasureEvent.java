package event;

import core.Game;

// Event: Treasure chest
// Adds event with 2 choices
public class TreasureEvent extends Event {

	// General constructor
	public TreasureEvent(Game game) {
		super(game, "Treasure Chest", "A treasure chest lays in the center of the room.");
		
		super.addChoice(new Choice('1', "Open treasure chest") { // Adds first choice
			public void activate() {
				double randomChance = Math.random();
				
				if (randomChance <= 0.15) {
					setChoiceResult("The treasure chest creaks open, briefly exposing the gold inside before \nteeth emerge from the chest and chomp down on your arm (-30 Health). \nThe chest keeps its lid closed and refuses to open. \nHaving been defeated by a wooden chest, you leave the room through a door on the other side.");
					// 15% chance to be chomped by a chest
					setHealthLost(30);
				} else if (randomChance <= 80) {
					setChoiceResult("You open the chest to reveal an empty bottle with a label that says 'Your luck'.");
					// 65% chance to be unlucky
					setHealthLost(0);
				} else {
					setChoiceResult("You open the chest to reveal a full bottle with a label that says \n'Health potion, will heal 25 health'. \nYou leave the room through a door on the other side of the room.");
					// 20% chance to get health potion
					setHealthLost(0);
				}
			}
		});
		
		super.addChoice(new Choice('2', "Leave the chest for the next adventurer") { // Add second choice
			public void activate() {
				double randomChance = Math.random();
				
				if (randomChance <= 0.15) {
					setChoiceResult("Just before you leave the room, you hear the chest move and growl. \nYou made a good choice leaving the chest alone.");
					// 15% chance to hear a mimic
					setHealthLost(0);
				} else if (randomChance <= 50) {
					setChoiceResult("Just before you leave the room, another person enters through the \ndoor you came from and opens the chest. \nThey take out a wand and immediately teleport away. Weird.");
					// 35% chance to see wizard
					setHealthLost(0);
				} else {
					setChoiceResult("You regretfully leave the room and the chest inside it.");
					// 50% chance for nothing
					setHealthLost(0);
				}
			}
		});
	}
}
