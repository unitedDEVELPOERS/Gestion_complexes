/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.Arbitre;
import edu.esprit.services.ArbitreCrud;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ghara
 */
public class ModifierArbitreController implements Initializable {
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
    private Button btAnnuler;
    @FXML
    private Button btEnregistrer;
    @FXML
    private PasswordField tfMdp;
    @FXML
    private ChoiceBox<String> tfCategorie;
    @FXML
    private TextField tfTelephone;
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
            getClass().getResource("GestionArbitre.fxml"));
              
                    Parent root;
                try {
                    root = loader.load();
                      tfCategorie.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AuthentificationClientController.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        
    }

    @FXML
    private void Modifier(ActionEvent event) {
        snom.setVisible(false);
        semail.setVisible(false);
        sprenom.setVisible(false);
        stelephone.setVisible(false);
        smdp.setVisible(false);
      String masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
                        + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
      String email=tfEmail.getText();
            String telephone=tfTelephone.getText();
            String nom=tfNom.getText();
            String prenom=tfPrenom.getText();
            String categorie=(String) tfCategorie.getValue();
            String complexe=tfComplexe.getText();
            String mdp=tfMdp.getText();
              if(nom.isEmpty()){
                  snom.setVisible(true);
                  snom.setText("champ vide");
                  
              } else if(email.isEmpty()){
                  semail.setVisible(true);
            semail.setText("champ vide");

            
        }else if(!email.matches(masque)){
               semail.setVisible(true);
              semail.setText("email incorrect!!");
        }else if(prenom.isEmpty()){
            sprenom.setVisible(true);
            sprenom.setText("champ vide");
        }
        else if(mdp.isEmpty()){
            smdp.setVisible(true);
            smdp.setText("champ vide");
        }else if(telephone.isEmpty()){
            stelephone.setVisible(true);
            stelephone.setText("champ vide");
        }else if (!telephone.matches("[0-9]+"))
        {
              stelephone.setVisible(true);
            stelephone.setText("num incorrect!! ");
        }else if( telephone.length()!=8){
              stelephone.setVisible(true);
            stelephone.setText("8 chiffres");
        }else {
        try {
            ArbitreCrud pcd = new ArbitreCrud();
            
           
            
            
            
           Arbitre p=new Arbitre(email,mdp,telephone,nom,prenom,complexe,categorie);
            
           JOptionPane.showMessageDialog(null, "Voulez-vous vraiment modifier vos informations?");
            pcd.update(p);
            
            
            FXMLLoader loader = new FXMLLoader(
            getClass().getResource("GestionArbitre.fxml"));
              
                    Parent root;
                try {
                    root = loader.load();
                      tfCategorie.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AuthentificationClientController.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SupprimerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
    }}
    
}
