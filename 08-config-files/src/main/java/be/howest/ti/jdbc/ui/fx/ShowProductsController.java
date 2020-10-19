package be.howest.ti.jdbc.ui.fx;

import be.howest.ti.jdbc.data.ProductRepository;
import be.howest.ti.jdbc.data.Repositories;
import be.howest.ti.jdbc.domain.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class ShowProductsController {

    private ProductRepository repo;
    private ObservableList<Product> products;

    @FXML
    private ListView<Product> lstProducts;

    @FXML
    void initialize() {
        repo = Repositories.getProductsRepo();
        products = FXCollections.observableList(repo.getProducts());
        lstProducts.setItems(products);
    }

    @SuppressWarnings("S1172")
    public void openAddProduct(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AddProduct.fxml"));
        Parent root = loader.load();
        AddProductController controller = loader.getController();
        controller.passSharedResources(stage, repo, products);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.showAndWait();
    }
}
