package event.story;

/*
 * A room is a collection of game events
 * This class generates a new room with either a given or random size
 */
public class Room {
	
	private int roomLength;
	private int roomWidth;

	// General constructor
	public Room(int length, int width) {
		roomLength = length;
		roomWidth = width;
	}

	// Generates a room with a random size instead of setting the length and width manually
	public Room() {
		int roomAdjustmentConstant = 20; // Arbitrary until room size needs to be converted into pixels
		double randomNumberLength = Math.random();
		double randomNumberWidth = Math.random();
		// Set the room length and width to the random numbers
		roomLength = (int) (roomAdjustmentConstant * randomNumberLength);
		roomWidth = (int) (roomAdjustmentConstant * randomNumberWidth);
	}

	@Override
	public String toString() {
		return "Room Length : " + roomLength + " | Room Width  : " + roomWidth;
	}
}
