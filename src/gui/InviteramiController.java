/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.equipe;
import entities.invitation;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.ServiceEquipe;
import services.ServiceInvitation;
import services.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author fachr
 */
public class InviteramiController implements Initializable {
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
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private Button chercher;
    @FXML
    private Button retour;
    @FXML
    private Button inviter;
    
    @FXML
    private Label tnom;
    @FXML
    private Label temail;
    @FXML
    private Label tprenom;
    @FXML
    private Label tinvi;
    @FXML
    private TableView<utilisateur> table;
    @FXML
    private TableColumn<utilisateur, String> tablenom;
    @FXML
    private TableColumn<utilisateur, String> tableprenom;
    @FXML
    private TableColumn<utilisateur, String> tableposition;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tnom.setVisible(false);
        tprenom.setVisible(false);
        temail.setVisible(false);
        tinvi.setVisible(false);
         try {
            ServiceUtilisateur s=new ServiceUtilisateur();
            List<utilisateur> l =new ArrayList<>();
            l=s.readAll();
            for(int i=0 ;i<l.size();i++)
               list.add(l.get(i));
           tablenom.setCellValueFactory(new PropertyValueFactory<utilisateur,String>("nom"));
            tableprenom.setCellValueFactory(new PropertyValueFactory<utilisateur,String>("prenom"));
            tableposition.setCellValueFactory(new PropertyValueFactory<utilisateur,String>("position"));
            table.setItems(list);
            
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());        }
    }    


    @FXML
    private void fchercher(ActionEvent event) {
        list.clear();
        String name=nom.getText();
       String pre=prenom.getText();
       String mail=email.getText();
          if(name.isEmpty()){
                tnom.setVisible(true);
        tprenom.setVisible(false);
        temail.setVisible(false);
          }else if(pre.isEmpty()){
                tnom.setVisible(false);
        tprenom.setVisible(true);
        temail.setVisible(false);
          }else if(mail.isEmpty()){
                tnom.setVisible(false);
        tprenom.setVisible(false);
        temail.setVisible(true);
          }else{  tnom.setVisible(false);
        tprenom.setVisible(false);
        temail.setVisible(false);
          try {
            ServiceUtilisateur s=new ServiceUtilisateur();
            List<utilisateur> l =new ArrayList<>();
            l=s.readAll();
            for(int i=0 ;i<l.size();i++){
                
              if(name.equals(l.get(i).nom)&&pre.equals(l.get(i).getPrenom())&&mail.equals(l.get(i).getEmail()))
            list.add(l.get(i));
                  }
             tablenom.setCellValueFactory(new PropertyValueFactory<utilisateur,String>("nom"));
            tableprenom.setCellValueFactory(new PropertyValueFactory<utilisateur,String>("prenom"));
            tableposition.setCellValueFactory(new PropertyValueFactory<utilisateur,String>("position"));
            table.setItems(list);
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());        }
        
    }}

    @FXML
    private void fretour(ActionEvent event) throws SQLException {
         try {
              if(utilisateur.getId()==equipe.getCapitain()){
           FXMLLoader loader=new  FXMLLoader(getClass().getResource("votreequipe.fxml"));
            Parent root=loader.load();
            VotreequipeController pdc = loader.getController();
            pdc.setEquipe(equipe);
            pdc.setUtilisateur(utilisateur);
           
            retour.getScene().setRoot(root);}else{
                 FXMLLoader loader=new  FXMLLoader(getClass().getResource("equipemembre.fxml"));
            Parent root=loader.load();
           EquipemembreController pdc = loader.getController();
          pdc.setEquipe(equipe);
          pdc.setUtilisateur(utilisateur);
            retour.getScene().setRoot(root);
                 
             }
           
        } catch (IOException ex) {
        System.out.println(ex.getMessage());    
        }
        
    }

    @FXML
    private void finviter(ActionEvent event) {
        ObservableList<utilisateur> s=table.getSelectionModel().getSelectedItems();
       if(s.isEmpty()){
           tinvi.setVisible(true);
       }else{ tinvi.setVisible(false);
               
                try {
            FXMLLoader loader=new  FXMLLoader(getClass().getResource("verificationbox.fxml"));
            Parent root=loader.load();
          VerificationboxController pdc = loader.getController();
          pdc.setidu(s.get(0).id);
          pdc.setEquipe(equipe);
          pdc.setUtilisateur(utilisateur);
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

    
}
