package controllers.menu;

import controllers.Controller;
import javafx.scene.control.Button;

public class MenuController extends Controller {

    protected final String indexPageURL = "../../pages/guest/";

    protected final String customerPageURL = "../../pages/customer/";

    public void emphasizeMenuItemSelected(Button button){
        button.getStyleClass().remove("menu_item");
        button.getStyleClass().add("menu_item_selected");
    }
}
