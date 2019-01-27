package controllers.customer;

import beans.Handyman;
import controllers.Controller;
import controllers.menu.CustomerMenuController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class MailRequestController extends Controller implements Initializable {

    @FXML
    private CustomerMenuController customerMenuController;

    @FXML
    private ComboBox requestJob;
    @FXML
    private DatePicker requestTime;
    @FXML
    private Slider requestUrgency;

    @FXML
    private ToggleGroup paymentRadioGroup;
    @FXML
    private TextField requestCardNumber;
    @FXML
    private TextField requestCardValidity;
    @FXML
    private TextField requestCardCode;
    @FXML
    private Button requestCardSave;

    @FXML
    private TextField requestAddressCounty;
    @FXML
    private TextField requestAddressStreet;

    private HandymanProfileController profileController;

    private Handyman handyman;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        customerMenuController.emphasizeMenuItemSelected(customerMenuController.getCustMenuSearch());
    }

    public HandymanProfileController getProfileController() {
        return profileController;
    }

    public void setProfileController(HandymanProfileController profileController) {
        this.profileController = profileController;
        this.handyman = profileController.getHandyman();
    }

    public void sendHandymanRequest(ActionEvent actionEvent) {

    }

    public void cancelHandymanRequest(ActionEvent actionEvent) {
        profileController.setHandymanProfileScene();
    }
}
