package event;

import core.Game;

public class BigHandEvent extends Event {

	public BigHandEvent(Game game) {
		super(game, "Big Hand", "A big floating hand greets you into the room. It would be polite to greet the hand back.");
		
		super.addChoice(new Choice(1, "Wave to the hand") {
			public void activate() {
				double randomChance = Math.random();
				
				if (randomChance <= 0.15) {
					System.out.println("The hand opens a secret door for you. You have no choice but to enter.");
				} else {
					System.out.println("The hand opens the door you just came through, but it leads into a new room.");
				}
			}
		});
		super.addChoice(new Choice(2, "Flip the hand off") {
			public void activate() {
				System.out.println("The hand slaps you through a brick wall, into another room (-40 Health). The hand then repairs the wall as an attempt to not see you again.");
				//you.removeHealth(40);
			}
		});
		super.addChoice(new Choice(3, "Attack the hand") {
			public void activate() {
				double randomChance = Math.random();
				
				if (randomChance <= 0.50) {
					System.out.println("You stab the hand and it immediately surrenders, as the hand hates splinters. The hand opens the door you entered through and pushes you into a new room.");
				} else {
					System.out.println("The hand mercilessly yeets you through the floor (-50 Health).");
					//if player is alive;
					System.out.println("The hand then plugs the hole in the floor with its finger and leaves you be in the next room.");
				}
			}
		});
	}
}