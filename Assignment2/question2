// --------------------------------------------------------
// Assignment no 2 q2
// Written by: Nigel Yong Sao Young ; 40089856
// For COMP 248 Section R – Fall 2018
// --------------------------------------------------------

import java.util.Scanner;
public class Question2 {
	public static void main(String[] args) {
		Scanner keyIn = new Scanner(System.in);
		int userInput=0, sum = 0; //declaring integer variable that will store user input and the sum that we will calculate
		String tryAgain; //string that will store whether user wants to try inputing another number

		// welcome message
		System.out.println("-----------------------------------------");
		System.out.println("   Welcome to our Calculation Program!");
		System.out.println("-----------------------------------------");

		// do while loop to ask the user if he/she wants to try again
		do {
			// do while loop to make sure a 7 digit at most is entered 
			do {
				System.out.print("\nEnter a number with at most 7-digits: ");
				userInput = keyIn.nextInt();
			}while(Integer.toString(userInput).length()>7);

			sum=0; // re initialising sum each time a new number is entered
			String strUserInput = Integer.toString(userInput);
			// selecting numbers one after each other to calculate the sum
			for (int i = 0; i <= strUserInput.length()-1; i++) {
				sum = sum + Integer.parseInt(strUserInput.substring(i,i+1));
			}

			// displaying results
			System.out.println("\nSum of the digits of "+userInput+" is: "+sum);
			System.out.println("\nThe divisors of "+sum+" are as follows:");

			for(int j = 1; j <= sum ; j++) {
				if(sum % j == 0)
					System.out.print(j+" "); // displaying the divisors one by one
			}

			// asking the user if he/she wants to try again and store it in tryAgain variable
			System.out.print("\n\nDo you want to try another number? (yes to repeat, no to stop) ");
			tryAgain = keyIn.next();

		}while(tryAgain.equalsIgnoreCase("yes"));

		System.out.println("\nThanks and Have a Great Day!"); // closing message
		
		keyIn.close(); // closing the keyIn variable
	}

}
