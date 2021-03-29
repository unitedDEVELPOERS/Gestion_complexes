/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import entities.Reservation;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.ReservationCrud;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class ReservationEncaissementController implements Initializable {
    ReservationCrud rc = new ReservationCrud();
    Reservation reservation=null;
    ObservableList l = FXCollections.observableArrayList();
    @FXML
    private ImageView btnClose;
    @FXML
    private TextField tfClient;
    @FXML
    private TextField tfTerrain;
    @FXML
    private TextField tfDate;
    @FXML
    private TextField tfHeure;
    @FXML
    private TextField tfMontant;
    @FXML
    private Button btnValider;
    @FXML
    private Button btnAnnuler;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setReservation(Reservation r){
        reservation = r;
        tfClient.setText(reservation.getClient().toString());
        tfTerrain.setText(reservation.getTerrain().toString());
        tfDate.setText(reservation.getDate_reservation().toString());
        tfHeure.setText(reservation.getHeure().toString());
        tfMontant.setText(Double.toString(reservation.getMontant()));
        System.out.println(r.isValidee());
        if(reservation.isValidee())
        {
            btnValider.setDisable(true);
            btnAnnuler.setDisable(true);
            
        }
        
    }

    @FXML
    private void btnClose(MouseEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btnValider(ActionEvent event) {
       Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setContentText("Encaisser et valider cette réservation ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {        
            reservation.setValidee(true);
            rc.modifierReservation(reservation);
            alerte("Réservation validée");
            Stage stage = (Stage) btnClose.getScene().getWindow();
            stage.close();
        }   
    }
    
    public void alerte(String msg){       
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        //alert.setTitle("Attention !");
        alert.setContentText(msg);
        alert.showAndWait();

    }

    @FXML
    private void btnAnnuler(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setContentText("Encaisser et valider cette réservation ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {        
            
            rc.supprimerReservation(reservation);
            alerte("Réservation annulée");
            ReservationsListController rlc = new ReservationsListController();
            l=rc.afficherReservations();
            rlc.setRefresh(l);
            Stage stage = (Stage) btnClose.getScene().getWindow();
            stage.close();
        }   
        
    }
    
}
