package refactored;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RentalTest {

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
            null
        );
        final int days = 16565422;
        final Rental rental = new Rental(movie, days);
        assertEquals(rental.getMovie(), movie);
    }

    @Test
    public void getStringFromMovie(){
        final String title = "chabarbsu aiubzi";
        final Movie movie = new Movie(
            title,
            null
        );
        final int days = 16565422;
        final Rental rental = new Rental(movie, days);
        assertEquals(rental.getMovie().getTitle(), title);
    }

}
