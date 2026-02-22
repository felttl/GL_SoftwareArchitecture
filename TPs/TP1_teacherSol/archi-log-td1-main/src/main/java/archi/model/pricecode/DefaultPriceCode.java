package archi.model.pricecode;

public class DefaultPriceCode implements Pricecode {
    private double basePrice;
    private double additionalFee;
    private int includeDays;

    public DefaultPriceCode(double basePrice, double additionalFee, int includeDays) {
        this.basePrice = basePrice;
        this.additionalFee = additionalFee;
        this.includeDays = includeDays;
    }

    @Override
    public double getPrice(int daysRented) {
        double rentalCost = 0;
        rentalCost += basePrice;
        if (daysRented > includeDays)
            rentalCost += (daysRented - includeDays) * additionalFee;
        return rentalCost;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented, int limit) {
        return 1;
    }

    @Override
    public DefaultPriceCode clone(){
        try {
            return (DefaultPriceCode) super.clone();
        } catch (Exception e) {
            return null;
        }

    }
}
