package controllers.menu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class CustomerMenuController extends MenuController {

    @FXML
    private Button custMenuSearch;
    @FXML
    private Button custMenuRequests;
    @FXML
    private Button custMenuFavorites;
    @FXML
    private Button custMenuUpdate;
    @FXML
    private Button custMenuLogout;

    public void switchToSearch(MouseEvent mouseEvent) throws IOException {
        BorderPane root = FXMLLoader.load(getClass().getResource(customerPageURL + "customer_handymen_search.fxml"));
        stage.setTitle("Pretraga majstora");
        scene.setRoot(root);
    }

    public void switchToRequests(MouseEvent mouseEvent) throws IOException {
        BorderPane root = FXMLLoader.load(getClass().getResource(customerPageURL + "customer_requests.fxml"));
        stage.setTitle("Pregled zahteva");
        scene.setRoot(root);
    }

    public void switchToFavorites(MouseEvent mouseEvent) throws IOException {
        BorderPane root = FXMLLoader.load(getClass().getResource(customerPageURL + "customer_favorites.fxml"));
        stage.setTitle("Odabrani majstori");
        scene.setRoot(root);
    }

    public void switchToUpdate(MouseEvent mouseEvent) throws IOException {
        BorderPane root = FXMLLoader.load(getClass().getResource(customerPageURL + "customer_update.fxml"));
        stage.setTitle("Održavanje naloga");
        scene.setRoot(root);
    }

    public void logout(MouseEvent mouseEvent) throws IOException {
        BorderPane root = FXMLLoader.load(getClass().getResource(indexPageURL + "login.fxml"));
        stage.setTitle("Odjava");
        scene.setRoot(root);
    }

    public Button getCustMenuSearch() {
        return custMenuSearch;
    }

    public void setCustMenuSearch(Button custMenuSearch) {
        this.custMenuSearch = custMenuSearch;
    }

    public Button getCustMenuRequests() {
        return custMenuRequests;
    }

    public void setCustMenuRequests(Button custMenuRequests) {
        this.custMenuRequests = custMenuRequests;
    }

    public Button getCustMenuFavorites() {
        return custMenuFavorites;
    }

    public void setCustMenuFavorites(Button custMenuFavorites) {
        this.custMenuFavorites = custMenuFavorites;
    }

    public Button getCustMenuUpdate() {
        return custMenuUpdate;
    }

    public void setCustMenuUpdate(Button custMenuUpdate) {
        this.custMenuUpdate = custMenuUpdate;
    }

    public Button getCustMenuLogout() {
        return custMenuLogout;
    }

    public void setCustMenuLogout(Button custMenuLogout) {
        this.custMenuLogout = custMenuLogout;
    }
}
