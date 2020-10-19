package ui.fx.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import data.Repositories;
import domain.Booking;
import domain.Restaurant;
import domain.User;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainDialogController {
    private User user = null;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<Booking> lstBookings;

    @FXML
    private ComboBox<Restaurant> cboRestaurants;

    @FXML
    private TextField txtDateAndTime;

    @FXML
    private TextField txtNumPersons;

    @FXML
    void addBooking(ActionEvent event) {
        if (areAllInputControlsFilledIn()) {
            try {
                int numPersons = Integer.parseInt(txtNumPersons.getText());
                Restaurant restaurant = cboRestaurants.getSelectionModel().getSelectedItem();
                String dateAndTime = txtDateAndTime.getText().trim();

                addBookingToRepo(restaurant, dateAndTime, numPersons);
                fillBookings();
            } catch (NumberFormatException ex) {
                showErrorMessage("Please enter a valid number of persons and try again.");
            }
        } else {
            showErrorMessage("Please complete all fields and try again.");
        }
    }

    private boolean areAllInputControlsFilledIn() {
        return cboRestaurants.getSelectionModel().getSelectedItem() != null
                && txtDateAndTime.getText().trim().length() > 0
                && txtNumPersons.getText().trim().length() > 0;
    }

    private void addBookingToRepo(Restaurant restaurant, String dateAndTime, int numPersons) {
        Booking booking = restaurant.makeBooking(dateAndTime, user.getLogin(), numPersons);
        Repositories.getBookingRepository().addBooking(booking);
    }

    private void showErrorMessage(String message) {
        Alert al = new Alert(Alert.AlertType.ERROR, message, ButtonType.OK);
        al.showAndWait();
    }

    void setUser(User user) {
        this.user = user;
    }

    @FXML
    void initialize() {
        assert lstBookings != null : "fx:id=\"lstBookings\" was not injected: check your FXML file 'MainDialog.fxml'.";
        assert cboRestaurants != null : "fx:id=\"cboRestaurants\" was not injected: check your FXML file 'MainDialog.fxml'.";
        assert txtDateAndTime != null : "fx:id=\"txtDateAndTime\" was not injected: check your FXML file 'MainDialog.fxml'.";
        assert txtNumPersons != null : "fx:id=\"txtNumPersons\" was not injected: check your FXML file 'MainDialog.fxml'.";

        fillBookings();
        fillRestaurants();
    }

    private void fillBookings() {
        lstBookings.setItems(FXCollections.observableList(Repositories.getBookingRepository().getBookings()));
    }

    private void fillRestaurants() {
        cboRestaurants.setItems(FXCollections.observableList(Repositories.getRestaurantRepository().getRestaurants()));
    }

}

