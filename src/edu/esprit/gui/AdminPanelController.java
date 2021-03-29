/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author ghara
 */
public class AdminPanelController implements Initializable {

    @FXML
    private BorderPane bp;
    @FXML
    private Button btnTerrain;
    @FXML
    private Button btnReservation;
    @FXML
    private Button btArbitre;
    @FXML
    private Button btComp;
    @FXML
    private Button btEquipe;
    @FXML
    private Button btMatch;
    @FXML
    private Button btCompte;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void BtTerrain(ActionEvent event) {
    }

    @FXML
    private void BtReservation(ActionEvent event) {
    }

    @FXML
    private void BtArbitre(ActionEvent event) {
    }

    @FXML
    private void BtCompetition(ActionEvent event) {
    }

    @FXML
    private void BtEquipe(ActionEvent event) {
    }

    @FXML
    private void BtMatch(ActionEvent event) {
    }

    @FXML
    private void BtCompte(ActionEvent event) {
    }
    
}
