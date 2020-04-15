package event;

import core.Game;

// Event: Squirrels
// Creates an event with 2 choices
public class SquirrelsEvent extends Event {
	
	// General constructor
	public SquirrelsEvent(Game game) {
		super(game, "Squirrels", "An army of squirrels lay asleep in the middle of the room. \nIf they get angry there is no survival. \nThere are two doors, one farther than the other.");
		
		super.addChoice(new Choice('1', "Sneak to the close door") { // Adds first choice
			public void activate() {
				double randomChance = Math.random();
				
				if (randomChance <= 0.50) {
					setChoiceResult("You successfully sneak to the door and escape the possibility of eternal torment by squirrels");
					// 50% chance to escape squirrels
					setHealthLost(0);
				} else if (randomChance <= 85) {
					setChoiceResult("You start to sneak towards the door but you step on a stray nut. \nThe army is awake, but they are happy because nut. \nYou manage to get to the close door into the next room.");
					// 35% chance to step on a nut
					setHealthLost(0);
				} else {
					setChoiceResult("You start to sneak towards the door but a small spider spooks you \nand you fall right on top of all of the squirrels. \nYou are then killed by an army of squirrels and the last thought running through your mind is 'Squirrel crowdsurfing'");
					// 15% chance to die
					setHealthLost(Integer.MAX_VALUE);
				}
			}
		});
		
		super.addChoice(new Choice('2', "Sneak to the far door") { // Adds second choice
			public void activate() {
				double randomChance = Math.random();
				
				if (randomChance <= 0.15) {
					setChoiceResult("You manage to sneak your way to the far door.");
					// 15% chance to escape
					setHealthLost(0);
				} else {
					setChoiceResult("A lone squirrel wakes up as you pass the close door. The squirrel says one word, in perfect English. \nOne word that will strike fear into anyone who hears a squirrel say it. \n\n'Bruh' -Lone Squirrel \n\nYou immediately open the close door behind you and leave the squirrels alone.");
					// 85% chance for bruh
					setHealthLost(0);
				}
			}
		});
	}
}
