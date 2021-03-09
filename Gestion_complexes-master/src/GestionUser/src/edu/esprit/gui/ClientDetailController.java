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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ghara
 */
public class ClientDetailController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfPosition;
    @FXML
    private TextField tfMail;
    @FXML
    private TextField tfTelephone;
    @FXML
    private PasswordField tfMdp;
    @FXML
    private Button btModifier;
    @FXML
    private Button btAcceuil;

    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
    }    

    public void setTfMail(TextField tfMail) {
        this.tfMail = tfMail;
    }

    public void setTfMdp(PasswordField tfMdp) {
        this.tfMdp = tfMdp;
    }

    public void setTfNom(TextField tfNom) {
        this.tfNom = tfNom;
    }

    public void setTfPosition(TextField tfPosition) {
        this.tfPosition = tfPosition;
    }

    public void setTfPrenom(TextField tfPrenom) {
        this.tfPrenom = tfPrenom;
    }

    public void setTfTelephone(TextField tfTelephone) {
        this.tfTelephone = tfTelephone;
    }

    @FXML
    private void Modifier(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("GestionClient.fxml"));
            Parent root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(ClientDetailController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void AfficheAcceuil(ActionEvent event) {
        
        
        
        
        
        
        
        
    }
     
    }    
    

