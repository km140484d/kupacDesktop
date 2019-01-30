package controllers.customer;

import beans.Handyman;
import controllers.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class FavoriteHandymanController extends Controller {
    @FXML
    private Label handymanName;

    private Handyman handyman;

    public void requestAction(MouseEvent mouseEvent) {
    }

    public void shareFacebook(ActionEvent actionEvent) {
    }

    public void shareInstagram(ActionEvent actionEvent) {
    }

    public void shareTwitter(ActionEvent actionEvent) {
    }

//    public Label getHandymanName() {
//        return handymanName;
//    }
//
//    public void setHandymanName(Label handymanName) {
//        this.handymanName = handymanName;
//    }

    public Handyman getHandyman() {
        return handyman;
    }

    public void setHandyman(Handyman handyman) {
        this.handyman = handyman;
        handymanName.setText(handyman.getName() + " " + handyman.getSurname());
    }
}
