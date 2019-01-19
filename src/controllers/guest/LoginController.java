package controllers.guest;

import controllers.Controller;
import controllers.MenuController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;
import resources.Constants;

public class LoginController extends Controller implements Initializable{

    @FXML
    private VBox centerVBox;
    @FXML
    private VBox menu;
    @FXML
    private MenuController menuController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        centerVBox.setMaxWidth(scene != null ? scene.getWidth()/2 : Constants.SCENE_WIDTH/2);
        centerVBox.setMaxHeight(scene != null ? scene.getHeight()/2 : Constants.SCENE_HEIGHT/2);
    }
}
