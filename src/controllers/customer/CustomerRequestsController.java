package controllers.customer;

import beans.Request;
import controllers.Controller;
import controllers.menu.CustomerMenuController;
import database.DB;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;
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
        List<Request> requests = DB.getDBInstance().getCurrentCustomer().getRequests();
        try {
            for(Request request: requests){
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(pageURL + "request.fxml"));
                Parent root = fxmlLoader.load();
                ((RequestController)fxmlLoader.getController()).setRequest(request);
                requestResults.getChildren().add(root);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
