// --------------------------------------------------------
// Assignment no 2 q1
// Written by: Nigel Yong Sao Young ; 40089856
// For COMP 248 Section R – Fall 2018
// --------------------------------------------------------

import java.util.Scanner;
public class Question1 {
	public static void main(String[] args) {
		int choice = 0; // integer variable in which the option of the user will be stored
		double lis_score, spe_score, rea_score, wri_score, ove_score; // variables to store the scores of the user
		double remainder; // variable remainder to help calculate the overall score
		
		// welcome message
		System.out.println("-------****-------****-------****-------****-------****-------");
		System.out.println("     Welcome to Concordia Language Proficiency Evaluator!");
		System.out.println("                     based on IELTS exam");
		System.out.println("-------****-------****-------****-------****-------****-------\n");

		// prompting the user for his option
		System.out.println("Please select one of the following options:");
		System.out.println("1 - Language Proficiency Requirements for the Applicant");
		System.out.println("2 - Evaluation of your English Proficiency\n");

		// declaring object scanner keyIn
		Scanner keyIn = new Scanner(System.in);

		// while loop that will keep on asking the user for an option if it is not 1 or 2
		while (choice <=0 || choice >= 3) {
			System.out.print("Please enter the digit corresponding to your case: ");
			choice = keyIn.nextInt();
			if (choice == 1) {
				System.out.println("\n- The overall score of IELTS exam of applicants needs to be equal or above 6.5 and the scores\r\n" + 
						"for writing and reading skills should not be below 6.0. If your overall score is 6, and your\r\n" + 
						"reading and writing scores are at least 6, you will be eligible for conditional admission. So\r\n" + 
						"you need to take an English course in the first semester. Otherwise, you have to retake the IELTS\r\n" + 
						"exam. Thanks for choosing Concordia.");
			}else if (choice == 2) {
				System.out.print("\nPlease enter your listening score: ");
				lis_score = keyIn.nextDouble();
				System.out.print("\nPlease enter your speaking score: ");
				spe_score = keyIn.nextDouble();
				System.out.print("\nPlease enter your reading score: ");
				rea_score = keyIn.nextDouble();
				System.out.print("\nPlease enter your writing score: ");
				wri_score = keyIn.nextDouble();

				ove_score = (lis_score + spe_score + rea_score + wri_score)/4;
				remainder = ove_score - (int)ove_score;
				
				// calculating the overall score
				if (remainder < 0.25) {
					ove_score = (int)ove_score;
				}else if (remainder>=0.25 && remainder < 0.75) {
					ove_score = (int)ove_score + 0.5;
				}else if (remainder >= 0.75) {
					ove_score = (int)ove_score + 1;
				}

				System.out.println("\n	Your overall score is: " + ove_score);
				System.out.println("	Your reading score is: " + rea_score);
				System.out.println("	Your writing score is: " + wri_score);

				// choosing appropriate messages depending on the scores
				if (ove_score >= 6.5 && rea_score >= 6 && lis_score >= 6) {
					System.out.println("\n	Congratulations: You are eligible for Admission.");
				}else if((ove_score >= 6.5 && (rea_score < 6 || wri_score < 6)) || ove_score == 6 && rea_score >= 6 && wri_score >= 6) {
					System.out.println("\n	You are eligible for Conditional Admission. You will have to take an English course during the first semester.");
				}else if((ove_score == 6 && (rea_score < 6 || wri_score < 6)) || ove_score < 6) {
					System.out.println("\n	Sorry, you have to retake the exam.");
				}

			}else {
				System.out.print("Not a valid choice. ");
			}
		}
		// closing the scanner
		keyIn.close();
	}

}
