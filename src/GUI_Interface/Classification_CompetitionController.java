/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Interface;

import Entitee.Resultats;
import Services.classificationCRUD;
import com.jfoenix.controls.JFXTextField;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import sun.awt.SunHints;
import sun.rmi.transport.Transport;

/**
 * FXML Controller class
 *
 * @author user
 */
public class Classification_CompetitionController implements Initializable {

   @FXML
    private TableView<Resultats> table_liste_resultats;

    
    @FXML
    private TableColumn<Resultats, ?> col_j;
    @FXML
    private TableColumn<Resultats, ?> col_G;
    @FXML
    private TableColumn<Resultats, ?> col_n;
    @FXML
    private TableColumn<Resultats, ?> col_p;
    @FXML
    private TableColumn<Resultats, ?> col_points;
    @FXML
    private PieChart pie_chart;
    @FXML
    private TextField txt_eq;
    @FXML
    private TextField txt_p;
    @FXML
    private TableColumn<Resultats, ?> col_nomeq;
    
      ObservableList<Resultats> listcat;
     ObservableList<Resultats> listM;
     private  ObservableList<PieChart.Data> pich;
    @FXML
    private TextField filterField;
     int index = -1;
    @FXML
    private Button btn_aff;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pich=FXCollections.observableArrayList();
        pie_chart.setData(pich);
        search_user();   
        loadtable();
        
        }    
 @FXML
    void getSelected (MouseEvent event){
    index = table_liste_resultats.getSelectionModel().getSelectedIndex();
    if (index <= -1){
    
        return;
    }
    txt_eq.setText(col_nomeq.getCellData(index).toString());
    txt_p.setText(col_points.getCellData(index).toString());

    }
    void loadtable() {
    
        ObservableList listcat = FXCollections.observableArrayList();
        classificationCRUD tc = new classificationCRUD();
        listcat=(ObservableList) tc.Afficherresultats();
        col_nomeq.setCellValueFactory(new PropertyValueFactory<>("nomeq"));
        col_j.setCellValueFactory(new PropertyValueFactory<>("jouer"));
        col_G.setCellValueFactory(new PropertyValueFactory<>("gagne"));
        col_n.setCellValueFactory(new PropertyValueFactory<>("nulle"));
        col_p.setCellValueFactory(new PropertyValueFactory<>("perdu"));
        col_points.setCellValueFactory(new PropertyValueFactory<>("points"));

        listM = tc.Afficherresultats();
        table_liste_resultats.setItems(listM);
        search_user();   
}
 void search_user() {

        classificationCRUD tc = new classificationCRUD();
        col_nomeq.setCellValueFactory(new PropertyValueFactory<>("nomeq"));
        col_j.setCellValueFactory(new PropertyValueFactory<>("jouer"));
        col_G.setCellValueFactory(new PropertyValueFactory<>("gagne"));
        col_n.setCellValueFactory(new PropertyValueFactory<>("nulle"));
        col_p.setCellValueFactory(new PropertyValueFactory<>("perdu"));
        col_points.setCellValueFactory(new PropertyValueFactory<>("points"));

        listM = tc.Afficherresultats();
        table_liste_resultats.setItems(listM);
        FilteredList<Resultats> filteredData = new FilteredList<>(listM, b -> true);

        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(c -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (c.getNomeq().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;

                }             
                else {
                    return false;
                }
            });
        });

        SortedList<Resultats> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table_liste_resultats.comparatorProperty());
        table_liste_resultats.setItems(sortedData);

    }

    @FXML
    private void btn_aff(ActionEvent event) {
        classificationCRUD tc = new classificationCRUD();
        listcat=(ObservableList) tc.Afficherresultats();
        
        pich.add(new PieChart.Data(txt_eq.getText(),Integer.valueOf(txt_p.getText())));
        pie_chart.setData(pich);
    }


}
