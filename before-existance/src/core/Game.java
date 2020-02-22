package core;

import event.Menu;

public class Game {
	
	private final Input input = new Input();
	private final Menu menu;
	
	public Game() {
		menu = new Menu(this);
		System.out.println(menu);
		menu.displayChoices();
	}
	
	public void close() {
		input.close();
	}
	
	public Input getInput() {
		return input;
	}
}
