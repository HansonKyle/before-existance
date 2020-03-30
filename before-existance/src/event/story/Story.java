package event.story;

import core.Game;
import event.Event;
import event.EventGenerator;

/*
 * This class stores game events in an array and prints events for player to read and respond to.
 */
public class Story {

	private final Event[] events;
	private final EventGenerator eventGenerator;

	public Story(Game game, int numEvents) { // Generates list of events using eventGenerator class
		this.events = new Event[numEvents];
		this.eventGenerator = new EventGenerator(game);
		
		for (int i = 0; i < events.length; i++) {
			events[i] = eventGenerator.generateUniqueEvent();
		}
	}
	
	public int length() {
		return events.length;
	}
	
	public Event getEvent(int i) {
		return events[i];
	}

	@Override
	public String toString() {
		return "Number of events: " + events.length;
	}
}
