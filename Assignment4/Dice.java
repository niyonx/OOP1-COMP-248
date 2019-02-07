// --------------------------------------------------------
// Assignment no4
// Written by: Nigel Yong Sao Young ; 40089856
// For COMP 248 Section R – Fall 2018 with Nancy Acemian
// --------------------------------------------------------

import java.util.Random;

public class Dice {

	private static int die1Val; // stores first die value
	private static int die2Val; // stores second die value
	private static Random rand = new Random(); // variable that will help in throwing the dice

	public Dice() {
		die1Val =0;
		die2Val =0;
	}
	
	public static int getDie1() { // accessor method for die 1
		return die1Val;
	}
	
	public static int getDie2() { // accessor method for die 2
		return die2Val;
	}
	
	public static int rollDice() { // rolls the dice and gets random values for the two dies
		die1Val = rand.nextInt(6)+1;
		die2Val = rand.nextInt(6)+1;
		return (die1Val + die2Val);
	}
	
	public String toString() { // overrides default toString method
		return "Value of first die: "+getDie1()+"\t Value of second die: "+getDie2();
	}


}

