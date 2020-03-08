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
	
	public void start() {
		if (game.getPlayer() == null || game.getPlayer().getDungeonsSurvived() == 0) {
			game.initPlayer();
		}
		
		int i = 0;
		while (i < events.length && game.getPlayer().isAlive()) { // Displays and requests input for every event in the array
			System.out.println(events[i].getDescription());
			events[i].displayChoices();
			events[i].requestChoice();
			System.out.println();
			i++;
		}
		if (game.getPlayer().isAlive()) { // If player is alive, print end of dungeon screen 
			game.getPlayer().dungeonSurvived();
			System.out.println("----------------------------------");
			System.out.println("You have completed this dungeon. Congratulations!");
			System.out.println("Current Stats: " + game.getPlayer());
			System.out.println("----------------------------------\n");
		}
		game.displayMenu();
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
