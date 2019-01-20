package controllers.customer;

import controllers.Controller;
import controllers.menu.CustomerMenuController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerSearchController extends Controller implements Initializable {

    private final String pageURL = "../../pages/customer/";

    @FXML
    private CustomerMenuController customerMenuController;
    @FXML
    private VBox customerSearchResults;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        customerMenuController.emphasizeMenuItemSelected(customerMenuController.getCustMenuSearch());
        try {
            HBox box = FXMLLoader.load(getClass().getResource(pageURL + "customer_handymen_result.fxml"));
            customerSearchResults.getChildren().add(box);
            HBox box1 = FXMLLoader.load(getClass().getResource(pageURL + "customer_handymen_result.fxml"));
            customerSearchResults.getChildren().add(box1);
            HBox box2 = FXMLLoader.load(getClass().getResource(pageURL + "customer_handymen_result.fxml"));
            customerSearchResults.getChildren().add(box2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
