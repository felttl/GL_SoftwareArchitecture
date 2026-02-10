package model;

import org.junit.Test;

import junit.framework.TestCase;

public class TestsNonRegression extends TestCase {
    static private int IDS_CPT = 0;
    private int _id;
    public TestsNonRegression(){
        this._id = IDS_CPT++;
        System.out.println("Constructor "+this._id+": I am instanced once per test function (below) before everyone else runs!");
    }
    
    @Override
    protected void setUp() throws Exception {
        System.out.println("\nSetup: I am executed (by instance "+this._id+") before every test");
    }

    @Test
    public void testDemo(){
        System.out.println("Test demo: instance " + this._id + " runs a demo test");
        assertTrue(true);
    }    

   @Test
   public void testCustomerStatement(){
        // On reproduis le scénario à tester avec les nouvelles interfaces
        Customers newImplem = new Customers("Alice");
        newImplem.addRental(new Rental(new Movie("Rogue One", Movie.NEW_RELEASE), 5));
        newImplem.addRental(new Rental(new Movie("Reine des neiges", Movie.CHILDRENS), 7));
        newImplem.addRental(new Rental(new Movie("Star Wars III", Movie.REGULAR), 4));

        // On reproduis le scénario à tester avec les anciennes interfaces
        old_model.Customers oldImplem = new old_model.Customers("Alice");
        oldImplem.addRental(new old_model.Rental(new old_model.Movie("Rogue One", old_model.Movie.NEW_RELEASE), 5));
        oldImplem.addRental(new old_model.Rental(new old_model.Movie("Reine des neiges", old_model.Movie.CHILDRENS), 7));
        oldImplem.addRental(new old_model.Rental(new old_model.Movie("Star Wars III", old_model.Movie.REGULAR), 4));

        // On vérifie que l'on a toujours le résultat attendu
        String statement = newImplem.statement();
        String expected = oldImplem.statement();//"Rental Record for Alice\n\tRogue One\t15.0 \n\tReine des neiges\t7.5 \n\tStar Wars III\t5.0 \nAmount owned is 27.5\nYou earned 4 frequent renter points";
        assertEquals(statement, expected);
   }

    @Override
    protected void tearDown() throws Exception {
        System.out.println("Tear down: I am executed (by instance "+this._id+") after every test\n");
    }
    
}
