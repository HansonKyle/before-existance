package event;

// Choice class stores options for the player to execute in the form of a key binding with a description
public abstract class Choice {
	
	private char keyBinding;
	private String description;

	// General constructor
	public Choice(char keyBinding, String description) {
		this.keyBinding = keyBinding;
		this.description = description;
	}
	
	// Copy constructor
	public Choice(Choice choice) {
		this.keyBinding = choice.keyBinding;
		this.description = choice.description;
	}
	
	// Allows for different choices to have different activation methods
	public abstract void activate();
	
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
