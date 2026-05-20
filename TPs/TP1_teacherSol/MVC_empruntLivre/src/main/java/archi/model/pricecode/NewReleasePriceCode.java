package archi.model.pricecode;

public class NewReleasePriceCode extends DefaultPriceCode {


    public NewReleasePriceCode(double basePrice, double additionalFee, int includeDays) {
        super(basePrice, additionalFee, includeDays);
    }

    @Override
    public int getFrequentRenterPoints(int daysRented, int limit) {
        if (daysRented > limit) {
            return 2;
        }
        return 1;
    }

    @Override
    public NewReleasePriceCode clone() {
        return (NewReleasePriceCode) super.clone();
    }
}
