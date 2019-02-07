// --------------------------------------------------------
// Assignment no4
// Written by: Nigel Yong Sao Young ; 40089856
// For COMP 248 Section R – Fall 2018 with Nancy Acemian
// --------------------------------------------------------

public class Garden {
	private char[][] garden;

	// constructor with default size 3
	public Garden() {
		garden = new char[3][3];
		initializeGarden();
	}

	// constructor with size
	public Garden(int size) {
		garden = new char[size][size];
		initializeGarden();
	}

	// fills up the garden with empty places (-)
	private void initializeGarden() {
		for(int i=0; i < garden.length; i++ ) {
			for(int j=0; j < garden.length; j++) {
				garden[i][j]='-';
			}
		}
	}

	// returns what is in location (r,c)
	public char getInLocation(int r,int c) {
		return garden[r][c];
	}

	// plants flower in location (r,c)
	public void plantFlower(int r,int c) {
		garden[r][c]='f';
	}

	// plants tree in location (r,c)
	public void plantTree(int r,int c) {
		garden[r][c]=garden[r+1][c]=garden[r][c+1]=garden[r+1][c+1]='t';
	}

	// removes flower/tree from location (r,c)
	public void removeFlower(int r, int c) {
		garden[r][c]='-';
	}

	// counts how many locations trees can be planted
	public int countPossibleTrees() {
		int count =0;
		for(int i=0; i < garden.length-1; i++) {
			for(int j=0; j < garden.length -1; j++) {
				if(garden[i][j]=='-' && garden[i][j+1] =='-' && garden[i+1][j]=='-'&& garden[i+1][j+1]=='-') {
					count++;
				}
			}
		}
		return count;
	}

	// counts how many locations flowers can be planted
	public int countPossibleFlowers() {
		int count = 0;
		for(int i = 0; i < garden.length; i++) {
			for(int j=0; j < garden.length; j++) {
				if(garden[i][j]=='-') {
					count++;
				}
			}
		}
		return count;
	}

	// checks if garden is full
	public boolean gardenFull() {
		if(this.countPossibleFlowers()==0) {
			return true;
		}
		return false;
	}

	// toString method 
	public String toString() {
		String myGarden="\n  | ";
		for(int i=0; i < garden.length; i++) {
			myGarden+=i+" ";
		}
		myGarden+="\n";
		for(int i = 0; i < garden.length; i++) {
			myGarden+=i+" | ";
			for(int j=0; j < garden.length; j++) {
				myGarden+=garden[i][j]+" ";
			}
			myGarden+="\n";
		}
		return myGarden;
	}
}
