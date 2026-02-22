package archi.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String _name;
	private List<Rental> _rentals = new ArrayList<>();
	private int _renterPoints ;
	private double _costOfAllRentals;

	public Customer(String name) {
		_name = name;
		_renterPoints = 0;
	}

	public void addRental(Rental rental) {
		_rentals.add(rental);
	}

	public String getName() {
		return _name;
	}

	public String statement() {
		StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");
		for (Rental r : _rentals) {
			double costOfRentingCurrentMovie = r.getPrice();
			_costOfAllRentals += costOfRentingCurrentMovie;
            // Build the string that contains info of the current rental
			result.append("\t").append(r.getMovie().getTitle()).append("\t").append(String.valueOf(costOfRentingCurrentMovie)).append("\n");
			_renterPoints += r.getRenterPoints();
		}
		result.append("Amount owned is ").append(String.valueOf(_costOfAllRentals)).append("\n");
		result.append("You earned ").append(String.valueOf(_renterPoints)).append(" frequent renter points");
		return result.toString();
	}



}
