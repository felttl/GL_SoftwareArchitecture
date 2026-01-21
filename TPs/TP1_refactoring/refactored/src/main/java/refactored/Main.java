package refactored;

public class Main {
    public static void main(String[] args) {
        var customer = new Customer("Un client");
        customer.addRental(
            new Rental(
                new Movie(
                    "Rogue One",
                MovieState.NEW_RELEASE), 
            5) 
        );
        customer.addRental(
            new Rental(
                new Movie(
                    "Reine des neiges",
                MovieState.CHILDRENS), 
            7) 
        );
        customer.addRental(
            new Rental(
                new Movie(
                    "Star Wars III",
                MovieState.REGULAR), 
            4) 
        );
        System.out.println(customer.statementFR());
    }
}
