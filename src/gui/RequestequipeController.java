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
public class RequestequipeController implements Initializable {

   ObservableList list =FXCollections.observableArrayList();
 public equipe equipe;
 public utilisateur utilisateur; 
 public invitation invitation;
    @FXML
    private Button refuse;
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

    public invitation getInvitation() {
        return invitation;
    }

    public void setInvitation(invitation invitation) {
        this.invitation = invitation;
    }
    @FXML
    private Label testaccepter;

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
        ServiceInvitation in =new ServiceInvitation();
        ServiceEquipe ut=new ServiceEquipe();
        
    try {
        List<invitation> li= in.readAll();
        List<equipe> lu=ut.readAll();
        for(int i=0;i<li.size();i++){
            if(li.get(i).getUtilisateur()==utilisateur.getId()&&li.get(i).getType().equals("request")&&li.get(i).getValide()==0){
                for(int j=0;j<lu.size();j++){
                    if(li.get(i).getEquipe()==lu.get(j).getId()){
                        list.add(lu.get(j));
                    }
                }
            }
        }
         nom.setCellValueFactory(new PropertyValueFactory<equipe,String>("nom"));
            
            tableinvitation.setItems(list);
    } catch (SQLException ex) {
        Logger.getLogger(DemandeequipeController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    @FXML
    private TableView<equipe> tableinvitation;
    @FXML
    private TableColumn<equipe, String> nom;
    
    @FXML
    private Button chercher;
    @FXML
    private TextField tnom;

    @FXML
    private Button refresh;
    @FXML
    private Button retour;
    @FXML
    private Button accepter;
    @FXML
    private Label nominvalide;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
       testaccepter.setVisible(false);
     
        nominvalide.setVisible(false);
        
    }    

    @FXML
    private void fchercher(ActionEvent event) {
        list.clear();
        String name=tnom.getText();
       
       
          if(name.isEmpty()){
                
        nominvalide.setVisible(true);
       
          }else{  
        nominvalide.setVisible(false);
        
           ServiceInvitation in =new ServiceInvitation();
        ServiceEquipe ut=new ServiceEquipe();
        
    try {
        List<invitation> li= in.readAll();
        List<equipe> lu=ut.readAll();
        for(int i=0;i<li.size();i++){
             if(li.get(i).getUtilisateur()==utilisateur.getId()&&li.get(i).getType().equals("request")&&li.get(i).getValide()==0){
                for(int j=0;j<lu.size();j++){
                    if(li.get(i).getEquipe()==lu.get(j).getId()&&name.equals(lu.get(j).nom)){
                        list.add(lu.get(j));
                    }
                }
            }
        }
              nom.setCellValueFactory(new PropertyValueFactory<equipe,String>("nom"));
           
            tableinvitation.setItems(list);
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());        }
        
    }
        
        
    }

    @FXML
    private void frefresh(ActionEvent event) {
        list.clear();
        testaccepter.setVisible(false);
        
        nominvalide.setVisible(false);
         ServiceInvitation in =new ServiceInvitation();
        ServiceEquipe ut=new ServiceEquipe();
        
    try {
        List<invitation> li= in.readAll();
        List<equipe> lu=ut.readAll();
        for(int i=0;i<li.size();i++){
            if(li.get(i).getUtilisateur()==utilisateur.getId()&&li.get(i).getType().equals("request")&&li.get(i).getValide()==0){
                for(int j=0;j<lu.size();j++){
                    if(li.get(i).getEquipe()==lu.get(j).getId()){
                        list.add(lu.get(j));
                    }
                }
            }
        }
         nom.setCellValueFactory(new PropertyValueFactory<equipe,String>("nom"));
            
            tableinvitation.setItems(list);
    } catch (SQLException ex) {
        Logger.getLogger(DemandeequipeController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @FXML
    private void fretour(ActionEvent event) throws SQLException {
          try {
            FXMLLoader loader=new  FXMLLoader(getClass().getResource("equipe.fxml"));
            Parent root=loader.load();
           EquipeController pdc = loader.getController();
          pdc.setEquipe(equipe);
          pdc.setUtilisateur(utilisateur);
         list.clear();
            retour.getScene().setRoot(root);
        } catch (IOException ex) {
        System.out.println(ex.getMessage());    
        }
    }

    @FXML
    private void faccepter(ActionEvent event) throws SQLException {
        ObservableList<equipe> s=tableinvitation.getSelectionModel().getSelectedItems();
       if(s.isEmpty()){
           testaccepter.setVisible(true);
       }else{ testaccepter.setVisible(false);
               ServiceInvitation in =new ServiceInvitation();
               List<invitation> li= in.readAll();
               for(int i=0;i<li.size();i++){
            if(li.get(i).getUtilisateur()==utilisateur.getId()&&li.get(i).getType().equals("request")&&li.get(i).getValide()==0&&li.get(i).getEquipe()==s.get(0).getId()){
                invitation=li.get(i);
                }
            }
        
                try {
            FXMLLoader loader=new  FXMLLoader(getClass().getResource("verificationdemandeinvitation.fxml"));
            Parent root=loader.load();
          VerificationdemandeinvitationController pdc = loader.getController();
          pdc.setInvitation(invitation);
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
    private void frefuse(ActionEvent event) throws SQLException {
          ObservableList<equipe> s=tableinvitation.getSelectionModel().getSelectedItems();
       if(s.isEmpty()){
           testaccepter.setVisible(true);
       }else{ testaccepter.setVisible(false);
               ServiceInvitation in =new ServiceInvitation();
               List<invitation> li= in.readAll();
               for(int i=0;i<li.size();i++){
            if(li.get(i).getUtilisateur()==utilisateur.getId()&&li.get(i).getType().equals("request")&&li.get(i).getValide()==0&&li.get(i).getEquipe()==s.get(0).getId()){
                invitation=li.get(i);
                }
            }
        
                try {
            FXMLLoader loader=new  FXMLLoader(getClass().getResource("verificationdemandeinvitationrefus.fxml"));
            Parent root=loader.load();
          VerificationdemandeinvitationrefusController pdc = loader.getController();
          pdc.setInvitation(invitation);
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
