package core;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
	
	private final Scanner scanner = new Scanner(System.in);
	
	public int requestInt(String message, int[] validInputs) {
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
	        	scanner.next();
	        }
	    }
	    return input;
	}
	
	public int requestInt(int[] validInputs) {
		return requestInt(null, validInputs);
	}
	
	public char requestChar(String message, char[] validInputs) {
	    String input = "";
	    boolean valid = false;
	    while (!valid) {
	        try {
	        	if (message != null) {
	        		System.out.println(message);
	        	}
	        	input = scanner.nextLine();
	            if (input.length() == 1) {
	            	for (char c : validInputs) {
	            		if (input.charAt(0) == c) {
	            			valid = true;
	            		}
	            	}
	            }
	        } catch (InputMismatchException e) {
	        	scanner.next();
	        }
	    }
	    return input.charAt(0);
	}
	
	public char requestChar(char[] validInputs) {
		return requestChar(null, validInputs);
	}
	
	public void close() {
		scanner.close();
	}
	
	public Scanner getScanner() {
		return scanner;
	}
}