package controllers.guest;

import beans.Customer;
import beans.DB;
import controllers.Controller;
import controllers.menu.MainMenuController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController extends Controller implements Initializable {

    private static final String guestPageURL = "../../pages/guest/";

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
    private DatePicker regCardValid;
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
        disableCreditCardInfo(true);
    }

    public void disableCreditCardInfo(boolean disable){
        regCardNumber.setDisable(disable);
        regCardValid.setDisable(disable);
        regCardCode.setDisable(disable);
    }

    public void creditCardAction(ActionEvent actionEvent) {
        disableCreditCardInfo(!regPayCheck.isSelected());
    }

    public void saveCustomerInfo(ActionEvent actionEvent) throws IOException {
        Customer customer = new Customer(regName.getText(), regSurname.getText(), regPhone.getText(), regEmail.getText(),
                regUsername.getText(), regPassword.getText(), regComment.getText());
        if (regPayCheck.isSelected())
            customer.setCreditCard(
                    customer.new CreditCard(regCardNumber.getText(),
                            regCardValid.getValue(), regCardCode.getText(), 0));
        DB.getDBInstance().addCustomer(customer);
        login();
    }

    public void login() throws IOException {
        BorderPane root = FXMLLoader.load(getClass().getResource(guestPageURL + "login.fxml"));
        stage.setTitle("Prijava");
        scene.setRoot(root);
    }

    public void cancelCustomerInfo(ActionEvent actionEvent) throws IOException {
        login();
    }
}
