// --------------------------------------------------------
// Assignment no4
// Written by: Nigel Yong Sao Young ; 40089856
// For COMP 248 Section R – Fall 2018 with Nancy Acemian
// --------------------------------------------------------

// purpose: We are coding a little game in which every player has to roll a dice, with each dice values having different outcomes
// on the players' garden. The player who fills up his garden first wins!

import java.util.Random;
import java.util.Scanner;
public class LetsPlay {
	public static int r, c;
	public static Scanner keyIn = new Scanner(System.in);
	
	public static void main(String[] args) {
		Random rand = new Random();
		int size, noGardeners, diceValue, maxDice = 0, repeatedBy=0, roundCount=0, count =0, diceVal, winner=0;
		boolean repeatDice, win = false;

		// Welcome banner message
		System.out.println("-------****-------****-------****-------****-------****-------");
		System.out.println("            Welcome to Crazy Nancy's Garden Game!");
		System.out.println("-------****-------****-------****-------****-------****-------");

		// General rules of the game
		System.out.println("\nTo win this game you need some luck with the dice and a bit of strategy.\r\n" + 
				"Your garden is an NxN lot. You can plant flowers or trees. A flower takes one spot. A tree takes 4 spots (2x2).\r\n" + 
				"You roll the dice and based on the outcome you get to plant a pre-set number of trees and flowers.\r\n" + 
				"\nRolls and their outcome:\r\n" + 
				"---------------------\r\n" + 
				"3: plan a tree (2x2) and a flower (1x1)\r\n" + 
				"6: plant 2 flowers (2 times 1x1)\r\n" + 
				"12: plant 2 trees (2 times 2x2)\r\n" + 
				"5 or 10: the rabbit will eat something that you have planted - might be a flower or part of a tree(1x1)\r\n" + 
				"Any other EVEN rolls: plant a tree (2x2)\r\n" + 
				"Any other ODD rolls: plant a flower (1x1)\r\n" + 
				"\nMinimum number of players: 2.\r\n" + 
				"Minimum garden size: 3x3.\r\n" + 
				"You can only plant in empty locations. To plant a tree you give the top left coordinates of the 2x2 space\r\n" + 
				"and I will check to make sure all 4 locations are free.\r\n" + 
				"\nOkay... Let's start the game! May the best gardener win!!!");

		System.out.println("The default garden size is a 4x4 square. You can use this default board size or change the size");

		// ask user size of board
		System.out.print("Enter 0 to use the default garden size or -1 to enter your own size: ");
		size = keyIn.nextInt();
		while(size!=0 && size!=-1) {
			System.out.print("Sorry but "+size+" is not a legal size. Enter your size: ");
			size = keyIn.nextInt();
		}

		if (size == -1) {
			System.out.print("What size board would you like (minimum size 3)? ");
			size = keyIn.nextInt();

			while(size<3) {
				System.out.println("Sorry but this board size is not possible. What size board would you like? (minimum 3) ");
				size = keyIn.nextInt();
			}
		}else {
			size = 3;
		}
		// ask user for number of players
		System.out.print("How many gardeners will there be (minimum 2 required to play, max allowed 10)? ");
		noGardeners = keyIn.nextInt();

		while(noGardeners < 2 || noGardeners > 10) {
			System.out.print("Sorry but this number of gardeners is not possible. How many gardeners will there be (minimum 2 required to play, max allowed 10)? ");
			noGardeners = keyIn.nextInt();
		}

		System.out.println("\nGreat, "+noGardeners+" players it will be!");

		// creating player array
		Player[] players = new Player[noGardeners];

		for(int i = 0; i < noGardeners; i++) {
			// asking for player's name
			System.out.print("--> Name of player "+(i+1)+" (no spaces allowed): ");
			players[i] = new Player(keyIn.next(),size);
		}

		// rolling dice to see who goes first
		System.out.println("\nLet's see who goes first...\n");
		int[] playersDice= new int[noGardeners];
		int[] startingOrder= new int[noGardeners];
		do {
			for (int i =0; i < noGardeners; i++) { // array in which values rolled by players is initialised
				playersDice[i]=0;
			}
			repeatDice = false;
			diceValue= Dice.rollDice();
			playersDice[0]=maxDice=diceValue; // dice roll value is stored into array playersDice so that it can be compared to new values
			System.out.println(players[0].getName()+" rolled a "+diceValue);
			for(int i = 1; i < noGardeners; i++) {
				diceValue= Dice.rollDice();
				System.out.println(players[i].getName()+" rolled a "+diceValue);
				if(diceValue>maxDice) { // maximum dice value and the player who threw it are recorded
					maxDice = diceValue;
					startingOrder[0]= i;
				}
				for(int j =0; j < noGardeners; j++) { // for every new total of dice roll, previous dice rolls are compared
					if(playersDice[j]==diceValue) {
						repeatDice = true; // repeatDice is set to true once dice value was already rolled by a player before
						repeatedBy = j; 
					}
				}
				if(repeatDice) { // message if ever two players have the same dice roll totals before repeating the whole process
					System.out.println("We will start over as "+diceValue+" was rolled by "+players[repeatedBy].getName()+" as well.\n");
					break;
				}
				playersDice[i]=diceValue; // dice roll value is stored into array playersDice so that it can be compared to new values
			}
		}while(repeatDice);

		// from the first player, other players goes after in the order the player names were entered
		for(int i = startingOrder[0]; i < noGardeners-1;i++) {
			startingOrder[count+1]=startingOrder[0]+i;
			count++;
		}

		for(int i = 0; i < startingOrder[0]; i++) {
			startingOrder[count+1]= i;
			count++;
		}

		// different message depending on the number of players
		if(noGardeners==2) {
			System.out.println("\n"+players[startingOrder[0]].getName()+" goes first, followed by "+players[startingOrder[1]].getName()+".\n");
		}else {
			System.out.print("\n"+players[startingOrder[0]].getName()+" goes first, followed by "+players[startingOrder[1]].getName());
			for(int i = 2; i < noGardeners -1 ; i++) {
				System.out.print(", "+players[startingOrder[i]].getName());
			}

			System.out.println(" and "+ players[startingOrder[noGardeners -1]].getName()+".\n");
		}


		System.out.println("-----------------------------------------------------------------------");
		System.out.println("                            Time to play!!!");
		System.out.println("-----------------------------------------------------------------------");

		while(win == false) { // continue the game until someone won
			for(int i=0; i< noGardeners; i++) {
				roundCount++;
				diceVal= Dice.rollDice();
				System.out.println("\nRound "+roundCount+": "+players[startingOrder[i]].getName()+" you rolled a "+diceVal+" (Die 1: "+Dice.getDie1()+" Die 2: "+Dice.getDie2()+")");
				switch(diceVal) {
				case 2: case 4: case 8: // plants a tree
					System.out.println("You must plant a tree (2x2)");
					players[startingOrder[i]].showGarden();
					System.out.println("You have "+players[startingOrder[i]].howManyTreesPossible()+" places to do this.");
					if(players[startingOrder[i]].howManyTreesPossible()!=0) {
						askCoordinates();

						while(!(r<size-1 && c<size-1) || players[startingOrder[i]].whatIsPlanted(r, c)!='-' ||
								players[startingOrder[i]].whatIsPlanted(r+1, c)!='-' ||
								players[startingOrder[i]].whatIsPlanted(r, c+1)!='-' ||
								players[startingOrder[i]].whatIsPlanted(r+1, c+1)!='-') {
							System.out.println("** Sorry either the row or column is not in the range of 0 to "+(size-1)+" or your tree will be off the grid. Enter the coordinates as row column again: ");
							r = keyIn.nextInt();
							c = keyIn.nextInt();
						}					
						players[startingOrder[i]].plantTreeInGarden(r, c);
					}else {
						System.out.println("** Sorry no room left to plant a tree - You miss a turn.");
					}
					break;
				case 7: case 9: case 11: // plants a flower
					System.out.println("You must plant a flower (1x1)");
					players[startingOrder[i]].showGarden();
					System.out.println("You have "+players[startingOrder[i]].howManyFlowersPossible()+" places to do this.");
					if(players[startingOrder[i]].howManyFlowersPossible()!=0) {
						askCoordinates();

						while(!(r<size && c<size) || players[startingOrder[i]].whatIsPlanted(r, c)!='-') {
							System.out.println("** Sorry either the row or column is not in the range of 0 to "+(size-1)+" or your flower will be off the grid. Enter the coordinates as row column again: ");
							r = keyIn.nextInt();
							c = keyIn.nextInt();
						}					
						players[startingOrder[i]].plantFlowerInGarden(r, c);
					}else {
						System.out.println("** Sorry no room left to plant a flower - You miss a turn.");
					}

					break;
				case 3: // plants a tree and a flower
					System.out.println("You must plant a tree (2x2) and a flower (1x1)");
					players[startingOrder[i]].showGarden();
					System.out.println("Let's start with the tree. You have "+players[startingOrder[i]].howManyTreesPossible()+" places to do this.");
					if(players[startingOrder[i]].howManyTreesPossible()!=0) {
						askCoordinates();

						while(!(r<size-1 && c<size-1) || players[startingOrder[i]].whatIsPlanted(r, c)!='-' ||
								players[startingOrder[i]].whatIsPlanted(r+1, c)!='-' ||
								players[startingOrder[i]].whatIsPlanted(r, c+1)!='-' ||
								players[startingOrder[i]].whatIsPlanted(r+1, c+1)!='-') { // checking desired location for tree
							System.out.println("** Sorry either the row or column is not in the range of 0 to "+(size-1)+" or your tree will be off the grid. Enter the coordinates as row column again: ");
							r = keyIn.nextInt();
							c = keyIn.nextInt();
						}					
						players[startingOrder[i]].plantTreeInGarden(r, c);
					}else {
						System.out.println("** Sorry no room left to plant a tree - You miss a turn.");
					}

					System.out.println("You still have a flower (1x1) flower to plant.");
					players[startingOrder[i]].showGarden();
					System.out.println("You have "+players[startingOrder[i]].howManyFlowersPossible()+" places to do this.");
					if(players[startingOrder[i]].howManyFlowersPossible()!=0) {
						askCoordinates();

						while(!(r<size && c<size) || players[startingOrder[i]].whatIsPlanted(r, c)!='-') { // checking desired location for flower
							System.out.println("** Sorry either the row or column is not in the range of 0 to "+(size-1)+" or your flower will be off the grid. Enter the coordinates as row column again: ");
							r = keyIn.nextInt();
							c = keyIn.nextInt();
						}					
						players[startingOrder[i]].plantFlowerInGarden(r, c);
					}else {
						System.out.println("** Sorry no room left to plant a flower - You miss a turn.");
					}
					break;
				case 6: // plants two flowers
					System.out.println("You must plant 2 flowers (1x1)");
					players[startingOrder[i]].showGarden();
					System.out.println("You have "+players[startingOrder[i]].howManyFlowersPossible()+" places to do this.");
					if(players[startingOrder[i]].howManyFlowersPossible()>=2){ // if both flowers can be planted
						askCoordinates();

						while(!(r<size && c<size) || players[startingOrder[i]].whatIsPlanted(r, c)!='-') {
							System.out.println("** Sorry either the row or column is not in the range of 0 to "+(size-1)+" or your flower will be off the grid. Enter the coordinates as row column again: ");
							r = keyIn.nextInt();
							c = keyIn.nextInt();
						}					
						players[startingOrder[i]].plantFlowerInGarden(r, c);

						System.out.println("You must plant a flower (1x1)");
						players[startingOrder[i]].showGarden();
						System.out.println("You have "+players[startingOrder[i]].howManyFlowersPossible()+" places to do this.");
						askCoordinates();

						while(!(r<size && c<size) || players[startingOrder[i]].whatIsPlanted(r, c)!='-') {
							System.out.println("** Sorry either the row or column is not in the range of 0 to "+(size-1)+" or your flower will be off the grid. Enter the coordinates as row column again: ");
							r = keyIn.nextInt();
							c = keyIn.nextInt();
						}					
						players[startingOrder[i]].plantFlowerInGarden(r, c);
					}else if(players[startingOrder[i]].howManyFlowersPossible()==1) { // if only one of the flowers can be planted
						System.out.print("There is enough room for 1 flower only in your garden. Enter the coordinates as row column: "); // can do a function
						r = keyIn.nextInt();
						c = keyIn.nextInt();

						while(!(r<size && c<size) || players[startingOrder[i]].whatIsPlanted(r, c)!='-') {
							System.out.println("** Sorry either the row or column is not in the range of 0 to "+(size-1)+" or your flower will be off the grid. Enter the coordinates as row column again: ");
							r = keyIn.nextInt();
							c = keyIn.nextInt();
						}					
						players[startingOrder[i]].plantFlowerInGarden(r, c);
					}else if(players[startingOrder[i]].howManyFlowersPossible()==0) { // if only one tree can be planted
						System.out.println("** Sorry no room left to plant any flowers - You miss a turn.");
					}

					break;
				case 12: // plants 2 trees
					if(players[startingOrder[i]].howManyTreesPossible()>=2){ // if both trees can be planted
						System.out.println("You must plant 2 trees (2x2)");
						players[startingOrder[i]].showGarden();
						System.out.println("You have "+players[startingOrder[i]].howManyTreesPossible()+" places to do this.");
						askCoordinates();

						while(!(r<size-1 && c<size-1) || players[startingOrder[i]].whatIsPlanted(r, c)!='-' ||
								players[startingOrder[i]].whatIsPlanted(r+1, c)!='-' ||
								players[startingOrder[i]].whatIsPlanted(r, c+1)!='-' ||
								players[startingOrder[i]].whatIsPlanted(r+1, c+1)!='-') { // checking desired location
							System.out.println("** Sorry either the row or column is not in the range of 0 to "+(size-1)+" or your tree will be off the grid. Enter the coordinates as row column again: ");
							r = keyIn.nextInt();
							c = keyIn.nextInt();
						}					
						players[startingOrder[i]].plantTreeInGarden(r, c);

						players[startingOrder[i]].showGarden();
						System.out.println("You have "+players[startingOrder[i]].howManyTreesPossible()+" places to do this.");
						askCoordinates();

						while(!(r<size-1 && c<size-1) || players[startingOrder[i]].whatIsPlanted(r, c)!='-' ||
								players[startingOrder[i]].whatIsPlanted(r+1, c)!='-' ||
								players[startingOrder[i]].whatIsPlanted(r, c+1)!='-' ||
								players[startingOrder[i]].whatIsPlanted(r+1, c+1)!='-') { // checking desired location
							System.out.println("** Sorry either the row or column is not in the range of 0 to "+(size-1)+" or your tree will be off the grid. Enter the coordinates as row column again: ");
							r = keyIn.nextInt();
							c = keyIn.nextInt();
						}					
						players[startingOrder[i]].plantTreeInGarden(r, c);
					}else if(players[startingOrder[i]].howManyTreesPossible()==1) { // if only one tree can be planted
						System.out.print("There is enough room for 1 flower only in your garden. Enter the coordinates as row column: "); // can do a function
						r = keyIn.nextInt();
						c = keyIn.nextInt();

						while(!(r<size-1 && c<size-1) || players[startingOrder[i]].whatIsPlanted(r, c)!='-' ||
								players[startingOrder[i]].whatIsPlanted(r+1, c)!='-' ||
								players[startingOrder[i]].whatIsPlanted(r, c+1)!='-' ||
								players[startingOrder[i]].whatIsPlanted(r+1, c+1)!='-') { // checking desired location
							System.out.println("** Sorry either the row or column is not in the range of 0 to "+(size-1)+" or your tree will be off the grid. Enter the coordinates as row column again: ");
							r = keyIn.nextInt();
							c = keyIn.nextInt();
						}					
						players[startingOrder[i]].plantTreeInGarden(r, c);
					}else if(players[startingOrder[i]].howManyTreesPossible()==0) { // if none of the two trees can be planted
						System.out.println("** Sorry no room left to plant any trees - You miss a turn.");
					}

					break;
				case 5: case 10: // rabbit eats
					players[startingOrder[i]].showGarden();
					if(players[startingOrder[i]].howManyFlowersPossible()==9) { // if rabbit has nothing to eat
						System.out.println("The rabbit could not eat anything since your garden is empty.");
					}else {
						do { // rabbit eats randomly
							r = rand.nextInt(size);
							c = rand.nextInt(size);
						}while(players[startingOrder[i]].whatIsPlanted(r, c)=='-');
						players[startingOrder[i]].eatHere(r, c);
						System.out.println("The rabbit ate whatever was in the location ("+r+","+c+")");
						players[startingOrder[i]].showGarden();
					}
					break;
				}
				// detects who wins
				if(players[startingOrder[i]].isGardenFull()) { // checks after each round if someone's garden is full
					win = players[startingOrder[i]].isGardenFull(); // returns true to win variable
					winner = startingOrder[i]; // stores who is the winner
					break; // gets out of for loop.
				}
			}
		}	
		
		// Display results
		System.out.println("\n-----------------------------------------------------------------------");
		System.out.println("                            FINAL RESULTS!!!");
		System.out.println("-----------------------------------------------------------------------\n");

		System.out.println("Here are the gardens after "+roundCount+" rounds.");

		for(int i=0; i< noGardeners; i++) {
			System.out.println(players[startingOrder[i]].getName()+"'s garden");
			players[startingOrder[i]].showGarden();
			System.out.println();
		}

		System.out.println("And the winner is... "+ players[winner].getName()+"!!!");
		System.out.println("What a beautiful garden you have.\n");

		System.out.println("Hope you had fun! :D");
	}
	
	// asks for initial desired location
	public static void askCoordinates() {
		System.out.print("Enter the coordinates as row column: "); 
		r = keyIn.nextInt();
		c = keyIn.nextInt();
	}
}
