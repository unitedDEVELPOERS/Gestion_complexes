/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author ghara
 */
public class AcceuilController implements Initializable {

    private Button login;
    @FXML
    private Button btAcceuil;
    @FXML
    private Button btReservation;
    @FXML
    private Button btEquipe;
    @FXML
    private Button btBoutique;
    @FXML
    private Button btCompte;
    @FXML
    private Button btfoot;
    @FXML
    private Button bthand;
    @FXML
    private Button btbasket;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Login(ActionEvent event) {
        
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource("AuthentificationClient.fxml"));
              
                    Parent root;
                try {
                    root = loader.load();
                      btCompte.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AuthentificationClientController.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        
    }

   

  

    @FXML
    private void Acceuil(ActionEvent event) {
    }

    @FXML
    private void Reservation(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource("AuthentificationClient.fxml"));
              
                    Parent root;
                try {
                    root = loader.load();
                      btAcceuil.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AuthentificationClientController.class.getName()).log(Level.SEVERE, null, ex);
                }
        
    }

    @FXML
    private void Complexe(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource("AuthentificationProprietaire.fxml"));
              
                    Parent root;
                try {
                    root = loader.load();
                      btAcceuil.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AuthentificationClientController.class.getName()).log(Level.SEVERE, null, ex);
                }
        
    }

    @FXML
    private void boutique(ActionEvent event) {
       FXMLLoader loader = new FXMLLoader(
            getClass().getResource("AuthentificationClient.fxml"));
              
                    Parent root;
                try {
                    root = loader.load();
                      btAcceuil.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AuthentificationClientController.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

    @FXML
    private void foot(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource("AuthentificationClient.fxml"));
              
                    Parent root;
                try {
                    root = loader.load();
                      btAcceuil.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AuthentificationClientController.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

    @FXML
    private void hand(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource("AuthentificationClient.fxml"));
              
                    Parent root;
                try {
                    root = loader.load();
                      btAcceuil.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AuthentificationClientController.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

    @FXML
    private void basket(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource("AuthentificationClient.fxml"));
              
                    Parent root;
                try {
                    root = loader.load();
                      btAcceuil.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AuthentificationClientController.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
}
