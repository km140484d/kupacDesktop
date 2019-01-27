package controllers.customer;

import beans.Customer;
import beans.Handyman;
import beans.Request;
import components.Window;
import controllers.Controller;
import controllers.menu.CustomerMenuController;
import database.DB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class MailRequestController extends Controller implements Initializable {

    private final String customerPageURL = "../../pages/customer/";

    @FXML
    private CustomerMenuController customerMenuController;

    @FXML
    private ComboBox requestJob;
    @FXML
    private DatePicker requestTime;
    @FXML
    private Slider requestUrgency;

    @FXML
    private RadioButton creditCardRadio;
    @FXML
    private TextField requestCardNumber;
    @FXML
    private DatePicker requestCardValidity;
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

    private Customer customer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        customerMenuController.emphasizeMenuItemSelected(customerMenuController.getCustMenuSearch());
        this.customer = DB.getDBInstance().getCurrentCustomer();
        if (customer.getCreditCard() != null){
            Customer.CreditCard card = customer.getCreditCard();
            requestCardNumber.setText(card.getNumber());
            requestCardValidity.setValue(card.getValidity());
            requestCardCode.setText(card.getCode());
            //requestCardSave.setDisable(true);
        }
    }

    public HandymanProfileController getProfileController() {
        return profileController;
    }

    public void setProfileController(HandymanProfileController profileController) {
        this.profileController = profileController;
        this.handyman = profileController.getHandyman();
        List<Handyman.Job> jobs = handyman.getJobs();
        for(Handyman.Job job: jobs)
            requestJob.getItems().add(job.getOccupation().getWork());
    }

    public void sendHandymanRequest(ActionEvent actionEvent) throws IOException {
        if (validateRequest()) {
            Handyman.Job job = handyman.getJobs().stream().filter(p ->
                    p.getOccupation().getWork().equals(requestJob.getValue())).collect(Collectors.toList()).get(0);
            if (creditCardRadio.isSelected() && customer.getCreditCard().getBalance().compareTo(job.getPrice()) < 0)
                new Window(true, "Upozorenje", "Nemate dovoljno sredstava na računu za traženu uslugu!").show();
            else {
                if (creditCardRadio.isSelected())
                    customer.getCreditCard().setBalance(customer.getCreditCard().getBalance() - job.getPrice());
                Request request = new Request(handyman, job,
                        requestAddressCounty.getText(), requestAddressStreet.getText(), DB.getDBInstance().currentDate(),
                        requestTime.getValue(), requestUrgency.getValue(), creditCardRadio.isSelected());
                customer.addRequestArchive(request);
                BorderPane root = FXMLLoader.load(getClass().getResource(customerPageURL + "customer_requests.fxml"));
                scene.setRoot(root);
            }
        }
    }

    public void cancelHandymanRequest(ActionEvent actionEvent) {
        profileController.setHandymanProfileScene();
    }

    public void disableCreditCard(boolean disable){
        requestCardNumber.setDisable(disable);
        requestCardValidity.setDisable(disable);
        requestCardCode.setDisable(disable);
        requestCardSave.setDisable(disable);
    }

    public void creditCardSelected(ActionEvent actionEvent) {
        disableCreditCard(false);
    }

    public void cashSelected(ActionEvent actionEvent) {
        disableCreditCard(true);
    }

    public void saveCreditCard(ActionEvent actionEvent) {
        if (validateCreditCard())
            customer.setCreditCard(customer.new CreditCard(requestCardNumber.getText(),
                requestCardValidity.getValue(), requestCardCode.getText(), 0.0));
    }

    public boolean validateCreditCard(){
        boolean validation = true;
        if (requestCardNumber.getText().isEmpty()) {
            requestCardNumber.getStyleClass().add("empty-field");
            validation = false;
        }else
            requestCardNumber.getStyleClass().remove("empty-field");
        if (requestCardValidity.getValue() == null) {
            requestCardValidity.getStyleClass().add("empty-field");
            validation = false;
        }else
            requestCardValidity.getStyleClass().remove("empty-field");
        if (requestCardCode.getText().isEmpty()) {
            requestCardCode.getStyleClass().add("empty-field");
            validation = false;
        }else
            requestCardCode.getStyleClass().remove("empty-field");
        return validation;
    }

    public boolean validateRequest(){
        boolean validation = true;
        if (requestJob.getValue() == null) {
            requestJob.getStyleClass().add("empty-field");
            validation = false;
        }else
            requestJob.getStyleClass().remove("empty-field");
        if (requestTime.getValue() == null) {
            requestTime.getStyleClass().add("empty-field");
            validation = false;
        }else
            requestTime.getStyleClass().remove("empty-field");
        if (requestAddressCounty.getText().isEmpty()) {
            requestAddressCounty.getStyleClass().add("empty-field");
            validation = false;
        }else
            requestAddressCounty.getStyleClass().remove("empty-field");
        if (requestAddressStreet.getText().isEmpty()) {
            requestAddressStreet.getStyleClass().add("empty-field");
            validation = false;
        }else
            requestAddressStreet.getStyleClass().remove("empty-field");
//        validation &= validateCreditCard();
        return validation;
    }
}
