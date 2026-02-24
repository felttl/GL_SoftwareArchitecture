package archi.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class SuperCustomer extends Customer {

    private List<SuperRental> activeRentals;
    // cannot modify Customers to add dates for them
    private List<Date> doneRentals; 

    public SuperCustomer(Customer c) {
        super(c.getName());
        this.defaultInit();
    }
    private void defaultInit(){
        this.activeRentals = new ArrayList<>();
    }
    public SuperCustomer(String name) {
        super(name);
        this.defaultInit();
    }

    public boolean isSameMovie(Movie m){
        for(SuperRental rental : this.activeRentals)
            if(rental.getMovie().equals(m)) return true;
        return false;
    }

    public void addActiveRental(SuperRental r){
        this.activeRentals.add(r);
    }

    public List<SuperRental> getActiveRentals() {
        return activeRentals;
    }

    /**
     * @param r {@link SuperRental} rental to remove
     * @return boolean, true if object exists else not
     * used to show to the user that the rental has been removed or not
     */
    public boolean removeActiveRental(SuperRental r){
        if(this.activeRentals.contains(r)){
            this.activeRentals.remove(r);
            return true;
        }
        return false;
    }

    public void resetRentals(){
        this.activeRentals.clear();
    }

    @Override
    public String statement() {
        return super.statement();
    }

    
}
