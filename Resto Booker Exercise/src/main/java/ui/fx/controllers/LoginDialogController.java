package ui.fx.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import domain.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import services.UserService;
import util.RestoException;

public class LoginDialogController {

    private final UserService userService = new UserService();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtLogin;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void login(ActionEvent event) {
        try {
            User user =
                    userService.loginUser(txtLogin.getText(), txtPassword.getText());
            openMainDialog(user);
        } catch (RestoException ex) {
            showErrorMessage(ex.getMessage());
        }
    }

    @FXML
    void exit(ActionEvent event) {
        Button btn = (Button) event.getSource();
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void register(ActionEvent event) {
        try {
            User user = userService.registerUser(txtLogin.getText(), txtPassword.getText(),
                    txtPassword.getText());
            showInfoMessage("Registration successful. Welcome, " +
                    user.getLogin());
            txtPassword.clear();
        } catch (RestoException ex) {
            showErrorMessage(ex.getMessage());
        }
    }

    @FXML
    void initialize() {
        assert txtLogin != null : "fx:id=\"txtLogin\" was not injected: check your FXML file 'LoginDialog.fxml'.";
        assert txtPassword != null : "fx:id=\"txtPassword\" was not injected: check your FXML file 'LoginDialog.fxml'.";

    }

    private void showErrorMessage(String message) {
        Alert al = new Alert(Alert.AlertType.ERROR, message, ButtonType.OK);
        al.showAndWait();
    }

    private void showInfoMessage(String message) {
        Alert al = new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK);
        al.showAndWait();
    }

    private void openMainDialog(User user) {
        try {
            Stage stage = new Stage();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainDialog.fxml"));
            Parent root = loader.load();
            MainDialogController controller = loader.getController();

            controller.setUser(user);

            Scene scene = new Scene(root);

            Stage oldStage = (Stage) txtLogin.getScene().getWindow();
            oldStage.close();

            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException ex) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "Unable to open main dialog.", ex);
            throw new RestoException("Unable to open main dialog.");
        }
    }
}
