/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.equipe;
import entities.invitation;
import entities.matche;
import entities.utilisateur;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.ServiceEquipe;
import services.ServiceInvitation;
import services.ServiceMatche;

/**
 * FXML Controller class
 *
 * @author fachr
 */
public class AccepterdefiController implements Initializable {
ObservableList listt =FXCollections.observableArrayList();
ObservableList listte =FXCollections.observableArrayList();
 public equipe equipe;
 public utilisateur utilisateur; 
    @FXML
    private TableView<equipe> list1;
    @FXML
    private TableColumn<equipe, String> date1;

    public equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(equipe equipe) throws SQLException {
        this.equipe = equipe;
        ServiceMatche sm=new ServiceMatche();
        ServiceEquipe se=new ServiceEquipe();
        List<matche> l=new ArrayList<>();
        l=sm.readAll();
        List<equipe> le=new ArrayList();
        le=se.readAll();
        for(int i=0;i<l.size();i++){
            if(equipe.getId()==l.get(i).getEquipe2()&&l.get(i).getValide()==0){
                listt.add(l.get(i));
                for(int j=0;j<le.size();j++){
                    if(le.get(j).getId()==l.get(i).getEquipe1()){
                        listte.add(le.get(j));
                    }
                }
            }
        }
            date1.setCellValueFactory(new PropertyValueFactory<equipe,String>("nom"));
          
            list1.setItems(listte);
            date.setCellValueFactory(new PropertyValueFactory<matche,String>("date_match"));
          
            list.setItems(listt);
            
    }

    public utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
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
    @FXML
    private Button accepter;
    @FXML
    private Button refuser;
    @FXML
    private Button retour;
    @FXML
    private TableView<matche> list;
    @FXML
    private TableColumn<matche, String> date;
   

    @FXML
    private Label testequipe;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
      
        testequipe.setVisible(false);
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
    private void faccepter(ActionEvent event) throws SQLException {
            ObservableList<matche> s=list.getSelectionModel().getSelectedItems();
       if(s.isEmpty()){
           testequipe.setVisible(true);
       }else{ testequipe.setVisible(false);
          
              ServiceMatche sm=new ServiceMatche();
              List<matche> lm=new ArrayList();
              lm=sm.readAll();
              for(int i=0;i<lm.size();i++){
                  if(s.get(0).getId()==lm.get(i).getId()){
                  lm.get(i).setValide(1);
                  
                  sm.update(lm.get(i));}
              }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Accepter defi");
alert.setHeaderText("vous avez Accepter une Defi ");
alert.setContentText("Date : "+s.get(0).getDate_match());

alert.showAndWait();
            
       }
        
    }

    @FXML
    private void frefuser(ActionEvent event) throws SQLException {
           ObservableList<matche> s=list.getSelectionModel().getSelectedItems();
       if(s.isEmpty()){
           testequipe.setVisible(true);
       }else{ testequipe.setVisible(false);
              ServiceMatche sm=new ServiceMatche();
              List<matche> lm=new ArrayList();
               lm=sm.readAll();
              for(int i=0;i<lm.size();i++){
                  if(s.get(0).getId()==lm.get(i).getId()){
                  lm.get(i).setValide(-1);
                  sm.update(lm.get(i));}
              }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Refuser defi");
alert.setHeaderText("vous avez Refuser une Defi ");
alert.setContentText("Date : "+s.get(0).getDate_match());

alert.showAndWait();
    }}

    @FXML
    private void fretour(ActionEvent event) throws SQLException {
         try {
            if(utilisateur.getId()==equipe.getCapitain()){
            FXMLLoader loader=new  FXMLLoader(getClass().getResource("creeposition.fxml"));
            Parent root=loader.load();
           CreepositionController pdc = loader.getController();
          pdc.setEquipe(equipe);
          pdc.setUtilisateur(utilisateur);
            testequipe.getScene().setRoot(root);}else{
                 FXMLLoader loader=new  FXMLLoader(getClass().getResource("equipemembre.fxml"));
            Parent root=loader.load();
           EquipemembreController pdc = loader.getController();
          pdc.setEquipe(equipe);
          pdc.setUtilisateur(utilisateur);
            testequipe.getScene().setRoot(root);
                 
             }
        } catch (IOException ex) {
        System.out.println(ex.getMessage());    
        }
    }

 
    
}
