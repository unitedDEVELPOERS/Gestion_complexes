/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Client;

import entities.Client;
import entities.Terrain;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import services.ReservationCrud;
import services.TerrainCrud;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class ReservationController implements Initializable {

    int index=0; 
    
    TerrainCrud tc = new TerrainCrud();
    int limite=tc.getAll().size();
    List<Terrain> nouveaux = new ArrayList();
    List<Terrain> listTerrains = new ArrayList();
    ReservationCrud rc = new ReservationCrud();
    Client client = new Client(31);   
    int notif;
    @FXML
    private HBox suggestion;
    @FXML
    private GridPane terrainsContainer;
    @FXML
    private Button btnPrecedent;
    @FXML
    private Button btnSuivant;
    @FXML
    private Label lbNotif;
    @FXML
    private Label lbMessage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            loadNouveaux();
        loadTerrains();  
        nouveaux = tc.getNouveaux();
        System.out.println(nouveaux.size());
        
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
        listTerrains=tc.getTerrainsPage(index, index+3);
        int column=0;
        int row = 1;
        try{        
        for(Terrain t:listTerrains){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/gui/client/terrain.fxml"));
            VBox terrainBox = fxmlLoader.load();
            TerrainController terrainController = fxmlLoader.getController();
            terrainController.setData(t);
            if(column==3){
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
        if(index==3)
            btnPrecedent.setDisable(true);
    }
    
    @FXML
    private void btnPrecedent(ActionEvent event) {
        if(index>0){
            listTerrains.clear();
            listTerrains = tc.getTerrainsPage(index, index-3);
            index-=3;        
            loadTerrains();
        }
    }

    @FXML
    private void btnSuivant(ActionEvent event) {
         if(index+3<=limite){
            listTerrains.clear();
            listTerrains = tc.getTerrainsPage(index, index+3);
            index+=3;        
            loadTerrains();
        }
        
    }
     
}
