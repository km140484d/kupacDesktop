package controllers.customer;

import beans.Handyman;
import controllers.Controller;
import controllers.SearchController;
import controllers.menu.CustomerMenuController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CustomerSearchController extends Controller implements Initializable {

    private final String pageURL = "../../pages/customer/";

    @FXML
    private CustomerMenuController customerMenuController;
    @FXML
    private SearchController searchController;
    @FXML
    private VBox customerSearchResults;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        customerMenuController.emphasizeMenuItemSelected(customerMenuController.getCustMenuSearch());
        searchController.setParentCustomerController(this);
    }

    public void displayHandymenResults(List<Handyman> handymen, String work) throws IOException {
        customerSearchResults.getChildren().clear();
        for(Handyman handyman: handymen){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(pageURL + "customer_handymen_result.fxml"));
            HBox box = fxmlLoader.load();
            ((HandymanResultController)fxmlLoader.getController()).setSearchController(this);
            ((HandymanResultController)fxmlLoader.getController()).setHandyman(handyman);
            customerSearchResults.getChildren().add(box);
        }
    }

}
