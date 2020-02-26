package event;

import core.Game;
// Event: Empty room
// Creates an event with 1 choice
public class EmptyRoomEvent extends Event {

	public EmptyRoomEvent(Game game) {
		super(game, "Empty Room", "This room is empty.");
		
		super.addChoice(new Choice('1', "Go through door") { // Add first choice
			public void activate() {
				System.out.println("You open the door and walk into the next room.");
			}
		});
	}
}
