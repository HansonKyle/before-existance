package event.story;

import core.Game;
import event.Event;
import event.EventGenerator;
// Story class stores events in an arrayList and prints events for player to read and respond to. Also initiates player and prints end of game statements.
public class Story {

	private final EventGenerator eventGenerator;
	
	private Game game;
	private Event[] events;

	public Story(Game game, int numEvents) { // Generates list of events using eventGenerator class
		this.game = game;
		this.events = new Event[numEvents];
		this.eventGenerator = new EventGenerator(game);
		
		for (int i = 0; i < events.length; i++) {
			events[i] = eventGenerator.generateUniqueEvent();
		}
	}

	public void start() {
		if (game.getPlayer() == null) { // initializes player if player does not exist
			game.initPlayer();
		}
		
		int i = 0;
		while (i < events.length && game.getPlayer().isAlive()) { // displays and requests input for every event in arrayList
			System.out.println(events[i].getDescription());
			events[i].displayChoices();
			events[i].requestChoice();
			System.out.println();
			i++;
		}
		if (game.getPlayer().isAlive()) { // prints end of game statements depending if player is alive or not
			game.getPlayer().dungeonSurvived();
			System.out.println("----------------------------------");
			System.out.println("You have completed this dungeon. Congratulations!");
			System.out.println("Current Stats: " + game.getPlayer());
			System.out.println("----------------------------------\n");
		} else {
			System.out.println("----------------------------------");
			System.out.println("Game over.");
			System.out.println("----------------------------------\n");
			game.setPlayer(null);
		}
		game.displayMenu();
	}

	@Override
	public String toString() {
		return "Number of events: " + events.length;
	}
}
