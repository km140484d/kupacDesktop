package controllers.customer;

import beans.Handyman;
import controllers.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import org.controlsfx.control.Rating;

import java.io.IOException;
import java.util.List;

public class HandymanResultController extends Controller {

    private static final String customerPageURL = "../../pages/customer/";

    @FXML
    private Label customerSearchResultHandyman;
    @FXML
    private Label customerSearchResultJob;
    @FXML
    private Rating customerSearchResultRating;

    private CustomerSearchController searchController;

    private Handyman handyman;

    public void viewHandymanProfile(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(customerPageURL + "handyman_profile.fxml"));
        BorderPane root = fxmlLoader.load();
        ((HandymanProfileController)fxmlLoader.getController()).setResultController(this);
        scene.setRoot(root);
    }

    public void sendHandymanRequest(ActionEvent actionEvent) throws IOException {
        BorderPane root = FXMLLoader.load(getClass().getResource(customerPageURL + "handyman_request_mail.fxml"));
        scene.setRoot(root);
    }

    public Handyman getHandyman() {
        return handyman;
    }

    public void setHandyman(Handyman handyman) {
        this.handyman = handyman;
        customerSearchResultHandyman.setText(handyman.getName() + " " + handyman.getSurname());
        List<Handyman.Job> jobs = handyman.getJobs();
        double averageRating = 0;
        for(Handyman.Job job: jobs){
            if (customerSearchResultJob.getText().isEmpty())
                customerSearchResultJob.setText(job.getOccupation().getWork());
            else
                customerSearchResultJob.setText(customerSearchResultJob.getText() + ", " + job.getOccupation().getWork());
            averageRating += job.getRating();
        }
        customerSearchResultRating.setRating(averageRating/jobs.size());
    }

    public CustomerSearchController getSearchController() {
        return searchController;
    }

    public void setSearchController(CustomerSearchController searchController) {
        this.searchController = searchController;
    }
}
