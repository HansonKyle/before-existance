package core;

import event.Menu;
import event.story.Story;

public class Game {
	
	private final Input input = new Input();
	private final Menu menu;
	private Story currentStory;
	
	public Game() {
		menu = new Menu(this);
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
	
	public Story getCurrentStory() {
		return currentStory;
	}
	
	public void setCurrentStory(Story currentStory) {
		this.currentStory = currentStory;
	}
}
