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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import services.ServiceInvitation;
import services.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author fachr
 */
public class DemandeequipeController implements Initializable {
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
        ServiceInvitation in =new ServiceInvitation();
        ServiceUtilisateur ut=new ServiceUtilisateur();
        
    try {
        List<invitation> li= in.readAll();
        List<utilisateur> lu=ut.readAll();
        for(int i=0;i<li.size();i++){
            if(li.get(i).getEquipe()==equipe.getId()&&li.get(i).getType().equals("demande")&&li.get(i).getValide()==0){
                for(int j=0;j<lu.size();j++){
                    if(li.get(i).getUtilisateur()==lu.get(j).getId()){
                        list.add(lu.get(j));
                    }
                }
            }
        }
         nom.setCellValueFactory(new PropertyValueFactory<utilisateur,String>("nom"));
            prenom.setCellValueFactory(new PropertyValueFactory<utilisateur,String>("prenom"));
            position.setCellValueFactory(new PropertyValueFactory<utilisateur,String>("position"));
            tableinvitation.setItems(list);
    } catch (SQLException ex) {
        Logger.getLogger(DemandeequipeController.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }

    public utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    @FXML
    private TableView<utilisateur> tableinvitation;
    @FXML
    private TableColumn<utilisateur, String> nom;
    @FXML
    private TableColumn<utilisateur, String> prenom;
    @FXML
    private TableColumn<utilisateur, String> position;
    @FXML
    private Button chercher;
    @FXML
    private TextField tnom;
    @FXML
    private TextField tprenom;
    @FXML
    private Button refresh;
    @FXML
    private Button retour;
    @FXML
    private Button accepter;
    @FXML
    private Label nominvalide;
    @FXML
    private Label prenominvalide;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
       testaccepter.setVisible(false);
        prenominvalide.setVisible(false);
        nominvalide.setVisible(false);
        
    }    

    @FXML
    private void fchercher(ActionEvent event) {
        list.clear();
        String name=tnom.getText();
       String pre=tprenom.getText();
       
          if(name.isEmpty()){
                prenominvalide.setVisible(false);
        nominvalide.setVisible(true);
       
          }else if(pre.isEmpty()){
                 prenominvalide.setVisible(true);
        nominvalide.setVisible(false);
          }else{  prenominvalide.setVisible(false);
        nominvalide.setVisible(false);
        
           ServiceInvitation in =new ServiceInvitation();
        ServiceUtilisateur ut=new ServiceUtilisateur();
        
    try {
        List<invitation> li= in.readAll();
        List<utilisateur> lu=ut.readAll();
        for(int i=0;i<li.size();i++){
            if(li.get(i).getEquipe()==equipe.getId()&&li.get(i).getType().equals("demande")&&li.get(i).getValide()==0){
                for(int j=0;j<lu.size();j++){
                    if(li.get(i).getUtilisateur()==lu.get(j).getId()&&name.equals(lu.get(j).nom)&&pre.equals(lu.get(j).getPrenom())){
                        list.add(lu.get(j));
                    }
                }
            }
        }
              nom.setCellValueFactory(new PropertyValueFactory<utilisateur,String>("nom"));
            prenom.setCellValueFactory(new PropertyValueFactory<utilisateur,String>("prenom"));
            position.setCellValueFactory(new PropertyValueFactory<utilisateur,String>("position"));
            tableinvitation.setItems(list);
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());        }
        
    }
        
        
    }

    @FXML
    private void frefresh(ActionEvent event) {
        list.clear();
        testaccepter.setVisible(false);
          prenominvalide.setVisible(false);
        nominvalide.setVisible(false);
        ServiceInvitation in =new ServiceInvitation();
        ServiceUtilisateur ut=new ServiceUtilisateur();
        
    try {
        List<invitation> li= in.readAll();
        List<utilisateur> lu=ut.readAll();
        for(int i=0;i<li.size();i++){
            if(li.get(i).getEquipe()==equipe.getId()&&li.get(i).getType().equals("demande")&&li.get(i).getValide()==0){
                for(int j=0;j<lu.size();j++){
                    if(li.get(i).getUtilisateur()==lu.get(j).getId()){
                        list.add(lu.get(j));
                    }
                }
            }
        }
         nom.setCellValueFactory(new PropertyValueFactory<utilisateur,String>("nom"));
            prenom.setCellValueFactory(new PropertyValueFactory<utilisateur,String>("prenom"));
            position.setCellValueFactory(new PropertyValueFactory<utilisateur,String>("position"));
            tableinvitation.setItems(list);
    } catch (SQLException ex) {
        Logger.getLogger(DemandeequipeController.class.getName()).log(Level.SEVERE, null, ex);
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
            testaccepter.getScene().setRoot(root);}else{
                 FXMLLoader loader=new  FXMLLoader(getClass().getResource("equipemembre.fxml"));
            Parent root=loader.load();
           EquipemembreController pdc = loader.getController();
          pdc.setEquipe(equipe);
          pdc.setUtilisateur(utilisateur);
            testaccepter.getScene().setRoot(root);
                 
             }
        } catch (IOException ex) {
        System.out.println(ex.getMessage());    
        }
    }

    @FXML
    private void faccepter(ActionEvent event) throws SQLException {
        ObservableList<utilisateur> s=tableinvitation.getSelectionModel().getSelectedItems();
       if(s.isEmpty()){
           testaccepter.setVisible(true);
       }else{ testaccepter.setVisible(false);
               ServiceInvitation in =new ServiceInvitation();
               List<invitation> li= in.readAll();
               for(int i=0;i<li.size();i++){
            if(li.get(i).getEquipe()==equipe.getId()&&li.get(i).getType().equals("demande")&&li.get(i).getValide()==0&&li.get(i).getUtilisateur()==s.get(0).getId()){
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
          ObservableList<utilisateur> s=tableinvitation.getSelectionModel().getSelectedItems();
       if(s.isEmpty()){
           testaccepter.setVisible(true);
       }else{ testaccepter.setVisible(false);
               ServiceInvitation in =new ServiceInvitation();
               List<invitation> li= in.readAll();
               for(int i=0;i<li.size();i++){
            if(li.get(i).getEquipe()==equipe.getId()&&li.get(i).getType().equals("demande")&&li.get(i).getValide()==0&&li.get(i).getUtilisateur()==s.get(0).getId()){
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
