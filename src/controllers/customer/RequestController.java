package controllers.customer;

import beans.Request;
import components.BorderTitlePanel;
import controllers.Controller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.Rating;

import java.net.URL;
import java.util.ResourceBundle;

public class RequestController extends Controller implements Initializable {

    @FXML
    private BorderTitlePanel cancelRequestPanel;
    @FXML
    private BorderTitlePanel rateRequestPanel;

    @FXML
    private Label requestSent;
    @FXML
    private Label handymanJob;
    @FXML
    private Label handymanName;
    @FXML
    private Label handymanAddress;
    @FXML
    private Label requestDate;
    @FXML
    private Label requestState;
    @FXML
    private Label requestCanceledDate;
    @FXML
    private Rating requestRated;
    @FXML
    private TextArea requestComment;

    private Request request;

    public void requestAction(MouseEvent mouseEvent) {
        if (requestState.getText().equals("POSLAT")){
            cancelRequestPanel.setVisible(!cancelRequestPanel.isVisible());
        }else{
            if (requestState.getText().equals("REALIZOVAN")){
                rateRequestPanel.setVisible(!rateRequestPanel.isVisible());
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cancelRequestPanel.managedProperty().bind(cancelRequestPanel.visibleProperty());
        rateRequestPanel.managedProperty().bind(rateRequestPanel.visibleProperty());
        requestCanceledDate.managedProperty().bind(requestCanceledDate.visibleProperty());
        //set the visibility of requestCanceledDate to true when the request is CANCELED

    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
        requestSent.setText(request.getRequestCreatedDate().toString());
        handymanJob.setText(request.getJob().getOccupation().getWork());
        handymanName.setText(request.getHandyman().getName() + " " + request.getHandyman().getSurname());
        handymanAddress.setText(request.getAddress().getStreetNumber() + ", " + request.getAddress().getCounty());
        requestDate.setText(request.getRequestDate().toString());
        requestState.setText(request.getCurrentState().toString());
    }
}
