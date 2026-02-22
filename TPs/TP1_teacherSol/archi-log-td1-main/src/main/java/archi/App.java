package archi;

import archi.model.Customers;
import archi.model.Movie;
import archi.model.Rental;
import archi.view.WindowFX;
import javafx.application.Application;

public class App {
    public static void main(String[] args) {
        Customers c = new Customers("Leon");
        Movie oppenheimer = new Movie("Oppenheimer", Movie.CHILDRENS );
        Rental oppenheimerRental = new Rental(oppenheimer, 4);
        c.addRental(oppenheimerRental);
        String expected = c.statement(); 
        System.out.println(expected);
        System.out.println("-------------------");

        Customers barbie = new Customers("Barbie");
        barbie.addRental(new Rental(oppenheimer, 10));
        System.out.println(barbie.statement());

        // launch JavaFX app
        Application.launch(WindowFX.class, args);
    }
}
