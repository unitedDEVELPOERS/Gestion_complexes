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
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
public class ModifierClientController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfEmail;
    @FXML
    private Button btAnnuler;
    @FXML
    private Button btEnregistrer;
    @FXML
    private PasswordField tfMdp;
    @FXML
    private ChoiceBox<?> tfCategorie;
    @FXML
    private TextField tfTelephone;
    @FXML
    private TextField tfComplexe;
    @FXML
    private Label snom;
    @FXML
    private Label sprenom;
    @FXML
    private Label semail;
    @FXML
    private Label smdp;
    @FXML
    private Label stelephone;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         try {
           
            
            // TODO
            ClientCrud p=new ClientCrud();
            
            List<Client> l =new ArrayList<>();
            l=p.readAll();
           for(int i=0;i<l.size();i++){
               
              
                   
              
          
            tfNom.setText(l.get(i).getNom());
            tfPrenom.setText(l.get(i).getPrenom());
            tfTelephone.setText(l.get(i).getTelephone());
            tfEmail.setText(l.get(i).getEmail());
            tfMdp.setText(l.get(i).getPwd());
            
             }
                
               
        } catch (SQLException ex) {
            Logger.getLogger(GestionProprietaireController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void Retour(ActionEvent event) {
    }

    @FXML
    private void Modifier(ActionEvent event) {
    }
    
}
