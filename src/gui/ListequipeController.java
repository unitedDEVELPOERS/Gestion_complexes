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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import services.ServiceEquipe;

/**
 * FXML Controller class
 *
 * @author fachr
 */
public class ListequipeController implements Initializable {
ObservableList list =FXCollections.observableArrayList();
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
    }

    public utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    @FXML
    private ListView<String> listequipe;
    @FXML
    private ListView<String> cequipe;
    @FXML
    private Button retour;
    @FXML
    private Button bchercher;
    @FXML
    private TextField chercher;
    @FXML
    private Label idequipechercher;
    @FXML
    private ImageView imageview;
    @FXML
    private Button demande;
    @FXML
    private Label selectequipe;
  public int id;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        selectequipe.setVisible(false);
Image image= new Image("/icons/joueur.png");
         imageview.setImage(image);
        try {
            ServiceEquipe s=new ServiceEquipe();
            List<equipe> l =new ArrayList<>();
            l=s.readAll();
            for(int i=0 ;i<l.size();i++)
            listequipe.getItems().addAll(l.get(i).getNom());
            listequipe.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());        }
    }    
   


    @FXML
    private void retourmenu(ActionEvent event) {
         try {
            FXMLLoader loader=new  FXMLLoader(getClass().getResource("creequipe.fxml"));
            Parent root=loader.load();
            CreequipeController pdc = loader.getController();
            pdc.setUtilisateur(utilisateur);
            cequipe.getScene().setRoot(root);
        } catch (IOException ex) {
        System.out.println(ex.getMessage());    
        }
    }

    @FXML
    private void chercherequipe(ActionEvent event) {
        cequipe.getItems().clear();
        String test=chercher.getText();
         // TODO
          
        try {
            ServiceEquipe s=new ServiceEquipe();
            List<equipe> l =new ArrayList<>();
            l=s.readAll();
            for(int i=0 ;i<l.size();i++){
                if(l.get(i).getNom().equals(test))
            cequipe.getItems().addAll(l.get(i).nom);
            }
            cequipe.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());        }
        
    }


    @FXML
    private void demandeequipe(ActionEvent event) throws SQLException, IOException {
          ObservableList<String> s=cequipe.getSelectionModel().getSelectedItems();
           ObservableList<String> se=    listequipe.getSelectionModel().getSelectedItems();
           
      if(s.isEmpty()&&se.isEmpty()){
        selectequipe.setVisible(true);
    }else if(!s.isEmpty()){
        FXMLLoader loader=new  FXMLLoader(getClass().getResource("verificationboxdemande.fxml"));
            Parent root=loader.load();
          VerificationboxdemandeController pdc = loader.getController();
        selectequipe.setVisible(false);
        ServiceEquipe ser =new ServiceEquipe();
                    
            List<equipe> l =new ArrayList<>();
            l=ser.readAll();
            for(int i=0 ;i<l.size();i++){
                if(l.get(i).getNom().equals(s.get(0))){
                    equipe=l.get(i);
                   pdc.setEquipe(equipe);
                   pdc.setUtilisateur(utilisateur);
                }
                   
                    }
                    
          
            
         
          
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
           stage.setTitle("verification");
           stage.show();
            
        
    }else if(!se.isEmpty()){ try {   FXMLLoader loader=new  FXMLLoader(getClass().getResource("verificationboxdemande.fxml"));
            Parent root=loader.load();
          VerificationboxdemandeController pdc = loader.getController();
        selectequipe.setVisible(false);
        ServiceEquipe ser =new ServiceEquipe();
                    
            List<equipe> l =new ArrayList<>();
            l=ser.readAll();
            for(int i=0 ;i<l.size();i++){
                if(l.get(i).getNom().equals(se.get(0))){
                    equipe=l.get(i);
                  pdc.setEquipe(equipe);
                  pdc.setUtilisateur(utilisateur);
                }
                   
                    }
                    
         
         
          
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
           stage.setTitle("verification");
           stage.show();
            
        } catch (IOException ex) {
        System.out.println(ex.getMessage());    
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

    @FXML
    private void list(ListView.EditEvent<String> event) {
    }
    
}
