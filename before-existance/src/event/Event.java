package event;
import java.util.ArrayList;

import core.Game;
// Event class creates events that allow the player to read the event and respond via choices made for the given event
public class Event {
	
	private final ArrayList<Choice> choices = new ArrayList<>();
	private Game game;
	private String name;
	private String description;

	public Event(Game game, String name, String description) { // General constructor
		this.game = game;
		this.name = name;
		this.description = description;
	}
	
	public void addChoice(Choice choice) { // Adds choice to the choices arrayList for this event
		choices.add(new Choice(choice) {
			@Override
			public void activate() {
				choice.activate();
			}
		});
	}
	
	public Choice getChoice(int key) { // activates choice if the key corresponds to one of the choices in arrayList
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
	
	public char[] getValidKeys() { // returns arrayList of key bindings for each choice in choices
		char[] keys = new char[choices.size()];
		for (int i = 0; i < choices.size(); i++) {
			keys[i] = choices.get(i).getKeyBinding();
		}
		return keys;
	}
	
	public void displayChoices() { // prints every choice in choices
		if (choices.size() > 0) {
			System.out.println("----------------------------------");
			for (Choice choice : choices) {
				System.out.println(choice);
			}
		}
	}
	
	public void requestChoice() { // activates choice if key entered matches a valid key
		if (choices.size() > 0) {
			System.out.println("----------------------------------");
			System.out.println("Enter your choice: ");
			int key = game.getInput().requestChar(getValidKeys(), "Invalid input. Please enter a number associated with one of the choices above:");
			Choice chosen = getChoice(key);
			chosen.activate();
		}
	}
	
	@Override
	public String toString() {
		return name;
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
}
