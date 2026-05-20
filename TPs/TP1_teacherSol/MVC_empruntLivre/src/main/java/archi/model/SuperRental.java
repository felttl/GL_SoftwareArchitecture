package archi.model;

import java.util.Date;
import java.util.Optional;
// import javax.annotation.Nonnull;

public class SuperRental extends Rental{

    // @Nonnull
    private Date startDate;
    // @Nullable
    private Optional<Date> endDate;

    public SuperRental(Rental r) {
        super(r.getMovie(), r.getDaysRented());
        this.startDate = new Date();
        this.endDate = Optional.empty();
    }

    public Date getStartDate(){
        return this.startDate;
    }

    public void setEndDate(Date d){
        this.endDate = Optional.of(d);
    }


    public Date getEndDate(){
        return this.endDate.orElse(null);
    }

    public SuperRental(Movie movie, int daysRented) {
        super(movie, daysRented);
    }


    
}
