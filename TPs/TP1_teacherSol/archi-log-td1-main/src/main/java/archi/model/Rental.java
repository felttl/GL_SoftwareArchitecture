package archi.model;

public class Rental {
	private Movie _movie;
	private int _daysRented;
	private int _number_of_days_for_eligible_points =1;

	public Rental(Movie movie, int daysRented) {
		_movie = movie.clone();
		_daysRented = daysRented;
	}

	public Movie getMovie() {
		return _movie;
	}

    public double getPrice(){
        return _movie.getRentalCost(_daysRented);
    }

	public int getRenterPoints(){
		return _movie.getFrequentRenterPoints(_daysRented, _number_of_days_for_eligible_points);
	}
}
