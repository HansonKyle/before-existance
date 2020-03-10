package event.story;

import core.Game;
import event.Event;
import event.EventGenerator;

// Story class stores events in an array and prints events for player to read and respond to.
public class Story {

	private final EventGenerator eventGenerator;
	
	private Event[] events;

	private Game game;

	public Story(Game game, int numEvents) { // Generates list of events using eventGenerator class
		this.game = game;
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
