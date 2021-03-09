/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Interface;

import Entitee.Categorie;
import Entitee.Competition;
import Services.CRUD;
import Services.CategorieCrud;
import com.jfoenix.controls.JFXDatePicker;
//import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.dateTime;
//import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
//import sun.util.calendar.BaseCalendar.Date;

/**
 * FXML Controller class
 *
 * @author user
 */
public class Tableview_avec_tous_lesActionsController implements Initializable {

    @FXML
    private TableView<Competition> table_liste_competition;

    @FXML
    private TableColumn<Competition, String> col_desgniation;

    @FXML
    private TableColumn<Competition, String> col_datec;

    @FXML
    private TableColumn<Competition, String> col_dated;

    @FXML
    private TableColumn<Competition, String> col_nbeq;

    @FXML
    private TableColumn<Competition, String> col_catg;

    @FXML
    private TableColumn<Competition, String> col_complex;

    @FXML
    private TableColumn<Competition, String> col_prix;

    @FXML
    private TextField filterField;

    @FXML
    private JFXDatePicker txt_dd;
    @FXML
    private TextField txt_nbeq;

    @FXML
    private TextField txt_comp;
    @FXML
    private TextField txt_des;
    ObservableList listM = FXCollections.observableArrayList();
    ObservableList<Competition> listM2;
    ObservableList<Competition> dataList;
    ObservableList<Categorie> listcat;
    int cat = -1;
    int index = -1;

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    @FXML
    private TextField txt_prix;
    @FXML
    private ComboBox<?> combo;
    private AnchorPane ancheAlert;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UpdateTable();
        CategorieCrud ccc = new CategorieCrud();
        Categorie c1 = ccc.find(1);
        System.out.println(c1);
        ObservableList listcat = FXCollections.observableArrayList();
        listcat = (ObservableList) ccc.AfficherCategories();
        combo.setItems(listcat);
        search_user();
    }

    @FXML
    private void Add_COMP(ActionEvent event) {
        try {
            String des = txt_des.getText();
            String desc = txt_dd.getValue().toString();
            String e = txt_nbeq.getText();
            Categorie ca = (Categorie) combo.getSelectionModel().getSelectedItem();

            String g = txt_comp.getText();
            String z = txt_prix.getText();

            Competition cccc = new Competition(des, desc, e, ca, g, z);
            CRUD tCrud = new CRUD();
            tCrud.Add_COMP(cccc);
            vider();
            UpdateTable();

        } catch (Exception e) {

        }
    }

    public void alerte() {
        Stage stage = (Stage) ancheAlert.getScene().getWindow();
        Alert.AlertType type = Alert.AlertType.INFORMATION;
        Alert alert = new Alert(type, "");
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(stage);
        alert.getDialogPane().setContentText("Tous les champs sont obligatoires !");
        alert.getDialogPane().setHeaderText("Attention !");
        alert.showAndWait();

    }

    public void vider() {
        txt_des.clear();
        txt_nbeq.clear();
        txt_comp.clear();
        txt_prix.clear();

    }

    @FXML
    private void Edit(ActionEvent event) {
        String value1 = txt_des.getText();
        String value2 = txt_dd.getValue().toString();
        String value3 = txt_nbeq.getText();
//            String value4 = txt_catg.getText();
        String value4 = txt_comp.getText();
        String value5 = txt_prix.getText();

        Competition uu = new Competition(value5, value2, value5, value5, value5);
        CRUD pp = new CRUD();
        pp.Edit(uu);

        UpdateTable();
        search_user();

    }

    @FXML
    private void Delete(ActionEvent event) {
        String value1 = txt_des.getText();
        String value2 = txt_dd.getValue().toString();
        String value3 = txt_nbeq.getText();
//            String value3 = combo.getSelectionModel().getSelectedItem().toString();
        String value4 = txt_comp.getText();
        String value5 = txt_prix.getText();
        Competition uu = new Competition(value1, value2, value3, value4, value5);
        CRUD pp = new CRUD();
        pp.Delete(uu);
        UpdateTable();
        search_user();

    }

    @FXML
    void getSelected(MouseEvent event) {
        index = table_liste_competition.getSelectionModel().getSelectedIndex();
        if (index <= -1) {

            return;
        }
        txt_des.setText(col_desgniation.getCellData(index).toString());
        txt_nbeq.setText(col_nbeq.getCellData(index).toString());
//    combo.setSelectionModel(col_catg.getCellData(index).toString());
        txt_comp.setText(col_complex.getCellData(index).toString());
        txt_prix.setText(col_prix.getCellData(index).toString());

    }

    public void UpdateTable() {
        ObservableList listM = FXCollections.observableArrayList();
        CRUD tc = new CRUD();
        col_desgniation.setCellValueFactory(new PropertyValueFactory<Competition, String>("designation"));
        col_datec.setCellValueFactory(new PropertyValueFactory<Competition, String>("date_creation"));
        col_dated.setCellValueFactory(new PropertyValueFactory<Competition, String>("date_debut"));
        col_nbeq.setCellValueFactory(new PropertyValueFactory<Competition, String>("nbre_equipes"));
        col_catg.setCellValueFactory(new PropertyValueFactory<Competition, String>("Categorie"));  
        col_complex.setCellValueFactory(new PropertyValueFactory<Competition, String>("complexe"));
        col_prix.setCellValueFactory(new PropertyValueFactory<Competition, String>("prix_participation"));

        listM = tc.getDatacompetition();
        table_liste_competition.setItems(listM);

    }

    @FXML
    void search_user() {

        CRUD tc = new CRUD();

        col_desgniation.setCellValueFactory(new PropertyValueFactory<Competition, String>("designation"));
        col_datec.setCellValueFactory(new PropertyValueFactory<Competition, String>("date_creation"));
        col_dated.setCellValueFactory(new PropertyValueFactory<Competition, String>("date_debut"));
        col_nbeq.setCellValueFactory(new PropertyValueFactory<Competition, String>("nbre_equipes"));
        col_catg.setCellValueFactory(new PropertyValueFactory<Competition, String>("idcatg"));
        col_complex.setCellValueFactory(new PropertyValueFactory<Competition, String>("complexe"));
        col_prix.setCellValueFactory(new PropertyValueFactory<Competition, String>("prix_participation"));

        dataList = tc.getDatacompetition();
        table_liste_competition.setItems(dataList);
        FilteredList<Competition> filteredData = new FilteredList<>(dataList, b -> true);

        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (person.getDesignation().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;

                } else {
                    return false;
                }
            });
        });

        SortedList<Competition> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table_liste_competition.comparatorProperty());
        table_liste_competition.setItems(sortedData);

    }

}
