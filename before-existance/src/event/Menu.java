package event;
import core.Game;
import event.story.Story;

// Menu class creates choices for the main menu
public class Menu extends Event {
	
	public Menu(Game game) {
		super(game, "Menu", "Dungeon Crawler");
		
		super.addChoice(new Choice('1', "Start Dungeon") { // Adds first choice to start game
			@Override
			public void activate() {
				Story mainStory = new Story(game, 4);
				mainStory.start();
			}
		});
		
		super.addChoice(new Choice('2', "Quit") { // Adds second choice to end game
			@Override
			public void activate() {
				System.out.println("Quitting game...");
				game.close();
			}
		});
	}
}
