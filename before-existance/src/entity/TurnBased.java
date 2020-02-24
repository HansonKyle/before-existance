package entity;
import java.lang.Math;

public class TurnBased {
	public static boolean firstTurn() {
		int x = (Math.random() <= 0.5) ? 1 : 2;
		
		if (x==1) {
			return true;
		}
		else {
			return false;
		}
	} 
	
}
