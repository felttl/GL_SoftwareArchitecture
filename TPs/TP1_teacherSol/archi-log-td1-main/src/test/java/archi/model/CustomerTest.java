package archi.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    private Customers c;
    private Movie m;
    private Rental rental;
    @Before
    public void setup(){
        c = new Customers("Leon");
        m = new Movie("Oppenheimer", Movie.CHILDRENS);
        rental = new Rental(m, 4);
    }

    @After
    public void teardown() {
        c = null;
        m = null;
        rental = null;
    }

    @Test
    public void testGetName() {
        assertEquals("Leon", c.getName());
    }

    @Test
    public void testStatement() {
        c.addRental(rental);
        String actual = c.statement();
        String expected = "Rental Record for Leon\n\tOppenheimer\t3.0\nAmount owned is 3.0\nYou earned 1 frequent renter points";
        assertEquals(expected, actual);
    }
}
