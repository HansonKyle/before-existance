package event.story;

import core.Game;
import entity.Player;
import event.Event;
import event.EventGenerator;

public class Story {

	private final EventGenerator eventGenerator;
	
	private Game game;
	private Player player;
	private Event[] events;

	public Story(Game game, int numEvents) {
		this.game = game;
		this.events = new Event[numEvents];
		this.eventGenerator = new EventGenerator(game);
		
		for (int i = 0; i < events.length; i++) {
			events[i] = eventGenerator.generateUniqueEvent();
		}
	}

	public void start() {
		if (game.getPlayer() == null) {
			game.initPlayer();
		}
		
		for (Event event : events) {
			System.out.println(event.getDescription());
			event.displayChoices();
			event.requestChoice();
			System.out.println();
		}
		System.out.println("----------------------------------");
		System.out.println("You have finished the game. Congratulations!");
		System.out.println("----------------------------------\n");
		
		game.displayMenu();
	}

	@Override
	public String toString() {
		return "Number of events: " + events.length;
	}
	
	public Player getPlayer() {
		return player;
	}
}