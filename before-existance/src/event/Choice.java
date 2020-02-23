package event;
public abstract class Choice {
	
	private char keyBinding;
	private String description;

	public Choice(char keyBinding, String description) {
		this.keyBinding = keyBinding;
		this.description = description;
	}
	
	public Choice(Choice choice) {
		this.keyBinding = choice.keyBinding;
		this.description = choice.description;
	}
	
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