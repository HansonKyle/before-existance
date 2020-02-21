public class Menu extends Event {
	
	public Menu(Game game) {
		super(game, "Dungeon Crawler");
		
		super.addChoice(new Choice(1, "Start Game") {
			@Override
			public void activate() {
				// Something that will happen when the game starts...
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