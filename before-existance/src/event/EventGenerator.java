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
				switch(num) {
					case 0:
						event = new FrailSkeletonEvent(game);
						break;
					case 1:
						event = new SquirrelsEvent(game);
						break;
					case 2:
						event = new TreasureEvent(game);
						break;
					case 3:
						event = new BigHandEvent(game);
						break;
					case 4:
						event = new EmptyRoomEvent(game);
						break;
				}
				generatedNumbers.add(num);
			}
		}
		return event;
	}
}