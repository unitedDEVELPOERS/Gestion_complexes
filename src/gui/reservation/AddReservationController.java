/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.reservation;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import entities.Fruit;
import entities.Terrain;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import org.controlsfx.control.textfield.TextFields;
import services.CategorieCrud;
import services.ProprietaireCrud;
import services.TerrainCrud;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class AddReservationController implements Initializable {

    @FXML
    private JFXComboBox<?> cbCategorie;
    @FXML
    private JFXComboBox<?> cbComplexe;
    @FXML
    private JFXButton btnChercher;

    ObservableList terrains = FXCollections.observableArrayList();
    ObservableList listCategories = FXCollections.observableArrayList();
    ObservableList listComplexes = FXCollections.observableArrayList();
    ObservableList listTerrains = FXCollections.observableArrayList();
    CategorieCrud catCrud = new CategorieCrud();
    ProprietaireCrud compCrud = new ProprietaireCrud();
    @FXML
    private JFXComboBox<?> cbVille;
    @FXML
    private JFXButton btnChercher1;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    
    
    TerrainCrud tc = new TerrainCrud();
    
    
    /**
     * Initializes the controller class.
     */
    


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        loadCbxCategories();
        loadCbxComplexes();
        terrains = tc.getAll();
    }
    

    @FXML
    private void chercher(ActionEvent event) {
    }
    
    public void loadCbxCategories(){
        listCategories=catCrud.getAll();
        cbCategorie.setItems(listCategories);
    }
    
    public void loadCbxComplexes(){
        listComplexes= compCrud.readAll();
        cbComplexe.setItems(listComplexes);
    }
    
}
