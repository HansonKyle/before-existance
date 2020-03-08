package core;

import entity.Player;
import event.Event;
import event.Menu;
import event.story.Story;

// Initializes the menu and player classes
public class Game {
	
	private final Input input = new Input();
	private final Menu menu;
	private Story currentStory;
	private Player player;

	public Game() {
		this.menu = new Menu(this);
		displayMenu();
	}
	
	// Prints the menu to the screen and waits for user input
	public void displayMenu() {
		System.out.println("| DUNGEON CRAWLER |");
		System.out.println(menu);
		menu.displayChoices();
		menu.requestChoice();
	}
	
	// Initializes the player by retrieving user input
	public void initPlayer() {
		System.out.println("----------------------------------");
		System.out.println("Please enter your name: ");
		
		String playerName = input.getScanner().next();
		this.player = new Player(playerName, 100, null);
		
		System.out.println();
	}
	
	public void start() {
		if (player == null || player.getDungeonsSurvived() == 0) {
			initPlayer();
		}
		
		Event[] events = currentStory.getEvents();
		int i = 0;
		while (i < events.length && player.isAlive()) { // Displays and requests input for every event in the array
			System.out.println(events[i].getDescription());
			events[i].displayChoices();
			events[i].requestChoice();
			System.out.println(events[i].getChoiceResult() + "\n");
			i++;
		}
		if (player.isAlive()) { // If player is alive, print end of dungeon screen 
			player.dungeonSurvived();
			System.out.println("----------------------------------");
			System.out.println("You have completed this dungeon. Congratulations!");
			System.out.println("Current Stats: " + player);
			System.out.println("----------------------------------\n");
		}
		displayMenu();
	}
	
	// Prints the menu to the screen and waits for user input
	public void close() {
		input.close();
	}
	
	public Input getInput() {
		return input;
	}
	
	public Story getCurrentStory() {
		return currentStory;
	}

	public void setCurrentStory(Story currentStory) {
		this.currentStory = currentStory;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
}
