/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Client;

import entities.Terrain;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import services.TerrainCrud;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class AccueilController implements Initializable {
    int index=0;    
    TerrainCrud tc = new TerrainCrud();
    int limite=tc.getAll().size();
    List<Terrain> nouveaux = new ArrayList();
    List<Terrain> listTerrains = new ArrayList();
    @FXML
    private HBox suggestion;
    @FXML
    private GridPane terrainsContainer;
    @FXML
    private Button btnPrecedent;
    @FXML
    private Button btnSuivant;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {  
        loadNouveaux();
        loadTerrains();  
        
    }    
    private void loadNouveaux(){
        nouveaux = tc.getNouveaux();
        try{
        for (Terrain t:nouveaux){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/gui/client/card.fxml"));
            HBox cardBox = fxmlLoader.load();
            CardController cardController = fxmlLoader.getController();
            cardController.setData(t);
            suggestion.getChildren().add(cardBox);           
        }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void loadTerrains(){
        listTerrains=tc.getTerrainsPage(index, index+4);
        int column=0;
        int row = 1;
        try{        
        for(Terrain t:listTerrains){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/gui/client/terrain.fxml"));
            VBox terrainBox = fxmlLoader.load();
            TerrainController terrainController = fxmlLoader.getController();
            terrainController.setData(t);
            if(column==4){
                column=0;
                ++row;
            }
            terrainsContainer.add(terrainBox, column++, row);
            GridPane.setMargin(terrainBox, new Insets(10));
        }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void limiteIndex(){
        if(index==4)
            btnPrecedent.setDisable(true);
    }
    @FXML
    private void btnPrecedent(ActionEvent event) {
        if(index>0){
            listTerrains.clear();
            listTerrains = tc.getTerrainsPage(index, index-4);
            index-=4;        
            loadTerrains();
        }
    }

    @FXML
    private void btnSuivant(ActionEvent event) {
        
        if(index+4<=limite){
            listTerrains.clear();
            listTerrains = tc.getTerrainsPage(index, index+4);
            index+=4;        
            loadTerrains();
        }
        
            
        
        
        
    }

    
}
