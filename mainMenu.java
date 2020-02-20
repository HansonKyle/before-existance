import java.util.Scanner;

public class mainMenu {
	
	
	public static void main(String[] args) {
		boolean checkStatement = false;
		
		while (checkStatement == false) {
			System.out.println("Welcome to gameTitle");
			System.out.println("Press the following keys in order to take action");
			System.out.println("P: Play");
			System.out.println("I: Instructions");
			System.out.println("Q: Quit");
			
			Scanner keyboard = new Scanner(System.in);
			String selection = keyboard.nextLine();
			char ch = selection.charAt(0);
			
			if (ch == 'P') {
				checkStatement = true;
			}
			else if (ch == 'I') {
				boolean keepInstructions = false;
				while (keepInstructions == false){
					System.out.println("This is a text based game in which the user goes on an adventure. Using the tools and ");
					System.out.println("spells in the users inventory they will face quests and foes that they will have to conquer.");
					System.out.println("B: Back to Main Menu");
					
					Scanner keyboard1 = new Scanner(System.in);
					String back = keyboard1.nextLine();
					char ch1 = back.charAt(0);
					
					if (ch1 == 'B') {
						keepInstructions = true;
					}
					else {
						System.out.println("A compatible key was not entered. Try again.");
					}
				}
			}
			else if (ch == 'Q') {
				System.out.println("Quitting Game Now...");
				System.exit(0);
			}
			else {
				System.out.println("A compatible key was not entered. Try again.");
			}
		}
	}
	
}
