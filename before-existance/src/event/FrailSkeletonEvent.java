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
					System.out.println("The frail skeleton hits you (-10 Health) then falls into a pile of bones");
					game.getPlayer().removeHealth(10);
					System.out.println("Current Stats: " + game.getPlayer());
					// 35% chance for the skeleton to hit the player
				} else {
					System.out.println("You poke the frail skeleton and it falls into a pile of bones");
					// 65% chance to disintegrate the skeleton
				}
			}
		});
		
		super.addChoice(new Choice('2', "Run to the door") { // Add second choice
			public void activate() {
				double randomChance = Math.random();
				
				if (randomChance <= 0.15) {
					System.out.println("You trip over a bone while running to the door. Luckily the skeleton has not noticed your clumsiness.");
					// 15% chance to be clumsy
				} else if (randomChance <= 0.25) {
					System.out.println("You trip over a bone while running to the door, but the skeleton noticed you! It throws it's left arm at you (-10 Health) just before you get through the door");
					game.getPlayer().removeHealth(10);
					System.out.println("Current Stats: " + game.getPlayer());
					// 25% chance to be hit by skeleton arm
				} else {
					System.out.println("You open the door and walk into the next room.");
					// 60% chance to leave
				}
			}
		});
	}
}
