import java.util.ArrayList;
public abstract class Item {
	private String name;
	private ArrayList<Item> inventory = new ArrayList<Item>();
	
	public abstract void use();
	
	public void addItem(Item i){
		inventory.add(i);
	}
	public void removeItem(Item i) {
		inventory.remove(i);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Item> getInventory() {
		return inventory;
	}
	public String toString(){
		return "Inventory: " + inventory;
	}
}