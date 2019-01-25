package controllers.customer;

import controllers.*;
import controllers.menu.*;
import javafx.fxml.*;
import javafx.scene.control.Pagination;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CustomerFavoritesController extends Controller implements Initializable{

    private static final int COLUMNS = 2;
    private static final int ROWS = 2;

    private static List<Integer> handymen = new ArrayList<>();

    static {
        handymen.add(1); handymen.add(2); handymen.add(3); handymen.add(4);
        handymen.add(5); handymen.add(6); handymen.add(7); handymen.add(8);
        handymen.add(9); handymen.add(10); handymen.add(11); handymen.add(12);
    }

    private final String pageURL = "../../pages/customer/";
    @FXML
    private CustomerMenuController customerMenuController;
    @FXML
    private VBox favoriteHandymen;


    @FXML
    private Pagination handymenPagination;
    @FXML
    private GridPane handymenGrid;
    @FXML
    private HBox firstHandyman;
    @FXML
    private FavoriteHandymanController firstHandymanController;
    @FXML
    private HBox secondHandyman;
    @FXML
    private FavoriteHandymanController secondHandymanController;
    @FXML
    private HBox thirdHandyman;
    @FXML
    private FavoriteHandymanController thirdHandymanController;
    @FXML
    private HBox fourthHandyman;
    @FXML
    private FavoriteHandymanController fourthHandymanController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        customerMenuController.emphasizeMenuItemSelected(customerMenuController.getCustMenuFavorites());
        try {
            handymenPagination.setPageCount(handymen.size()/4);
//            handymenPagination.setMaxPageIndicatorCount(handymen.size()/4);
            handymenPagination.setPageFactory((Integer pageIndex) ->  createPage(pageIndex));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private GridPane createPage(Integer pageIndex){
        int page = pageIndex * ROWS * COLUMNS;
        try {
            firstHandyman = FXMLLoader.load(getClass().getResource(pageURL + "favorite_handyman.fxml"));
            firstHandymanController.getHandymanName().setText(handymen.get(page) + "");
            secondHandyman = FXMLLoader.load(getClass().getResource(pageURL + "favorite_handyman.fxml"));
            secondHandymanController.getHandymanName().setText(handymen.get(page + 1) + "");
            thirdHandyman = FXMLLoader.load(getClass().getResource(pageURL + "favorite_handyman.fxml"));
            thirdHandymanController.getHandymanName().setText(handymen.get(page + 2) + "");
            fourthHandyman = FXMLLoader.load(getClass().getResource(pageURL + "favorite_handyman.fxml"));
            fourthHandymanController.getHandymanName().setText(handymen.get(page + 3) + "");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return handymenGrid;
    }


}
