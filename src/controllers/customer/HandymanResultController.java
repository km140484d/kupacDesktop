package controllers.customer;

import controllers.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class HandymanResultController extends Controller {

    private static final String customerPageURL = "../../pages/customer/";

    public void viewHandymanProfile(ActionEvent actionEvent) throws IOException {
        BorderPane root = FXMLLoader.load(getClass().getResource(customerPageURL + "handyman_profile.fxml"));
        scene.setRoot(root);
    }

    public void sendHandymanRequest(ActionEvent actionEvent) throws IOException {
        BorderPane root = FXMLLoader.load(getClass().getResource(customerPageURL + "handyman_request_mail.fxml"));
        scene.setRoot(root);
    }
}
