/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.equipe;
import entities.utilisateur;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author fachr
 */
public class VotreequipeController implements Initializable {
public equipe equipe;
public utilisateur utilisateur;
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

    public equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(equipe equipe) {
        this.equipe = equipe;
           Image image= new Image(equipe.logo);
        logo.setImage(image);
        this.nomequipe.setText(equipe.getNom());
    }
    @FXML
    private ImageView logo;
    
    @FXML
    private Button clogo;
    @FXML
    private Button ami;
    @FXML
    private Button cequipe;
    @FXML
    private TextField nomequipe;
    @FXML
    private ImageView joueur;

    public utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public TextField getNomequipe() {
        return nomequipe;
    }

    public void setNomequipe(TextField nomequipe) {
        this.nomequipe = nomequipe;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODOSys
   
     
         Image imagej= new Image("/icons/joueur.png");
         
        joueur.setImage(imagej);
        
        
    }    

    @FXML
    private void changelogo(ActionEvent event) {
       try {
            FXMLLoader loader=new  FXMLLoader(getClass().getResource("Changelogo.fxml"));
            Parent root=loader.load();
          ChangelogoController pdc = loader.getController();
          pdc.setEquipe(equipe);
          pdc.setUtilisateur(utilisateur);
       logo.getScene().setRoot(root);
        } catch (IOException ex) {
        System.out.println(ex.getMessage());    
        }   
        
    }

    @FXML
    private void inviterami(ActionEvent event) {
         try {
            FXMLLoader loader=new  FXMLLoader(getClass().getResource("inviterami.fxml"));
            Parent root=loader.load();
           InviteramiController pdc = loader.getController();
          pdc.setEquipe(equipe);
          pdc.setUtilisateur(utilisateur);
            logo.getScene().setRoot(root);
        } catch (IOException ex) {
        System.out.println(ex.getMessage());    
        }
        
        
    }

    @FXML
    private void choisirequipe(ActionEvent event) throws SQLException {
         try {
              if(utilisateur.getId()==equipe.getCapitain()){
            FXMLLoader loader=new  FXMLLoader(getClass().getResource("creeposition.fxml"));
            Parent root=loader.load();
           CreepositionController pdc = loader.getController();
          pdc.setEquipe(equipe);
          pdc.setUtilisateur(utilisateur);
            nomequipe.getScene().setRoot(root);}else{
                 FXMLLoader loader=new  FXMLLoader(getClass().getResource("equipemembre.fxml"));
            Parent root=loader.load();
           EquipemembreController pdc = loader.getController();
          pdc.setEquipe(equipe);
          pdc.setUtilisateur(utilisateur);
            nomequipe.getScene().setRoot(root);
                 
             }
        } catch (IOException ex) {
        System.out.println(ex.getMessage());    
        }
    }

    @FXML
    private void Acceuil(ActionEvent event) {
    }

    @FXML
    private void Reservation(ActionEvent event) {
    }

    @FXML
    private void Equipe(ActionEvent event) {
    }

    @FXML
    private void Compte(ActionEvent event) {
    }
  
    
}
