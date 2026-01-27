package refactored;

import java.util.ArrayList;

public class Customer {
	private String name;
	private ArrayList<Rental> rentals = new ArrayList<>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental rental) {
		this.rentals.add(rental);
	}

	public Rental getRental(int i){
		return this.rentals.get(i);		
	}
	
	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		StringBuilder result = new StringBuilder(
			String.format(
				"Rental Record for %s\n",
				this.getName()
			)
		);
		int index = 0;
		for (; index < this.rentals.size(); index++) {
			Rental current = rentals.get(index);
			if (current.canEarnExtraPoints())
				frequentRenterPoints++;
			result.append(current.toString());
			totalAmount += current.getPointsAmount();
		}
		result.append(
			String.format(
				"Amount owned is %f\n", 
				totalAmount
			)
		);
		// 2 ways of seeing things : 
		// 1 : use only append() on the stringBuilder (difficul to see String final rendering)
		// 2 : use String.format() to see in a better way, string organization
		result.append(
			String.format(
				"You earned %d \" frequent renter points\"", 
				-1+index+frequentRenterPoints
			)
		);
		return result.toString();
	}
	/**
	 * permet d'obtenir une description du statement en français
	 * 
	 * (containte du prof d'avoir un affichage spécifique)
	 */
	public String statementFR(){
		StringBuilder result = new StringBuilder(String.format(
			"%s a loue des films:\n", 
			this.name
		));
		final int leng = this.rentals.size();
		Rental current;
		for (int i = 0; i < leng; i++) {
			current = rentals.get(i);
			result.append(current.toStringFR())
			 .append(leng > 0 && i != leng-1 ? "," : ".")	
			 .append("\n");
		}
		return result.toString();
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}

}
