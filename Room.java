import java.math.*;

public class Room {
	private int roomLength;
	private int roomWidth;

	public Room(int l, int w) {
		roomLength = l;
		roomWidth = w;
	}

	public Room() {
		int roomAdjustmentConstant = 10; // Arbitrary until room size needs to be converted into pixels
		double randomNumberLength = Math.random();
		double randomNumberWidth = Math.random();
		roomLength = (int) (roomAdjustmentConstant * randomNumberLength);
		roomWidth = (int) (roomAdjustmentConstant * randomNumberWidth);
	}

	public String toString() {
		return "Room Length: " + roomLength + "\nRoom Width: " + roomWidth;
	}

}