package event;

import java.util.ArrayList;
import core.Game;

// Event class creates events that allow the player to read and respond via choices made for the given event
public class Event {
	
	private final ArrayList<Choice> choices = new ArrayList<>();
	
	private Game game;
	private String name;
	private String description;
	private String choiceResult;
	private int healthLost;

	// General constructor
	public Event(Game game, String name, String description) {
		this.game = game;
		this.name = name;
		this.description = description;
	}
	
	// Adds a choice to the choices arrayList for this event
	public void addChoice(Choice choice) {
		choices.add(new Choice(choice) {
			@Override
			public void activate() {
				choice.activate();
			}
		});
	}
	
	/**
	 * Retrieves, copies and returns a choice in choices
	 * 
	 * @param key a valid key that corresponds to a choice in the event
	 * @return choice
	 */
	public Choice getChoice(char key) {
		for (Choice choice : choices) {
			if (key == choice.getKeyBinding()) {
				return new Choice(choice) {
					@Override
					public void activate() {
						choice.activate();
					}
				};
			}
		}
		return null;
	}
			
	/**
	 * @param none
	 * @return keys array of key bindings for each choice in choices
	 */
	public char[] getValidKeys() {
		char[] keys = new char[choices.size()];
		for (int i = 0; i < choices.size(); i++) {
			keys[i] = choices.get(i).getKeyBinding();
		}
		return keys;
	}
	
	// Prints every choice in choices
	public void displayChoices() {
		if (choices.size() > 0) {
			System.out.println("----------------------------------");
			for (Choice choice : choices) {
				System.out.println(choice);
			}
		}
	}
	
	// Activates the choice that corresponds to the key that was entered
	public void requestChoice() {
		if (choices.size() > 0) {
			System.out.println("----------------------------------");
			System.out.println("Enter your choice: ");
			char key = game.getInput().requestChar(getValidKeys(), "Invalid input. Please enter a number associated with one of the choices above:");
			Choice chosen = getChoice(key);
			chosen.activate();
		}
	}
	
	// Setters and getters
	
	@Override
	public String toString() {
		return name;
	}
	
	public int getChoicesLength() {
		return choices.size() - 1;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getChoiceResult() {
		return choiceResult;
	}

	public void setChoiceResult(String choiceResult) {
		this.choiceResult = choiceResult;
	}
	
	public int getHealthLost() {
		return healthLost;
	}

	public void setHealthLost(int healthLost) {
		this.healthLost = healthLost;
	}
}
