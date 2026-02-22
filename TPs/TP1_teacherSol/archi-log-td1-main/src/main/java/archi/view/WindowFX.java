package archi.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class WindowFX extends Application {

  @Override
  public void start(Stage stage) {

    // --- Ligne 1 : TextFields
    TextField tf1 = new TextField();
    tf1.setPromptText("Field 1");

    TextField tf2 = new TextField();
    tf2.setPromptText("Field 2");

    HBox textRow = new HBox(15, tf1, tf2);
    textRow.setAlignment(Pos.CENTER);

    // --- Ligne 2 : ListView (listes scrollables)
    ListView<String> list1 = new ListView<>();
    list1.getItems().addAll(
            "Milk", "Eggs", "Bread", "Cheese"
    );
    list1.setPrefSize(200, 150);

    ListView<String> list2 = new ListView<>();
    list2.getItems().addAll(
            "Apples", "Bananas", "Oranges"
    );
    list2.setPrefSize(200, 150);

    HBox listRow = new HBox(15, list1, list2);
    listRow.setAlignment(Pos.CENTER);

    // --- Ligne 3 : Bouton aligné sous liste droite
    Button btn = new Button("placeHolderTxt");

    Region spacer = new Region();
    HBox.setHgrow(spacer, Priority.ALWAYS);

    HBox buttonRow = new HBox(15, spacer, btn);
    buttonRow.setAlignment(Pos.CENTER);

    // --- Layout principal
    VBox root = new VBox(20, textRow, listRow, buttonRow);
    root.setPadding(new Insets(30));
    root.setAlignment(Pos.TOP_CENTER);

    Scene scene = new Scene(root, 700, 500);

    stage.setScene(scene);
    stage.setTitle("Shopping Lists");
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}