package controllers.customer;

import beans.Handyman;
import controllers.Controller;
import controllers.menu.CustomerMenuController;
import database.DB;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Pagination;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

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
    private VBox firstHandyman;
    @FXML
    private VBox secondHandyman;
    @FXML
    private VBox thirdHandyman;
    @FXML
    private VBox fourthHandyman;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        customerMenuController.emphasizeMenuItemSelected(customerMenuController.getCustMenuFavorites());
        try {
            handymenPagination.setPageCount((DB.getDBInstance().getCurrentCustomer().getFavoriteHandymen().size()-1)/4+1);
            handymenPagination.setPageFactory((Integer pageIndex) ->  createPage(pageIndex));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private GridPane createPage(Integer pageIndex){
        int page = pageIndex * ROWS * COLUMNS;
        try {
            firstHandyman.getChildren().clear();
            secondHandyman.getChildren().clear();
            thirdHandyman.getChildren().clear();
            fourthHandyman.getChildren().clear();
            List<Handyman> handymen = DB.getCurrentCustomer().getFavoriteHandymen();
            for(int i=page; i < page + ROWS*COLUMNS && i < handymen.size(); i++){
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(pageURL + "favorite_handyman.fxml"));
                Parent favorite = fxmlLoader.load();
                ((FavoriteHandymanController)fxmlLoader.getController()).setHandyman(handymen.get(i));
                switch (i - page){
                    case 0:
                        firstHandyman.getChildren().add(favorite);
                        break;
                    case 1:
                        secondHandyman.getChildren().add(favorite);
                        break;
                    case 2:
                        thirdHandyman.getChildren().add(favorite);
                        break;
                    case 3:
                        fourthHandyman.getChildren().add(favorite);
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return handymenGrid;
    }


}
