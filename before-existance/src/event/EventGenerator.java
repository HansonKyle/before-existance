package event;

import java.util.ArrayList;
import java.util.Random;

import core.Game;

public class EventGenerator {
	
	private final ArrayList<Integer> generatedNumbers = new ArrayList<>();
	private final Random random = new Random();
	
	private Game game;
	
	public EventGenerator(Game game) {
		this.game = game;
	}
	
	public Event generateUniqueEvent() {
		Event event = null;
		while (event == null) {
			int num = random.nextInt(5);
			if (!generatedNumbers.contains(num)) {
				if (num == 0) {
					event = new FrailSkeletonEvent(game);
				} else if (num == 1) {
					event = new SquirrelsEvent(game);
				} else if (num == 2) {
					event = new TreasureEvent(game);
				} else if (num == 3) {
					event = new BigHandEvent(game);
				} else {
					event = new EmptyRoomEvent(game);
				}
				generatedNumbers.add(num);
			}
		}
		return event;
	}
}