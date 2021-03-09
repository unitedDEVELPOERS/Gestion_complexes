/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.Arbitre;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import edu.esprit.services.ArbitreCrud;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;


/**
 * FXML Controller class
 *
 * @author bezin
 */
public class AjouterArbitreController implements Initializable {
 ObservableList<String> ListeChoice=FXCollections.observableArrayList("FootBall","HandBall","BasketBall","VolleyBall");

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private ChoiceBox tfCategorie;
    @FXML
    private Label lbNom;
    @FXML
    
   
    private TextField tfComplexe;
    @FXML
    private Button btModifier;
    @FXML
    private Button btSupprimer;
    @FXML
    private Button btAjouter;
    @FXML
    private Button Retour;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfTelephone;
    @FXML
    private PasswordField tfMdp;
    
     ObservableList<Arbitre> listM;
@FXML
    private TableView<Arbitre> table_liste_arbitre;

    @FXML
    private TableColumn<Arbitre, String> col_email;
    @FXML
    private TableColumn<Arbitre, String> col_nom;

    @FXML
    private TableColumn<Arbitre, String> col_prenom;

    @FXML
    private TableColumn<Arbitre, String> col_telephone;
    
    @FXML
    private TableColumn<Arbitre, String> col_categorie;
     @FXML
    private TableColumn<Arbitre, String> col_complexe;
    
     int index = -1;
    
    
    
    
    
     @Override
    public void initialize(URL location, ResourceBundle resources) {
      
        UpdateTable();
        tfCategorie.setValue("Gardien");
        tfCategorie.setItems(ListeChoice);
    
    }
    @FXML
    private void ModifArbitre(ActionEvent event) {
        try {
            String mail=tfEmail.getText();
            String telephone=tfTelephone.getText();
            String nom=tfNom.getText();
            String prenom=tfPrenom.getText();
            String categorie=(String) tfCategorie.getValue();
            String complexe=tfComplexe.getText();
            String mdp=tfMdp.getText();
            String role="arbitre";
            Arbitre uu=new Arbitre(mail,mdp,role,telephone,nom,prenom,complexe,categorie);
            ArbitreCrud pp=new  ArbitreCrud();
            pp.update(uu);
            UpdateTable();
            
        } catch (SQLException ex) {
            Logger.getLogger(AjouterArbitreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @FXML
    private void SuppArbitre(ActionEvent event) {
        
        try {
            String mail=tfEmail.getText();
            String telephone=tfTelephone.getText();
            String nom=tfNom.getText();
            String prenom=tfPrenom.getText();
            String categorie=(String) tfCategorie.getValue();
            String complexe=tfComplexe.getText();
            String mdp=tfMdp.getText();
            String role="arbitre";
            Arbitre uu=new Arbitre(mail,mdp,role,telephone,nom,prenom,complexe,categorie);
            ArbitreCrud pp=new  ArbitreCrud();
            pp.supprimer(uu);
            UpdateTable();
            tfEmail.clear();
         tfMdp.clear();
         tfNom.clear();
         tfPrenom.clear();
         tfTelephone.clear();
         tfComplexe.clear();
//            search_user();
        } catch (SQLException ex) {
            Logger.getLogger(AjouterArbitreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void AjouArbitre(ActionEvent event) {
       
        try {
            String mail=tfEmail.getText();
            String telephone=tfTelephone.getText();
            String nom=tfNom.getText();
            String prenom=tfPrenom.getText();
            String categorie=(String) tfCategorie.getValue();
            String complexe=tfComplexe.getText();
            String mdp=tfMdp.getText();
            String role="arbitre";
            Arbitre uu=new Arbitre(mail,mdp,role,telephone,nom,prenom,complexe,categorie);
            

ArbitreCrud pp=new  ArbitreCrud();
pp.ajouter(uu);
UpdateTable();
//            search_user();
        } catch (SQLException ex) {
            Logger.getLogger(AjouterArbitreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @FXML
    private void Rerurn(ActionEvent event) {
        
         FXMLLoader loader = new FXMLLoader(
            getClass().getResource("Acceuil.fxml"));
              
                    Parent root;
                try {
                    root = loader.load();
                      tfCategorie.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AuthentificationClientController.class.getName()).log(Level.SEVERE, null, ex);
                }
        
    }

   

    public void UpdateTable(){
        
        
         col_email.setCellValueFactory(new PropertyValueFactory<>("Email"));
         col_telephone.setCellValueFactory(new PropertyValueFactory<>("Telephone"));
         col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
         col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
         col_categorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
         col_complexe.setCellValueFactory(new PropertyValueFactory<>("complexe"));
         
         listM = ArbitreCrud.getDataArbitre();
         table_liste_arbitre.setItems(listM);
         
         tfEmail.clear();
         tfMdp.clear();
         tfNom.clear();
         tfPrenom.clear();
         tfTelephone.clear();
         tfComplexe.clear();
         
         
     
    

    }
@FXML
    void getSelected (MouseEvent event){
    index = table_liste_arbitre.getSelectionModel().getSelectedIndex();
    if (index <= -1){
    
        return;
    }
    tfEmail.setText(col_email.getCellData(index));
    tfTelephone.setText(col_telephone.getCellData(index));
    tfNom.setText(col_nom.getCellData(index));
    tfPrenom.setText(col_prenom.getCellData(index));
    tfCategorie.setValue(col_categorie.getCellData(index));
    tfComplexe.setText(col_complexe.getCellData(index));
   
    tfMdp.setDisable(true);
    tfEmail.setDisable(true);
    
    }
    
     /*void search_user() {          
        col_desgniation.setCellValueFactory(new PropertyValueFactory<Competition,String>("designation"));
        col_datec.setCellValueFactory(new PropertyValueFactory<Competition,String>("date_creation"));
        col_dated.setCellValueFactory(new PropertyValueFactory<Competition,String>("date_debut"));
        col_nbeq.setCellValueFactory(new PropertyValueFactory<Competition,String>("nbre_equipes"));
        col_catg.setCellValueFactory(new PropertyValueFactory<Competition,String>("categorie"));
        col_complex.setCellValueFactory(new PropertyValueFactory<Competition,String>("complexe"));
        listM = CRUD.getDatacompetition();
        table_liste_competition.setItems(listM);
        
        
        
        
        
        FilteredList<Competition> filteredData = new FilteredList<>(dataList, b -> true);  
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
        filteredData.setPredicate(Competit -> {
        if (newValue == null || newValue.isEmpty()) {
     return true;
    }    
        
        
        
        
        
    String lowerCaseFilter = newValue.toLowerCase();
    
    if (Competit.getDesignation().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
     return true; // Filter matches desg
    } else if (Competit.getDate_debut().toLowerCase().indexOf(lowerCaseFilter) != -1) {
     return true; // Filter matches date debut
    }else if (Competit.getDate_creation().toLowerCase().indexOf(lowerCaseFilter) != -1) {
     return true; // Filter matches date creation
    }
    else if (String.valueOf(Competit.getCategorie()).indexOf(lowerCaseFilter)!=-1)
         return true;// Filter matches categorie
                                
         else  
          return false; // Does not match.
   });
  }); 
        
        
  SortedList<Competition> sortedData = new SortedList<>(filteredData);  
  sortedData.comparatorProperty().bind(table_liste_competition.comparatorProperty());  
  table_liste_competition.setItems(sortedData);      
    }*/
    
}
