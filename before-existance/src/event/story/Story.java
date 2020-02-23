package event.story;

import core.Game;
import event.Event;
import event.EventGenerator;

public class Story {

	private final EventGenerator eventGenerator;
	
	private Game game;
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
		game.initPlayer();
		
		int i = 0;
		while (i < events.length && game.getPlayer().isAlive()) {
			System.out.println(events[i].getDescription());
			events[i].displayChoices();
			events[i].requestChoice();
			System.out.println();
			i++;
		}
		if (game.getPlayer().isAlive()) {
			game.getPlayer().dungeonSurvived();
			System.out.println("----------------------------------");
			System.out.println("You have completed this dungeon. Congratulations!");
			System.out.println("Current Stats: " + game.getPlayer());
			System.out.println("----------------------------------\n");
		} else {
			System.out.println("----------------------------------");
			System.out.println("Game over.");
			System.out.println("----------------------------------\n");
		}
		game.setPlayer(null);
		game.displayMenu();
	}

	@Override
	public String toString() {
		return "Number of events: " + events.length;
	}
}
