package archi.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {
    private Movie m;
    @Before
    public void setup(){
        m = new Movie("star wars", Movie.CHILDRENS);
    }
    @Test
    public void testGetPriceCode() {
        assertEquals(Movie.CHILDRENS, m.getPriceCode());
    }

    @Test
    public void testGetTitle() {
        assertEquals("star wars", m.getTitle());
    }

    @Test
    public void testSetPriceCode() {
        m.setPriceCode(Movie.CHILDRENS);
        assertEquals(Movie.CHILDRENS, m.getPriceCode());

    }
}
