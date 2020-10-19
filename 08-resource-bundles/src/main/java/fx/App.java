package fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceDialog;
import javafx.stage.Stage;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Locale locale = getLocale();
        ResourceBundle bundle = ResourceBundle.getBundle("Screen", locale);
        Parent root = FXMLLoader.load(App.class.getResource("/fxml/Screen.fxml"), bundle);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private Locale getLocale() {
        Map<String, Locale> languages = Stream.of(
                new Locale("en","BE"),
                new Locale("nl","BE")
        ).collect(Collectors.toMap(Locale::getDisplayLanguage, l->l));

        ChoiceDialog<String> dialog = new ChoiceDialog<>(
                languages.keySet().iterator().next(),
                languages.keySet());

        dialog.setTitle("The Item factory");
        dialog.setHeaderText("Pick your language:");
        dialog.setContentText("Language:");

        return dialog.showAndWait().map(languages::get).orElse(Locale.getDefault());
    }

}
