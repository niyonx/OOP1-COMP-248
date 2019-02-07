// --------------------------------------------------------
// Assignment no3 q2
// Written by: Nigel Yong Sao Young ; 40089856
// For COMP 248 Section R – Fall 2018
// --------------------------------------------------------

public class House {
	private int age;
	private String type;
	private double cost;

	// 1st constructor
	public House() {
		age = 50;
		type = "attached";
		cost = 100000;
	}

	// 2nd constructor
	public House(double newCost) {
		age = 50;
		type = "attached";
		cost = newCost;
	}
	
	// 3rd constructor
	public House(int newAge, double newCost) {
		age = newAge;
		type = "attached";
		cost = newCost;
	}

	// 4th constructor
	public House(int newAge, double newCost, String newType) {
		age = newAge;
		type = newType;
		cost = newCost;
	}

	// Accessor method for each attributes
	
	public int getAge() {
		return age;
	}

	public String getType() {
		return type;
	}

	public double getCost() {
		return cost;
	}
	
	// Mutator method for each attributes

	public void setAge(int newAge) {
		age= newAge;
	}

	public void setType(String newType) {
		type = newType;
	}

	public void setCost(double newCost) {
		cost= newCost;
	}
	
	public void setAll(int newAge, String newType, double newCost) {
		age= newAge;
		type = newType;
		cost= newCost;
	}

	public void setAgeAndCost(int newAge, double newCost) {
		age= newAge;
		cost= newCost;
	}

	// It will estimate the price of the house according to the type and it's age and irrespective of its cost
	public double estimatePrice() {
		if (type.equals("attached")) {
			if (age <=5) {
				return Math.round(100000*Math.pow(1.01,age));
			}else
				return Math.round(100000*Math.pow(1.01, 5)*Math.pow(1.02, age-5));
		}else if(type.equals("semi-attached")) {
			if (age <=5) {
				return Math.round(150000*Math.pow(1.02,age));
			}else
				return Math.round(150000*Math.pow(1.02, 5)*Math.pow(1.03, age-5));
		}else if(type.equals("detached")) {
			return Math.round(200000*Math.pow(1.02,age));
		}else
			return 0;
	}

	// overriding default toString method
	public String toString() {
		return "This house is type "+type+". Its age is "+age+" and costs $"+cost;
	}

	// overriding default equals method, comparing value of two objects' attributes
	public boolean equals(House anotherHouse) {
		return this.age==anotherHouse.age && this.type == anotherHouse.type && this.cost == anotherHouse.cost;
	}

	// comparing cost of each house and returns true if the house's cost is less than the other house's cost
	public boolean isLessThan(House anotherHouse) {
		return this.getCost() < anotherHouse.getCost();
		// return this.estimatePrice() < anotherHouse.estimatePrice(); // from my understanding of question 2, I used .getCost rather than .estimatePrice to compare the houses
	}

	// comparing cost of each house and returns true if the house's cost is greater than the other house's cost
	public boolean isGreaterThan(House anotherHouse) {
		return this.getCost() > anotherHouse.getCost();
		// return this.estimatePrice() > anotherHouse.estimatePrice(); // from my understanding of question 2, I used .getCost rather than .estimatePrice to compare the houses
	}
}
