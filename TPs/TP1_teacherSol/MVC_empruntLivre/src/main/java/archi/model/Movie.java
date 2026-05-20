package archi.model;

import archi.model.pricecode.DefaultPriceCode;
import archi.model.pricecode.NewReleasePriceCode;
import archi.model.pricecode.Pricecode;

public class Movie implements Cloneable{
    public static final Pricecode CHILDRENS = new DefaultPriceCode(1.5, 1.5, 3);
    public static final Pricecode REGULAR = new DefaultPriceCode(2, 1.5, 2);
    public static final Pricecode NEW_RELEASE = new NewReleasePriceCode(1, 3, 0);

    private String _title;
    private Pricecode _priceCode;

    public Movie(String title, Pricecode priceCode) {
        _title = title;
        _priceCode = priceCode;
    }

    @Override
    public Movie clone() {
        try {
            Movie m = (Movie)super.clone();
            return m;
        } catch (CloneNotSupportedException e) {
            System.err.println("clone not implemented for Movie");
            return null;
        }
    }

    public Pricecode getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(Pricecode priceCode) {
        _priceCode = priceCode;
    }

    public String getTitle() {
        return _title;
    }

    public double getRentalCost(int daysRented) {
        return _priceCode.getPrice(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented, int limit){
        return _priceCode.getFrequentRenterPoints(daysRented, limit);
    }

    @Override
    public String toString() {
        return _title;
    }

}
