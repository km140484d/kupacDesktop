package controllers.menu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MainMenuController extends MenuController {

    @FXML
    private Button loginButton;
    @FXML
    private Button regButton;
    @FXML
    private Button searchButton;

    public void emphasizeMenuItemSelected(Button button){
        button.getStyleClass().remove("menu_item");
        button.getStyleClass().add("menu_item_selected");
    }

    public void switchToPrijava(MouseEvent mouseEvent) throws IOException {
        BorderPane root = FXMLLoader.load(getClass().getResource(indexPageURL + "login.fxml"));
        stage.setTitle("Prijava");
        scene.setRoot(root);
    }

    public void switchToRegistracija(MouseEvent mouseEvent) throws IOException {
        BorderPane root = FXMLLoader.load(getClass().getResource(indexPageURL + "registration.fxml"));
        stage.setTitle("Registracija");
        scene.setRoot(root);
    }

    public void switchToPretraga(MouseEvent mouseEvent) throws IOException {
        BorderPane root = FXMLLoader.load(getClass().getResource(indexPageURL + "index_handymen_search.fxml"));
        stage.setTitle("Pretraga majstora");
        scene.setRoot(root);
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(Button loginButton) {
        this.loginButton = loginButton;
    }

    public Button getRegButton() {
        return regButton;
    }

    public void setRegButton(Button regButton) {
        this.regButton = regButton;
    }

    public Button getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(Button searchButton) {
        this.searchButton = searchButton;
    }
}
