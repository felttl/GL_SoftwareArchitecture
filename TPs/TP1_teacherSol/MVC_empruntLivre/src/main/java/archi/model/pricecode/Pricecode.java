package archi.model.pricecode;

public interface Pricecode extends Cloneable {
     double getPrice(int daysRented);
     int getFrequentRenterPoints(int daysRented, int limit);
}
