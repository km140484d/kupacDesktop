package controllers.customer;

import controllers.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.*;

public class FavoriteHandymanController extends Controller {
    @FXML
    private Label handymanName;

    public void requestAction(MouseEvent mouseEvent) {
    }

    public void shareFacebook(ActionEvent actionEvent) {
    }

    public void shareInstagram(ActionEvent actionEvent) {
    }

    public void shareTwitter(ActionEvent actionEvent) {
    }

    public Label getHandymanName() {
        return handymanName;
    }

    public void setHandymanName(Label handymanName) {
        this.handymanName = handymanName;
    }
}
