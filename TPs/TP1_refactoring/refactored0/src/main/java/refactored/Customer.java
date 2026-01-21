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

	public String getName() {
		return this.name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		String result = "Rental Record for " + this.getName() + "\n";
		double amount = 0;
		int index = 0;
		for (; index < this.rentals.size(); index++) {
			Rental current = rentals.get(index);
			amount = current.getPointsAmount();
			if (current.canEarnExtraPoints())
				frequentRenterPoints++;
			result += current.toString();
			totalAmount += amount;			
		}
		result += "Amount owned is " + String.valueOf(totalAmount) +
				"\n";
		result += "You earned " + String.valueOf(-1+index+frequentRenterPoints) +
				" frequent renter points";
		return result;
	}
	/**
	 * permet d'obtenir une description du statement en français
	 * 
	 * (containte du prof d'avoir un affichage spécifique)
	 */
	public String statementFR(){
		String result = String.format(
			"%s a loue des films:\n", 
			this.name
		);
		for (int i = 0; i < this.rentals.size(); i++) {
			Rental current = rentals.get(i);
			result += current.toStringFR();
		}
		return result;
	}
}
