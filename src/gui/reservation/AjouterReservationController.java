/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.reservation;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import services.ReservationCrud;
import services.TerrainCrud;

/**
 * FXML Controller class
 *
 * @author ahmed
 */

public class AjouterReservationController implements Initializable {
    ReservationCrud rc = new ReservationCrud();
    ObservableList listReserv = FXCollections.observableArrayList();
    ObservableList listTerrains = FXCollections.observableArrayList();
    TerrainCrud tc = new TerrainCrud();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
//    public void loadTable(){
//        paneDetails.setVisible(false);
//        paneNouveau.setVisible(false);
//        listTerrains.clear();
//        listTerrains=tc.getAll();
//        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
//        colNom.setCellValueFactory(new PropertyValueFactory<>("designation"));
//        colCategorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
//        colPrix.setCellValueFactory(new PropertyValueFactory<>("prix_location"));
//        colHOuv.setCellValueFactory(new PropertyValueFactory<>("heure_ouverture"));
//        colHFerm.setCellValueFactory(new PropertyValueFactory<>("heure_fermeture"));
//        ActButton();
//        tableTerrain.setItems(listTerrains);
//}
    
}
