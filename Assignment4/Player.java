// --------------------------------------------------------
// Assignment no4
// Written by: Nigel Yong Sao Young ; 40089856
// For COMP 248 Section R – Fall 2018 with Nancy Acemian
// --------------------------------------------------------

public class Player {
	private String name;
	private Garden garden;

	public Player(String myName, int gardenSize) {
		name = myName;
		if (gardenSize ==3) {
			garden = new Garden();
		}else {
			garden = new Garden(gardenSize);
		}
	}

	// getters and setters 
	public String getName() {
		return name;
	}

	public void setName(String myName) {
		name = myName;
	}

	// returns in how many locations flowers can be planted
	public int howManyFlowersPossible() {
		return garden.countPossibleFlowers();
	}
	
	// returns in how many locations trees can be planted
	public int howManyTreesPossible() {
		return garden.countPossibleTrees();
	}
	
	// returns what is planted at (r,c) location
	public char whatIsPlanted(int r, int c) {
		return garden.getInLocation(r,c);
	}
	
	// plants the tree at location (r,c)
	public void plantTreeInGarden(int r, int c) {
		garden.plantTree(r,c);
	}
	
	// plants the flower at location (r,c)
	public void plantFlowerInGarden(int r, int c) {
		garden.plantFlower(r, c);
	}
	
	// rabbit eats whatever is in location (r,c)
	public void eatHere(int r, int c) {
		garden.removeFlower(r, c);
	}
	
	// returns true if garden is full
	public boolean isGardenFull() {
		return garden.gardenFull();
	}
	
	// displays the playr's garden
	public void showGarden() {
		System.out.println(garden);
	}
}
