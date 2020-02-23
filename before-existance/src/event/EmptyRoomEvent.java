package event;

import core.Game;

public class EmptyRoomEvent extends Event {

	public EmptyRoomEvent(Game game) {
		super(game, "Empty Room", "The room is empty.");
		
		super.addChoice(new Choice(1, "Go through door") {
			public void activate() {
				System.out.println("You open the door and walk into the next room.");
			}
		});
	}
}