package be.howest.ti.jdbc.ui.fx;

import be.howest.ti.jdbc.data.ProductRepository;
import be.howest.ti.jdbc.domain.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddProductController {

    private Stage stage;
    private ProductRepository repo;
    private ObservableList<Product> products;

    void passSharedResources(Stage stage, ProductRepository repo, ObservableList<Product> products) {
        this.stage = stage;
        this.repo = repo;
        this.products = products;
    }

    @FXML
    private TextField txtfName;

    @FXML
    private TextField txtfPrice;

    @FXML
    private ComboBox<Integer> selectVAT;


    @FXML
    void initialize() {
        selectVAT.setItems(FXCollections.observableArrayList(6,12, 21));
    }

    @FXML
    void doAdd(ActionEvent event) {
        try {
            double price = Double.parseDouble(txtfPrice.getText());
            Product p = new Product(txtfName.getText(), price, selectVAT.getValue());


            repo.addProduct(p);
            products.add(p);
            closeWindow();
        } catch (NumberFormatException ex) {
            txtfPrice.appendText(" <-- This is not a number");
        }
    }

    private void closeWindow() {
        stage.close();
    }

    @FXML
    void doCancel(ActionEvent event) {
        closeWindow();
    }

}
