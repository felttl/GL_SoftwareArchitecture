
public class DefaultPriceCode implements PriceCode{

    private double baseprice, additionnalfee;
    private int includeDays;

    private static final double REGULAR_BASE_PRICE = 6;
    private static final double REGULAR_INCLUDED_DAYS = 5;

    public DefaultPriceCode(double baseprice, double additionnalfee, int includeDays) {
        this.baseprice = baseprice;
        this.additionnalfee = additionnalfee;
        this.includeDays = includeDays;
    }


    public double getPrice(int days) {
        double amount = REGULAR_BASE_PRICE;
        if(days > REGULAR_INCLUDED_DAYS)
            amount += (days-this.includeDays)*this.additionnalfee;
        return amount;
    }

    public double getFrequentRenterPoints() {
        return 0;
    }

}
