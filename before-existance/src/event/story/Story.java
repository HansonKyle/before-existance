package event.story;

import core.Game;
import event.Event;
import event.EventGenerator;

/*
 * This class stores game events in an array for player to read and respond to
 * Events are randomly generated and placed in the array using the EventGenerator class
 */
public class Story {

	private final Event[] events;
	private final EventGenerator eventGenerator;

	// General constructor
	public Story(Game game, int numEvents) {
		this.events = new Event[numEvents];
		this.eventGenerator = new EventGenerator(game);
		
		// Generates list of events using eventGenerator class
		for (int i = 0; i < events.length; i++) {
			events[i] = eventGenerator.generateUniqueEvent();
		}
	}
	
	/**
	 * Gets the number of events in the story
	 * 
	 * @return number of events
	 */
	public int length() {
		return events.length;
	}
	
	/**
	 * Gets a specific event from the story
	 * 
	 * @param i the event index
	 * @return the event at the corresponding index
	 */
	public Event getEvent(int i) {
		return events[i];
	}

	@Override
	public String toString() {
		return "Number of events: " + events.length;
	}
}
