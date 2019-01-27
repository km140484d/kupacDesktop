package controllers.customer;

import controllers.Controller;
import controllers.menu.CustomerMenuController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MailRequestController extends Controller implements Initializable {

    @FXML
    private CustomerMenuController customerMenuController;

    private HandymanProfileController profileController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        customerMenuController.emphasizeMenuItemSelected(customerMenuController.getCustMenuSearch());
    }

    public HandymanProfileController getProfileController() {
        return profileController;
    }

    public void setProfileController(HandymanProfileController profileController) {
        this.profileController = profileController;
    }
}
