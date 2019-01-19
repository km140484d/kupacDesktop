package controllers.guest;

import controllers.*;
import javafx.fxml.*;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class IndexSearchController extends Controller implements Initializable {

    private final String pageURL = "../../pages/guest/";

    @FXML
    private VBox indexSearchResults;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            HBox box = FXMLLoader.load(getClass().getResource(pageURL + "index_handymen_result.fxml"));
            indexSearchResults.getChildren().add(box);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
