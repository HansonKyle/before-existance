package event;
// Choice class stores options for the player to execute in the form of a key binding with a description
public abstract class Choice {
	
	private char keyBinding;
	private String description;

	public Choice(char keyBinding, String description) { // General constructor
		this.keyBinding = keyBinding;
		this.description = description;
	}
	
	public Choice(Choice choice) { // Copy constructor
		this.keyBinding = choice.keyBinding;
		this.description = choice.description;
	}
	
	public abstract void activate(); // Abstract activate method that allows for different choices to have different activation methods
	
	@Override
	public String toString() {
		return keyBinding + ". " + description;
	}
	
	public char getKeyBinding() {
		return keyBinding;
	}

	public void setKeyBinding(char keyBinding) {
		this.keyBinding = keyBinding;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
