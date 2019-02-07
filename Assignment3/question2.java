// --------------------------------------------------------
// Assignment no3 q2
// Written by: Nigel Yong Sao Young ; 40089856
// For COMP 248 Section R – Fall 2018
// --------------------------------------------------------

// The purpose of this question is to play with accessors, mutators and methods.
public class question2 {
	public static void main(String[] args) {
		House firstHouse = new House();
		House secondHouse = new House(275000);
		House thirdHouse = new House(11, 495000);
		House fourthHouse = new House(14, 230000, "detached");
		
		// Output description of the 4 houses
		System.out.println("House 1: " + firstHouse+".");
		System.out.println("House 2: " + secondHouse+".");
		System.out.println("House 3: " + thirdHouse+".");
		System.out.println("House 4: " + fourthHouse+".");
		
		// Testing accessor methods
		System.out.println("\nAccessor Method: The housetype for house H4 is "
		+fourthHouse.getType()+", its age is "+fourthHouse.getAge()+", and it costs $"+fourthHouse.getCost()+".");
		
		// Testing estimatePrice method on one attached and one detached house
		System.out.println("\nThe estimated price of house H3 is $"+ thirdHouse.estimatePrice()+".");
		System.out.println("The estimated price of house H4 is $"+ fourthHouse.estimatePrice()+".");
		
		// Testing all 5 mutator methods
		System.out.println("\nUsing setAge method");
		System.out.println("Mutator method: The old age for house H3 is "+ thirdHouse.getAge()+".");
		thirdHouse.setAge(21);
		System.out.println("Mutator method: The new age for house H3 is "+ thirdHouse.getAge()+".");
		
		System.out.println("\nUsing setType method");
		System.out.println("Mutator method: The old type for house H3 is "+ thirdHouse.getType()+".");
		thirdHouse.setType("semi-detached");
		System.out.println("Mutator method: The new type for house H3 is "+ thirdHouse.getType()+".");
		
		System.out.println("\nUsing setCost method");
		System.out.println("Mutator method: The old cost for house H3 is $"+ thirdHouse.getCost()+".");
		thirdHouse.setCost(780000);
		System.out.println("Mutator method: The new cost for house H3 is $"+ thirdHouse.getCost()+".");
		
		System.out.println("\nUsing setAll method");
		System.out.println("Mutator method: The old housetype for house H3 is "+thirdHouse.getType()+", its new age is "+thirdHouse.getAge()+" and its" + 
				" cost is $"+thirdHouse.getCost()+".");
		thirdHouse.setAll(31,"detached",345000);
		System.out.println("Mutator method: The new housetype for house H3 is "+thirdHouse.getType()+", its new age is "+thirdHouse.getAge()+" and its" + 
				" cost is $"+thirdHouse.getCost()+".");
		
		System.out.println("\nUsing setAgeAndCost method");
		System.out.println("Mutator Method: The old house H3 age is "+thirdHouse.getAge()+" and its new cost is $"+thirdHouse.getCost()+".");
		thirdHouse.setAgeAndCost(45, 660000);
		System.out.println("Mutator Method: The old house H3 age is "+thirdHouse.getAge()+" and its new cost is $"+thirdHouse.getCost()+".");
		
		// Testing toString method on different house objects
		System.out.println("\ntoString method on house H1: "+ firstHouse+".");
		System.out.println("toString method on house H2: "+ secondHouse+".");
		
		// Testing equals method on different house objects
		System.out.println("\nequals method: Houses H1 and H2 are equal is "+ firstHouse.equals(secondHouse)+".");
		secondHouse.setCost(100000);
		System.out.println("// Cost of house H2 is now changed to $100000 (same as house H1)"+".");
		System.out.println("equals method: Houses H1 and H2 are equal is "+ firstHouse.equals(secondHouse)+".");
		
		// Testing isLessThan and isGreaterThan method.
		System.out.println("\nisLessThan method: House 4 price is less than house 3 is "+ fourthHouse.isLessThan(thirdHouse)+".");
		System.out.println("isGreaterThan method: House 1 price is greater than house 3 is "+ firstHouse.isGreaterThan(thirdHouse)+".");
	}
}
