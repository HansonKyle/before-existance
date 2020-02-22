package event;
public abstract class Choice {
	
	private int keyBinding;
	private String description;

	public Choice(int keyBinding, String description) {
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
	
	public int getKeyBinding() {
		return keyBinding;
	}

	public void setKeyBinding(int keyBinding) {
		this.keyBinding = keyBinding;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}