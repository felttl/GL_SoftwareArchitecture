package refactored;

public class Movie {

    private static final PriceCode CHILDRENS = null;

    private String title;
    private PriceCode priceCode;

    public static final PriceCode CHILDREN = Movie.CHILDRENS;

    public Movie(String title, PriceCode priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public PriceCode getPriceCode() {
        return this.priceCode;
    }

    public void setPriceCode(PriceCode priceCode) {
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return this.title;
    }

    public double getPrice(int days){
        return movie.getPrice(daysRented);
    }

}
