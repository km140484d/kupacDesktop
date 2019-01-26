package controllers.guest;

import controllers.Controller;
import controllers.menu.MainMenuController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController extends Controller implements Initializable {

    @FXML
    private MainMenuController menuController;

    //basic info
    @FXML
    private TextField regName;
    @FXML
    private TextField regSurname;
    @FXML
    private TextField regPhone;
    @FXML
    private TextField regEmail;

    //credit card
    @FXML
    private CheckBox regPayCheck;
    @FXML
    private TextField regCardNumber;
    @FXML
    private TextField regCardValid;
    @FXML
    private TextField regCardCode;

    //login information
    @FXML
    private TextField regUsername;
    @FXML
    private TextField regPassword;
    @FXML
    private TextField regPasswordRep;

    //comment
    @FXML
    private TextArea regComment;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        menuController.emphasizeMenuItemSelected(menuController.getRegButton());
    }

    public void disableCreditCardInfo(boolean disable){
        regCardNumber.setDisable(disable);
        regCardValid.setDisable(disable);
        regCardCode.setDisable(disable);
    }

    public void creditCardAction(ActionEvent actionEvent) {
        disableCreditCardInfo(!regPayCheck.isSelected());
    }
}
