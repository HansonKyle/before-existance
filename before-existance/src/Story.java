import java.util.Scanner;
public class Story {

	private int numOfEvents;

	public Story(int events) {
		numOfEvents = events;
	}
	public void playerInitialize() {
		System.out.println("Enter your name: ");
		Scanner keyboard = new Scanner(System.in);
		Player you = new Player(keyboard.nextLine(), 100);
		System.out.println(you.toString());
	}
	
	public void nextRoom() {
		double randomRoom = Math.random();
		double randomChance = Math.random();
		if (randomRoom <= 0.2) {
			Event second = new Event(null, "Nothing");
			second.addChoice(new Choice(1, "Go through door") {
				public void activate() {
					if (randomChance <= 0.15) {
						System.out.println("You pushed when you should have pulled and walked into the door. \n(-10 Health)");
						//you.removeHealth(10);
					} else {
						System.out.println("You open the door and walk into the next room.");
					}
				}
			});
		} else if (randomRoom <= 0.4) {
			// generate other type of room
		} else if (randomRoom <= 0.6) {
			// generate different type of room
		} else if (randomRoom <= 0.8) {
			// generate big room
		} else {
			// generate small room
		}
	}

	public void start() {
		Room startingRoom = new Room(5, 5);
		System.out.println(startingRoom.toString());
		Event first = new Event(null, "Nothing");
		//Menu startingMenu = new Menu(this);
		first.addChoice(new Choice(1, "Go through door") {
			public void activate() {
					System.out.println("You open the door and walk into the next room.");
			}
		});
		for (int i = 0; i < numOfEvents; i++) {
			this.nextRoom();
		}
	}

	@Override
	public String toString() {
		String statement = "Number of events: " + numOfEvents;
		return statement;
	}
}
