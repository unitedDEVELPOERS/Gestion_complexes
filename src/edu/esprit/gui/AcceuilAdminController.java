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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ghara
 */
public class AcceuilAdminController implements Initializable {

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
    @FXML
    private Button btDeco;
    @FXML
    private Button btMatch2;
    @FXML
    private TextField tfRaison;
    @FXML
    private TextField tfMatricule;
    @FXML
    private TextField tfEmail;
    @FXML
    private PasswordField tfMdp;
    @FXML
    private TextField tfMdp1;
    @FXML
    private TableView<?> table_liste_arbitre;
    @FXML
    private TableColumn<?, ?> col_email;
    @FXML
    private TableColumn<?, ?> col_telephone;
    @FXML
    private TableColumn<?, ?> col_nom;
    @FXML
    private TableColumn<?, ?> col_prenom;

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

    @FXML
    private void Deconnecter(ActionEvent event) {
    }

    @FXML
    private void getSelected(MouseEvent event) {
    }
    
}
