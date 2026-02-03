package refactored;

public class Movie {

    private String title;
    private MovieState priceCode;

    public static final PriceCode CHILDREN = Movie.CHILDRENS;

    public Movie(String title, PriceCode priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public MovieState getPriceCode() {
        return this.priceCode;
    }

    public void setPriceCode(MovieState priceCode) {
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return this.title;
    }

    public double getPrice(int days){
        return movie.getPrice(daysRented)
    }

}
