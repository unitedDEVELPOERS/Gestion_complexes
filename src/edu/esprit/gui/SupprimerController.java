/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.Arbitre;
import edu.esprit.entities.Client;
import edu.esprit.entities.Proprietaire;
import edu.esprit.services.ArbitreCrud;
import edu.esprit.services.ClientCrud;
import edu.esprit.services.ProprietaireCrud;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
public class SupprimerController implements Initializable {

    @FXML
    private Button btAnnuler;
    @FXML
    private Button btSupp;
    GestionClientController gestClient;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Afficher(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(
            getClass().getResource("GestionProprietaire.fxml"));
              
                    Parent root;
                try {
                    root = loader.load();
                      btAnnuler.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(SupprimerController.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

    @FXML
    private void Supprimer(ActionEvent event) {
   
        
        try {
            ProprietaireCrud pcd = new ProprietaireCrud();
            Proprietaire p=new Proprietaire(gestClient.getC().getEmail());
            Client c=new Client(gestClient.getC().getEmail());
            ClientCrud ccd = new ClientCrud();
            Arbitre a=new Arbitre(gestClient.getC().getEmail());
            ArbitreCrud acd = new ArbitreCrud();
            
            if("client".equals(gestClient.getC().getRole())){
                
                pcd.supprimer(p);
            }
            else  if("proprietaire".equals(gestClient.getC().getRole())){
                
                ccd.supprimer(c);
            }
            else  if("arbitre".equals(gestClient.getC().getRole())){
                
                acd.supprimer(a);
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SupprimerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
           
        
        
        
    }
    
}
