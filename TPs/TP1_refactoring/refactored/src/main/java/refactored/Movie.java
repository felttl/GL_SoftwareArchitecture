package refactored;

public class Movie {

    private String title;
    private MovieState priceCode;

    public Movie(String title, MovieState priceCode) {
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

}
