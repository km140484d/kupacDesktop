package controllers.customer;

import components.*;
import controllers.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.input.*;

import java.net.URL;
import java.util.ResourceBundle;

public class RequestController extends Controller implements Initializable {

    @FXML
    private Label requestState;
    @FXML
    private BorderTitlePanel cancelRequestPanel;
    @FXML
    private BorderTitlePanel rateRequestPanel;
    @FXML
    private Label requestCanceledDate;

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

}
