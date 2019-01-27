package controllers.customer;

import beans.Handyman;
import controllers.Controller;
import controllers.menu.CustomerMenuController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import org.controlsfx.control.Rating;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HandymanProfileController extends Controller implements Initializable {

    private final String customerPageURL = "../../pages/customer/";

    @FXML
    private CustomerMenuController customerMenuController;

    @FXML
    private Label handymanName;
    @FXML
    private Label handymanEmail;
    @FXML
    private Label handymanPhone;
    @FXML
    private TableView handymanTableJobs;
    @FXML
    private TableColumn<TableJob, String> handymanJobColumn;
    @FXML
    private TableColumn<TableJob, Double> handymanPriceColumn;
    @FXML
    private TableColumn<TableJob, Double> handymanRatingColumn;
    @FXML
    private Label handymanSpecialSkills;

    private HandymanResultController resultController;

    private Handyman handyman;

    private Parent root;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        customerMenuController.emphasizeMenuItemSelected(customerMenuController.getCustMenuSearch());
    }

    public void createRequest(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(customerPageURL + "handyman_request_mail.fxml"));
        Parent root = fxmlLoader.load();
        ((MailRequestController)fxmlLoader.getController()).setProfileController(this);
        scene.setRoot(root);
    }

    public void backToSearch(ActionEvent actionEvent) {
        resultController.getSearchController().setSavedSearchScene();
    }

    public class TableJob{
        private String occupation;
        private Double price;
        private double rating;

        public TableJob(String occupation, Double price, double rating) {
            this.occupation = occupation;
            this.price = price;
            this.rating = rating;
        }

        public String getOccupation() {
            return occupation;
        }

        public void setOccupation(String occupation) {
            this.occupation = occupation;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }
    }

    public Handyman getHandyman() {
        return handyman;
    }

    public void setHandyman(Handyman handyman) {
        this.handyman = handyman;
    }

    public HandymanResultController getResultController() {
        return resultController;
    }

    public void setResultController(HandymanResultController resultController) {
        this.resultController = resultController;
        this.handyman = resultController.getHandyman();
        handymanName.setText(handyman.getName() + " " + handyman.getSurname());
        handymanEmail.setText(handyman.getEmail());
        handymanPhone.setText(handyman.getPhone());
        handyman.getSkills().forEach(s -> {
            if (handymanSpecialSkills.getText().isEmpty())
                handymanSpecialSkills.setText(s.getDescription());
            else
                handymanSpecialSkills.setText(handymanSpecialSkills.getText() + ", " + s.getDescription());
        });

        List<TableJob> tableJobs = new ArrayList<>();
        List<Handyman.Job> jobs = handyman.getJobs();
        for(Handyman.Job job: jobs)
            tableJobs.add(new TableJob(job.getOccupation().getWork(), job.getPrice(), job.getRating()));

        Callback<TableColumn<TableJob, Double>, TableCell<TableJob, Double>> cellFactory = param -> {
            final TableCell<TableJob, Double> cell = new TableCell<>() {

                final Rating rating = new Rating();

                @Override
                public void updateItem(Double item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        TableJob tj = getTableView().getItems().get(getIndex());
                        rating.setRating(tj.getRating());
                        rating.setDisable(true);
                        rating.setScaleX(.75);
                        rating.setScaleY(.75);
                        setGraphic(rating);
                    }
                    setText(null);
                }
            };
            return cell;
        };
        handymanRatingColumn.setCellFactory(cellFactory);
        handymanTableJobs.setItems(FXCollections.observableArrayList(tableJobs));
    }

    public Parent getRoot() {
        return root;
    }

    public void setRoot(Parent root) {
        this.root = root;
    }

    public void setHandymanProfileScene(){
        scene.setRoot(root);
    }
}
