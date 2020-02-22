package event;

import core.Game;

public class EmptyRoom extends Event {

	public EmptyRoom(Game game) {
		super(game, "Nothing");
		
		super.addChoice(new Choice(1, "Go through door") {
			public void activate() {
				//if (randomChance <= 0.15) {
					//System.out.println("You pushed when you should have pulled and walked into the door. \n(-10 Health)");
					//you.removeHealth(10);
				//} else {
					//System.out.println("You open the door and walk into the next room.");
			//	}
			}
		});
	}
}