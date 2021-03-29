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
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class CardController {

    @FXML
    private HBox card;
    private Label lbDesignation;
    private Label lbDescription;
    @FXML
    private ImageView cardImage;

    Terrain t=null;
    @FXML
    private Text txtDesignation;
    @FXML
    private Text txtAdresse;
    
    public void setData(Terrain terrain){
        t=terrain;
    Image image = new Image(getClass().getResourceAsStream(terrain.getImage()),170,130,false,false);
    cardImage.setImage(image);
    //lbDesignation.setText(terrain.getDesignation());
    txtAdresse.setText(terrain.getAdresse());
    txtDesignation.setText(terrain.getDesignation());
    card.setStyle("-fx-background-color:  #d1e0e0;"+
            " -fx-background-radius:15;"+
            " -fx-effect:dropShadown(three-pass-box, rgba(0,0,0,0),10,0,0,10);");    
    
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
            
            stage.setScene(new Scene(root));
            stage.isFullScreen();
            stage.show();  
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
