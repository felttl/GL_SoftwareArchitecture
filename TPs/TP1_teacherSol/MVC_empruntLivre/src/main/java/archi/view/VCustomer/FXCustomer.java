 package archi.view.VCustomer;

import java.util.List;
import java.util.Objects;

import archi.model.Movie;
import archi.model.Rental;
import archi.model.SuperCustomer;
import archi.model.SuperRental;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Customer view, he can :
 * - rent a bool
 * - drop a book
 * - see his rentals
 * - see all available books
 * - see all reserved books
 */
public class FXCustomer extends Application {

  /// TODO: adding this : 
  /// 1) classcolor of (reserved (red), available (no color), ...)
  /// 2) add logic behind button and rename it
  /// 3) plug classes (Customer) to JavaFX and other stuff... 
  ///   make it clean and refactor if necessayr
  /// 4) tests all new things (event UI if possible)
  /// 5) end

  private static List<Movie> allAvailableMovies;
  private static SuperCustomer injectedCustomer;

  @Override
  public void start(Stage stage) {

    stage.setTitle("MovieRental");

    // TITRES COLONNES
    Label titleLeft = new Label("My Rentals");
    Label titleRight = new Label("Available Movies");

    // TEXTFIELDS
    TextField tfCenter = new TextField();
    tfCenter.setPromptText("Search active rentals");

    TextField tfLeft = new TextField();
    tfLeft.setPromptText("Search done rentals");

    TextField tfRight = new TextField();
    tfRight.setPromptText("Search movies");

    // LISTES
    ListView<Rental> listLeftDoneRentals = new ListView<>();
    listLeftDoneRentals.getItems().addAll(
      FXCustomer.injectedCustomer.getRentals()
    );

    ListView<SuperRental> listLeftActiveRentals = new ListView<>();
    listLeftActiveRentals.getItems().addAll(
       FXCustomer.injectedCustomer.getActiveRentals()
    );

    ListView<Movie> listRightAllMovies = new ListView<>();
    listRightAllMovies.getItems().addAll(
      FXCustomer.allAvailableMovies
    );
    listRightAllMovies.setCellFactory(lv -> new ListCell<>() {
      @Override
      protected void updateItem(Movie movie, boolean empty) {
        super.updateItem(movie, empty);
        if (empty || movie == null) {
          setText(null);
          setGraphic(null);
          return;
        }
        Label title = new Label(movie.getTitle());
        Circle status = new Circle(6);
        if (FXCustomer.injectedCustomer.isSameMovie(movie))
          status.setStyle("-fx-fill: red;");
        else 
          status.setStyle("-fx-fill: green;");
        HBox box = new HBox(10, status, title);
        box.setAlignment(Pos.CENTER_LEFT);
        setGraphic(box);
      }
    });

    // extensibilité
    listLeftDoneRentals.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    listLeftActiveRentals.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    listRightAllMovies.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

    // GRID STRUCTURE
    GridPane grid = new GridPane();
    grid.setHgap(20);
    grid.setVgap(10);
    grid.setPadding(new Insets(20));

    // 2 colonnes 50% / 50%
    ColumnConstraints col1 = new ColumnConstraints();
    col1.setPercentWidth(50);

    ColumnConstraints col2 = new ColumnConstraints();
    col2.setPercentWidth(50);

    grid.getColumnConstraints().addAll(col1, col2);

    // Rows
    grid.add(titleLeft, 0, 0);
    grid.add(titleRight, 1, 0);

    grid.add(tfLeft, 0, 1);
    grid.add(tfRight, 1, 1);

    // Colonne gauche restructurée proprement
    VBox leftColumn = new VBox(10,
      listLeftDoneRentals,
      tfCenter,
      listLeftActiveRentals
    );

    VBox.setVgrow(listLeftDoneRentals, Priority.ALWAYS);
    VBox.setVgrow(listLeftActiveRentals, Priority.ALWAYS);

    // Placement principal
    grid.add(leftColumn, 0, 2);
    grid.add(listRightAllMovies, 1, 2);

    // La ligne 2 (listes) prend toute la hauteur restante
    RowConstraints r1 = new RowConstraints();
    RowConstraints r2 = new RowConstraints();
    RowConstraints r3 = new RowConstraints();
    RowConstraints r4 = new RowConstraints();
    r4.setVgrow(Priority.ALWAYS);

    grid.getRowConstraints().addAll(r1, r2, r3, r4);

    Button btnDrop = new Button("Drop");
    btnDrop.getStyleClass().add("btnDrop");
    // messages d'erreurs en bas
    Button btnRent = new Button("Rent");
    TextField tfSystem = new TextField();
    tfSystem.setPromptText("");
    tfSystem.setEditable(false);
    tfSystem.getStyleClass().add("system-field");
    tfSystem.setMaxWidth(Double.MAX_VALUE);
    // les évènements c'est dans la View ou le Controller ?

    // btnDrop.setOnAction(e -> {
    //     Rental selectedRental = listLeftDoneRentals.getSelectionModel().getSelectedItem();
    //     if (selectedRental != null) {
    //         injectedCustomer.getRentals().remove(selectedRental);
    //         listLeftDoneRentals.getItems().remove(selectedRental);
    //         availableMovies.add(selectedRental.getMovie());
    //         listRightAllMovies.getItems().add(selectedRental.getMovie());
    //         return;
    //     }
    // });


    // --- Barre basse boutons
    HBox bottomBox = new HBox(10, btnDrop, btnRent);
    bottomBox.setAlignment(Pos.CENTER_RIGHT);

    // --- Container bas complet (boutons + champ système)
    VBox bottomContainer = new VBox(10, bottomBox, tfSystem);
    bottomContainer.setPadding(new Insets(10, 20, 20, 20));
    VBox.setVgrow(tfSystem, Priority.NEVER);

    // root view
    BorderPane root = new BorderPane();
    root.setCenter(grid);
    root.setBottom(bottomContainer);

    Scene scene = new Scene(root, 900, 600);

    scene.getStylesheets().add(
        Objects.requireNonNull(
            getClass().getResource("/style.css")
        ).toExternalForm()
    );

    stage.setScene(scene);
    stage.show();
  }


  // javaFX constraints area

  public static void main(String[] args) {
    launch(args);
  }

  public static void setCustomer(SuperCustomer c) {
    FXCustomer.injectedCustomer = c;
  }

  public static void setAllAvailableMovies(List<Movie> movies) {
    FXCustomer.allAvailableMovies = movies;
  }


}