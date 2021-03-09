/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Match;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import services.PlanningCRUD;

/**
 * FXML Controller class
 *
 * @author bezin
 */
public class PlanningController implements Initializable {

    @FXML
    private TextField tfDateMatch;
    @FXML
    private TextField tfTerrain;
    @FXML
    private TextField tfResuEq1;
    @FXML
    private Button Modifier;
    @FXML
    private Button Supprimer;
    ObservableList<Match> listM;
    @FXML
    private TableView<?> tableV;
    @FXML
    private TextField tfResuEq2;
    ObservableList<Match> ListM;
    @FXML
    private TableColumn<?, ?> idColumn;
    @FXML
    private TableColumn<?, ?> dateMatchColumn;
    @FXML
    private TableColumn<?, ?> terrainColumn;
    @FXML
    private TableColumn<?, ?> RE1Column;
    @FXML
    private TableColumn<?, ?> RE2Column;
    @FXML
    private TableColumn<?, ?> PvColumn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableView.getColumns().addll()
    }    
   


    private void Affichier(ActionEvent event) {
        updateTable();
    }

    private void Modifier(ActionEvent event) {
        String dateM = tfDateMatch.getText();
        String terrain = tfTerrain.getText();
        String rsulEq1 = tfResuEq1.getText();
        String rsulEq2 = tfResuEq2.getText();

        //Match a = new Match(tableV.getSelectionModel().getSelectedItem().getId(), name, Pre, Categ, Compl);
        PlanningCRUD A = new PlanningCRUD();
        //A.modifier(a);
        updateTable();
        Suppression();
        
    }

    public void Suppression() {
        tfDateMatch.clear();
        tfTerrain.clear();
        tfResuEq1.clear();
        tfResuEq2.clear();

    }
    private void Supprimer(ActionEvent event) {
       PlanningCRUD a = new PlanningCRUD();
       PlanningCRUD A = new PlanningCRUD();
        A.supprimer(tableV.getSelectionModel().getSelectedItem().getId());
        updateTable();
        Suppression();
     
    
    }

    private void updateTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
