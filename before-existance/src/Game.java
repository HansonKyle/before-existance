public class Game {
	
	private final Input input = new Input();
	private final Player player = new Player("Username", 100);
	private final Menu menu;
	
	public Game() {
		menu = new Menu(this);
		System.out.println(menu);
		menu.displayChoices();
	}
	
	public void close() {
		input.close();
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public Input getInput() {
		return input;
	}
}