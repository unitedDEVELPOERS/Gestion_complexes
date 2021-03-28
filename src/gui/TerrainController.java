/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class TerrainController implements Initializable {

    @FXML
    private ImageView imageTerrain;
    @FXML
    private Label lbDesignation;
    @FXML
    private Label lbComplexe;
    @FXML
    private VBox vbTerrain;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void afficherTerrain(MouseEvent event) {
        System.out.println("gui.TerrainController.afficherTerrain()");
    }
    
}
