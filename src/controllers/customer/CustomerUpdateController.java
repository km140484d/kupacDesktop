package controllers.customer;

import controllers.Controller;
import controllers.menu.CustomerMenuController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerUpdateController extends Controller implements Initializable{

    @FXML
    private CustomerMenuController customerMenuController;
    @FXML
    private HBox editCommandBox;
    @FXML
    private Button editButon;

    //basic info
    @FXML
    private TextField editName;
    @FXML
    private TextField editSurname;
    @FXML
    private TextField editPhone;
    @FXML
    private TextField editEmail;

    //credit card
    @FXML
    private CheckBox editPayCheck;
    @FXML
    private TextField editCardNumber;
    @FXML
    private TextField editCardValid;
    @FXML
    private TextField editCardCode;

    //login information
    @FXML
    private TextField editUsername;
    @FXML
    private TextField editPassword;
    @FXML
    private TextField editPasswordRep;

    //comment
    @FXML
    private TextArea editComment;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        customerMenuController.emphasizeMenuItemSelected(customerMenuController.getCustMenuUpdate());
        editCommandBox.managedProperty().bind(editCommandBox.visibleProperty());
        editButon.managedProperty().bind(editButon.visibleProperty());
        disableInfo(true);
        disableCreditCardInfo(true);
    }

    public void disableInfo(boolean disable){
        editName.setDisable(disable);
        editSurname.setDisable(disable);
        editPhone.setDisable(disable);
        editEmail.setDisable(disable);

        editPayCheck.setDisable(disable);
        if (!disable && editPayCheck.isSelected())
            disableCreditCardInfo(false);

        editUsername.setDisable(disable);
        editPassword.setDisable(disable);
        editPasswordRep.setDisable(disable);

        editComment.setDisable(disable);
    }

    public void disableCreditCardInfo(boolean disable){
        editCardNumber.setDisable(disable);
        editCardValid.setDisable(disable);
        editCardCode.setDisable(disable);
    }

    public void setEditMode(boolean edit){
        editButon.setVisible(edit);
        editCommandBox.setVisible(!edit);
    }

    public void activateEditMode(ActionEvent actionEvent) {
        disableInfo(false);
        setEditMode(false);
    }

    public void saveChanges(ActionEvent actionEvent) {
        //save changes
        disableInfo(true);
        setEditMode(true);
    }

    public void discardChanges(ActionEvent actionEvent) {
        //discard changes
        disableInfo(true);
        setEditMode(true);
    }

    public void creditCardAction(ActionEvent actionEvent) {
        disableCreditCardInfo(!editPayCheck.isSelected());
    }
}
