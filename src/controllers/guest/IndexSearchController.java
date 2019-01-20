package controllers.guest;

import controllers.Controller;
import controllers.menu.MainMenuController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class IndexSearchController extends Controller implements Initializable {

    private final String pageURL = "../../pages/guest/";

    @FXML
    private VBox indexSearchResults;
    @FXML
    private MainMenuController menuController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        menuController.emphasizeMenuItemSelected(menuController.getSearchButton());
        try {
            HBox box = FXMLLoader.load(getClass().getResource(pageURL + "index_handymen_result.fxml"));
            indexSearchResults.getChildren().add(box);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
