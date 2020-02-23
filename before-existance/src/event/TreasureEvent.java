package event;

import core.Game;

public class TreasureEvent extends Event {

	public TreasureEvent(Game game) {
		super(game, "Treasure Chest", "A treasure chest lays in the center of the room.");
		
		super.addChoice(new Choice('1', "Open treasure chest") {
			public void activate() {
				double randomChance = Math.random();
				
				if (randomChance <= 0.15) {
					System.out.println("The treasure chest creaks open, briefly exposing the gold inside before teeth emerge from the chest and chomp down on your arm (-30 Health). The chest keeps its lid closed and refuses to open.");
					System.out.println("Having been defeated by a wooden chest, you leave the room through a door on the other side.");
					game.getPlayer().removeHealth(30);
					System.out.println("Current Stats: " + game.getPlayer());
				} else if (randomChance <= 80) {
					System.out.println("You open the chest to reveal an empty bottle with a label that says 'Your luck'.");
				} else {
					System.out.println("You open the chest to reveal a full bottle with a label that says 'Health potion, will heal 25 health'.");
					System.out.println("You leave the room through a door on the other side of the room.");
				}
			}
		});
		
		super.addChoice(new Choice('2', "Leave the chest for the next adventurer") {
			public void activate() {
				double randomChance = Math.random();
				
				if (randomChance <= 0.15) {
					System.out.println("Just before you leave the room, you hear the chest move and growl. You made a good choice leaving the chest alone.");
				} else if (randomChance <= 50) {
					System.out.println("Just before you leave the room, another person enters through the door you came from and opens the chest. They take out a wand and immediately teleport away. Weird.");
				} else {
					System.out.println("You regretfully leave the room and the chest inside it.");
				}
			}
		});
	}
}