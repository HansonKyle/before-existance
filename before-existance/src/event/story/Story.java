package event.story;
import core.Game;
import event.Choice;
import event.Event;

public class Story {

	private Game game;
	private int numOfEvents;

	public Story(Game game, int events) {
		this.game = game;
		numOfEvents = events;
	}
	
	public void nextRoom() {
		double randomRoom = Math.random();
		double randomChance = Math.random();
		Room randRoom = new Room();
		System.out.println(randRoom.toString());
		if (randomRoom <= 0.2) {
			System.out.println("The room is empty");
			
		} else if (randomRoom <= 0.4) {
			
			System.out.println("There lies a lone skeleton in the center of the room");
			Event event = new Event(game, "Frail Skeleton");
			event.addChoice(new Choice(1, "Fight skeleton") {
				public void activate() {
					if (randomChance <= 0.15) {
						System.out.println("The frail skeleton hits you then falls into a pile of bones");
						//you.removeHealth(10);
					} else {
						System.out.println("You poke the frail skeleton and it falls into a pile of bones");
					}
				}
			});
			event.addChoice(new Choice(2, "Run to the door") {
				public void activate() {
					if (randomChance <= 0.15) {
						System.out.println("You trip over a bone while running to the door. Luckily the skeleton has not noticed your clumsiness");
						//you.removeHealth(10);
					} else if (randomChance <= 0.25) {
						System.out.println("You trip over a bone while running to the door, but the skeleton noticed you! It throws it's left arm at you (-10 Health) just before you get through the door");
					} else {
						System.out.println("You open the door and walk into the next room.");
					}
				}
			});
			event.displayChoices();
		} else if (randomRoom <= 0.6) {
			System.out.println("A big floating hand greets you into the room. It would be polite to greet the hand back.");
			Event event = new Event(game, "Big Hand");
			event.addChoice(new Choice(1, "Wave to the hand.") {
				public void activate() {
					if (randomChance <= 0.15) {
						System.out.println("The hand opens a secret door for you. You have no choice but to enter.");
					} else {
						System.out.println("The hand opens the door you just came through, but it leads into a new room.");
					}
				}
			});
			event.addChoice(new Choice(2, "Flip the hand off.") {
				public void activate() {
					System.out.println("The hand slaps you through a brick wall, into another room (-40 Health). The hand then repairs the wall as an attempt to not see you again.");
					//you.removeHealth(40);
				}
			});
			event.addChoice(new Choice(3, "Attack the hand.") {
				public void activate() {
					if (randomChance <= 0.50) {
						System.out.println("You stab the hand and it immediately surrenders, as the hand hates splinters. The hand opens the door you entered through and pushes you into a new room.");
					} else {
						System.out.println("The hand mercilessly yeets you through the floor (-50 Health).");
						//if player is alive;
						System.out.println("The hand then plugs the hole in the floor with its finger and leaves you be in the next room.");
					}
				}
			});
			event.displayChoices();
		} else if (randomRoom <= 0.8) {
			System.out.println("An army of squirrels lay asleep in the middle of the room. If they get angry there is no survival. There are two doors, one farther than the other.");
			Event event = new Event(game, "SQUIRRELS");
			event.addChoice(new Choice(1, "Sneak to the close door.") {
				public void activate() {
					if (randomChance <= 0.50) {
						System.out.println("You successfully sneak to the door and escape the possibility of eternal torment by squirrels");
						//you.removeHealth(10);
					} else if (randomChance <= 85) {
						System.out.println("You start to sneak towards the door but you step on a stray nut. The army is awake, but they are happy because nut. You manage to get to the close door into the next room.");
					} else {
						System.out.println("You start to sneak towards the door but a small spider spooks you and you fall right on top of all of the squirrels. You are then killed by an army of squirrels and the last thought running through your mind is 'Squirrel crowdsurfing'");
					}
				}
			});
			event.addChoice(new Choice(2, "Sneak to the far door.") {
				public void activate() {
					if (randomChance <= 0.15) {
						System.out.println("You manage to sneak your way to the far door.");
						//you.removeHealth(10);
					} else {
						System.out.println("A lone squirrel wakes up as you pass the close door. The squirrel says one word, in perfect English. One word that will strike fear into anyone who hears a squirrel say this word.");
						System.out.println("'Bruh' -Lone Squirrel");
						System.out.println("You immediately open the close door behind you and leave the squirrels alone.");
					}
				}
			});
			event.displayChoices();
		} else {
			System.out.println("A treasure chest lays in the center of the room.");
			Event event = new Event(game, "Treasure chest");
			event.addChoice(new Choice(1, "Open treasure chest.") {
				public void activate() {
					if (randomChance <= 0.15) {
						System.out.println("The treasure chest creaks open, briefly exposing the gold inside before teeth emerge from the chest and chomp down on your arm (-30 Health). The chest keeps its lid closed and refuses to open.");
						System.out.println("Having been defeated by a wooden chest, you leave the room through a door on the other side.");
						//you.removeHealth(30);
					} else if (randomChance <= 80) {
						System.out.println("You open the chest to reveal an empty bottle with a label that says 'Your luck'.");
					} else {
						System.out.println("You open the chest to reveal a full bottle with a label that says 'Health potion, will heal 25 health'. You then leave the room through a door on the other side.");
					}
				}
			});
			event.addChoice(new Choice(2, "Leave the chest for the next adventurer") {
				public void activate() {
					if (randomChance <= 0.15) {
						System.out.println("Just before you leave the room, you hear the chest move and growl. You made a good choice leaving the chest alone.");
						//you.removeHealth(10);
					} else if (randomChance <= 50) {
						System.out.println("Just before you leave the room, another person enters through the door you came from and opens the chest. They take out a wand and immediately teleport away. Weird.");
					} else {
						System.out.println("You regretfully leave the room and the chest inside it.");
					}
				}
			});
			event.displayChoices();
		}
	}

	public void start() {
		Room startingRoom = new Room(5, 5);
		System.out.println("----------------------------------\n" + startingRoom + "\n");
		
		Event first = new Event(game, "Nothing");
		first.addChoice(new Choice(1, "Go through door") {
			public void activate() {
					System.out.println("You open the door and walk into the next room.");
			}
		});
		first.displayChoices();
		
		for (int i = 0; i < numOfEvents; i++) {
			System.out.println("\n----------------------------------");
			this.nextRoom();
		}
		System.out.println("You finished the game! Congration");
	}

	@Override
	public String toString() {
		String statement = "Number of events: " + numOfEvents;
		return statement;
	}
}
