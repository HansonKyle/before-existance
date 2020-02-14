
public class Entity {
  private String name;
	private int attack;
	
	public Entity(String nama, int atk) {
		name = nama;
		attack = atk;
	}
	
	public void addAttack(int addition) {
		attack += addition;
	}
	public void reduceAttack(int reduction) {
		attack -= reduction;
	}
	public void setAttack(int toSet) {
		attack = toSet;
	}
	public int getAttack() {
		int attackCopy = attack;
		return attackCopy;
	}
	public void setName(String noime) {
		name = noime;
	}
  public String getName() {
		String nameCopy = name;
		return nameCopy;
	}
	public String toString() {
		return name + " has an attack of " + attack
	}
}
