package entity;
import java.lang.Math;

public class TurnBased {
	
	public static boolean firstTurn() {
		return Math.random() <= 0.5;
	}
}