import model.Customers;
import model.Movie;
import model.Rental;

public class Main {
    public static void main(String[] args) {
        Customers alice = new Customers("Alice");
        alice.addRental(new Rental(new Movie("Rogue One", Movie.NEW_RELEASE), 5));
        alice.addRental(new Rental(new Movie("Reine des neiges", Movie.CHILDRENS), 7));
        alice.addRental(new Rental(new Movie("Star Wars III", Movie.REGULAR), 4));
        System.out.println(alice.statement());
    }
}
