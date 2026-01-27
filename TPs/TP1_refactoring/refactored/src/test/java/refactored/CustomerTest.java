package refactored;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

// on importe le package entier car la classe utilise tout le package
import refactored.*;

/**
 * on doit mettre private et public rien 
 * d'autre pour pouvoir modifier 
 * pour pouvoir modifier l'interieur sans qu'il
 * y ait des problèmes pour
 * les gens qui utilisent le code (la lib entière)
 */
public class CustomerTest {


    private final int maxIntervalDaysRental;
    final ArrayList<MovieState> types;

    String name;
    private ArrayList<Rental> rentals;
    private Random random;
    private Customer customer;

    public CustomerTest(){
        this.types = new ArrayList<>(
            Arrays.asList(
                MovieState.CHILDRENS,
                MovieState.NEW_RELEASE,
                MovieState.REGULAR
            )
        );   
        this.rentals = new ArrayList<>();      
        
        this.maxIntervalDaysRental = 10;
        final short numberOfTRentals = 10;        
        
        this.name = "david auber";
        this.random = ThreadLocalRandom.current();
        this.randRentals(numberOfTRentals);
        this.customer = new Customer(this.name);

    }

    /**
     * 
     * @param lenMsg size of the random text (in characters)
     */
    private String randTitleMovie(short lenMsg){
        var res = new StringBuilder();
        final int asciiLettersStart = 64;
        for (; lenMsg > 0; lenMsg--) {
            final int asciiletter = this.random.nextInt(26);
            res.append((char)asciiletter+asciiLettersStart);
        }
        return res.toString();
    }

    /**
     * generate random rentals to test
     * @param number
     */
    private void randRentals(short number){
        while (number > 0) {
            this.rentals.add(this.randRental());
            number--;
        }
    }


    @Test
    // @DisplayName("this.name match customer.getName()")
    public void getNameTest(){
        assertEquals(this.customer.getName(), this.name);
    }

    @Test
    // @DisplayName("make sure Customer.getName() is correct")
    public void setNameTest(){
        this.name = "david auber 1";
        this.customer.setName(name);
        assertEquals(this.customer.getName(), this.name);
    }


    @Test
    public void statementTest(){
        this.customer = new Customer(this.name);

        StringBuilder res = new StringBuilder()
         .append("Rental Record for ").append(this.name)
         .append("\n");
        int frequentRenterPoints = 0;
        double totalAmount = 0;
        Rental current;
        int i = 0;
        for (; i < this.rentals.size(); i++) {
            current = this.rentals.get(i);
            customer.addRental(current);            
            if(current.canEarnExtraPoints()) // tested already
                frequentRenterPoints++;
            res.append(current.toString()); // tested ''
            totalAmount += current.getPointsAmount(); // tested
        }
		res.append(String.format("Amount owned is %f\n", totalAmount));
        res.append(
			String.format(
				"You earned %d \" frequent renter points\"", 
				-1+i+frequentRenterPoints
			)
		);
        assertEquals(res.toString(), customer.statement());
    }

    @Test
    public void statementFRTest(){
        var expectRes = new StringBuilder(
            this.name+" a loue des films:\n"
        );
        short numberOfTRentals = 4;
        
        for (int j = 0; j < numberOfTRentals; j++) {
            final Rental rdRental = this.randRental();
            this.customer.addRental(rdRental);
            expectRes.append(rdRental.toStringFR()) // tested already
             .append(numberOfTRentals > 0 && j != numberOfTRentals-1 ? "," : ".")	
			 .append("\n");
        }
        assertEquals(
            expectRes.toString(),
            this.customer.statementFR()
        );
    }

    /**
     * generate random rentals to test
     */
    private Rental randRental(){
        final short movieTitleSize = 10;
        int tmpIdx = this.random.nextInt(this.types.size());
        Movie movie = new Movie(
            this.randTitleMovie(movieTitleSize),
            this.types.get(tmpIdx)
        );
        int rand = this.random.nextInt(this.maxIntervalDaysRental);
        return new Rental(movie,rand);
    }

    @Test
    public void getRentalTest(){
        this.randRentals((short)this.rentals.size());
        // duplicate
        for (int i =0; i < this.rentals.size(); i++) {
            final Rental current = this.rentals.get(i);
            customer.addRental(current);
        }
        for (int i = 0; i < this.rentals.size()/2; i++) {
            final int rd = this.random.nextInt(this.rentals.size());
            final Rental actual = this.customer.getRental(rd);
            assertEquals(this.rentals.get(rd), actual);            
        }
    }


}