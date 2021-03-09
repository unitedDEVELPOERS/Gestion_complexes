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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ghara
 */
public class GestionArbitreController implements Initializable {
ObservableList<String> ListeChoice=FXCollections.observableArrayList("FootBall","HandBall","BasketBall","VolleyBall");

    @FXML
    private TextField tfNom;
     @FXML
    private TextField tfComplexe;
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
    private TextField tfEquipe;
    @FXML
    private TextField tfTelephone;
    @FXML
    private ChoiceBox<String> tfCategorie;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
        // TODO
        
        ArbitreCrud p=new ArbitreCrud();
        
        ObservableList<Arbitre> l;
        l=p.getDataArbitre();
        tfNom.setText(l.get(0).getNom());
        tfPrenom.setText(l.get(0).getPrenom());
        tfCategorie.setValue(l.get(0).getCategorie());
        tfCategorie.setItems(ListeChoice);
       
        tfEmail.setText(l.get(0).getEmail());
        tfMdp.setText(l.get(0).getPwd());
    
    }    

    @FXML
    private void Retour(ActionEvent event) {
        
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource("Acceuil.fxml"));
              
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
            getClass().getResource("ModifierArbitre.fxml"));
              
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
         JOptionPane.showMessageDialog(null, "Voulez-vous vraiment supprimer votre compte?");
         
         
         try {
            String mail=tfEmail.getText();
            String telephone=tfTelephone.getText();
            String nom=tfNom.getText();
            String prenom=tfPrenom.getText();
            String categorie=(String) tfCategorie.getValue();
            String complexe=tfComplexe.getText();
            String mdp=tfMdp.getText();
            String role="arbitre";
            Arbitre uu=new Arbitre(mail,role,telephone,nom,prenom,categorie,complexe);
            ArbitreCrud pp=new  ArbitreCrud();
            pp.supprimer(uu);
           FXMLLoader loader = new FXMLLoader(
            getClass().getResource("Acceuil.fxml"));
              
                    Parent root;
                try {
                    root = loader.load();
                      tfEmail.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AuthentificationClientController.class.getName()).log(Level.SEVERE, null, ex);
                }
        
         
//            search_user();
        } catch (SQLException ex) {
            Logger.getLogger(AjouterArbitreController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
         
         
         
         
        /*FXMLLoader loader = new FXMLLoader(
            getClass().getResource("Supprimer.fxml"));
              
                    Parent root;
                try {
                    root = loader.load();
                      tfEmail.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AuthentificationClientController.class.getName()).log(Level.SEVERE, null, ex);
                }*/
    }
    
}
