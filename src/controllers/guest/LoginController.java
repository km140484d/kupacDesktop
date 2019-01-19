package controllers.guest;

import controllers.Controller;
import controllers.menu.MainMenuController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import resources.Constants;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController extends Controller implements Initializable{

    @FXML
    private VBox centerVBox;
    @FXML
    private VBox menu;
    @FXML
    private MainMenuController menuController;

    private static final String customerPageURL = "../../pages/customer/";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        centerVBox.setMaxWidth(scene != null ? scene.getWidth()/2 : Constants.SCENE_WIDTH/2);
        centerVBox.setMaxHeight(scene != null ? scene.getHeight()/2 : Constants.SCENE_HEIGHT/2);
        menuController.emphasizeMenuItemSelected(menuController.getLoginButton());
    }

    public void login(ActionEvent actionEvent) throws IOException {
        BorderPane root = FXMLLoader.load(getClass().getResource(customerPageURL + "customer_favorites.fxml"));
        stage.setTitle("Odabrani majstori");
        scene.setRoot(root);
    }
}
