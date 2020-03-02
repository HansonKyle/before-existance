package event;

import core.Game;

// Event: Big hand
// Creates an event with 3 choices
public class BigHandEvent extends Event {

	
	public BigHandEvent(Game game) {
		super(game, "Big Hand", "A big floating hand greets you into the room. It would be polite to greet the hand back.");
		
		super.addChoice(new Choice('1', "Wave to the hand") { // add first choice
			public void activate() {
				double randomChance = Math.random();
				
				if (randomChance <= 0.15) {
					setChoiceResult("The hand opens a secret door for you. You have no choice but to enter."); // 15% chance of secret door
					setHealthLost(0);
				} else {
					setChoiceResult("The hand opens the door you just came through, but somehow it leads into a new room."); // 85% chance of regular door
					setHealthLost(0);
				}
			}
		});
		
		super.addChoice(new Choice('2', "Flip the hand off") { // add second choice
			public void activate() {
				setChoiceResult("The hand slaps you through a brick wall, into another room (-40 Health). \nThe hand then repairs the wall as an attempt to not see you again."); 
				// 100% chance of being slapped for 40 health
				setHealthLost(40);
			}
		});
		
		super.addChoice(new Choice('3', "Attack the hand") { // add third choice
			public void activate() {
				double randomChance = Math.random();
				
				if (randomChance <= 0.50) {
					setChoiceResult("You stab the hand and it immediately surrenders, as the hand hates splinters. The hand opens the door you entered through and pushes you into a new room.");
					// 50% chance for the hand to surrender
					setHealthLost(0);
				} else {
					setChoiceResult("The hand mercilessly yeets you through the floor (-50 Health). \nThe hand then plugs the hole in the floor with its finger and leaves you be in the next room.");
					// 50% chance to be yeeted into the floor for 50 health
					setHealthLost(50);
				}
			}
		});
	}
}
