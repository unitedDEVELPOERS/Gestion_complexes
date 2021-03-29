/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import API.SendMail;
import entities.equipe;
import entities.invitation;
import entities.utilisateur;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.mail.MessagingException;
import services.ServiceInvitation;

/**
 * FXML Controller class
 *
 * @author fachr
 */
public class VerificationboxdemandeController implements Initializable {
 
  public equipe equipe;
public utilisateur utilisateur;

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
    private Button oui;
    @FXML
    private Button non;
    @FXML
    private ImageView vert;
    @FXML
    private ImageView red;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Image image= new Image("/icons/vert.png");
         vert.setImage(image);
            Image image1= new Image("/icons/rouge.png");
         red.setImage(image1);
         
    }    

    @FXML
    private void boui(ActionEvent event) {
         ServiceInvitation si= new ServiceInvitation();
                invitation i =new invitation(equipe.getId(),utilisateur.getId(),"demande");
        try {
            si.ajouter(i);
        } catch (SQLException ex) {
            Logger.getLogger(VerificationboxController.class.getName()).log(Level.SEVERE, null, ex);
        }
            try {
                     SendMail.mail("f.achref@live.fr",this.utilisateur.getNom(),2);
                 } catch (MessagingException ex) {
                     Logger.getLogger(DetailsequipeController.class.getName()).log(Level.SEVERE, null, ex);
                 }
        Stage stage=(Stage)oui.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void bnon(ActionEvent event) {
        Stage stage=(Stage)oui.getScene().getWindow();
        stage.close();
    }
    
}
