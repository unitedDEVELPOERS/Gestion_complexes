/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Interface;

import Entitee.Competition;
import Entitee.Equipe;
import Services.CRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author user
 */
public class Liste_CompetitionController implements Initializable {
    @FXML
    private TableColumn<Competition, Integer> col_id;
    @FXML
    private TableView<Competition> table_liste_competition;

    @FXML
    private TableColumn<Competition, String> col_desgniation;

    @FXML
    private TableColumn<Competition, String> col_datec;

    @FXML
    private TableColumn<Competition, String> col_dated;

    @FXML
    private TableColumn<Competition, String> col_nbeq;

    @FXML
    private TableColumn<Competition, String> col_catg;
    
    @FXML
    private TableColumn<Competition, String> col_complex;
    
     @FXML
    private TableColumn<Competition, String> col_prix;
    
     
     ObservableList<Competition> listM;
    ObservableList<Competition> dataList;
    @FXML
    private TextField txt_nbeq;
    @FXML
    private TextField txt_des;
      @FXML
    private TextField txt_id;
    
      
      
    
    
    
    
    
    @FXML
    private Button afficher_les_q_particieper;
    
    @FXML
    private TableView<Equipe> table_eq1_et_eq2;
   
    @FXML
    private TableColumn<Equipe, ?> col_num_eq;
   
    @FXML
    private TableColumn<Equipe, ?> col_eqp;
  
  
    //////////////////////////////////////////
     int index = -1;
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

           UpdateTable();
    }    

    
   @FXML
    void getSelected (MouseEvent event){
    index = table_liste_competition.getSelectionModel().getSelectedIndex();
    if (index <= -1){
    
        return;
    }
    txt_id.setText(col_id.getCellData(index).toString());
    txt_des.setText(col_desgniation.getCellData(index).toString());
    txt_nbeq.setText(col_nbeq.getCellData(index).toString());

    }

    
    
    public void UpdateTable(){
        
        ObservableList listcat = FXCollections.observableArrayList();
        CRUD tc = new CRUD();
        listcat=(ObservableList) tc.AfficherCategories();
        col_id.setCellValueFactory(new PropertyValueFactory<Competition,Integer>("id"));
        col_desgniation.setCellValueFactory(new PropertyValueFactory<Competition,String>("designation"));
        col_datec.setCellValueFactory(new PropertyValueFactory<Competition,String>("date_creation"));
        col_dated.setCellValueFactory(new PropertyValueFactory<Competition,String>("date_debut"));
        col_nbeq.setCellValueFactory(new PropertyValueFactory<Competition,String>("nbre_equipes"));
        col_catg.setCellValueFactory(new PropertyValueFactory<Competition,String>("idcatg"));
        col_complex.setCellValueFactory(new PropertyValueFactory<Competition,String>("complexe"));
        col_prix.setCellValueFactory(new PropertyValueFactory<Competition,String>("prix_participation"));

        listM = tc.getDatacompetition();
        table_liste_competition.setItems(listM);

    }

    @FXML
    private void afficher_les_eq(ActionEvent event) {
        
        
        
        
    }
}
