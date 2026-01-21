package refactored;

// import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MovieTest {

    @Test
    public void getPriceCodeTest(){
        MovieState tmp = MovieState.NEW_RELEASE;
        Movie movie = new Movie(
            "Rogue One", tmp
        );
        assertEquals(movie.getPriceCode(), tmp);
        tmp = MovieState.CHILDRENS;
        movie = new Movie(
            "Reine des Neiges", tmp
        );
        assertEquals(movie.getPriceCode(), tmp);
        tmp = MovieState.REGULAR;
        movie = new Movie(
            "Le Hobbit", tmp
        );
        assertEquals(movie.getPriceCode(), tmp);
    }
    
    @Test
    public void setPriceCodeTest(){
        MovieState tmp = MovieState.NEW_RELEASE;
        final Movie movie = new Movie(
            "Rogue One", tmp
        );
        tmp = MovieState.REGULAR;
        movie.setPriceCode(tmp);
        assertEquals(movie.getPriceCode(), tmp);
    }

    @Test
    public void getTitleTest(){
        String title = "Reine des Neiges";
        final Movie movie = new Movie(
            title, MovieState.CHILDRENS
        );
        assertEquals(movie.getTitle(), title);
    }


}
