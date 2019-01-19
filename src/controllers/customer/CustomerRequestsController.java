package controllers.customer;

import controllers.Controller;
import controllers.menu.CustomerMenuController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerRequestsController extends Controller implements Initializable{

    @FXML
    private CustomerMenuController customerMenuController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        customerMenuController.emphasizeMenuItemSelected(customerMenuController.getCustMenuRequests());
    }

}
