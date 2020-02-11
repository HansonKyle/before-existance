import java.math.*;

public class Story {
	private int numOfEvents;

	public Story(int events) {
		numOfEvents = events;
	}

	public void nextRoom() {
		double randomNumber = Math.random();
		if (randomNumber <= 0.2) {
			// generate certain type of room
		}
		if (randomNumber <= 0.4) {
			// generate other type of room
		}
		if (randomNumber <= 0.6) {
			// generate different type of room
		}
		if (randomNumber <= 0.8) {
			// generate big room
		} else {
			// generate small room
		}
	}

	public String toString() {
		String statement = "Number of events: " + numOfEvents;
		return statement;
	}
//main function used to test this class
	/*
	public static void main(String[] args) {
	Story yayStoryTime = new Story(10);
	System.out.println(yayStoryTime);
	
	} */
}
