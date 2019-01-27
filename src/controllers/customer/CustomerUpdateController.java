package controllers.customer;

import beans.Customer;
import beans.DB;
import components.Window;
import controllers.Controller;
import controllers.menu.CustomerMenuController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

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
    private DatePicker editCardValid;
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

    private Customer customer = DB.getDBInstance().getCurrentCustomer();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        customerMenuController.emphasizeMenuItemSelected(customerMenuController.getCustMenuUpdate());
        editCommandBox.managedProperty().bind(editCommandBox.visibleProperty());
        editButon.managedProperty().bind(editButon.visibleProperty());
        disableInfo(true);
        disableCreditCardInfo(true);
        initializeCustomerControls();
    }

    private void initializeCustomerControls() {
        editName.setText(customer.getName());
        editSurname.setText(customer.getSurname());
        editPhone.setText(customer.getPhone());
        editEmail.setText(customer.getEmail());
        if (customer.getCreditCard() != null){
            editPayCheck.setSelected(true);
            editCardNumber.setText(customer.getCreditCard().getNumber());
            editCardValid.setValue(customer.getCreditCard().getValidity());
            editCardCode.setText(customer.getCreditCard().getCode());
        }
        editUsername.setText(customer.getAccount().getUsername());
        editPassword.setText(customer.getAccount().getPassword());
        editPasswordRep.setText(customer.getAccount().getPassword());
        editComment.setText(customer.getComment());
    }

    private void saveCustomerInfo() {
        customer.setName(editName.getText());
        customer.setSurname(editSurname.getText());
        customer.setPhone(editPhone.getText());
        customer.setEmail(editEmail.getText());
        if (customer.getCreditCard() != null && editPayCheck.isSelected()){
            customer.getCreditCard().setNumber(editCardNumber.getText());
            customer.getCreditCard().setValidity(editCardValid.getValue());
            customer.getCreditCard().setCode(editCardCode.getText());
        }
        customer.getAccount().setUsername(editUsername.getText());
        customer.getAccount().setPassword(editPassword.getText());
        customer.setComment(editComment.getText());
    }

    public void disableInfo(boolean disable){
        editName.setDisable(disable);
        editSurname.setDisable(disable);
        editPhone.setDisable(disable);
        editEmail.setDisable(disable);

        editPayCheck.setDisable(disable);
        if (disable || (!disable && editPayCheck.isSelected()))
            disableCreditCardInfo(disable);

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
        if (!editUsername.getText().equals(customer.getAccount().getUsername()) &&
                !DB.getDBInstance().getCustomers().stream(). filter(p ->
                        p.getAccount().getUsername().equals(editUsername.getText())).collect(Collectors.toList()).isEmpty())
            new Window(true, "Poruka", "Već postoji korisnik sa unetim nalogom!").display();
        else{
            if (!editPassword.getText().equals(editPasswordRep.getText())){
                new Window(true, "Poruka", "Lozinke se ne poklapaju!").display();
            }else{
                saveCustomerInfo();
                disableInfo(true);
                setEditMode(true);
            }
        }
    }

    public void discardChanges(ActionEvent actionEvent) {
        initializeCustomerControls();
        disableInfo(true);
        setEditMode(true);
    }

    public void creditCardAction(ActionEvent actionEvent) {
        disableCreditCardInfo(!editPayCheck.isSelected());
    }
}
