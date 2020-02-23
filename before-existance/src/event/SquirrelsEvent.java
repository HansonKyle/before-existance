package event;

import core.Game;

public class SquirrelsEvent extends Event {

	public SquirrelsEvent(Game game) {
		super(game, "Squirrels", "An army of squirrels lay asleep in the middle of the room. If they get angry there is no survival. There are two doors, one farther than the other.");
		
		super.addChoice(new Choice(1, "Sneak to the close door") {
			public void activate() {
				double randomChance = Math.random();
				
				if (randomChance <= 0.50) {
					System.out.println("You successfully sneak to the door and escape the possibility of eternal torment by squirrels");
					//you.removeHealth(10);
				} else if (randomChance <= 85) {
					System.out.println("You start to sneak towards the door but you step on a stray nut. The army is awake, but they are happy because nut. You manage to get to the close door into the next room.");
				} else {
					System.out.println("You start to sneak towards the door but a small spider spooks you and you fall right on top of all of the squirrels. You are then killed by an army of squirrels and the last thought running through your mind is 'Squirrel crowdsurfing'");
				}
			}
		});
		
		super.addChoice(new Choice(2, "Sneak to the far door") {
			public void activate() {
				double randomChance = Math.random();
				
				if (randomChance <= 0.15) {
					System.out.println("You manage to sneak your way to the far door.");
					//you.removeHealth(10);
				} else {
					System.out.println("A lone squirrel wakes up as you pass the close door. The squirrel says one word, in perfect English. One word that will strike fear into anyone who hears a squirrel say this word.");
					System.out.println("'Bruh' -Lone Squirrel");
					System.out.println("You immediately open the close door behind you and leave the squirrels alone.");
				}
			}
		});
	}
}