/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.Proprietaire;
import edu.esprit.services.ProprietaireCrud;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ghara
 */
public class GestionProprietaireController implements Initializable {

    @FXML
    private TextField tfMatricule;
    @FXML
    private TextField tfRaison;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfMdp;
    @FXML
    private Button btRetour;
    @FXML
    private Button btModifier;
    @FXML
    private Button btSupprimer;
   Proprietaire p=new Proprietaire();
  AuthentificationProprietaireController authProp=new AuthentificationProprietaireController();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
           
            
            // TODO
            ProprietaireCrud p=new ProprietaireCrud();
            
            List<Proprietaire> l =new ArrayList<>();
            l=p.readAll();
           for(int i=0;i<l.size();i++){
               
               if(l.get(i).getEmail().equals(authProp.getP().getEmail())){
                   
              
          
            tfMatricule.setText(l.get(i).getMatricule());
            tfRaison.setText(l.get(i).getRaison());
            tfEmail.setText(l.get(i).getRaison());
            tfMdp.setText(l.get(i).getRaison());
             }
                }
               
        } catch (SQLException ex) {
            Logger.getLogger(GestionProprietaireController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        
        
    }

    @FXML
    
    
    
    
    
    private void ModifierInfo(ActionEvent event) throws IOException {
        
        //redirection
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

    public Proprietaire getP() {
        return p;
    }

    public void setP(Proprietaire p) {
        this.p = p;
    }



    
    
}
