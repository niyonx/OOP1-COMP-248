// --------------------------------------------------------
// Assignment no 1
// Written by: Nigel Yong Sao Young ; 40089856
// For COMP 248 Section R – Fall 2018
// --------------------------------------------------------

import java.util.*; //importing the scanner library

public class Question2 {
	public static void main(String[] args) {
		//declaring the variables weight, height and bmi in double for them to take decimal values too
		double weight, height, bmi; 
		
		//creating my scanner object
		Scanner keyin = new Scanner(System.in); 
		
		//prompting value weight from user and assigning the value to variable weight
		System.out.println("Enter your weight in kilogram:");
		weight = keyin.nextDouble();
		
		//prompting value height from user and assigning the value to variable height
		System.out.println("Enter your height in metres:");
		height = keyin.nextDouble();
		
		//calculating the bmi
		bmi = weight/(height*height);
		
		//displaying the result with style
		System.out.println("\n************** BMI **************");
		System.out.println("\nYour weight:	"+weight+" kg");
		System.out.println("Your height:	"+height+" m");
		System.out.println("Your BMI is:	"+bmi);
		System.out.println("\n***** You're welcome! :D *****");
		
		//closing the scanner
		keyin.close();
	}
}
