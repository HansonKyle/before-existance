package core;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
	
	private final Scanner scanner = new Scanner(System.in);
	
	public int requestInt(String message, int[] validInputs, String errorMessage) {
	    int input = 0;
	    boolean valid = false;
	    while (!valid) {
	        try {
	        	if (message != null) {
	        		System.out.println(message);
	        	}
	        	input = scanner.nextInt();
	        	for (int i : validInputs) {
	        		if (input == i) {
	        			valid = true;
	        		}
	        	}
	        } catch (InputMismatchException e) {
	        	if (errorMessage != null) {
	        		System.out.println(errorMessage);
	        	}
	        	scanner.next();
	        }
	    }
	    return input;
	}
	
	public int requestInt(int[] validInputs, String errorMessage) {
		return requestInt(null, validInputs, errorMessage);
	}
	
	public void close() {
		scanner.close();
	}
	
	public Scanner getScanner() {
		return scanner;
	}
}