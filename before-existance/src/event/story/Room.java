package event.story;

// Room class generates room sizes for events
public class Room {
	
	private int roomLength;
	private int roomWidth;

	// General constructor
	public Room(int l, int w) {
		roomLength = l;
		roomWidth = w;
	}

	// Random constructor
	public Room() {
		int roomAdjustmentConstant = 20; // Arbitrary until room size needs to be converted into pixels
		double randomNumberLength = Math.random();
		double randomNumberWidth = Math.random();
		roomLength = (int) (roomAdjustmentConstant * randomNumberLength);
		roomWidth = (int) (roomAdjustmentConstant * randomNumberWidth);
	}

	@Override
	public String toString() {
		return "Room Length : " + roomLength + " | Room Width  : " + roomWidth;
	}
}
