package event;

import core.Game;

/*
 * Creates and presents an event of the player entering an empty room, proceeds to the next event with the player's choice.
 */
public class EmptyRoomEvent extends Event {

	// General constructor
	public EmptyRoomEvent(Game game) {
		super(game, "Empty Room", "This room is empty.");
		
		super.addChoice(new Choice('1', "Go through door") { // Add first choice
			public void activate() {
				setChoiceResult("You open the door and walk into the next room.");
				setHealthLost(0);
			}
		});
	}
}
