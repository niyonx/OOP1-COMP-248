// --------------------------------------------------------
// Assignment no3 q1
// Written by: Nigel Yong Sao Young ; 40089856
// For COMP 248 Section R – Fall 2018
// --------------------------------------------------------

/* This program will stimulate teams playing against each other for a maximum number of 20 tournaments. 
*  We have an array teams16 that stores the teams names. E.g teams16[0] = "Uruguay"
*  We will have an array score of size 16 that will keep the recent scores how many goals each team scored. E.g scores[0] = 4 means that Uruguay scored 4 goals in the recent match
*  We have another array winning that will keep the index of the teams which won. E.g winning[1]= 3 means that teams16[3] (Argentina) won in the second match. winning[11] = 6 means that teams16[6] (Belgium) won in the 12th match.
*  From this, we are able to have a hierarchy of the tournament advancement. (Who will proceed to the next round)
*/

import java.util.Scanner;
import java.util.Random;
public class question1 {
	public static void main(String[] args) {
		Random rand = new Random(); // declaring the random object variable which decide for the scores
		Scanner keyIn = new Scanner(System.in); // declaring the scanner variable  to take input in
		String favTeam; // declaring string variable to store favorite team of user
		double avg=0; // declaring double variable average 
		int count = 0, tourcount = 0, matchcount = 0; // declaring 3 counters: count, tournament count, match count
		boolean teamExists=false, win=false; // declaring two boolean variable to know if favorite team exists and if it won

		// declaring array teams16 storing 16 teams names
		String[] teams16 = {"Uruguay", "Portugal", "France", "Argentina", "Brazil", "Mexico",
				"Belgium", "Japan", "Spain", "Russia", "Croatia", "Denmark", "Sweden", "Switzerland",
				"Colombia", "England"}; 

		// declaring two arrays: one that will keep track of scores by team (each team has takes one index)
		// the other one will store which team goes to the next round (it knows which team from it's index)
		int[] scores = new int[16], winning = new int[16]; 
		
		// declaring 2D array that will score how many goals were scored per matches in each tournament
		int[][] goaltotal = new int[20][16];

		// asking user for his favourite team 
		System.out.print("Enter your favourite team: ");
		favTeam = keyIn.next();
		// checking if favourite team entered by the user exists and plays in the tournament
		do {
			if(favTeam.equals(teams16[count])) {
				teamExists = true;
			}
			count++;
		}while(teamExists == false && count <= teams16.length -1);

		// if team does not exist, program is stopped after a little message
		if (teamExists == false) {
			System.out.println("Your team is not in the Round of 16");
			System.exit(0);
		}

		// while loop that will continue until 20 tournaments are played or until the favourite team won
		while(tourcount < 20 && win==false ) {
			matchcount = 0;
			System.out.println();
			System.out.println("Tournament "+ (tourcount + 1));

			//------------------------------------------------ Round 16 ------------------------------------------------

			// filling up the scores array for each team (each index), min goal 0 - max goal 4
			for (int i= 0; i < teams16.length; i++) {
				scores[i]= rand.nextInt(5); 
			}

			// if two teams playing against each other have a draw, then increment either team to decide the win for all matches
			for (int i = 0; i < teams16.length; i+=2) {
				if (scores[i] == scores[i+1])
					if(rand.nextInt(2)==1)
						scores[i]++;
					else
						scores[i+1]++;
			}

			// displaying the scores of each match of this round
			System.out.print("ROUND OF 16");
			for (int i = 0; i < teams16.length; i+=2) {
				System.out.print(" ["+teams16[i]+" "+scores[i]+" : "+scores[i+1]+" "+teams16[i+1]+"] ");
			}

			// comparing scores of teams playing against each other and storing the winning team's index in the winning array
			for (int i = 0; i < teams16.length; i+=2) {
				if (scores[i]>scores[i+1])
					winning[matchcount]=i;
				else
					winning[matchcount]=i+1;
				goaltotal[tourcount][matchcount]= scores[i] + scores[i+1]; // storing the number of goals scored in each match
				matchcount++; // 8
			}

			//------------------------------------------------ Quarter Finals ------------------------------------------------

			// for all the 8 teams who won in the previous round, decide how many goals the teams will score in their new match
			for(int i = 0; i < 8; i++) {
				scores[winning[i]]= rand.nextInt(5);
			}

			// if the teams playing against each other have a draw (90 min), sudden death as one of the teams score one more goal
			for(int i = 0; i < 8; i+=2) {
				if (scores[winning[i]]==scores[winning[i+1]]) {
					if(rand.nextInt(2)==1)
						scores[winning[i]]++;
					else
						scores[winning[i+1]]++;
				}
			}

			// displaying the results of the quarter finals round
			System.out.print("\nQUARTER-FINALS");
			for (int i = 0; i < matchcount; i+=2) {
				System.out.print(" ["+teams16[winning[i]]+" "+scores[winning[i]]+" : "+scores[winning[i+1]]+" "+teams16[winning[i+1]]+"] ");
			}
			
			// deciding who won in this round and storing the team's index in array winning
			for (int i = 0; i < 8; i+=2) {
				if (scores[winning[i]]>scores[winning[i+1]])
					winning[matchcount]=winning[i];
				else
					winning[matchcount]=winning[i+1]; 
				goaltotal[tourcount][matchcount]= scores[winning[i]] + scores[winning[i+1]];  // storing the number of goals scored in each match
				matchcount++; // 12
			}

			//------------------------------------------------ Semi Finals ------------------------------------------------

			// for all teams who won in the quarter finals (winning[8]- winning[11]), decide how many goals they scores in the semi finals
			for(int i = 8 ; i < 12; i++) {
				scores[winning[i]]= rand.nextInt(5);
			}

			// if the teams playing against each other have a draw, sudden death as one of the teams scores
			for(int i = 8; i < 12; i+=2) {
				if (scores[winning[i]]==scores[winning[i+1]]) {
					if(rand.nextInt(2)==1)
						scores[winning[i]]++;
					else
						scores[winning[i+1]]++;
				}
			}

			// displaying the results of this round
			System.out.print("\nSEMI-FINALS");
			for (int i = 8; i < 12; i+=2) {
				System.out.print(" ["+teams16[winning[i]]+" "+scores[winning[i]]+" : "+scores[winning[i+1]]+" "+teams16[winning[i+1]]+"] ");
			}

			// storing the two winning teams in the winning[] array
			for (int i = 8; i < 12; i+=2) {
				if (scores[winning[i]]>scores[winning[i+1]])
					winning[matchcount]=winning[i];
				else
					winning[matchcount]=winning[i+1];
				goaltotal[tourcount][matchcount]= scores[winning[i]] + scores[winning[i+1]];  // storing the number of goals scored in each match
				matchcount++; // 13
			}

			//------------------------------------------------ Final ------------------------------------------------

			// deciding what is the score of the final game
			for(int i = 12 ; i < 14; i++) {
				scores[winning[i]]= rand.nextInt(5);
			}

			// if there is a draw at the end of the 90 min, sudden death that will decide who won
			for(int i = 12; i < 14; i+=2) {
				if (scores[winning[i]]==scores[winning[i+1]]) {
					if(rand.nextInt(2)==1)
						scores[winning[i]]++;
					else
						scores[winning[i+1]]++;
				}
			}

			// displaying the results of the final round
			System.out.print("\nFINAL");
			for (int i = 12; i < matchcount; i+=2) {
				System.out.print(" ["+teams16[winning[i]]+" "+scores[winning[i]]+" : "+scores[winning[i+1]]+" "+teams16[winning[i+1]]+"] ");
			}

			// decide who won the final
			for (int i = 12; i < matchcount; i+=2) {
				if (scores[winning[i]]>scores[winning[i+1]])
					winning[matchcount]=winning[i];
				else
					winning[matchcount]=winning[i+1];
				goaltotal[tourcount][matchcount]= scores[winning[i]] + scores[winning[i+1]]; // storing the number of goals scored in each match
				matchcount++; // 14
			}

			// message to let user know who the winner is
			System.out.println();
			System.out.println("The WINNER is: " + teams16[winning[14]]+"!");

			// message displaying how many tournaments it took for the favourite team to win
			if (teams16[winning[14]].equals(favTeam)) {
				win = true;
				if (tourcount ==0)
					System.out.println("\nIt took only "+(tourcount+1)+" tournament for "+favTeam+" to win!!! :D");
				else
					System.out.println("\nIt took "+(tourcount+1)+" tournaments of the game for "+favTeam+" to win!!! :D");
			}
			
			// incrementing tournament count
			tourcount++;
		}

		// declaring an array for the tournament goal average
		double[] tourAvg= new double[tourcount];
		
		// if user did not win at all in the 20 tournaments, a message is displayed
		if (win == false)
			System.out.println("\nSorry, "+favTeam+ " did not win in 20 tournaments! :(");

		System.out.println("\n----------------------------------------- GOAL STATS -----------------------------------------\n");

		// displaying the number of goals scored in each match of each tournament and 
		// then calculating the average number of goals scored to display
		for(int i = 0 ; i < tourcount; i++) {
			avg = 0;
			System.out.print("[Tournament "+ (i+1) +"]\tTotal goals: ["+ goaltotal[i][0]);
			avg += goaltotal[i][0];
			for(int j=1; j < 15; j++) {
				System.out.print(", "+ goaltotal[i][j]);
				avg += goaltotal[i][j];
			}
			avg = avg /15;
			tourAvg[i]=avg;

			System.out.println("]\t[Average: "+rounding(avg,1)+"]");
		}
		
		// calculating and displaying the average number of goals scored in all the tournaments
		avg = 0;
		for(int i = 0 ; i < tourcount; i++) {
			avg += tourAvg[i];
		}
		avg = avg / (tourcount);
		System.out.println("\nAverage goals for "+tourcount+" tournament(s): "+rounding(avg,1));

		// calculating and displaying the number of matches greater than the average goal value
		count=0;
		for (int i = 0; i < tourcount; i++) {
			for(int j=0; j < 15; j++) {
				if (goaltotal[i][j]>avg)
					count++;
			}
		}
		System.out.println("Total matches in all tournaments over the average goal value: "+ count);
		keyIn.close();
	}

	// method to round off the average number of goals in the tournaments
	private static double rounding (double value, int precision) {
		int scale = (int) Math.pow(10, precision);
		return (double) Math.round(value * scale) / scale;
	}
}
