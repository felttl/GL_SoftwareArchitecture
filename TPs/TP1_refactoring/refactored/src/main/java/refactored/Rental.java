package refactored;

public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return this.daysRented;
    }

    public Movie getMovie() {
        return this.movie;
    }

    /**
     * @return the number of points earned
     * from the rental
     */
    public double getPointsAmount(){
        double amount = 0.d;
        final double valueFactor = 1.5d;
        MovieState type = this.movie.getPriceCode();
        if(type == MovieState.REGULAR){
            amount += 2;
            if(this.daysRented > 2)
                amount += this.daysRented * valueFactor - 3;
        } else if (type == MovieState.NEW_RELEASE) {
            amount += this.daysRented * valueFactor * 2;
        } else if (type == MovieState.CHILDRENS) {
            amount += 1.5;
            if (this.daysRented > 3)
                amount += this.daysRented * valueFactor - 4.5;
        }
        return amount;
    }

    /**
     * add bonus points in specific conditions
     * @return if the bonus is given or not
     */
    public boolean canEarnExtraPoints(){
        final boolean isRelease = this.movie.getPriceCode() == MovieState.NEW_RELEASE;
        return isRelease && this.daysRented > 1;
    }

    /**
     * transform the objects into a string
     * 
     * (sortie d'affichage par defaut donne par le code
     * avant refactoring (sortie est exactement la même))
     */
    @Override
    public String toString(){
        return String.format(
            "%s %s %s %f %s",
            "\t", this.movie.getTitle(),
            "\t", this.getPointsAmount(), "\n"
        );
    }

    /**
     * renvoie une traduction en français
     * de l'objet (critères de sortie du prof)
     */
    public String toStringFR(){
        final String plural = this.daysRented > 1 ? "s" : "";
        return String.format(
            " - \"%s\" de type %s pendant %d jour%s", 
            this.movie.getTitle(),
            this.movie.getPriceCode(),
            this.daysRented,
            plural
        );
    }

}
