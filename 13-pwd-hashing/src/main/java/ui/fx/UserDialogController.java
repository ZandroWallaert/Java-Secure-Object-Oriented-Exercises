package ui.fx;

import domain.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import services.UserService;
import util.PwdException;

public class UserDialogController {

    private UserService userService = new UserService();

    @FXML
    private TextField txtLogin;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void login(ActionEvent event) {
        try {
            User user = userService.loginUser(txtLogin.getText(), txtPassword.getText());
            showInfoMessage(String.format("Welcome, %s!", user.getLogin()));
        } catch (PwdException ex) {
            showErrorMessage(ex.getMessage());
        }
    }

    @FXML
    void register(ActionEvent event) {
        try {
            userService.registerUser(txtLogin.getText(), txtPassword.getText());
            txtLogin.clear();
            txtPassword.clear();
            showInfoMessage("Registration complete.");
        } catch (PwdException ex) {
            showErrorMessage(ex.getMessage());
        }
    }

    private void showInfoMessage(String message) {
        new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK).showAndWait();
    }

    private void showErrorMessage(String message) {
        new Alert(Alert.AlertType.ERROR, message, ButtonType.OK).showAndWait();
    }

}
