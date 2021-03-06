/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.penalite;

import entities.Complexe;
import entities.Penalite;
import java.net.URL;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.TreeSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import services.PenaliteCRUD;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class AddPenaliteController implements Initializable {

    @FXML
    private TextField tfDes;
    @FXML
    private TextField tfNbrePoint;
    @FXML
    private TableColumn<Penalite, Integer> colId;
    @FXML
    private TableColumn<Penalite, String> colDes;
    @FXML
    private TableColumn<Penalite, Integer> colPoints;
    @FXML
    private TableView<Penalite> tablePenalites;

    ObservableList<Penalite> listPenalites = FXCollections.observableArrayList();
    @FXML
    private Pane paneNew;
    @FXML
    private Button btnNew;
    @FXML
    private Button btnAnnuler;
    @FXML
    private Button btnEnregistrer;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        paneNew.setVisible(false);
        PenaliteCRUD pCrud = new PenaliteCRUD();
        Collection <Penalite> clp=new TreeSet<Penalite>();
        //clp=pCrud.findAll();
        
        Complexe c = new Complexe();
//        Penalite p = new Penalite(1,"carton rouge",5,c);
//        Penalite pp = new Penalite(2,"carton jaune",3,c);
        //Penalite p1 = pCrud.find(12);
//        tab();
        
        

    }    
public void tab(){
    try {
        PenaliteCRUD pCrud = new PenaliteCRUD();
        listPenalites = (ObservableList<Penalite>) pCrud.afficherPenalites();
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colDes.setCellValueFactory(new PropertyValueFactory<>("designation"));
        colPoints.setCellValueFactory(new PropertyValueFactory<>("nbre_points_retires"));
        tablePenalites.setItems(listPenalites);
        
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}
    @FXML
    private void AjouterPenalite(ActionEvent event) {
        try{
        String des = tfDes.getText();
        int nbrePoint = Integer.parseInt(tfNbrePoint.getText());
        
        Complexe c = new Complexe(1);
        Penalite p = new Penalite(1, des, nbrePoint, c);
        PenaliteCRUD pCrud = new PenaliteCRUD();
        pCrud.addPenalite(p);        
        clear();
        annuler(event);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        
    }
    
    private void clear(){
        tfDes.clear();
        tfNbrePoint.clear();
                
    }

    @FXML
    private void nouveau(ActionEvent event) {
        tablePenalites.setVisible(false);
        paneNew.setVisible(true);
        btnNew.setDisable(true);
        
    }

    @FXML
    private void annuler(ActionEvent event) {
        paneNew.setVisible(false);
        btnNew.setDisable(false);
        tablePenalites.setVisible(true);
    }
    
   

   
    
    
}
