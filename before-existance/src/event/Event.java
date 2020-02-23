package event;
import java.util.ArrayList;

import core.Game;

public class Event {
	
	private final ArrayList<Choice> choices = new ArrayList<>();
	private Game game;
	private String name;
	private String description;

	public Event(Game game, String name, String description) {
		this.game = game;
		this.name = name;
		this.description = description;
	}
	
	public void addChoice(Choice choice) {
		choices.add(new Choice(choice) {
			@Override
			public void activate() {
				choice.activate();
			}
		});
	}
	
	public Choice getChoice(int key) {
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
	
	public int[] getValidKeys() {
		int[] keys = new int[choices.size()];
		for (int i = 0; i < choices.size(); i++) {
			keys[i] = choices.get(i).getKeyBinding();
		}
		return keys;
	}
	
	public void displayChoices() {
		if (choices.size() > 0) {
			System.out.println("----------------------------------");
			for (Choice choice : choices) {
				System.out.println(choice);
			}
		}
	}
	
	public void requestChoice() {
		if (choices.size() > 0) {
			System.out.println("----------------------------------");
			System.out.println("Enter your choice: ");
			int key = game.getInput().requestInt(getValidKeys());
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
