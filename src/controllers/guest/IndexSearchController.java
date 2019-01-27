package controllers.guest;

import beans.Handyman;
import controllers.Controller;
import controllers.SearchController;
import controllers.menu.MainMenuController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.controlsfx.control.Rating;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class IndexSearchController extends Controller implements Initializable {

    private final String pageURL = "../../pages/guest/";

    @FXML
    private VBox indexSearchResults;
    @FXML
    private MainMenuController menuController;
    @FXML
    private SearchController searchController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        menuController.emphasizeMenuItemSelected(menuController.getSearchButton());
        searchController.setParentIndexController(this);

    }

    public void displayHandymenResults(List<Handyman> handymen, String work) throws IOException {
        indexSearchResults.getChildren().clear();
        for(Handyman handyman: handymen){
            HBox box = FXMLLoader.load(getClass().getResource(pageURL + "index_handymen_result.fxml"));
            Label nameSurnameLabel = (Label)box.lookup("#indexSearchResultHandyman");
            nameSurnameLabel.setText(handyman.getName() + " " + handyman.getSurname());
            Label jobsLabel = (Label)box.lookup("#indexSearchResultJob");
            Rating ratingComponent = (Rating)box.lookup("#indexSearchResultRating");
            List<Handyman.Job> jobs = handyman.getJobs();
            double averageRating = 0;
            for(Handyman.Job job: jobs){
                if (jobsLabel.getText().isEmpty())
                    jobsLabel.setText(job.getOccupation().getWork());
                else
                    jobsLabel.setText(jobsLabel.getText() + ", " + job.getOccupation().getWork());
                averageRating += job.getRating();
            }
            ratingComponent.setRating(averageRating/jobs.size());
            indexSearchResults.getChildren().add(box);
        }
    }

}
