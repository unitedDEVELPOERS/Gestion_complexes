/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.Client;
import edu.esprit.entities.Proprietaire;
import edu.esprit.services.ClientCrud;
import edu.esprit.services.ProprietaireCrud;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ghara
 */
public class GestionClientController implements Initializable {
ObservableList<String> ListeChoice=FXCollections.observableArrayList("Gardien","Defenseur","Attaquant","Milieu");

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfEmail;
    @FXML
    private Button btRetour;
    @FXML
    private Button btModifier;
    @FXML
    private Button btSupprimer;
    @FXML
    private PasswordField tfMdp;
    @FXML
    private Label tfEquipe;
    @FXML
    private TextField tfTelephone;
    @FXML
    private ChoiceBox<String> tfCategorie;
    Client c=new Client();
    @FXML
    private TextField tfPrenom1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                    
    try {
        // TODO
        ClientCrud p=new ClientCrud();
        
        List<Client> l =new ArrayList<>();
        l=p.readAll();
        tfNom.setText(l.get(0).getNom());
        tfPrenom.setText(l.get(0).getPrenom());
        tfCategorie.setValue(l.get(0).getPosition());
        tfCategorie.setItems(ListeChoice);
        
        tfEmail.setText(l.get(0).getEmail());
        tfMdp.setText(l.get(0).getPwd());
    } catch (SQLException ex) {
        Logger.getLogger(GestionClientController.class.getName()).log(Level.SEVERE, null, ex);
    }
       
    }    

    @FXML
    private void Retour(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource("AcceuilClient.fxml"));
              
                    Parent root;
                try {
                    root = loader.load();
                      tfEmail.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AuthentificationClientController.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

    @FXML
    private void ModifierInfo(ActionEvent event) {
        
         FXMLLoader loader = new FXMLLoader(
            getClass().getResource("Modifier.fxml"));
              
                    Parent root;
                try {
                    root = loader.load();
                      tfEmail.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AuthentificationClientController.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        
    }

    @FXML
    private void SupprimerCompte(ActionEvent event) {
        
        
         FXMLLoader loader = new FXMLLoader(
            getClass().getResource("Supprimer.fxml"));
              
                    Parent root;
                try {
                    root = loader.load();
                      tfEmail.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AuthentificationClientController.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

    public Client getC() {
        return c;
    }

    public void setC(Client c) {
        this.c = c;
    }
    
    
    
     
    
    
    
    
}
