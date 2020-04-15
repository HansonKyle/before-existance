package core;

import java.util.InputMismatchException;
import java.util.Scanner;

// Contains methods for retrieving user input with validation and exception handling
public class Input {
	
	private final Scanner scanner = new Scanner(System.in);
	
	/**
	 * Continually ask the user to input an integer until valid input is given.
	 * 
	 * @param message printed before asking the user for input
	 * @param validInputs contains all acceptable forms of input
	 * @param errorMesssage printed after the user gives invalid input
	 * 
	 * @return input
	 */
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
	
	/**
	 * Continually ask the user to input an integer until valid input is given.
	 * 
	 * @param validInputs contains all acceptable forms of input
	 * @param errorMesssage printed after the user gives invalid input
	 * 
	 * @return input
	 */
	public int requestInt(int[] validInputs, String errorMessage) {
		return requestInt(null, validInputs, errorMessage);
	}
	
	/**
	 * Continually ask the user to input a char until valid input is given.
	 * 
	 * @param message printed before asking the user for input
	 * @param validInputs contains all acceptable forms of input
	 * @param errorMesssage printed after the user gives invalid input
	 * 
	 * @return input
	 */
	public char requestChar(String message, char[] validInputs, String errorMessage) {
	    String input = "";
	    boolean valid = false;
	    while (!valid) {
	        try {
	        	if (message != null) {
	        		System.out.println(message);
	        	}
	        	input = scanner.nextLine();
	        	if (input.length() == 1) {
		        	for (char i : validInputs) {
		        		if (input.charAt(0) == i) {
		        			valid = true;
		        		}
		        	}
	        	}
	        } catch (InputMismatchException e) {
	        	if (errorMessage != null) {
	        		System.out.println(errorMessage);
	        	}
	        	scanner.next();
	        }
	    }
	    return input.charAt(0);
	}
	
	/**
	 * Continually ask the user to input a char until valid input is given.
	 * 
	 * @param validInputs contains all acceptable forms of input
	 * @param errorMesssage printed after the user gives invalid input
	 * 
	 * @return input
	 */
	public char requestChar(char[] validInputs, String errorMessage) {
		return requestChar(null, validInputs, errorMessage);
	}
	
	public void close() {
		scanner.close();
	}
	
	public Scanner getScanner() {
		return scanner;
	}
}