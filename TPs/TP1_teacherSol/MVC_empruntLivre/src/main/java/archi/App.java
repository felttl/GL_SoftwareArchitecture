package archi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import archi.model.Customers;
import archi.model.Movie;
import archi.model.Rental;
import archi.model.SuperCustomer;
import archi.view.VCustomer.FXCustomer;
import javafx.application.Application;

/**
 * openjdk 21.0.9 2025-10-21
 * OpenJDK Runtime Environment (build 21.0.9+-14649483-b1163.86)
 * OpenJDK 64-Bit Server VM (build 21.0.9+-14649483-b1163.86, mixed mode)
 */
public class App {
    public static void main(String[] args) {
        Customers c = new Customers("Leon");
        Movie oppenheimer = new Movie("Oppenheimer", Movie.CHILDRENS );
        Rental oppenheimerRental = new Rental(oppenheimer, 4);
        c.addRental(oppenheimerRental);
        c.addRental(new Rental(
            new Movie("Barbie", Movie.CHILDRENS), 
            97
        ));
        c.addRental(new Rental(
            new Movie("Ten Steps", Movie.REGULAR), 
            1
        ));
        c.addRental(new Rental(
            new Movie("Avatar", Movie.NEW_RELEASE), 
            14
        ));
        String expected = c.statement(); 
        System.out.println(expected);
        System.out.println("-------------------");

        Customers barbie = new Customers("Barbie");
        barbie.addRental(new Rental(oppenheimer, 10));
        System.out.println(barbie.statement());

        // need a database here for movies
        // for the exercice : just a short example
        List<Movie> availableMovies = new ArrayList<>(
            Arrays.asList(
                new Movie("Avatar", Movie.NEW_RELEASE),
                new Movie("The Batman", Movie.NEW_RELEASE),
                new Movie("The Flash", Movie.NEW_RELEASE),
                new Movie("The Marvels", Movie.REGULAR),
                new Movie("The Little Mermaid", Movie.CHILDRENS),
                new Movie("The Hunger Games", Movie.REGULAR),
                new Movie("The Lord of the Rings", Movie.REGULAR),
                new Movie("The Matrix", Movie.REGULAR),
                new Movie("The Godfather", Movie.REGULAR),
                new Movie("The Shawshank Redemption", Movie.REGULAR),
                new Movie("The Dark Knight", Movie.REGULAR),
                new Movie("Barbie", Movie.CHILDRENS),
                new Movie("Pulp Fiction", Movie.REGULAR),
                new Movie("The Lord of the Rings: The Return of the King", Movie.REGULAR),
                new Movie("The Lord of the Rings: The Fellowship of the Ring", Movie.REGULAR),
                new Movie("The Lord of the Rings: The Two Towers", Movie.REGULAR),
                new Movie("The Lord of the Rings: The Return of the King", Movie.REGULAR),
                new Movie("Castle in the Sky", Movie.CHILDRENS),
                new Movie("My Neighbor Totoro", Movie.CHILDRENS),
                new Movie("Spirited Away", Movie.REGULAR),
                new Movie("Princess Mononoke", Movie.REGULAR),
                new Movie("Ten Steps", Movie.REGULAR),
                new Movie("Howl's Moving Castle", Movie.REGULAR),
                new Movie("The Wind Rises", Movie.REGULAR),
                new Movie("The Tale of the Princess Kaguya", Movie.REGULAR),
                new Movie("The Secret World of Arrietty", Movie.REGULAR),
                new Movie("The Cat Returns", Movie.REGULAR),
                new Movie("The Red Turtle", Movie.REGULAR),
                new Movie("The Breadwinner", Movie.REGULAR),
                new Movie("The Boy and the Beast", Movie.REGULAR)
            )
        );
        // load customer informations
        FXCustomer.setCustomer(new SuperCustomer(c));
        FXCustomer.setAllAvailableMovies(availableMovies);
        // launch JavaFX app
        Application.launch(FXCustomer.class, args);
    }
}
