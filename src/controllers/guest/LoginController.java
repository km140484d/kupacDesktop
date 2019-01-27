package controllers.guest;

import beans.Customer;
import beans.DB;
import components.Window;
import controllers.Controller;
import controllers.menu.MainMenuController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import resources.Constants;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class LoginController extends Controller implements Initializable{

    @FXML
    private VBox centerVBox;
    @FXML
    private VBox menu;
    @FXML
    private MainMenuController menuController;

    @FXML
    private TextField logUsername;
    @FXML
    private PasswordField logPassword;

    private static final String customerPageURL = "../../pages/customer/";
    private static final String guestPageURL = "../../pages/guest/";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        centerVBox.setMaxWidth(scene != null ? scene.getWidth()/2 : Constants.SCENE_WIDTH/2);
        centerVBox.setMaxHeight(scene != null ? scene.getHeight()/2 : Constants.SCENE_HEIGHT/2);
        menuController.emphasizeMenuItemSelected(menuController.getLoginButton());
    }

    public void login(ActionEvent actionEvent) throws IOException {
        List<Customer> customers = DB.getDBInstance().getCustomers().
                stream().filter(p -> p.getAccount().getUsername().equals(logUsername.getText())).collect(Collectors.toList());
        if (!customers.isEmpty()){
            if (customers.get(0).getAccount().getPassword().equals(logPassword.getText())){
                DB.getDBInstance().setCurrentCustomer(customers.get(0));
                BorderPane root = FXMLLoader.load(getClass().getResource(customerPageURL + "customer_favorites.fxml"));
                stage.setTitle("Odabrani majstori");
                scene.setRoot(root);
            }else{
                new Window(true, "Poruka", "Pogrešno uneta lozinka!").display();
            }
        }else{
            new Window(true, "Poruka", "Korisnik sa unetim podacima ne postoji u sistemu!").display();
        }

    }

    public void registration(ActionEvent actionEvent) throws IOException {
        BorderPane root = FXMLLoader.load(getClass().getResource(guestPageURL + "registration.fxml"));
        stage.setTitle("Registracija");
        scene.setRoot(root);
    }
}
