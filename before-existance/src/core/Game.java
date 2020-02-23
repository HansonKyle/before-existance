package core;

import entity.Player;
import event.Menu;

public class Game {
	
	private final Input input = new Input();
	private final Menu menu;
	private Player player;

	public Game() {
		menu = new Menu(this);
		displayMenu();
	}
	
	public void initPlayer() {
		System.out.println("----------------------------------");
		System.out.println("Please enter your name: ");
		
		String playerName = input.getScanner().next();
		this.player = new Player(playerName, 100, null);
		
		System.out.println();
	}
	
	public void displayMenu() {
		System.out.println(menu);
		menu.displayChoices();
		menu.requestChoice();
	}
	
	public void close() {
		input.close();
	}
	
	public Input getInput() {
		return input;
	}
	
	public Player getPlayer() {
		return player;
	}
}
