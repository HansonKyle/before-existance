package event;

import core.Game;

// Event: Frail Skeleton
// Creates an event with 2 choices
public class FrailSkeletonEvent extends Event {

	public FrailSkeletonEvent(Game game) {
		super(game, "Frail Skeleton", "You come across a frail skeleton.");
		
		super.addChoice(new Choice('1', "Fight the skeleton") { // Add first choice
			public void activate() {
				double randomChance = Math.random();
				
				if (randomChance <= 0.35) {
					setChoiceResult("The frail skeleton hits you (-10 Health) then falls into a pile of bones");
					// 35% chance for the skeleton to hit the player
					setHealthLost(10);
				} else {
					setChoiceResult("You poke the frail skeleton and it falls into a pile of bones");
					// 65% chance to disintegrate the skeleton
					setHealthLost(0);
				}
			}
		});
		
		super.addChoice(new Choice('2', "Run to the door") { // Add second choice
			public void activate() {
				double randomChance = Math.random();
				
				if (randomChance <= 0.15) {
					setChoiceResult("You trip over a bone while running to the door. Luckily the skeleton has not noticed your clumsiness.");
					// 15% chance to be clumsy
					setHealthLost(0);
				} else if (randomChance <= 0.25) {
					setChoiceResult("You trip over a bone while running to the door, but the skeleton noticed you! \nIt throws it's left arm at you (-10 Health) just before you get through the door");
					// 25% chance to be hit by skeleton arm
					setHealthLost(10);
				} else {
					setChoiceResult("You open the door and walk into the next room.");
					// 60% chance to leave
					setHealthLost(0);
				}
			}
		});
	}
}
