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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
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
import javafx.stage.Stage;
import services.ServiceEquipe;
import services.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author fachr
 */
public class ModifierequipeController implements Initializable {
 public equipe equipe;
public utilisateur utilisateur;
    @FXML
    private Label nomexistedeja;
    @FXML
    private Label nominvalid;
    @FXML
    private Label min;
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
         nomequipe.setText(equipe.getNom().toUpperCase());
           Image image= new Image(equipe.logo);
        logo.setImage(image);
    }

    public utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    @FXML
    private ImageView logo;
    @FXML
    private Button clogo;
    @FXML
    private TextField nomequipe;
    @FXML
    private TextField nommodifier;
    @FXML
    private TextField nbrjoueur;
    @FXML
    private Button retour;
    @FXML
    private Button confirmer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nomexistedeja.setVisible(false);
        nominvalid.setVisible(false);
        min.setVisible(false);
        max.setVisible(false);
    }    

    @FXML
    private void changelogo(ActionEvent event) {
         try {
            FXMLLoader loader=new  FXMLLoader(getClass().getResource("changelogo2.fxml"));
            Parent root=loader.load();
          Changelogo2Controller pdc = loader.getController();
          pdc.setEquipe(equipe);
          pdc.setUtilisateur(utilisateur);
       logo.getScene().setRoot(root);
        } catch (IOException ex) {
        System.out.println(ex.getMessage());    
        }   
    }

    @FXML
    private void fretour(ActionEvent event) throws SQLException {
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
    private void fconfirmer(ActionEvent event) throws SQLException, IOException {
         boolean found=false;
         String nom=nommodifier.getText();
         String nbrj=nbrjoueur.getText();
        ServiceEquipe s=new ServiceEquipe();
            List<equipe> l =new ArrayList<>();
        
            l=s.readAll();
            for(int i=0 ;i<l.size();i++){
                if(l.get(i).nom.equals(nom)){
                    found=true;
                }
                }
            if(nom.isEmpty()){
                nomexistedeja.setVisible(false);
                nominvalid.setVisible(true);
                min.setVisible(false);
                max.setVisible(false);
            }else if(found){
                nomexistedeja.setVisible(true);
                nominvalid.setVisible(false);
                min.setVisible(false);
                max.setVisible(false);
            }else{  nomexistedeja.setVisible(false);
            nominvalid.setVisible(false);
            if(nbrj.isEmpty()){min.setVisible(true);
            max.setVisible(true);}
            int nbr =Integer.parseInt(nbrjoueur.getText());
            
            if(nbr<6||nbr>12){ nomexistedeja.setVisible(false);
            nominvalid.setVisible(false);
            min.setVisible(true);
            max.setVisible(true);
            }
            else {
                
                equipe.setNom(nom);
                equipe.setNbre_joueur(nbr);
                ServiceEquipe r=new ServiceEquipe();
                
                
                r.update(equipe);
                
                
                
                FXMLLoader loader=new  FXMLLoader(getClass().getResource("confirmermodification.fxml"));
                Parent root=loader.load();
                
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("verification");
                stage.show();
                
                
                
                
                
            }
            
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
