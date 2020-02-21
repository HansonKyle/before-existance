import java.util.ArrayList;

public class Spell {
	private String name;
	private ArrayList<Spell> Spellbook = new ArrayList<Spell>();
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Spell> getSpellbook() {
		return Spellbook;
	}
}
