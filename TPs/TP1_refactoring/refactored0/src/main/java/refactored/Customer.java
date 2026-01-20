package refactored;

import java.util.ArrayList;
import java.util.Enumeration;

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
			amount = this.getAmount(current);
			if ((current.getMovie().getPriceCode() == MovieState.NEW_RELEASE)
			 && (current.getDaysRented() > 1))
				frequentRenterPoints++;
			result += this.stringyfy(current, amount);
			totalAmount += amount;			
		}
		result += "Amount owned is " + String.valueOf(totalAmount) +
				"\n";
		result += "You earned " + String.valueOf(-1+index+frequentRenterPoints) +
				" frequent renter points";
		return result;
	}
	private String stringyfy(Rental rental, double amount){
		return "\t" + rental.getMovie().getTitle() + "\t" +
					String.valueOf(amount) + " \n";
	}
	private double getAmount(Rental each){
		double amount = 0f;
		var type = each.getMovie().getPriceCode();
		final double valueFactor = 1.5d;
		if (type == MovieState.REGULAR){
			amount += 2;
			if (each.getDaysRented() > 2) {
				amount += each.getDaysRented() * valueFactor - 3;
			}
		} else if (type == MovieState.NEW_RELEASE){
			amount += each.getDaysRented() * valueFactor * 2;
		} else if (type == MovieState.CHILDRENS){
			amount += 1.5;
			if (each.getDaysRented() > 3)
				amount += each.getDaysRented() * valueFactor - 4.5;
		}
		return amount;
	}
}
