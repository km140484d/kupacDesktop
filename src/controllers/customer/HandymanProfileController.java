package controllers.customer;

import controllers.Controller;
import controllers.menu.CustomerMenuController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HandymanProfileController extends Controller implements Initializable {

    private final String customerPageURL = "../../pages/customer/";

    @FXML
    private CustomerMenuController customerMenuController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        customerMenuController.emphasizeMenuItemSelected(customerMenuController.getCustMenuSearch());
    }

    public void createRequest(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(customerPageURL + "handyman_request_mail.fxml"));
//        stage.setTitle("Prijava");
        scene.setRoot(root);
    }
}
