import controllers.*;
import controllers.guest.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import resources.Constants;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        LoginController.setPrimaryStage(primaryStage);
        MenuController.setPrimaryStage(primaryStage);
        Parent root = FXMLLoader.load(getClass().getResource("pages/guest/login.fxml"));
        primaryStage.setTitle("Kupac");
        Scene primaryScene = new Scene(root, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        primaryStage.setScene(primaryScene);
        primaryScene.getStylesheets().add(getClass().getResource("resources/css/base").toExternalForm());
        primaryStage.show();
        //primaryStage.setFullScreen(true);
        MenuController.setPrimaryScene(primaryScene);
        LoginController.setPrimaryScene(primaryScene);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
