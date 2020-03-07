package event;

import core.Game;

// Event: Template
// Creates an event with X choices
public class EventTemplate extends Event {

	
	public EventTemplate(Game game) {
		super(game, "Event Name", "Event Description");
		
		super.addChoice(new Choice('1', "Choice 1 Description") { // add first choice
			public void activate() {
				double randomChance = Math.random();
				
				if (randomChance <= 0.15) {
					setChoiceResult("Rare result"); // 15% chance of rare
					setHealthLost(0);
				} else {
					setChoiceResult("Common result"); // 85% chance of common
					setHealthLost(0);
				}
			}
		});
		
		super.addChoice(new Choice('2', "Choice 2 Description") { // add second choice
			public void activate() {
				setChoiceResult("Result"); // Will happen
				setHealthLost(40);
			}
		});
		
		super.addChoice(new Choice('3', "Choice 3 Description") { // add third choice
			public void activate() {
				double randomChance = Math.random();
				
				if (randomChance <= 0.50) {
					setChoiceResult("Result 1"); // 50% chance to do it
					setHealthLost(0);
				} else {
					setChoiceResult("Result 2"); // 50% chance to do it
					setHealthLost(50);
				}
			}
		});
	}
}
