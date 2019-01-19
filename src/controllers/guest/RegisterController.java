package controllers.guest;

import controllers.Controller;
import controllers.menu.MainMenuController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController extends Controller implements Initializable {

    @FXML
    private MainMenuController menuController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        menuController.emphasizeMenuItemSelected(menuController.getRegButton());
    }
}
