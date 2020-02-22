package event;
import java.util.ArrayList;

import core.Game;

public class Event {
	
	private Game game;
	private String name;
	private ArrayList<Choice> choices = new ArrayList<>();
	
	public Event(Game game, String name) {
		this.game = game;
		this.name = name;
	}
	
	public void addChoice(Choice choice) {
		choices.add(new Choice(choice) {
			@Override
			public void activate() {
				choice.activate();
			}
		});
	}
	
	public void addChoice(int i, String desc) {
		choices.add(new Choice(i, desc) {
			@Override
			public void activate() {
				
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
		for (Choice choice : choices) {
			System.out.println(choice);
		}
		requestChoice();
	}
	
	public void requestChoice() {
		int key = game.getInput().requestInt(getValidKeys());
		Choice chosen = getChoice(key);
		chosen.activate();
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
}
