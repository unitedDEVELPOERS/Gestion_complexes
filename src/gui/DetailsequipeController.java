/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import API.SendMail;
import entities.equipe;
import entities.utilisateur;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.mail.MessagingException;
import services.ServiceEquipe;
import services.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author fachr
 */
public class DetailsequipeController implements Initializable {
public equipe equipe;
public utilisateur utilisateur;
    @FXML
    private TextField Nomequipe;
    @FXML
    private TextField Nbrjoueurs;
    @FXML
    private Label cnbr;
    @FXML
    private Button retour;
    @FXML
    private Label cnom;
    @FXML
    private Label cnom1;
    @FXML
    private ImageView imageview;
    @FXML
    private Label max;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cnbr.setVisible(false);
        cnom.setVisible(false);
        cnom1.setVisible(false);
        max.setVisible(false);
         Image image= new Image("/icons/joueur.png");
         imageview.setImage(image);
    }    

    @FXML
    private void ajouterequipe(ActionEvent event) throws SQLException, IOException {
        boolean found=false;
         String nom=Nomequipe.getText();
         String nbrj=Nbrjoueurs.getText();
        ServiceEquipe s=new ServiceEquipe();
            List<equipe> l =new ArrayList<>();
        
            l=s.readAll();
            for(int i=0 ;i<l.size();i++){
                if(l.get(i).nom.equals(nom)){
                    found=true;
                }
                }
        
            
                  
        try {
           
             if(nom.isEmpty()){
                 cnbr.setVisible(false);
                 cnom1.setVisible(false);
                  cnom.setVisible(true);
                  max.setVisible(false);
             }else if(found){
                 cnbr.setVisible(false);
                 cnom.setVisible(false);
                  cnom1.setVisible(true);
                  max.setVisible(false);
             }else{cnom.setVisible(false);cnom1.setVisible(false);
             if(nbrj.isEmpty()){cnbr.setVisible(true);max.setVisible(true);}
             int nbr =Integer.parseInt(Nbrjoueurs.getText());
             
             if(nbr<6||nbr>12){cnom.setVisible(false);
                  cnom1.setVisible(false);
                 max.setVisible(true);
                 cnbr.setVisible(true);
             }
             else {
            equipe e=new equipe(nom,nbr,"/icons/vector1.png",utilisateur.getId());
            
            ServiceEquipe r=new ServiceEquipe();
            r.ajouter(e);
           List<equipe> le=r.readAll();
              
           for(int x=0;x<le.size();x++){
               
              if(le.get(x).getNom().equals(nom))
               {this.setEquipe(le.get(x));
               
               }
               }
         
           utilisateur.setEquipe(equipe.getId());
           ServiceUtilisateur su=new ServiceUtilisateur();
           su.updateequipe(utilisateur);
           
                 try {
                     SendMail.mail("f.achref@live.fr",this.equipe.getNom(),0);
                 } catch (MessagingException ex) {
                     Logger.getLogger(DetailsequipeController.class.getName()).log(Level.SEVERE, null, ex);
                 }
              FXMLLoader loader=new  FXMLLoader(getClass().getResource("votreequipe.fxml"));
            Parent root=loader.load();
            VotreequipeController pdc = loader.getController();
            pdc.setUtilisateur(utilisateur);
            pdc.setEquipe(equipe);
            
            retour.getScene().setRoot(root);
        
       
             
             
             
             
             
             
             }
            
             }} catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
       
    }

    @FXML
    private void retourmmenu(ActionEvent event) {
         try {
            FXMLLoader loader=new  FXMLLoader(getClass().getResource("creequipe.fxml"));
            Parent root=loader.load();
            CreequipeController pdc = loader.getController();
            pdc.setUtilisateur(utilisateur);
            retour.getScene().setRoot(root);
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
