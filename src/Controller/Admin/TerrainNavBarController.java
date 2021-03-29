/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import entities.Terrain;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class TerrainNavBarController implements Initializable {

    @FXML
    private BorderPane bp;
    @FXML
    private Button btnNosTerrains;
    @FXML
    private Button btnNouveau;
    public Terrain tttt = null;
String nn="l";
    /**
     * Initializes the controller class.
     */
     public void setTerrain(Terrain ter) {
        this.tttt = ter;
        //modifierDetails(ter);
        System.out.println("welcome navbar set "+tttt);
        
    }
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       loadPage("/gui/Admin/TerrainsList");  
        //System.out.println("welcome navbar init "+tttt);
    }    

    @FXML
    private void nosTerrains(ActionEvent event) {
        loadPage("/gui/Admin/TerrainsList");   
    }

   
    @FXML
    private void nouveau(ActionEvent event) {
        //loadPage("/gui/Admin/AddTerrain"); 
        nouveauTerrain();
    }
    
    private void loadPage(String page){
        Parent root=null;
        try{
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
            
        } catch (IOException ex) {
            Logger.getLogger(TerrainNavBarController.class.getName()).log(Level.SEVERE, null, ex);
        }
        bp.setCenter(root);
        
    }

    private void btnEditer(ActionEvent event) {
        loadPage("/gui/Admin/UpdateTerrain");
        
        //System.out.println("kkkkk "+t);
    }


    private void btnAfficher(ActionEvent event) {
        
        System.out.println("welcome "+tttt);
    }
    
    public void modifierDetails(Terrain ter){
        try {            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Admin/UpdateTerrain.fxml"));
            Parent root = loader.load();
                    
            UpdateTerrainController atc = loader.getController();
            //atc.setTerrain(ter);
            //atc.setMessage("modifié");
            //tableTerrain.getScene().setRoot(root);          
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    
    }
    
    public void nouveauTerrain(){
        try{
            FXMLLoader loader = new FXMLLoader(
            getClass().getResource("/gui/Admin/AddTerrain.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
//            AddTerrainController pdc = loader.getController();
//            btnNouveau.getScene().setRoot(root);
            stage.setScene(new Scene(root));
            stage.show();            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    
}
