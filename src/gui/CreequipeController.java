/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.equipe;
import entities.utilisateur;
import java.io.IOException;
import static java.lang.Math.random;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import services.ServiceEquipe;
import services.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author fachr
 */
public class CreequipeController implements Initializable {
public equipe equipe;
public utilisateur utilisateur;
    @FXML
    private Button cequipe;
    @FXML
    private Button retour;
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
    }

    public utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    @FXML
    private Button requipe;
    @FXML
    private ImageView imageview;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Image image= new Image("/icons/joueur.png");
        imageview.setImage(image);
      
    
        
    }    

    @FXML
    private void ajouterequipe(ActionEvent event) {
        try {
            FXMLLoader loader=new  FXMLLoader(getClass().getResource("detailsequipe.fxml"));
            Parent root=loader.load();
            DetailsequipeController pdc = loader.getController();
            pdc.setUtilisateur(utilisateur);
            cequipe.getScene().setRoot(root);
        } catch (IOException ex) {
        System.out.println(ex.getMessage());    
        }
       
    }

    @FXML
    private void rejoindreequipe(ActionEvent event) {
        try {
            FXMLLoader loader=new  FXMLLoader(getClass().getResource("listequipe.fxml"));
            Parent root=loader.load();
            ListequipeController pdc = loader.getController();
            pdc.setUtilisateur(utilisateur);
            cequipe.getScene().setRoot(root);
        } catch (IOException ex) {
        System.out.println(ex.getMessage());    
        }
    }

    @FXML
    private void frerour(ActionEvent event) {
         try {
            FXMLLoader loader=new  FXMLLoader(getClass().getResource("equipe.fxml"));
            Parent root=loader.load();
           EquipeController pdc = loader.getController();
            pdc.setUtilisateur(utilisateur);
            cequipe.getScene().setRoot(root);
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
