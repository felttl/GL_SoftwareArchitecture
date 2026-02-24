package archi.controller;

import archi.model.Customer;
import archi.model.Movie;
import javafx.collections.ObservableList;

/**
 * redirecting to all sub-controllers
 */
public class MainController {

    private Customer customer;

    private ObservableList<Movie> reservedMovies;
    private ObservableList<Movie> availableMovies;

    public MainController(Customer customer){
        this.customer = customer;
        this.loadData();
    }

    private void loadData() {
        this.reservedMovies.clear();
        // customer.get
    }
    
    
}
