package item;
public abstract class Item {
	
	//Set a variable for the name
	private String name;
	
	//Apply the name
	public Item(String name) {
		this.name = name;
	}
	
	//Use the method use
	public abstract void use();
	
	//Get the name
	public String getName() {
		return name;
	}
	
	//Set the name
	public void setName(String name) {
		this.name = name;
	}
}
