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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import services.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author fachr
 */
public class EquipemembreController implements Initializable {

 ObservableList list =FXCollections.observableArrayList();
 public equipe equipe;
 
    @FXML
    private ImageView terrain;
    @FXML
    private Label NGK;
    @FXML
    private Label NDD1;
    @FXML
    private Label NDD2;
    @FXML
    private Label NMID1;
    @FXML
    private Label NMID2;
    @FXML
    private Label NATT;
    @FXML
    private TextField capitainequipe;
    @FXML
    private Button retour;
    @FXML
    private Button listematch;
    @FXML
    private Button inviterami;
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
public int cap,idu;
    public void setEquipe(equipe equipe) throws SQLException {
        list.clear();
        this.equipe = equipe;
         nomequipe.setText(equipe.getNom().toUpperCase());
           Image image= new Image(equipe.logo);
        logo.setImage(image);
        cap=equipe.getCapitain();
         
          try {
            ServiceUtilisateur s=new ServiceUtilisateur();
            List<utilisateur> l =new ArrayList<>();
            l=s.readAll();
            for(int i=0 ;i<l.size();i++){
                if(l.get(i).getEquipe()==equipe.getId())
                list.add(l.get(i));
                if(l.get(i).getId()==cap){
                    capitainequipe.setText(l.get(i).getNom().toUpperCase());}
            }
               
           tablenom.setCellValueFactory(new PropertyValueFactory<utilisateur,String>("nom"));
            tableprenom.setCellValueFactory(new PropertyValueFactory<utilisateur,String>("prenom"));
            tableposition.setCellValueFactory(new PropertyValueFactory<utilisateur,String>("position"));
            tablemember.setItems(list);
            
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());        }
           ServiceUtilisateur su =new ServiceUtilisateur();
           List<utilisateur> l=new ArrayList();
           l=su.readAll();
           for(int x=0;x<l.size();x++){
               if(l.get(x).getEquipe()==equipe.getId()){
                   if(l.get(x).getPosition_equipe()==1){
                       GK.setVisible(false);
                       NGK.setText(l.get(x).getNom());
                   }
                    if(l.get(x).getPosition_equipe()==2){
                       DD1.setVisible(false);
                       NDD1.setText(l.get(x).getNom());
                   }
                     if(l.get(x).getPosition_equipe()==3){
                       DD2.setVisible(false);
                       NDD2.setText(l.get(x).getNom());
                   }
                      if(l.get(x).getPosition_equipe()==4){
                       MID1.setVisible(false);
                       NMID1.setText(l.get(x).getNom());
                   }
                       if(l.get(x).getPosition_equipe()==5){
                       MID2.setVisible(false);
                       NMID2.setText(l.get(x).getNom());
                   }
                        if(l.get(x).getPosition_equipe()==6){
                       ATT.setVisible(false);
                       NATT.setText(l.get(x).getNom());
                   }
               }
           }
        
    }

    public utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(utilisateur utilisateur) {
        this.utilisateur = utilisateur;
        idu=utilisateur.getId();
    }
public utilisateur utilisateur; 
    @FXML
    private TableView<utilisateur> tablemember;
    @FXML
    private TableColumn<utilisateur, String> tablenom;
    @FXML
    private TableColumn<utilisateur, String> tableprenom;
    @FXML
    private TableColumn<utilisateur, String>tableposition;
    @FXML
    private ImageView GK;
    @FXML
    private ImageView MID1;
    @FXML
    private ImageView DD2;
    @FXML
    private ImageView DD1;
    @FXML
    private ImageView ATT;
    @FXML
    private ImageView MID2;
    @FXML
    private ImageView logo;
    @FXML
    private TextField nomequipe;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Image image= new Image("/icons/terrainfootball.jpg");
        terrain.setImage(image);
        Image icon=new Image("/icons/inviteramis.png");
       GK.setImage(icon);       DD1.setImage(icon);       DD2.setImage(icon);       MID1.setImage(icon);       MID2.setImage(icon);       ATT.setImage(icon);
       
     
         
     
    }    

  
    @FXML
    private void fretour(ActionEvent event) {
         try {
            FXMLLoader loader=new  FXMLLoader(getClass().getResource("equipe.fxml"));
            Parent root=loader.load();
           EquipeController pdc = loader.getController();
          
          pdc.setUtilisateur(utilisateur);
         list.clear();
            logo.getScene().setRoot(root);
        } catch (IOException ex) {
        System.out.println(ex.getMessage());    
        }
    }



    @FXML
    private void flistematch(ActionEvent event) throws SQLException {
         try {
            FXMLLoader loader=new  FXMLLoader(getClass().getResource("listematche.fxml"));
            Parent root=loader.load();
           ListematcheController pdc = loader.getController();
          pdc.setEquipe(equipe);
          pdc.setUtilisateur(utilisateur);
            logo.getScene().setRoot(root);
        } catch (IOException ex) {
        System.out.println(ex.getMessage());    
        }
    }

    @FXML
    private void finviterami(ActionEvent event) {
          try {
            FXMLLoader loader=new  FXMLLoader(getClass().getResource("inviterami.fxml"));
            Parent root=loader.load();
           InviteramiController pdc = loader.getController();
          pdc.setEquipe(equipe);
          pdc.setUtilisateur(utilisateur);
            logo.getScene().setRoot(root);
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

    @FXML
    private void setposition1(MouseEvent event) {
    }

    @FXML
    private void setposition2(MouseEvent event) {
    }

    @FXML
    private void setposition3(MouseEvent event) {
    }

    @FXML
    private void setposition4(MouseEvent event) {
    }

    @FXML
    private void setposition5(MouseEvent event) {
    }

    @FXML
    private void setposition6(MouseEvent event) {
    }
}
