/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author ahmed
 */
public class PointStart extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root =
//                    FXMLLoader.load(getClass().getResource("/gui/Admin/AddTerrain.fxml"));
//                    FXMLLoader.load(getClass().getResource("/gui/terrain/NewReservation.fxml"));
                       // FXMLLoader.load(getClass().getResource("/gui/reservation/ShowReservations.fxml"));                                                   
//                    FXMLLoader.load(getClass().getResource("/gui/Admin/TerrainsList.fxml"));
                //FXMLLoader.load(getClass().getResource("/gui/terrain/ListeTerrains.fxml"));
//                    FXMLLoader.load(getClass().getResource("/gui/terrain/GestionTerrains.fxml"));
//                    FXMLLoader.load(getClass().getResource("/gui/terrain/detailsTerrain.fxml"));
                   // FXMLLoader.load(getClass().getResource("/gui/client/Accueil.fxml"));
                    FXMLLoader.load(getClass().getResource("/gui/client/AcceuilClient.fxml"));
//                    FXMLLoader.load(getClass().getResource("/gui/client/MesReservations.fxml"));
                    //FXMLLoader.load(getClass().getResource("adminPanel.fxml"));
                   
                    
            Scene scene = new Scene(root);
            //primaryStage.initStyle(StageStyle.UNDECORATED);
            //primaryStage.setTitle("Home window");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
