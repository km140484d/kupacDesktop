package controllers.customer;

import controllers.*;
import controllers.menu.*;
import javafx.fxml.*;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerRequestsController extends Controller implements Initializable{

    private final String pageURL = "../../pages/customer/";

    @FXML
    private CustomerMenuController customerMenuController;

    @FXML
    private VBox requestResults;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        customerMenuController.emphasizeMenuItemSelected(customerMenuController.getCustMenuRequests());
        try {
            VBox box = FXMLLoader.load(getClass().getResource(pageURL + "request.fxml"));
            requestResults.getChildren().add(box);
            VBox box1 = FXMLLoader.load(getClass().getResource(pageURL + "request.fxml"));
            requestResults.getChildren().add(box1);
            VBox box2 = FXMLLoader.load(getClass().getResource(pageURL + "request.fxml"));
            requestResults.getChildren().add(box2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
