/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Client;

import entities.Terrain;
//import gui.terrain.DetailsTerrainController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class TerrainController{

    @FXML
    private ImageView imageTerrain;
    @FXML
    private Label lbDesignation;
    @FXML
    private VBox vbTerrain;

    Terrain t=null;
    private Label lbDescription;
    @FXML
    private Text txtDesc;
    @FXML
    private Label lbAdresse;
    
    
    public void setData(Terrain terrain){
        t=terrain;
        Image image = new Image(getClass().getResourceAsStream(terrain.getImage()),350,200,false,false);
        imageTerrain.setImage(image);
        lbDesignation.setText(terrain.getDesignation());
        lbAdresse.setText(terrain.getAdresse());
        if(terrain.getDescription().length()>200)
            txtDesc.setText(terrain.getDescription().substring(1, 200));
        else
            txtDesc.setText(terrain.getDescription());
    }

    @FXML
    private void afficherTerrain(MouseEvent event) {        
        System.out.println(t);
        afficherDetails(t);
    }
    
    public void afficherDetails(Terrain ter){
        try {            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/client/TerrainDetails.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
           stage.initStyle(StageStyle.UNDECORATED);  
            
            TerrainDetailsController tdc = loader.getController();
            tdc.setTerrain(ter);
            System.out.println("lllll "+ter);
            stage.setScene(new Scene(root));
            stage.show();  
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
