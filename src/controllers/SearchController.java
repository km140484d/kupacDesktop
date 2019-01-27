package controllers;

import beans.Handyman;
import beans.Occupation;
import beans.Skill;
import controllers.customer.CustomerSearchController;
import controllers.guest.IndexSearchController;
import database.DB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import org.controlsfx.control.Rating;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class SearchController extends Controller implements Initializable {

    @FXML
    private ComboBox searchJob;
    @FXML
    private Slider searchUrgency;

    @FXML
    private TextField searchPriceMin;
    @FXML
    private TextField searchPriceMax;
    @FXML
    private DatePicker searchDateMin;
    @FXML
    private DatePicker searchDateMax;
    @FXML
    private TextField searchExpMin;
    @FXML
    private TextField searchExpMax;

    @FXML
    private Rating searchRating;
    @FXML
    private ComboBox searchSkills;

    private IndexSearchController indexSearchController;

    private CustomerSearchController customerSearchController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Occupation> occupations = DB.getDBInstance().getOccupations();
        for(Occupation occupation: occupations)
            searchJob.getItems().add(occupation.getWork());
        List<Skill> skills = DB.getDBInstance().getSkills();
        for(Skill skill: skills)
            searchSkills.getItems().add(skill.getDescription());
    }

    public void search(ActionEvent actionEvent) throws IOException {
        List<Handyman> handymen = DB.getDBInstance().getHandymen();
        String priceMinText = searchPriceMin.getText();
        String priceMaxText = searchPriceMax.getText();
        String expMinText = searchExpMin.getText();
        String expMaxText = searchExpMax.getText();
        Double priceMinValue = priceMinText.isEmpty() ? null : Double.parseDouble(priceMinText);
        Double priceMaxValue = priceMaxText.isEmpty() ? null : Double.parseDouble(priceMaxText);
        Integer expMinValue = expMinText.isEmpty() ? null : Integer.parseInt(expMinText);
        Integer expMaxValue = expMaxText.isEmpty() ? null : Integer.parseInt(expMaxText);
        double ratingValue = searchRating.getRating();
        List<Handyman> handymenResult = handymen.stream().filter(p ->
            !p.getJobs().stream().filter(j ->
                (searchJob.getValue() == null || j.getOccupation().getWork().equals(searchJob.getValue())) &&
                (priceMinText.isEmpty() || j.getPrice().compareTo(priceMinValue) >= 0) &&
                (priceMaxText.isEmpty() || j.getPrice().compareTo(priceMaxValue) <= 0) &&
                (expMinText.isEmpty() || j.getExperience().compareTo(expMinValue) >= 0) &&
                (expMaxText.isEmpty() || j.getExperience().compareTo(expMaxValue) <= 0) &&
                (j.getRating() >= ratingValue)
            ).collect(Collectors.toList()).isEmpty() &&
                    (searchSkills.getValue() == null || !p.getSkills().stream().filter( s ->
                            s.getDescription().equals(searchSkills.getValue())
                    ).collect(Collectors.toList()).isEmpty())
        ).collect(Collectors.toList());
        if (indexSearchController != null)
            indexSearchController.displayHandymenResults(handymenResult, (String) searchJob.getValue());
        else
            customerSearchController.displayHandymenResults(handymenResult, (String) searchJob.getValue());
    }

    public void setParentIndexController(IndexSearchController indexSearchController){
        this.indexSearchController = indexSearchController;
    }

    public void setParentCustomerController(CustomerSearchController customerSearchController){
        this.customerSearchController = customerSearchController;
    }

}
