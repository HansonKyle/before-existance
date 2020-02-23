package event;
import core.Game;
import event.story.Story;

public class Menu extends Event {
	
	public Menu(Game game) {
		super(game, "Menu", "Dungeon Crawler");
		
		super.addChoice(new Choice(1, "Start Game") {
			@Override
			public void activate() {
				Story mainStory = new Story(game, 4);
				mainStory.start();
			}
		});
		
		super.addChoice(new Choice(2, "Quit") {
			@Override
			public void activate() {
				System.out.println("Quitting game...");
				game.close();
			}
		});
	}
}
