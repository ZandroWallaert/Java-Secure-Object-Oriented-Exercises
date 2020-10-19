package fx;

import domain.Item;
import domain.ItemException;
import domain.Sex;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class ScreenController {

    @FXML
    private TextField name;

    @FXML
    private TextField age;

    @FXML
    private ComboBox<Sex> sex;

    @FXML
    private ListView<Item> items;

    @FXML
    private Label error;

    @FXML
    private ResourceBundle resources;

    @FXML
    private void initialize() {
        assert resources != null;
        Logger.getAnonymousLogger().info("Initialize ScreenController");
        error.setTextFill(Color.web("red"));
        items.setItems(FXCollections.observableArrayList(
                new Item("Alice",1, Sex.F),
                new Item("Bob",2, Sex.M),
                new Item("C3PO",3, Sex.X)
        ));
        sex.setItems(FXCollections.observableArrayList(Sex.values()));
    }

    private Optional<Item> getItem() {

        try {
            Item item = new Item(
                    name.getText(),
                    Integer.parseInt(age.getText()),
                    Objects.requireNonNull(sex.getValue())
            );
            Platform.runLater(this::clearInputs);
            return Optional.of(item);
        } catch (NumberFormatException ex){
            error.setText(String.format(resources.getString("screen.error.invalid.age"), age.getText()));
            age.clear();
            return Optional.empty();
        } catch (NullPointerException ex) {
            error.setText(resources.getString("screen.error.no.sex"));
            return Optional.empty();
        } catch (ItemException ex) {
            error.setText(resources.getString(ex.getMessage()));
            return Optional.empty();
        }
    }

    private void clearInputs() {
        name.clear();
        age.clear();
        sex.getSelectionModel().clearSelection();
        sex.setPromptText("- select -");
    }

    @FXML
    private void add(ActionEvent evt) {
        Logger.getAnonymousLogger().info("Add button clicked");
        getItem().ifPresent(items.getItems()::add);
    }

}
