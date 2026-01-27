package refactored;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import refactored.Movie;
import refactored.MovieState;
import refactored.Rental;

public class RentalTest {

    final private String title;
    final private Movie movie;
    final private MovieState type;

    public RentalTest(){
        this.title = "Rogue One";
        this.type = MovieState.NEW_RELEASE;
        this.movie = new Movie(
            this.title,this.type
        ); 
    }

    @Test
    public void daysRentedTest(){
        final Movie movie = new Movie(
            "Rogue One",
            MovieState.NEW_RELEASE
        );
        final int days = 5;
        final Rental rental = new Rental(movie, days);
        assertEquals(rental.getDaysRented(), days);
        assertEquals(rental.getMovie(), movie);
    }
    
    @Test
    public void getMovieTest(){
        final Movie movie = new Movie(
            "Reine des neiges",
            MovieState.CHILDRENS
        );
        final int days = 16565422;
        final Rental rental = new Rental(movie, days);
        assertEquals(rental.getMovie(), movie);
    }

    @Test
    public void getMovieNullTest(){
        final Movie movie = new Movie(
            "text",
            MovieState.CHILDRENS
        );
        final int days = 16565422;
        final Rental rental = new Rental(movie, days);
        assertEquals(rental.getMovie(), movie);
    }

    @Test
    public void getStringFromMovieTest(){
        final String title = "chabarbsu aiubzi";
        final Movie movie = new Movie(
            title,
            MovieState.CHILDRENS
        );
        final int days = 16565422;
        final Rental rental = new Rental(movie, days);
        assertEquals(rental.getMovie().getTitle(), title);
    }

    @Test
    public void canEarnExtraPointsTest(){
        final String title = "osef";
        Movie movie = new Movie(title,MovieState.CHILDRENS);
        final int days = 165652;
        final short testNumber = 10;
        final var types = new ArrayList<MovieState>(
            Arrays.asList(
                MovieState.CHILDRENS,
                MovieState.NEW_RELEASE,
                MovieState.REGULAR
            )
        );
        Rental rental;        
        int rdDays;
        MovieState rdType;
        int rdt;
        Random random = ThreadLocalRandom.current();
        boolean cond;
        for (short idx = 0; idx < testNumber; idx++) {
            rdt = random.nextInt(types.size());
            rdType = types.get(rdt);
            rdDays = random.nextInt(100);
            movie = new Movie(title, rdType);
            rental = new Rental(movie, rdDays);
            cond = rdType == MovieState.NEW_RELEASE && rdDays > 1;
            assertEquals(rental.canEarnExtraPoints(), cond); 
        }
    }
    @Test
    public void getPointsAmountTest(){
        final String title = "osef";
        Movie movie = new Movie(title,MovieState.CHILDRENS);
        final short testNumber = 10;
        final var types = new ArrayList<MovieState>(
            Arrays.asList(
                MovieState.CHILDRENS,
                MovieState.NEW_RELEASE,
                MovieState.REGULAR
            )
        );
        Rental rental;
        int rdDays;
        MovieState rdType;
        int rdt;
        Random random = ThreadLocalRandom.current();
        int computedPoints;
        final double junitDelta = 0.0001;
        final double factor = 1.5d;
        for (short idx = 0; idx < testNumber; idx++) {
            rdt = random.nextInt(types.size());
            rdType = types.get(rdt);
            rdDays = (idx+1) % 5;
            if (idx == 5) rdDays = 0;
            movie = new Movie(title, rdType);
            rental = new Rental(movie, rdDays);
            double amount = 0d;
            int daysRented = rental.getDaysRented();
            final var rtPriceCode = rental.getMovie().getPriceCode();
            if (null != rtPriceCode) switch (rtPriceCode) {
                case REGULAR:
                    amount += 2;
                    if(daysRented > 2)
                        amount += daysRented * factor - 3;
                    break;
                case NEW_RELEASE:
                    amount += daysRented * factor * 2;
                    break;
                case CHILDRENS:
                    amount += 1.5;
                    if (daysRented > 3)
                        amount += daysRented * factor - 4.5;
                    break;
                default:
                    break;
            }
            assertEquals(
                rental.getPointsAmount(), 
                amount,
                junitDelta
            );            
        }
    }
    @Test
    public void toStringTest(){
        Random random = ThreadLocalRandom.current();
        final String title = "osef";
        Movie movie = new Movie(title,MovieState.CHILDRENS);
        final int daysRented = random.nextInt(10);
        Rental rental = new Rental(movie, daysRented);

        final String rentalStr = rental.toString();
        final String rentalStrExpected = String.format(
            "%s %s %s %f %s",
            "\t", title,
            "\t", rental.getPointsAmount(), "\n"
        );
        final boolean areEqual = rentalStr.equals(rentalStrExpected);
        if (!areEqual){
            System.out.println("exp: "+rentalStrExpected);
            System.out.println("rea: "+rentalStr);            
        }
        assertEquals(true, areEqual);
    }
    @Test
    public void toStringFRTest(){
        Random random = ThreadLocalRandom.current();
        final String title = "osef";
        Movie movie = new Movie(title,MovieState.CHILDRENS);
        final int daysRented = random.nextInt(10);
        Rental rental = new Rental(movie, daysRented);

        final String pural = daysRented > 1 ? "s" : "";
        final String rentalStr = rental.toStringFR();
        final String rentalStrFRExpected = new StringBuilder()
         .append(" - \"").append(title)
         .append("\" de type ")
         .append(movie.getPriceCode())
         .append(" pendant ").append(daysRented)
         .append(" jour").append(pural)
         .toString();
        final boolean areEqual = rentalStr.equals(rentalStrFRExpected);
        assertEquals(true, areEqual);
    }

    
    @Test
    public void valueTest(){
        System.out.println(this.title);
        System.out.println(this.movie.getTitle());
        assertEquals(this.title, this.movie.getTitle());
    }
}
