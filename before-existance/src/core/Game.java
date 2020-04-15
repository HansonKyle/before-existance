package core;

import entity.Player;

/*
 * Initializes the player and user input classes
 */
public class Game {
	
	private final Input input = new Input();
	private Player player;
	
	/**
	 * Initializes the player by asking the user to input their name in the console
	 */
	public void initPlayer() {
		System.out.println("----------------------------------");
		System.out.println("Please enter your name: ");
		
		String playerName = input.getScanner().next();
		this.player = new Player(playerName, 100, null);
		
		System.out.println();
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
	
	public void setPlayer(Player player) {
		this.player = player;
	}
}
