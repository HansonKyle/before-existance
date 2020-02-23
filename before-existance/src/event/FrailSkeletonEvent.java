package event;

import core.Game;

public class FrailSkeletonEvent extends Event {

	public FrailSkeletonEvent(Game game) {
		super(game, "Frail Skeleton", "You come across a frail skeleton.");
		
		super.addChoice(new Choice(1, "Fight the skeleton") {
			public void activate() {
				double randomChance = Math.random();
				
				if (randomChance <= 0.15) {
					System.out.println("The frail skeleton hits you then falls into a pile of bones");
					//you.removeHealth(10);
				} else {
					System.out.println("You poke the frail skeleton and it falls into a pile of bones");
				}
			}
		});
		
		super.addChoice(new Choice(2, "Run to the door") {
			public void activate() {
				double randomChance = Math.random();
				
				if (randomChance <= 0.15) {
					System.out.println("You trip over a bone while running to the door. Luckily the skeleton has not noticed your clumsiness.");
					//you.removeHealth(10);
				} else if (randomChance <= 0.25) {
					System.out.println("You trip over a bone while running to the door, but the skeleton noticed you! It throws it's left arm at you (-10 Health) just before you get through the door");
				} else {
					System.out.println("You open the door and walk into the next room.");
				}
			}
		});
	}
}