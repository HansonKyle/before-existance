package event.story;

import core.Game;
import event.Event;
import event.EventGenerator;

// Story class stores events in an array and prints events for player to read and respond to.
public class Story {

	private final EventGenerator eventGenerator;
	private Event[] events;

	public Story(Game game, int numEvents) { // Generates list of events using eventGenerator class
		this.events = new Event[numEvents];
		this.eventGenerator = new EventGenerator(game);
		
		for (int i = 0; i < events.length; i++) {
			events[i] = eventGenerator.generateUniqueEvent();
		}
	}
	
	public Event[] getEvents() {
		Event[] events = new Event[this.events.length];
		for (int i = 0; i < events.length; i++) {
			events[i] = this.events[i];
		}
		return events;
	}
	
	public Event getEvent(int i) {
		return events[i];
	}
	
	public int length() {
		return events.length;
	}

	@Override
	public String toString() {
		return "Number of events: " + events.length;
	}
}
