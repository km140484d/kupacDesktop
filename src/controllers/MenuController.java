package controllers;

import javafx.event.Event;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.io.IOException;

public class MenuController extends Controller{

    @FXML
    private Button loginButton;
    @FXML
    private Button regButton;
    @FXML
    private Button searchButton;

    private final String pageURL = "../pages/guest/";

    public void emphasizeMenuItemSelected(Button button){
        button.getStyleClass().remove("menu_item");
        button.getStyleClass().add("menu_item_selected");
    }

    public void switchToPrijava(Event event) throws IOException {
        System.out.println(loginButton.getText() + loginButton.getStyleClass());
        stage.setTitle("Prijava");
        BorderPane root = FXMLLoader.load(getClass().getResource(pageURL + "login.fxml"));
        emphasizeMenuItemSelected(loginButton);
        scene.setRoot(root);
    }

    public void switchToRegistracija(Event event) throws IOException {
        stage.setTitle("Registracija");
        BorderPane root = FXMLLoader.load(getClass().getResource(pageURL + "registration.fxml"));
        scene.setRoot(root);
        emphasizeMenuItemSelected(regButton);
    }

    public void switchToPretragaMajstora(Event event) throws IOException {
        stage.setTitle("Pretraga majstora");
        BorderPane root = FXMLLoader.load(getClass().getResource(pageURL + "handymen_search.fxml"));
        scene.setRoot(root);
        emphasizeMenuItemSelected(searchButton);
    }

}
