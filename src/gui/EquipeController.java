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
import services.ServiceEquipe;
import services.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author fachr
 */
public class EquipeController implements Initializable {
    public equipe equipe;
public utilisateur utilisateur;
    @FXML
    private Button listrequest;
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
    private Button votreequipe;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
              ServiceUtilisateur s=new ServiceUtilisateur();
    try {
        List <utilisateur> l=s.readAll();
        this.setUtilisateur(l.get(6));
        System.out.println(utilisateur);
                
       
    } catch (SQLException ex) {
        Logger.getLogger(CreequipeController.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }    

    @FXML
    private void fvotreequipe(ActionEvent event) throws SQLException {
        if(utilisateur.getEquipe()==0){
          try {
            FXMLLoader loader=new  FXMLLoader(getClass().getResource("creequipe.fxml"));
            Parent root=loader.load();
           CreequipeController pdc = loader.getController();
          pdc.setEquipe(equipe);
          pdc.setUtilisateur(utilisateur);
            votreequipe.getScene().setRoot(root);
        } catch (IOException ex) {
        System.out.println(ex.getMessage());    
        }
        
        }else{
        
         try {
             ServiceEquipe se= new ServiceEquipe();
             List<equipe> eq=se.readAll();
             for(int i=0;i<eq.size();i++){
                 if(eq.get(i).getId()==utilisateur.getEquipe())
                     this.setEquipe(eq.get(i));
             }
             if(utilisateur.getId()==equipe.getCapitain()){
            FXMLLoader loader=new  FXMLLoader(getClass().getResource("creeposition.fxml"));
            Parent root=loader.load();
           CreepositionController pdc = loader.getController();
          pdc.setEquipe(equipe);
          pdc.setUtilisateur(utilisateur);
            votreequipe.getScene().setRoot(root);}else{
                 FXMLLoader loader=new  FXMLLoader(getClass().getResource("equipemembre.fxml"));
            Parent root=loader.load();
           EquipemembreController pdc = loader.getController();
          pdc.setEquipe(equipe);
          pdc.setUtilisateur(utilisateur);
            votreequipe.getScene().setRoot(root);
                 
             }
        } catch (IOException ex) {
        System.out.println(ex.getMessage());    
        }
        }
    }

    @FXML
    private void flistrequest(ActionEvent event) throws SQLException {
         try {
            FXMLLoader loader=new  FXMLLoader(getClass().getResource("requestequipe.fxml"));
            Parent root=loader.load();
        RequestequipeController pdc = loader.getController();
          pdc.setEquipe(equipe);
          pdc.setUtilisateur(utilisateur);
            votreequipe.getScene().setRoot(root);
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
