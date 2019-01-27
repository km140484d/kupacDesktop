package controllers;

import beans.Occupation;
import beans.Skill;
import database.DB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import org.controlsfx.control.Rating;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Occupation> occupations = DB.getDBInstance().getOccupations();
        for(Occupation occupation: occupations)
            searchJob.getItems().add(occupation.getWork());
        List<Skill> skills = DB.getDBInstance().getSkills();
        for(Skill skill: skills)
            searchSkills.getItems().add(skill.getDescription());
    }

    public void search(ActionEvent actionEvent) {

    }
}
